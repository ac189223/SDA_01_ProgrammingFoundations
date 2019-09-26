package PF03.PreviousExams.Account;

import java.util.ArrayList;

public class Customer {
    private String nbr;
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String nbr, String name) {
        this.setNbr(nbr);;
        this.setName(name);
        this.setAccounts(new ArrayList<>());
    }

    public String getNbr() { return nbr; }
    public void setNbr(String nbr) { this.nbr = nbr; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ArrayList<Account> getAccounts() { return accounts; }
    public void setAccounts(ArrayList<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) {
        getAccounts().add(account);
        account.setOwner(this); }
}
