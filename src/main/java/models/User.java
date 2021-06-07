package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String firstName;
    private String lastName;
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
    public User(String username, String email, String password, List<Instrument> instruments, String imageUrl, String firstName, String lastName){
        this.username = username;
        this.email = email;
        this.password = password;
        this.instruments = instruments;
        this.imageUrl = imageUrl;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username= username;
        this.email= email;
        this.password= password;
        this.firstName= firstName;
        this.lastName = lastName;
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
    public String getImageUrl(){ return this.imageUrl; }
    public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
