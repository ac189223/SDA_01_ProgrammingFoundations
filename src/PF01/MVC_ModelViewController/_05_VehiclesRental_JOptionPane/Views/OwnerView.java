package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.Views;

import PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects.Owner;

public class OwnerView {
    public void printCarDetails(Owner owner) {
        System.out.println(owner.getName() + " " + owner.getSurname() + " is " + owner.getAge() + " and comes from " + owner.getCountryOfOrigin() + ".");
        if (owner.getNumberOfCars() > 0)
            System.out.println("Has " + owner.getNumberOfCars() + " cars to rent.");
    }
}