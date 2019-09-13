package PF02.Quiz.JavaAssignment;

public class Account {
    private String nbr;
    private double saldo;
    private Customer owner;

    public Account() {}

    public Account(String nbr, double saldo, Customer owner) {
        this.setNbr(nbr);
        this.setSaldo(saldo);
        this.setOwner(owner);
        owner.addAccount(this);
    }

    public String getNbr() { return nbr; }

    public void setNbr(String nbr) { this.nbr = nbr; }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    public Customer getOwner() { return owner; }

    public void setOwner(Customer owner) { this.owner = owner; }

    public void withdraw(double amount) { setSaldo(getSaldo() - amount); }

    public void deposit(double amount) { setSaldo(getSaldo() + amount); }

    public void printStatus() { System.out.println("    account number " + getNbr() + " with saldo " + getSaldo()); }
}