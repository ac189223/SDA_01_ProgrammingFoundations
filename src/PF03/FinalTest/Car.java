package PF03.FinalTest;

public class Car {
    private String regNr;
    private String model;
    private Owner owner;

    public Car() {}
    public Car(String regNr, String model) {
        this.setRegNr(regNr);
        this.setModel(model);
    }
    public Car(String regNr, String model, Owner owner) {
        this.setRegNr(regNr);
        this.setModel(model);
        this.setOwner(owner);
    }

    public void setRegNr(String regNr) { this.regNr = regNr; }
    public String getRegNr() { return this.regNr; }

    public void setModel(String model) { this.model = model; }
    public String getModel() { return this.model; }

    public void setOwner(Owner owner) {
        this.owner = owner;
        this.getOwner().setCar(this);
    }
    public Owner getOwner() { return this.owner; }

}
