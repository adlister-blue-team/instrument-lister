package dao;

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
            while (rs.next()){
                users.add(new User(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
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
            return new User(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error getting user by username.", e);
        }
    }

    @Override
    public String insertUser(User user) {
        try {
            String insertQuery = "INSERT INTO users(email, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
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
            String insertQuery = "UPDATE users SET email = ?, username = ?, password = ? WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, username);
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
            String insertQuery = "DELETE from users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting a user.", e);
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
