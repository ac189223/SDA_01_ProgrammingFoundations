package PF02.Exs.Ex07;

public class Account {
    private String nbr;
    private double balance;
    private Customer owner;

    public Account() {}

    public Account(String nbr, double balance, Customer owner) {
        this.nbr = nbr;
        this.balance = balance;
        this.owner = owner;
    }

    public String getNbr() { return nbr; }

    public void setNbr(String nbr) { this.nbr = nbr; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public Customer getOwner() { return owner; }

    public void setOwner(Customer owner) { this.owner = owner; }

    public void withdraw(double amount) { setBalance(getBalance() - amount); }

    public void deposit(double amount) { setBalance(getBalance() + amount); }

}
/*
Class: Account
 Withdraw take out a certain amount from the current account.
 deposit insert amount on the current account.
 */