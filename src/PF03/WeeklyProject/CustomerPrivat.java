package PF03.WeeklyProject;

import java.util.ArrayList;

public class CustomerPrivat extends Customer {
    private String ssn;
    
    public CustomerPrivat(String ssn, String name, String address, String phoneNr) {
        super(name, address, phoneNr);
        this.setSsn(ssn);
    }

    public CustomerPrivat(String ssn, String name, String address, String phoneNr, ArrayList<Order> orders) {
        super(name, address, phoneNr, orders);
        this.setSsn(ssn);
    }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }
}
