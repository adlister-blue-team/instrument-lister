package models;

public class Instrument {
    private long id;
    private String name;
    private String description;
    private String owner;
    private Float price;

    public Instrument() {}

    public Instrument(String name, String description, String owner, Float price) {
        this.name= name;
        this.description= description;
        this.owner= owner;
        this.price = price;
    }

    public Instrument(long id, String name, String description, String owner, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.price= price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

