package PF03.PreviousExams.House;

public class Tenant {
    private String ssn;
    private String name;
    Apartment apartment;

    public Tenant(String ssn, String name) {
        this.setSsn(ssn);
        this.setName(name);
        this.setApartment(null);
    }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Apartment getApartment() { return apartment; }
    public void setApartment(Apartment apartment) { this.apartment = apartment; }
}
