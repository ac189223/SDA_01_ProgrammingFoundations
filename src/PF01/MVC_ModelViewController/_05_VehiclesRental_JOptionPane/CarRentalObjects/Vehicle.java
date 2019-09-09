package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects;

import java.util.Random;

public class Vehicle implements VehicleInterface {
    private String name;
    private int owner;
    private boolean isRented;
    private boolean isRunning;
    private int safeSpeed = 50;
    private String color;
    private boolean isDamaged;

    Vehicle(String name, int owner, String color) {
        this.name = name;
        this.owner = owner;
        this.isRented = false;
        this.isRunning = false;
        this.color = color;
        this.isDamaged = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getSafeSpeed() {
        return safeSpeed;
    }

    public void setSafeSpeed(int safeSpeed) {
        this.safeSpeed = safeSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    @Override
    public void startEngine() {
        this.isRunning = true;
        System.out.println("Engine is in position: " + this.isRunning);
    }

    @Override
    public void stopEngine() {
        this.isRunning = false;
        System.out.println("Engine is in position: " + this.isRunning);
    }

    @Override
    public void crash(int speed) {
        System.out.print("You crashed the vehicle! ");
        if (speed > safeSpeed) {
            isDamaged = true;
            System.out.println("It is totally damaged!");
        }
        else {
            Random random = new Random();
            System.out.println("It will be renovated in " + (random.nextInt(4) + 1) + " weeks.");
        }
    }
}
