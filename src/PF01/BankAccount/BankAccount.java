package PF01.BankAccount;

import java.util.Scanner;

public class BankAccount {
    private String nbr;
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
        System.out.println("Balance: " + getBalance());
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public static void test() {
        BankAccount bankAccount = new BankAccount(2000);
        System.out.println(bankAccount.getBalance());
        bankAccount.deposit(300);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(500);
        System.out.println(bankAccount.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double startAmount = 0;
        int operation = 2;
        double amount = 0;
        String decision = "N";

        System.out.print("Bank account creation - enter amount of money that you want to have there: ");
        startAmount = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(startAmount);

        while (decision.equals("N") || decision.equals("n")) {
            System.out.print("Deposit or withdrawal (0-deposit, 1-withdrawal): ");
            operation = scanner.nextInt();
            if (operation != 0 && operation != 1) {
                System.out.println("Unknown operation. Maybe try again.");
            } else {
                System.out.print("Enter amount: ");
                amount = scanner.nextDouble();
                if (operation == 0) {
                    bankAccount.deposit(amount);
                } else {
                    bankAccount.withdraw(amount);
                }
                System.out.println("Balance: " + bankAccount.getBalance());
            }
            System.out.print("Would you like to exit? (Y/N) ");
            scanner.nextLine();
            decision = scanner.nextLine();
        }
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}
