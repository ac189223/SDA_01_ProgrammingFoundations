package PF02.Exs.Ex07;

import java.util.ArrayList;

public class AccountRegister {
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountRegister(ArrayList<Account> accounts) { this.accounts = accounts; }

    public ArrayList<Account> getAccounts() { return accounts; }

    public void setAccounts(ArrayList<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) { getAccounts().add(account); }

    public Account find(String nbr) {
        for (Account account: getAccounts())
            if (account.getNbr().equals(nbr))
                return account;
        return null;
    }

    public void transfer(String fromNbr, String toNbr, double amount) {
        find(fromNbr).withdraw(amount);
        find(toNbr).deposit(amount);
        System.out.println("Transferred " + amount + " from " + fromNbr + " to " + toNbr);
    }
}
/*
Class: AccountRegister:
 add method are adding an account
 find method have to find and return an account
    (nbr in Account is unique).
    If no account with the current nbr is found, null is returned.
 Transfer method moves a certain amount from one account to another account.
    You can assume that it is money at the account the money is transferred from
    (no control of the balance is needed). 
whoOwnsAccount (Strint accountNbr): Customer.
    The method should return the customer who owns the account.
    If there is no customer, null is returned.
 */