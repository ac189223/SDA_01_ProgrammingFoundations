package PF02.Exs.Bonus01_House;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        House house1 = new House();

        ArrayList<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(1, 58, 2100));
        apartments.add(new Apartment(2, 72, 2700));
        apartments.add(new Apartment(3, 93, 2900));

        House house2 = new House(apartments);

        Apartment apartment = new Apartment(4, 60, 2000);
        house2.addApartment(apartment);

        house2.removeApartment(2);

        System.out.println("Smallest apartment size is " + house2.minApartmentSize());
        System.out.println("Cheapest apartment price is " + house2.minApartmentPrice());
        System.out.println("Average size of apartments is " + house2.averageSize());
    }
}
