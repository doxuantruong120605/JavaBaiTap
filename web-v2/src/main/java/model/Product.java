package model;

public class Product {
    private int id;
    private String pname;
    private String pavatar;
    private int ptotal;
    private float price;
    private String porigin;
    private String category;
    private String storage;
    private String color;
    private String description;

    public Product(int id, String pname, String pavatar, int ptotal, float price, String porigin, String category, String storage, String color, String description) {
        this.id = id;
        this.pname = pname;
        this.pavatar = pavatar;
        this.ptotal = ptotal;
        this.price = price;
        this.porigin = porigin;
        this.category = category;
        this.storage = storage;
        this.color = color;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPavatar() {
        return pavatar;
    }

    public void setPavatar(String pavatar) {
        this.pavatar = pavatar;
    }

    public int getPtotal() {
        return ptotal;
    }

    public void setPtotal(int ptotal) {
        this.ptotal = ptotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPorigin() {
        return porigin;
    }

    public void setPorigin(String porigin) {
        this.porigin = porigin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
