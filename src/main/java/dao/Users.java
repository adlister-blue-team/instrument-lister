package dao;

public interface Users {
    List<User> getAllUsers();

    User getUserById();

    User getUserByUsername();

    //returns id of inserted user
    long insertUser();

    //returns true if updated, false if failed to update
    boolean updateUser(long id, User user);

    //returns true if deleted, false if failed to delete
    boolean deleteUser(long id);
}
