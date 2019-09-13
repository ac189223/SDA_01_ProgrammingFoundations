package PF02.Quiz.JavaAssignment;

import java.util.ArrayList;

public class CustomerRegister {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerRegister() { }

    public ArrayList<Customer> getCustomers() { return customers; }

    public void setCustomers(ArrayList<Customer> customers) { this.customers = customers; }

    public void addCustomer(Customer customer) { getCustomers().add(customer); }

    public Customer find(String nbr) {
        for (Customer customer : getCustomers())
            if (customer.getNbr().equals(nbr))
                return customer;
        return null;
    }

    public void printAccounts(String customerNbr) { find(customerNbr).printAccounts(); }

    public double getAccountSaldo(String customerNbr, String accountNbr) { return find(customerNbr).printSaldo(accountNbr); }

    public void transfer(String fromAccountNbr, String toAccountNbr, double amount) {
        for (Customer customer: getCustomers())
            for (Account account: customer.getOwnerOf()) {
                if (account.getNbr().equals(fromAccountNbr))
                    account.withdraw(amount);
                if (account.getNbr().equals(toAccountNbr))
                    account.deposit(amount);
            }
    }
}