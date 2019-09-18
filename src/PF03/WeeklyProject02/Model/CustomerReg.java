package PF03.WeeklyProject02.Model;

import java.util.ArrayList;

public class CustomerReg {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerReg() { }

    public CustomerReg(ArrayList<Customer> customers) { this.setCustomers(customers); }

    public ArrayList<Customer> getCustomers() { return customers; }
    public void setCustomers(ArrayList<Customer> customers) { this.setCustomers(customers); }
    public void addCustomers(Customer customer) { getCustomers().add(customer); }
    public void removeCustomer(Customer customer) { getCustomers().remove(customer); }
    public void removeCustomer(String id) { getCustomers().remove(findCustomer(id)); }

    public Customer findCustomer(String id) {
        for (Customer customer : getCustomers())
            if (customer.getClass() == CustomerPrivate.class)
                return checkSsn((CustomerPrivate) customer, id);
            else
                return checkCorporateId((CustomerCompany)customer, id);
        return null;
    }
    private Customer checkSsn(CustomerPrivate customer, String id) {
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


    public void updateCustomer(String custId, String name, String address, String phone) {
        Customer tmpCustomer = findCustomer(custId);
        tmpCustomer.setName(name);
        tmpCustomer.setAddress(address);
        tmpCustomer.setPhoneNr(phone);
    }
}