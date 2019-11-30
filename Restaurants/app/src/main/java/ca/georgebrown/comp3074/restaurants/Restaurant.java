package ca.georgebrown.comp3074.restaurants;

public class Restaurant {

    private final String id;
    private final String name;
    private final String type ;
    private String address;
    private String phone ;
    private String website ;
    private String rate ;
    private String price;
    private String otherTags;

    public Restaurant(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {return id;}

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtherTags() {
        return otherTags;
    }

    public void setOtherTags(String otherTags) {
        this.otherTags = otherTags;
    }


    @Override
    public String toString() {
        return name ;
    }

}
