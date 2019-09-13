package PF02.Quiz.JavaAssignment;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Customer customer1 = new Customer("1", "Anna");
        Customer customer2 = new Customer("2", "Eva");

        Account account1 = new Account("1", 500, customer1);
    //    customer1.addAccount(account1);
        Account account2 = new Account("2", 1000, customer1);
    //    customer1.addAccount(account2);
        Account account3 = new Account("3", 1500, customer2);
    //    customer2.addAccount(account3);

        CustomerRegister customerRegister = new CustomerRegister();

        ArrayList<Customer> tmpCustomers = new ArrayList<>();
        tmpCustomers.add(customer1);
        customerRegister.setCustomers(tmpCustomers);
        customerRegister.addCustomer(customer2);

        System.out.println("Initial:");
        customerRegister.printAccounts("1");
        customerRegister.printAccounts("2");

        account1.deposit(200);
        account2.withdraw(500);

        System.out.println("\nAfter first change:");
        customerRegister.printAccounts("1");
        customerRegister.printAccounts("2");

        System.out.println("Customers in the register:");
        for (Customer customer: customerRegister.getCustomers())
            System.out.println(customer.getNbr() + " " + customer.getName());

        System.out.println("Saldo of account 1 of customer 1 is: " +
                customerRegister.getAccountSaldo("1","1"));

        customerRegister.transfer("1", "3", 100);

        System.out.println("\nAfter transfer:");
        customerRegister.printAccounts("1");
        customerRegister.printAccounts("2");
    }
}
