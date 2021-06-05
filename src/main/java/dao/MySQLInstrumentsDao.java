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
                        rs.getLong("owner_id"),
                        rs.getFloat("price"),
                        rs.getString("shipping_method"),
                        rs.getString("payment_type")
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
            return new Instrument(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getLong("owner_id"),
                    rs.getFloat("price"),
                    rs.getString("shipping_method"),
                    rs.getString("payment_type")
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error getting instrument by id.", e);
        }
    }

    @Override
    public Long insertInstrument(Instrument instrument) {
        try {
            String insertQuery = "INSERT INTO instruments(name, description, owner_id, payment_type, price, shipping_method) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrument.getName());
            stmt.setString(2, instrument.getDescription());
            stmt.setLong(3, instrument.getOwnerId());
            stmt.setString(4, instrument.getPaymentType());
            stmt.setFloat(5, instrument.getPrice());
            stmt.setString(6, instrument.getShippingMethod());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new instrument.", e);
        }
    }

    @Override
    public long updateInstrument(long id, Instrument instrument) {
        try {
            String insertQuery = "UPDATE instruments SET name = ?, description = ?, owner_id = ?, price = ?," +
                                    "shipping_method = ?, payment_type = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, instrument.getName());
            stmt.setString(2, instrument.getDescription());
            stmt.setLong(3, instrument.getOwnerId());
            stmt.setString(4, instrument.getPaymentType());
            stmt.setFloat(5, instrument.getPrice());
            stmt.setString(6, instrument.getShippingMethod());
            stmt.setLong(7, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error updating an instrument.", e);
        }
    }

    @Override
    public boolean deleteInstrument(long id) {
        try {
            String insertQuery = "DELETE from instruments WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an instrument.", e);
        }
    }

    public Connection getConnection(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
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
