package PF02.Quiz.JavaAssignment;

import java.util.ArrayList;

public class Customer {
    private String nbr;
    private String name;
    private ArrayList<Account> ownerOf;

    public Customer() {}

    public Customer(String nbr, String name) {
        this.setNbr(nbr);
        this.setName(name);
        this.setOwnerOf(new ArrayList<>());
    }

    public Customer(String nbr, String name, ArrayList<Account> ownerOf) {
        this.setNbr(nbr);
        this.setName(name);
        this.setOwnerOf(ownerOf);
    }

    public String getNbr() { return nbr; }

    public void setNbr(String nbr) { this.nbr = nbr; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Account> getOwnerOf() { return ownerOf; }

    public void setOwnerOf(ArrayList<Account> ownerOf) { this.ownerOf = ownerOf; }

    public void addAccount(Account account) { getOwnerOf().add(account); }

    private Account findAccount(String nbr) {
        for(Account account: getOwnerOf())
            if (account.getNbr().equals(nbr))
                return account;
        return null;
    }

    public void printAccounts() {
        System.out.println(getName() + " owns below bank accounts:");
        for (Account account: getOwnerOf()) {
            account.printStatus();
        }
    }

    public double printSaldo(String accountNbr) { return findAccount(accountNbr).getSaldo(); }
}
