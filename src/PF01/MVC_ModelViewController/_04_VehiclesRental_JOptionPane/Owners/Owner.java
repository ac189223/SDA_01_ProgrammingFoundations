package PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Owners;

import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Vehicles.CarController;

import java.util.ArrayList;

public class Owner {
    private String name;
    private String surname;
    private int age;
    private String countryOfOrigin;
    private ArrayList<CarController> cars;
    private int numberOfCars;

    public Owner(String name, String surname, int age, String countryOfOrigin) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.countryOfOrigin = countryOfOrigin;
        this.cars = new ArrayList<>();
        this.numberOfCars = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public ArrayList<CarController> getCars() {
        return cars;
    }

    public void addCar(CarController car) { this.cars.add(car); }

    public void removeCar(CarController car) { this.cars.remove(car); }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void countVehicles() {
        numberOfCars = cars.size();
    }
}
