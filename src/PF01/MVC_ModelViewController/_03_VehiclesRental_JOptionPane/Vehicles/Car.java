package PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane.Vehicles;

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

    int getDoors() {
        return doors;
    }

    void setDoors(int doors) {
        this.doors = doors;
    }

    int getSeats() {
        return seats;
    }

    void setSeats(int seats) {
        this.seats = seats;
    }

    boolean isManual() {
        return manual;
    }

    void setManual(boolean manual) {
        this.manual = manual;
    }
}
