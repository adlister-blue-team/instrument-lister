package dao;

import models.User;

import java.util.List;

public interface Users {
    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByUsername(String username);

    //returns id of inserted user
    long insertUser(User user);

    //returns id of deleted user
    long updateUser(long id, User user);

    //returns if of deleted user
    long deleteUser(long id);
}
