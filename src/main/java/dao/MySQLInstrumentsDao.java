package dao;

import com.mysql.cj.jdbc.Driver;
import models.Instrument;
import models.User;

import javax.security.auth.login.Configuration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLInstrumentsDao implements Instruments {
    private Connection connection = null;

    public MySQLInstrumentsDao(Config config){
        this.connection = getConnection(config);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        String query = "SELECT * FROM instruments";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                instruments.add(new Instrument(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("owner_name"),
                        rs.getFloat("price"),
                        rs.getString("shipping_method"),
                        rs.getString("payment_type"),
                        getInstrumentTypes(rs.getLong("id")),
                        rs.getString("image_url")
                ));
            }
            return instruments;

        } catch (SQLException e) {
            throw new RuntimeException("Error getting all instruments.", e);
        }
    }

    @Override
    public Instrument getInstrumentById(long id) {
        String query = "SELECT * FROM instruments WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new Instrument(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("owner_name"),
                    rs.getFloat("price"),
                    rs.getString("shipping_method"),
                    rs.getString("payment_type"),
                    getInstrumentTypes(rs.getLong("id")),
                    rs.getString("image_url")
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error getting instrument by id.", e);
        }
    }

    public List<Instrument> searchInstrumentsByName(String name){
        List<Instrument> instruments = new ArrayList<>();
        String query = "SELECT * FROM instruments WHERE name LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                instruments.add(new Instrument(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("owner_name"),
                        rs.getFloat("price"),
                        rs.getString("shipping_method"),
                        rs.getString("payment_type"),
                        getInstrumentTypes(rs.getLong("id")),
                        rs.getString("image_url")
                ));
            }
            return instruments;

        } catch (SQLException e) {
            throw new RuntimeException("Error searching for instruments by name.", e);
        }
    }

    @Override
    public Long insertInstrument(Instrument instrument) {
        try {
            String query = "INSERT INTO instruments(name, description, owner_name, payment_type, price, shipping_method, image_url) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrument.getName());
            stmt.setString(2, instrument.getDescription());
            stmt.setString(3, instrument.getOwnerUsername());
            stmt.setString(4, instrument.getPaymentType());
            stmt.setFloat(5, instrument.getPrice());
            stmt.setString(6, instrument.getShippingMethod());
            stmt.setString(7, instrument.getImageUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            long id = rs.getLong(1);

            //adds the instrument to types relations to the instruments_types table
            query = "INSERT INTO instruments_types (instrument_id, type_name) VALUES (?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            for (String type : instrument.getTypes()){
                stmt.setString(2, type);
                stmt.executeUpdate();
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new instrument.", e);
        }
    }

    @Override
    public long updateInstrument(long id, Instrument instrument) {
        try {
            String query = "UPDATE instruments SET name = ?, description = ?, owner_name = ?, price = ?," +
                                    "shipping_method = ?, payment_type = ?, image_url = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrument.getName());
            stmt.setString(2, instrument.getDescription());
            stmt.setString(3, instrument.getOwnerUsername());
            stmt.setString(4, instrument.getPaymentType());
            stmt.setFloat(5, instrument.getPrice());
            stmt.setString(6, instrument.getShippingMethod());
            stmt.setString(7, instrument.getImageUrl());
            stmt.setLong(8, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            //wipes the previous instrument to type relations from the instruments_types table
            query = "DELETE FROM instruments_types WHERE instrument_id = ?";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();

            //adds the new instrument to types relations to the instruments_types table
            query = "INSERT INTO instruments_types (instrument_id, type_name) VALUES (?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            for (String type : instrument.getTypes()){
                stmt.setString(2, type);
                stmt.executeUpdate();
            }

            //update instrument in user's instruments
            User user = DaoFactory.getUsersDao().getUserByUsername(instrument.getOwnerUsername());
            instrument.setId(id);

            return id;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating an instrument.", e);
        }
    }

    @Override
    public boolean deleteInstrument(long id) {
        try {

            Instrument instrument = getInstrumentById(id);
            User user = DaoFactory.getUsersDao().getUserByUsername(instrument.getOwnerUsername());

            String query = "DELETE from instruments WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeQuery();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an instrument.", e);
        }
    }

    @Override
    public List<String> getInstrumentTypes(long id){
        List<String> types = new ArrayList<>();
        try {
            String query = "SELECT type_name FROM instruments_types WHERE instrument_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                types.add(rs.getString("type_name"));
            }
            return types;

        } catch (SQLException e) {
            throw new RuntimeException("Error getting instrument types.", e);
        }
    }

    public Connection getConnection(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
}
