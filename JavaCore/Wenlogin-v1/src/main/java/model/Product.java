package model;

public class Product {
    private int id;
    private String pname;
    private String pavarta;
    private float ptotal;
    private String porigin;
    private String discription;

    public Product(int id, String pname, String pavarta, float ptatal, String porigin, String discription) {
        this.id = id;
        this.pname = pname;
        this.pavarta = pavarta;
        this.ptotal = ptatal;
        this.porigin = porigin;
        this.discription = discription;
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

    public String getPavarta() {
        return pavarta;
    }

    public void setPavarta(String pavarta) {
        this.pavarta = pavarta;
    }

    public float getPtotal() {
        return ptotal;
    }

    public void setPtotal(float ptatal) {
        this.ptotal = ptatal;
    }

    public String getPorigin() {
        return porigin;
    }

    public void setPorigin(String porigin) {
        this.porigin = porigin;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
