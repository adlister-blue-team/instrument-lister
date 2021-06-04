package models;

public class Instrument {
    private long id;
    private String name;
    private String description;
    private long owner_id;
    private float price;
    private String shippingMethod;
    private String paymentType;

    public Instrument(long id, String name, String description, long owner_id, float price, String shipping_method, String paymentType) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.owner_id=owner_id;
        this.price=price;
        this.shippingMethod= shipping_method;
        this.paymentType=paymentType;
    }

    public Instrument(long id, String name, String description, Long owner_id, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner_id = owner_id;
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
        return owner_id;
    }

    public void setOwnerId(Long owner) {
        this.owner_id = owner;
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

