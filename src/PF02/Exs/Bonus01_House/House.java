package PF02.Exs.Bonus01_House;

import java.util.ArrayList;

public class House {
    private ArrayList<Apartment> apartments;

    public House() { }

    public House(ArrayList<Apartment> apartments) { this.setApartments(apartments); }

    public ArrayList<Apartment> getApartments() { return apartments; }

    public void setApartments(ArrayList<Apartment> apartments) { this.apartments = apartments; }

    public void addApartment(Apartment apartment) { getApartments().add(apartment); }

    public Apartment searchApartment(int apartmentNr) {
        for (Apartment apartment: getApartments())
            if (apartment.getApartmentNr() == apartmentNr)
                return apartment;
        return null;
    }

    public void removeApartment(int apartmentNr){
        if (searchApartment(apartmentNr) != null)
            getApartments().remove(searchApartment(apartmentNr));
    }

    public int minApartmentPrice() {
        int minPrice = Integer.MAX_VALUE;
        for (Apartment apartment: getApartments())
            if (apartment.getPrice() < minPrice)
                minPrice = apartment.getPrice();
        return minPrice;
    }

    public int minApartmentSize() {
        int minSize = Integer.MAX_VALUE;
        for (Apartment apartment: getApartments())
            if (apartment.getSize() < minSize)
                minSize = apartment.getSize();
        return minSize;
    }

    public int numberOfApartments() { return getApartments().size(); }

    public int totalSize() {
        int sum = 0;
        for (Apartment apartment: getApartments())
            sum += apartment.getSize();
        return sum;
    }

    public double averageSize() { return totalSize() / numberOfApartments(); }

}
