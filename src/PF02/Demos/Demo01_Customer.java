package PF02.Demos;

public class Demo01_Customer {
    private String personalNumber;
    private String nameSurname;
    private String city;

    public Demo01_Customer() {}

    public Demo01_Customer(String personalNumber, String nameSurname, String city) {
        this.personalNumber = personalNumber;
        this.nameSurname = nameSurname;
        this.city = city;
    }

    public String getPersonalNumber() { return personalNumber; }

    public void setPersonalNumber(String personalNumber) { this.personalNumber = personalNumber; }

    public String getNameSurname() { return nameSurname; }

    public void setNameSurname(String nameSurname) { this.nameSurname = nameSurname; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }
}
