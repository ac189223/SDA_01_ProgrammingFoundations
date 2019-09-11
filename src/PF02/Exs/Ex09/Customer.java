package PF02.Exs.Ex09;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private ArrayList<Order> orders;

    Customer() {}

    Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }

    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public ArrayList<Order> getOrders() { return orders; }

    public void setOrders(ArrayList<Order> orders) { this.orders = orders; }

    public double totalPrice() {
        double sum = 0;
        for (Order order: getOrders())
            sum += order.orderPrice();
        return sum;
    }

    public void addOrder(Order order) { getOrders().add(order); }
}
