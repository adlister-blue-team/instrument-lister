package dao;

import models.Instrument;
import models.User;

import java.util.List;

public interface Users {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    //returns username of inserted user
    String insertUser(User user);

    //returns username of updated user
    User updateUser( User user);

    //return true if deleted user
    boolean deleteUser(String username);

    List<Instrument> getUserInstruments(String username);

    long getUserId(String username);

    User getUserById(long ownerId);
}
