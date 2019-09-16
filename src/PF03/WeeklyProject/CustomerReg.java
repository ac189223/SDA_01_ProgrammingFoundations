package PF03.WeeklyProject;

import java.util.ArrayList;

public class CustomerReg {
    private ArrayList<Customer> customers = new ArrayList<>();

    CustomerReg() { }

    CustomerReg(ArrayList<Customer> customers) { this.setCustomers(customers); }

    public ArrayList<Customer> getCustomers() { return customers; }
    public void setCustomers(ArrayList<Customer> customers) { this.setCustomers(customers); }
    public void addCustomers(Customer customer) { getCustomers().add(customer); }
    public void removeCustomer(Customer customer) { getCustomers().remove(customer); }
    public void removeCustomer(String id) { getCustomers().remove(findCustomer(id)); }

    public Customer findCustomer(String id) {
        for (Customer customer : getCustomers())
            if (customer.getClass() == CustomerPrivat.class)
                checkSsn((CustomerPrivat) customer, id);
            else
                checkCorporateId((CustomerCompany)customer, id);
        return null;
    }
    private Customer checkSsn(CustomerPrivat customer, String id) {
        if (customer.getSsn().equals(id))
            return customer;
        return null;
    }
    private Customer checkCorporateId(CustomerCompany customer, String id) {
        if (customer.getCorporateId().equals(id))
            return customer;
        return null;
    }

    public void printArticlesOfCustomer(String id) { findCustomer(id).listArticles(); }
    public void printArticlesOfCustomer(Customer customer) { customer.listArticles(); }

    public ArrayList<Supplier> findSuppliersOfCustomer(String id) { return null; }
    public ArrayList<Supplier> findSuppliersOfCustomer(Customer customer) { return null; }


}