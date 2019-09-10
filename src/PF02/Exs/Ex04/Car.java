package PF02.Exs.Ex04;

public class Car {
    private String regNr;
    private String model;
    private Owner owner;

    public Car() {}

    public Car(String regNr, String model, Owner owner) {
        this.regNr = regNr;
        this.model = model;
        this.owner = owner;
    }

    public String getRegNr() { return regNr; }

    public void setRegNr(String regNr) { this.regNr = regNr; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public Owner getOwner() { return owner; }

    public void setOwner(Owner owner) { this.owner = owner; }
}
