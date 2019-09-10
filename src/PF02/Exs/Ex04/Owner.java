package PF02.Exs.Ex04;

public class Owner {
    private String ssn;
    private String name;
    private Car ownerOf;

    public Owner() {}

    public Owner(String ssn, String name, Car ownerOf) {
        this.ssn = ssn;
        this.name = name;
        this.ownerOf = ownerOf;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Car getOwnerOf() { return ownerOf; }

    public void setOwnerOf(Car ownerOf) { this.ownerOf = ownerOf; }
}
