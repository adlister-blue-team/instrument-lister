package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private List<Instrument> instruments = new ArrayList<>();

    public User(){}
    public User(String username, String email, String password, String imageUrl){
        this.username = username;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
    }
    public User(String username, String email, String password, List<Instrument> instruments, String imageUrl){
        this.username = username;
        this.email = email;
        this.password = password;
        this.instruments = instruments;
        this.imageUrl = imageUrl;
    }
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(String username, String email, String password, List<Instrument> instruments){
        this.username = username;
        this.email = email;
        this.password = password;
        this.instruments = instruments;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public List<Instrument> getInstruments(){ return this.instruments; }
    public void setInstruments(List<Instrument> instruments){ this.instruments = instruments; }
}
