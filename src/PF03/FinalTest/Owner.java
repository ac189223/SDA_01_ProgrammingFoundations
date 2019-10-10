package PF03.FinalTest;

public class Owner {
    private String ssn;
    private String name;
    private Car car;

    public Owner () {}
    public Owner (String ssn, String name) {
        this.setSsn(ssn);
        this.setName(name);
    }
    public Owner (String ssn, String name, Car car) {
        this.setSsn(ssn);
        this.setName(name);
        this.setCar(car);
    }

    public void setSsn(String ssn) { this.ssn = ssn; }
    public String getSsn() { return this.ssn; }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void setCar(Car car) { this.car = car; }
    public Car getCar() { return this.car; }


}
