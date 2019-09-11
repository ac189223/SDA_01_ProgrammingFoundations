package PF02.Exs.Ex08;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    private static PersonRegister personRegister = new PersonRegister(new ArrayList<>());

    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        personRegister.getPeople().add(new Person("820319-3453", "Karl", new ArrayList<>()));
        personRegister.getPeople().add(new Person("850702-3654", "Monique", new ArrayList<>()));
        personRegister.getPeople().add(new Person("800411-9764", "Stephan", new ArrayList<>()));
        personRegister.getPeople().add(new Person("921130-7465", "Anna", new ArrayList<>()));

        bankAccounts.add(new BankAccount("92-1530-743", 35000, new Person()));
        bankAccounts.add(new BankAccount("56-8473-768", 63000, new Person()));
        bankAccounts.add(new BankAccount("98-8968-424", 28000, new Person()));
        bankAccounts.add(new BankAccount("32-4657-134", 47000, new Person()));
        bankAccounts.add(new BankAccount("92-6555-003", 34500, new Person()));
        bankAccounts.add(new BankAccount("96-8543-768", 54000, new Person()));
        bankAccounts.add(new BankAccount("98-8968-254", 20000, new Person()));
        bankAccounts.add(new BankAccount("07-4337-934", 64000, new Person()));
        bankAccounts.add(new BankAccount("92-1530-743", 43000, new Person()));
        bankAccounts.add(new BankAccount("21-8653-748", 63000, new Person()));
        bankAccounts.add(new BankAccount("65-8968-784", 33000, new Person()));
        bankAccounts.add(new BankAccount("99-4657-232", 40000, new Person()));

        Random random = new Random();
        int personCount = 0;
        for (BankAccount bankAccount : bankAccounts) {
            personRegister.getPeople().get(personCount % personRegister.getPeople().size()).addAccount(bankAccount);
            bankAccount.setOwner(personRegister.getPeople().get(personCount % personRegister.getPeople().size()));
            personCount++;
        }

        for (Person person : personRegister.getPeople())
            person.printStatus();
        System.out.println();

        personRegister.remove("850702-3654");

        for (Person person : personRegister.getPeople())
            person.printStatus();
        System.out.println();

        for (int i = 0; i < random.nextInt(20) + 11; i++) {
            int randomPerson = random.nextInt(personRegister.getPeople().size());
            if (personRegister.getPeople().get(randomPerson).getBankAccounts().size() > 0) {
                int randomAccount = random.nextInt(personRegister.getPeople().get(randomPerson).getBankAccounts().size());
                double randomAmount = (double)(random.nextInt(50) + 1) * 1000;
                if ((i % 2) == 0)
                    personRegister.getPeople().get(randomPerson).getBankAccounts().get(randomAccount).withdraw(randomAmount);
                else
                    personRegister.getPeople().get(randomPerson).getBankAccounts().get(randomAccount).deposit(randomAmount);
            }
        }

        System.out.println("\nHere is the updated view after transfers:");
        for (Person person : personRegister.getPeople())
            person.printStatus();
        System.out.println();
    }
}
