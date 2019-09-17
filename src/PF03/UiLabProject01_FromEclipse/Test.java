package PF03.UiLabProject01_FromEclipse;

public class Test {
    public static void main(String[] args) {

        // Creates two new credit cards
        CreditCard creditCard1 = new CreditCard(123, "Visa");
        CreditCard creditCard2 = new CreditCard(234, "Master Card");

        // Creates two new customers
        Customer customer1 = new Customer("111111-1111", "Anna Andersson");
        Customer customer2 = new Customer("222222-22222", "Beata Bengtsson");

        // Creates a new customer register
        CustomerRegister customers = new CustomerRegister();

        // Connects cards to customer
        creditCard1.setHolder(customer1);
        creditCard2.setHolder(customer2);

        // Connects customer to card
        customer1.setCreditCard(creditCard1);
        customer2.setCreditCard(creditCard2);

        // Inserts customers into a ArrayList
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);

        // Test some of the object's methods
        System.out.println(creditCard1.getHolder().getCName());
        System.out.println(customer2.getCreditCard().getCardNumber());
        Customer tmpC = customers.findCustomer("111111-1111");
        if (tmpC != null)
            System.out.println("Find: " + tmpC.getCName());
        customers.removeCustomer("111111-1111");
        Customer tmpCustomer = customers.findCustomer("111111-1111");
        if (tmpCustomer == null)
            System.out.println("It is working!!!");
    }
}
