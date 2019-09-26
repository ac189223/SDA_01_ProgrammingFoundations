package PF03.PreviousExams.Account;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        AccountRegister accountRegister = new AccountRegister(new ArrayList<>());
        // create customer
        Customer customer = new Customer("0101", "Fabian");
        // create account by adding to customer
        customer.addAccount(new Account("01", 1500));
        // add account to register
        accountRegister.addAccount(customer.getAccounts().get(0));
        // create account by adding to customer
        accountRegister.addAccount(new Account("02", 2000));
        System.out.println("Balance on start" +
                "\nAccount01  -  " + accountRegister.findAccount("01").getBalance() +
                "\nAccount02  -  " + accountRegister.findAccount("02").getBalance() +
                "\n" + customer.getName() + " owns account" + customer.getAccounts().get(0).getNbr() );
        // withdraw and deposit
        accountRegister.findAccount("01").withdraw(200);
        accountRegister.getAccounts().get(1).deposit(50);
        System.out.println("Balance in the middle" +
                "\nAccount01  -  " + accountRegister.findAccount("01").getBalance() +
                "\nAccount02  -  " + accountRegister.findAccount("02").getBalance());
        accountRegister.transfer("01", "02",500);
        System.out.println("Balance at the end" +
                "\nAccount01  -  " + accountRegister.findAccount("01").getBalance() +
                "\nAccount02  -  " + accountRegister.findAccount("02").getBalance());

    }
}
