package models;

public class Instrument {
    private long id;
    private String name;
    private String description;
    private long ownerId;
    private float price;
    private String shippingMethod;
    private String paymentType;

    public Instrument(long id, String name, String description, long ownerId, float price, String shippingMethod, String paymentType) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.ownerId=ownerId;
        this.price=price;
        this.shippingMethod= shippingMethod;
        this.paymentType=paymentType;
    }

    public Instrument(String name, String description, long ownerId, float price, String shippingMethod, String paymentType) {
        this.name=name;
        this.description=description;
        this.ownerId=ownerId;
        this.price=price;
        this.shippingMethod= shippingMethod;
        this.paymentType=paymentType;
    }

    public Instrument(long id, String name, String description, Long ownerId, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long owner) {
        this.ownerId = owner;
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

