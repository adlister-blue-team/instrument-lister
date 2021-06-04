package dao;

import com.mysql.cj.jdbc.Driver;

import javax.security.auth.login.Configuration;
import javax.sound.midi.Instrument;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLInstrumentsDao {
    private Connection connection = null;

    public MySQLInstrumentsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getName(),
                    config.getDescription(),
                    config.getOwner_id(),
                    config.getPayment_type(),
                    config.getPrice(),
                    config.getShipping_method()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
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

    @Override
    public Long insert(Instruments instruments) {
        try {
            String insertQuery = "INSERT INTO Instruments(name, description, owner_id, payment_type, price, shipping_method) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, instruments.getName());
            statement.setString(2, instruments.getDescription());
            statement.setLong(3, instruments.getOwner_id());
            statement.setString(4, instruments.getPayment_type());
            statement.setFloat(5, instruments.getPrice());
            statement.setString(6, statement.getShipping_method());
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
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getLong("owner_id"),
                resultSet.getString("payment_type"),
                resultSet.getFloat("price"),
                resultSet.getString("shipping_method")
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
