package PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane.Vehicles;

public class Moped extends Vehicle {
    private int wheels;
    private boolean luggageSpace;

    public Moped(String name, int owner, String color, int wheels, boolean luggageSpace) {
        super(name, owner, color);
        this.wheels = wheels;
        this.luggageSpace = luggageSpace;
        this.setSafeSpeed(30);
    }

    int getWheels() {
        return wheels;
    }

    void setWheels(int wheels) {
        this.wheels = wheels;
    }

    boolean hasLuggageSpace() {
        return luggageSpace;
    }

    void setLuggageSpace(boolean luggageSpace) {
        this.luggageSpace = luggageSpace;
    }
}
