package dao;

public class DaoFactory {
    private static Instruments instrumentsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Users getUsersDao() {
        if(usersDao == null){
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Instruments getInstrumentsDao() {
        if(instrumentsDao == null){
            instrumentsDao = new MySQLInstrumentsDao(config);
        }
        return instrumentsDao;
    }
}
