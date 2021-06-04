package dao;

import com.mysql.cj.jdbc.Driver;
import models.Instrument;

import javax.security.auth.login.Configuration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLInstrumentsDao implements Instruments {
    private Connection connection = null;

    public MySQLInstrumentsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                 config.getUrl(),
                 config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    public List<Instrument> all() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM Instruments");
            ResultSet resultSet = statement.executeQuery();
            return createInstrumentsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all Instriments.", e);
        }
    }


    public Long insert(Instrument instrument) {
        try {
            String insertQuery = "INSERT INTO Instruments(name, description, owner_id, payment_type, price, shipping_method) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, instrument.getName());
            statement.setString(2, instrument.getDescription());
            statement.setLong(3, instrument.getOwnerId());
            statement.setString(4, instrument.getPaymentType());
            statement.setFloat(5, instrument.getPrice());
            statement.setString(6, instrument.getShippingMethod());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new Instrument.", e);
        }
    }

    private Instrument extractInstrument(ResultSet resultSet) throws SQLException {
        return new Instrument(
                resultSet.getLong("id") ,
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getLong("owner_id"),
                resultSet.getFloat("price"),
                resultSet.getString("shipping_method"),
                resultSet.getString("paymentType")
        );
    }

    private List<Instrument> createInstrumentsFromResults(ResultSet resultSet) throws SQLException {
        List<Instrument> Instrument = new ArrayList<>();
        while (resultSet.next()) {
            Instrument.add(extractInstrument(resultSet));
        }
        return Instrument;
    }

}
