package PF02.Exs;

public class Ex02 {
    private String accountNr;
    private int amount;

    public Ex02(String accountNr, int amount) {
        this.accountNr = accountNr;
        this.amount = amount;
    }

    public String getAccountNr() { return accountNr; }

    public void setAccountNr(String accountNr) { this.accountNr = accountNr; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public void deposit(int amount) {
        setAmount(getAmount() + amount);
        printDetails();
    }

    public void withdraw(int amount) {
        setAmount(getAmount() - amount);
        printDetails();
    }

    public void printDetails() {
        System.out.println("There is  " + getAmount() + " SEK on account number " + getAccountNr() + ".");
    }

    public static void main(String[] args) {
        Ex02 bankAccount = new Ex02("57659834-67", 15000);

        bankAccount.printDetails();
        bankAccount.deposit(1500);
        bankAccount.withdraw(3000);
    }
}
