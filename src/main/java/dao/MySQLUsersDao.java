package dao;

import models.Instrument;
import models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;

    public MySQLUsersDao(Config config){
        this.connection = getConnection(config);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<String> instruments = new ArrayList<>();
            while (rs.next()){

                users.add(new User(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        getUserInstruments(rs.getString("username")),
                        rs.getString("image_url")
                ));
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException("Error getting all users.", e);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new User(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    getUserInstruments(rs.getString("username")),
                    rs.getString("image_url")
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error getting user by username.", e);
        }
    }

    @Override
    public String insertUser(User user) {
        try {
            String query = "INSERT INTO users(email, username, password, image_url) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getImageUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return user.getUsername();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    @Override
    public String updateUser(String username, User user) {
        try {
            String query = "UPDATE users SET email = ?, username = ?, password = ?, image_url = ? WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getImageUrl());
            stmt.setString(5, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return user.getUsername();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating a user.", e);
        }
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            String query = "DELETE from users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting a user.", e);
        }
    }

    public List<Instrument> getUserInstruments(String username){
        String query = "SELECT * FROM instruments WHERE owner_name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            List<Instrument> instruments = new ArrayList<>();
            while (rs.next()) {
                instruments.add(new Instrument(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("owner_name"),
                        rs.getFloat("price"),
                        rs.getString("shipping_method"),
                        rs.getString("payment_type"),
                        DaoFactory.getInstrumentsDao().getInstrumentTypes(rs.getLong("id")),
                        rs.getString("image_url")
                ));
            }
            return instruments;

        } catch (SQLException e) {
            throw new RuntimeException("Error getting instrument by id.", e);
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
