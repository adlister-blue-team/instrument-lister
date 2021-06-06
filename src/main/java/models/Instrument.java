package models;

import java.util.List;

public class Instrument {
    private long id;
    private String name;
    private String description;
    private String ownerUsername;
    private float price;
    private String shippingMethod;
    private String paymentType;
    private List<String> types;

    public Instrument(long id, String name, String description, String ownerUsername, float price, String shippingMethod, String paymentType, List<String> types) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.ownerUsername = ownerUsername;
        this.price=price;
        this.shippingMethod= shippingMethod;
        this.paymentType=paymentType;
        this.types = types;
    }

    public Instrument(String name, String description, String ownerUsername, float price, String shippingMethod, String paymentType, List<String> types) {
        this.name=name;
        this.description=description;
        this.ownerUsername = ownerUsername;
        this.price=price;
        this.shippingMethod= shippingMethod;
        this.paymentType=paymentType;
        this.types = types;
    }

    public Instrument(long id, String name, String description, String ownerUsername, Float price, List<String> types) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerUsername = ownerUsername;
        this.price= price;
        this.types = types;
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

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}

