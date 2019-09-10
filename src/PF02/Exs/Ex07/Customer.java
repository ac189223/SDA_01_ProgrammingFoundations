package PF02.Exs.Ex07;

import java.util.ArrayList;

public class Customer {
    private String ssn;
    private String name;
    private ArrayList<Account> ownerOf;

    public Customer() {}

    public Customer(String ssn, String name, ArrayList<Account> ownerOf) {
        this.ssn = ssn;
        this.name = name;
        this.ownerOf = ownerOf;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Account> getOwnerOf() { return ownerOf; }

    public void setOwnerOf(ArrayList<Account> ownerOf) { this.ownerOf = ownerOf; }

    public void addAccount(Account account) { getOwnerOf().add(account); }

    public void printStatus() { System.out.println(getName() + " owns " + getOwnerOf().size() +
            " bank accounts and has total of " + totalBalance() + " SEK"); }

    public double totalBalance() {
        double sum = 0;
        for (Account account: getOwnerOf())
            sum += account.getBalance();
        return sum;
    }
}
