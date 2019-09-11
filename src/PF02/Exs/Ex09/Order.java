package PF02.Exs.Ex09;

import java.util.ArrayList;

public class Order {
    private String orderNr;
    private String date;
    private Customer customer;
    private ArrayList<OrderLine> orderLines;

    Order(String orderNr, String date) {
        this.orderNr = orderNr;
        this.date = date;
        this.customer = new Customer();
        this.orderLines = new ArrayList<>();
    }

    public String getOrderNr() { return orderNr; }

    public void setOrderNr(String orderNr) { this.orderNr = orderNr; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public ArrayList<OrderLine> getOrderLines() { return orderLines; }

    public void setOrderLines(ArrayList<OrderLine> orderLines) { this.orderLines = orderLines; }

    public double orderPrice() {
        double sum = 0;
        for (OrderLine orderLine: getOrderLines())
            sum += orderLine.getPrice();
        return sum;
    }

    public void addOrderLine(OrderLine orderLine) { getOrderLines().add(orderLine); }
}