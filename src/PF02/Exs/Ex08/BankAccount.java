package PF02.Exs.Ex08;

public class BankAccount {
    private String nbr;
    private double balance;
    private Person owner;

    public BankAccount() {}

    public BankAccount(String nbr, double balance, Person owner) {
        this.nbr = nbr;
        this.balance = balance;
        this.owner = owner;
    }

    public String getNbr() { return nbr; }

    public void setNbr(String nbr) { this.nbr = nbr; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public Person getOwner() { return owner; }

    public void setOwner(Person owner) { this.owner = owner; }

    public void withdraw(double amount) { setBalance(getBalance() - amount); }

    public void deposit(double amount) { setBalance(getBalance() + amount); }

}
/*
Class: BankAccount
 Withdraw take out a certain amount from the current account.
 deposit insert amount on the current account.
 */