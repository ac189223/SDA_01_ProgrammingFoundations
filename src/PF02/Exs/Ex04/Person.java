package PF02.Exs.Ex04;

public class Person {
    private String ssn;
    private String name;
    private Account holderOf;

    public Person() {}

    public Person(String ssn, String name, Account holderOf) {
        this.ssn = ssn;
        this.name = name;
        this.holderOf = holderOf;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Account getHolderOf() { return holderOf; }

    public void setHolderOf(Account holderOf) { this.holderOf = holderOf; }
}
