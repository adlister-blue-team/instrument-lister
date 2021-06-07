package dao;

import models.User;

import java.util.List;

public interface Users {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    //returns username of inserted user
    String insertUser(User user);

    //returns username of updated user
    String updateUser(String username, User user);

    //return true if deleted user
    boolean deleteUser(String username);
}
