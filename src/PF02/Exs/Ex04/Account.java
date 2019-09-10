package PF02.Exs.Ex04;

public class Account {
    private String accountNr;
    private Person holder;

    public Account() {}

    public Account(String accountNr, Person holder) {
        this.accountNr = accountNr;
        this.holder = holder;
    }

    public String getAccountNr() { return accountNr; }

    public void setAccountNr(String accountNr) { this.accountNr = accountNr; }

    public Person getHolder() { return holder; }

    public void setHolder(Person holder) { this.holder = holder; }
}
