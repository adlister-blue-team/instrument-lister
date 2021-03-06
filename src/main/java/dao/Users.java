package dao;

import models.Instrument;
import models.User;

import java.util.List;

public interface Users {
    List<User> getAllUsers();

    //returns username of inserted user
    String insertUser(User user);

    //returns username of updated user
    User updateUser( User user);

    //return true if deleted user
    boolean deleteUser(String username);

    List<Instrument> getUserInstruments(long id);

    User getUserByUsername(String username);

    User getUserById(long ownerId);

    long getUserId(String username);
}
