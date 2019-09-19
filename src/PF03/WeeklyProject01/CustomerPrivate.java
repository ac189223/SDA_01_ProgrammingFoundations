package PF03.WeeklyProject01;

import java.util.ArrayList;

public class CustomerPrivate extends Customer {
    private String ssn;
    
    public CustomerPrivate(String ssn, String name, String address, String phoneNr) {
        super(name, address, phoneNr);
        this.setSsn(ssn);
    }

    public CustomerPrivate(String ssn, String name, String address, String phoneNr, ArrayList<Order> orders) {
        super(name, address, phoneNr, orders);
        this.setSsn(ssn);
    }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }
}
