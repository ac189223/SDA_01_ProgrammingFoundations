package PF02.Demos;

import java.util.ArrayList;

public class Demo01_CustomerReg {
    private ArrayList<Demo01_Customer> customerReg;

    public Demo01_CustomerReg() {
        setCustomerReg(new ArrayList<Demo01_Customer>());
    }

    public ArrayList<Demo01_Customer> getCustomerReg() {
        return customerReg;
    }

    public void setCustomerReg(ArrayList<Demo01_Customer> customerReg) {
        this.customerReg = customerReg;
    }

    public void addCustomer(Demo01_Customer aCustomer) {
        getCustomerReg().add(aCustomer); }

    public void deleteCustomer(String personalNumber) {
        Demo01_Customer tmpCustomer;
        int i = 0;
        boolean find = false;

        while (i < getCustomerReg().size() && !find) {
            tmpCustomer = getCustomerReg().get(i);
            if (tmpCustomer.getPersonalNumber().equals(personalNumber)) {
                getCustomerReg().remove(i);
                find = true;
            }
            i++;
        }
    }

    public Demo01_Customer customerSearch(String personalNumber) {
        Demo01_Customer tmpCustomer;
        int i = 0;
        boolean find = false;
        int index = -1;

        while (i < getCustomerReg().size() && find == false) {
            tmpCustomer = getCustomerReg().get(i);
            if (tmpCustomer.getPersonalNumber().equals(personalNumber)) {
                index = i;
                find = true;
            }
            i++;
        }

        if (index != -1)
            tmpCustomer = getCustomerReg().get(index);
        else
            tmpCustomer = null;
        return tmpCustomer;
    }

    public static void main(String[] args) {
        Demo01_CustomerReg reg = new Demo01_CustomerReg();
        Demo01_Customer tmpCustomer;
        Demo01_Customer customer1 = new Demo01_Customer("800501-1122", "Anna Ahl", "Lund");
        Demo01_Customer customer2 = new Demo01_Customer("811222-2345", "Hans Hage", "Malmo");
        Demo01_Customer customer3 = new Demo01_Customer("830112-3456", "Eva Lind", "Ystad");

        reg.addCustomer(customer1);
        reg.addCustomer(customer2);
        reg.addCustomer(customer3);
        reg.deleteCustomer("811222-2345");
        tmpCustomer = reg.customerSearch("800501-1122");
        System.out.println (tmpCustomer.getNameSurname());

        for (int i = 0; i < reg.getCustomerReg().size(); i++) {
            tmpCustomer = reg.getCustomerReg().get(i);
            System.out.println (tmpCustomer.getNameSurname() + ", " + tmpCustomer.getPersonalNumber() + ", " + tmpCustomer.getCity());
        }
    }
}
