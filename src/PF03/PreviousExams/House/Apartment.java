package PF03.PreviousExams.House;

public class Apartment {
    private String aNr;
    private int size;
    private int price;
    private Tenant tenant;

    public Apartment(String aNr, int size, int price) {
        this.setaNr(aNr);
        this.setSize(size);
        this.setPrice(price);
        this.setTenant(null);
    }

    public String getaNr() { return aNr; }
    public void setaNr(String aNr) { this.aNr = aNr; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public Tenant getTenant() { return tenant; }
    public void setTenant(Tenant tenant) { this.tenant = tenant; }
}
