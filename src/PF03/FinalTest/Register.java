package PF03.FinalTest;

import java.util.ArrayList;

public class Register {
    private ArrayList<Car> register;

    public Register() {
        this.setRegister(new ArrayList<>());
    }

    public Register(ArrayList<Car> register) {
        this.setRegister(register);
    }

    public void setRegister(ArrayList<Car> register) {
        this.register = register;
    }

    public ArrayList<Car> getRegister() {
        return this.register;
    }

    public void addNewCar(Car car) {
        this.getRegister().add(car);
    }

    public void removeCar(String regNr) {
        this.getRegister().remove(findCar(regNr));
    }

    /**
     * Find method with lambda - not sure if it returns null correctly, so commented.
     * public Car findCar(String regNr) { return (Car) this.getRegister().stream().filter(car -> car.getRegNr() == regNr); }
     */

    public Car findCar(String regNr) {
        for (Car car : this.getRegister())
            if (car.getRegNr().equals(regNr))
                return car;
        return null;
    }

    public Owner findOwner(String regNr) {
        for (Car car : this.getRegister())
            if (car.getRegNr().equals(regNr))
                return car.getOwner();
        return null;
    }

    public void printAllOwners() {
        for (Car car : this.getRegister())
            System.out.print(car.getOwner().getName() + ", ");
        System.out.println();

    }
}