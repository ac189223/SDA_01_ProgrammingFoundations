package PF02.Exs.Bonus01_House;

public class Apartment {
    private int apartmentNr;
    private int size;
    private int price;

    public Apartment(int apartmentNr, int size, int price) {
        this.setApartmentNr(apartmentNr);
        this.setSize(size);
        this.setPrice(price);
    }

    public int getApartmentNr() { return apartmentNr; }

    public void setApartmentNr(int apartmentNr) { this.apartmentNr = apartmentNr; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}
