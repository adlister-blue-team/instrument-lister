package dao;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/instruments_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    }
    public String getUser() {
        return "root";
    }
    public String getPassword() {
        return "codeup";
    }
}
