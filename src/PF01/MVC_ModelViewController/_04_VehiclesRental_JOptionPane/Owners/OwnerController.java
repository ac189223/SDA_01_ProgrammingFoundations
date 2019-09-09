package PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Owners;

import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Vehicles.CarController;

import java.util.ArrayList;

public class OwnerController {
    private Owner model;
    private OwnerView view;

    public OwnerController(Owner owner, OwnerView ownerView) {
        this.model = owner;
        this.view = ownerView;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public String getSurname() { return model.getSurname(); }

    public void setSurname(String surname) {
        model.setSurname(surname);
    }

    public int getAge() {
        return model.getAge();
    }

    public void setAge(int age) {
        model.setAge(age);
    }

    public String getCountryOfOrigin() {
        return model.getCountryOfOrigin();
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        model.setCountryOfOrigin(countryOfOrigin);
    }

    public ArrayList<CarController> getCars() {
        return model.getCars();
    }

    public void updateVieW() { view.printCarDetails(model); }

    public void buyCar(CarController car) {
        model.addCar(car);
    }

    public void countVehicles() { model.countVehicles(); }

    public int getNumberOfCars() { return model.getNumberOfCars(); }

    public void sellCar(CarController car) { model.removeCar(car); }

    public void listCars() {
        System.out.print(getNumberOfCars() + " cars: ");
        String v = "";
        for (CarController car : getCars())
            v += car.getName() + ", ";
        System.out.println(v.substring(0, v.length() - 2));
    }
}
