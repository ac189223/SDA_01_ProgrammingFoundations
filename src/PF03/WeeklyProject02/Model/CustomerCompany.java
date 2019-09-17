package PF03.WeeklyProject02.Model;

import java.util.ArrayList;

public class CustomerCompany extends Customer {
    private String corporateId;

    public CustomerCompany(String corporateId, String name, String address, String phoneNr) {
        super(name, address, phoneNr);
        this.setCorporateId(corporateId);
    }

    public CustomerCompany(String corporateId, String name, String address, String phoneNr, ArrayList<Order> orders) {
        super(name, address, phoneNr, orders);
        this.setCorporateId(corporateId);
    }

    public String getCorporateId() { return corporateId; }
    public void setCorporateId(String corporateId) { this.corporateId = corporateId; }
}
