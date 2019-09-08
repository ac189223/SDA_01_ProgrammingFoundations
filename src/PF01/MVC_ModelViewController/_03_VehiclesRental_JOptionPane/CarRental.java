package PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane;

import PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane.Owners.OwnerController;

import java.util.ArrayList;

public class CarRental {
    ArrayList<OwnerController> owners = new ArrayList<>();

    public static void main(String[] args) {
        CarRental carRental = new CarRental();

        CarRentalMethods.createOwners(carRental);
        CarRentalMethods.createCars(carRental);

        CarRentalMethods.presentOffer(carRental);

        CarRentalMethods.askForPreferences();
        CarRentalMethods.offerCars(carRental);
        CarRentalMethods.askForChoice(carRental);
    }
}
