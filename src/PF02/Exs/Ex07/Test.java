package PF02.Exs.Ex07;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    private static AccountRegister accReg = new AccountRegister(new ArrayList<>());

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        customers.add(new Customer("820319-3453", "Karl", new ArrayList<>()));
        customers.add(new Customer("850702-3654", "Monique", new ArrayList<>()));
        customers.add(new Customer("800411-9764", "Stephan", new ArrayList<>()));
        customers.add(new Customer("921130-7465", "Anna", new ArrayList<>()));

        accounts.add(new Account("92-1530-743", 35000, new Customer()));
        accounts.add(new Account("56-8473-768", 63000, new Customer()));
        accounts.add(new Account("98-8968-424", 28000, new Customer()));
        accounts.add(new Account("32-4657-134", 47000, new Customer()));
        accounts.add(new Account("92-6555-003", 34500, new Customer()));
        accounts.add(new Account("96-8543-768", 54000, new Customer()));
        accounts.add(new Account("98-8968-254", 20000, new Customer()));
        accounts.add(new Account("07-4337-934", 64000, new Customer()));
        accounts.add(new Account("92-1530-743", 43000, new Customer()));
        accounts.add(new Account("21-8653-748", 63000, new Customer()));
        accounts.add(new Account("65-8968-784", 33000, new Customer()));
        accounts.add(new Account("99-4657-232", 40000, new Customer()));

        Random random = new Random();
        for (Account account: accounts) {
            account.setOwner(customers.get(random.nextInt(customers.size())));
            account.getOwner().addAccount(account);
        }

        for (Customer customer: customers)
            customer.printStatus();
        System.out.println();

        accReg.setAccounts(accounts);

        for (int i = 0; i < random.nextInt(20) + 11; i++)
            accReg.transfer(accounts.get(random.nextInt(accounts.size())).getNbr(),
                    accounts.get(random.nextInt(accounts.size())).getNbr(),
                    (double)(random.nextInt(50) + 1) * 1000);

        System.out.println("\nHere is the updated view after transfers:");
        for (Customer customer: customers)
            customer.printStatus();

        System.out.println("\nAccount 32-4657-134 is owned by " + accReg.whoOwnsAccount("32-4657-134").getName());
    }
}
