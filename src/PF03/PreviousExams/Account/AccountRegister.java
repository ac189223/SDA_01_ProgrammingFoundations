package PF03.PreviousExams.Account;

import java.util.ArrayList;

public class AccountRegister {
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountRegister(ArrayList<Account> accounts) { this.setAccounts(accounts); }
    public ArrayList<Account> getAccounts() { return accounts; }
    public void setAccounts(ArrayList<Account> accounts) { this.accounts = accounts; }

    public void addAccount(Account account) { getAccounts(). add(account); }
    public Account findAccount(String nbr) {
        return getAccounts().stream().filter(account -> account.getNbr().equals(nbr)).findAny().get(); }
    public void transfer(String fromAccountNbr, String toAccountNbr, double amount) {
        findAccount(fromAccountNbr).withdraw(amount);
        findAccount(toAccountNbr).deposit(amount);
    }
}
