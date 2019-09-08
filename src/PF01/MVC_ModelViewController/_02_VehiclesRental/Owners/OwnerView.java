package PF01.MVC_ModelViewController._02_VehiclesRental.Owners;

public class OwnerView {
    void printCarDetails(Owner owner) {
        System.out.println(owner.getName() + " " + owner.getSurname() + " is " + owner.getAge() + " and comes from " + owner.getCountryOfOrigin() + ".");
        if (owner.getNumberOfCars() > 0)
            System.out.println("Has " + owner.getNumberOfCars() + " cars to rent.");
    }
}