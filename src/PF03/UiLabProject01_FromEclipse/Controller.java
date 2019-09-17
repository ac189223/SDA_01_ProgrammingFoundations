package PF03.UiLabProject01_FromEclipse;

import javax.swing.*;

public class Controller {
    CustomerRegister customers;     //Reference to model ("CustomerRegister")
    JFrame customerFrame;           //Reference to graphic view

    public Controller(CustomerRegister customerReg, JFrame customerFrame) {
        this.customers = customerReg;
        this.customerFrame = customerFrame;
    }

    public void addCustomer(String cNumber, String cName) {
        Customer tmpCustomer = new Customer(cNumber, cName);
        customers.addCustomer(tmpCustomer);
    }

    public void addCustomer(String nbr, String name, int cardN, String cardT) {
        Customer tmpCustomer = new Customer(nbr, name);
        CreditCard creditCard = new CreditCard(cardN, cardT);
        tmpCustomer.setCreditCard(creditCard);
        creditCard.setHolder(tmpCustomer);
        customers.addCustomer(tmpCustomer);
    }

    public void removeCustomer(String cNumberRemove) {
        customers.removeCustomer(cNumberRemove);
    }

    public String[] findCustomer(String cNumberFind) {
        Customer c;
        String[] aCust = null;
        c = customers.findCustomer(cNumberFind);
        if (c != null && c.getCreditCard() != null) {
            aCust = new String[4];
            aCust[0] = c.getCNumber();
            aCust[1] = c.getCName();
            aCust[2] = c.getCreditCard().getType();
            aCust[3] = Integer.toString(c.getCreditCard().getCardNumber());
        } else if (c != null) {
            aCust = new String[2];
            aCust[0] = c.getCNumber();
            aCust[1] = c.getCName();
        }
        return aCust;
    }

    public void updateCustomerName(String cNumber, String newCName) {
        customers.setCustomerName(cNumber, newCName);
    }
}