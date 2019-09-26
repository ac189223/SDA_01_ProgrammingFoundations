package PF03.PreviousExams.House;

import java.util.ArrayList;

public class House {
    private ArrayList<Apartment> apartments = new ArrayList<>();

    public House() { this.setApartments(new ArrayList<>()); }
    public ArrayList<Apartment> getApartments() { return apartments; }
    public void setApartments(ArrayList<Apartment> apartments) { this.apartments = apartments; }
}
