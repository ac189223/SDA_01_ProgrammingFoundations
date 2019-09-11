package PF02.Exs.Ex08;

import java.util.ArrayList;

public class Person {
    private String pNbr;
    private String name;
    private ArrayList<BankAccount> bankAccounts;

    public Person() {}

    public Person(String pNbr, String name, ArrayList<BankAccount> bankAccounts) {
        this.pNbr = pNbr;
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public String getpNbr() { return pNbr; }

    public void setpNbr(String pNbr) { this.pNbr = pNbr; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<BankAccount> getBankAccounts() { return bankAccounts; }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) { this.bankAccounts = bankAccounts; }

    public void addAccount(BankAccount bankAccount) { getBankAccounts().add(bankAccount); }

    public void printStatus() { System.out.println(getName() + " owns " + getBankAccounts().size() +
            " bank accounts and has total of " + totalBalance() + " SEK"); }

    public double totalBalance() {
        double sum = 0;
        for (BankAccount bankAccount : getBankAccounts())
            sum += bankAccount.getBalance();
        return sum;
    }
}
