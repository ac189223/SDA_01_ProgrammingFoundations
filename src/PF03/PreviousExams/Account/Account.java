package PF03.PreviousExams.Account;

public class Account {
    private String nbr;
    private double balance;
    private Customer owner;

    public Account(String nbr, double balance) {
        this.setNbr(nbr);
        this.setBalance(balance);
        this.setOwner(null);
    }

    public String getNbr() { return nbr; }
    public void setNbr(String nbr) { this.nbr = nbr; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Customer getOwner() { return owner; }
    public void setOwner(Customer owner) { this.owner = owner; }

    public void withdraw(double amount) { this.setBalance(getBalance() - amount); }
    public void deposit(double amount) { this.setBalance(getBalance() + amount); }
}
