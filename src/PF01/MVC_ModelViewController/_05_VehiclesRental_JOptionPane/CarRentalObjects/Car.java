package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects;

public class Car extends Vehicle {
    private int doors;
    private int seats;
    private boolean manual;

    public Car(String name, int owner, String color, int doors, int seats, boolean manual) {
        super(name, owner, color);
        this.doors = doors;
        this.seats = seats;
        this.manual = manual;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}
