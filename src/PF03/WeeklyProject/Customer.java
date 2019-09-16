package PF03.WeeklyProject;

import java.util.ArrayList;

public abstract class Customer {
    private String name;
    private String address;
    private String phoneNr;
    private ArrayList<Order> orders;

    Customer() {}

    Customer(String name, String address, String phoneNr) {
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNr(phoneNr);
        this.setOrders(new ArrayList<>());
    }

    Customer(String name, String address, String phoneNr, ArrayList<Order> orders) {
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNr(phoneNr);
        this.setOrders(orders);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNr() { return phoneNr; }
    public void setPhoneNr(String phoneNr) { this.phoneNr = phoneNr; }

    public ArrayList<Order> getOrders() { return orders; }
    public void setOrders(ArrayList<Order> orders) { this.orders = orders; }
    public void addOrder(Order order) {
        if (!getOrders().contains(order)) {
            getOrders().add(order);
            try { order.setOrderedBy(this); } catch (NullPointerException e) { }
        }
    }
    public void removeOrder(Order order) {
        if (getOrders().contains(order)) {
            getOrders().remove(order);
            try { order.setOrderedBy(null); } catch (NullPointerException e) { }
        }
    }
    public void removeOrder(String orderNr) {
        if (getOrders().contains(findOrder(orderNr))) {
            getOrders().remove(findOrder(orderNr));
            try { findOrder(orderNr).setOrderedBy(null); } catch (NullPointerException e) { }
        }
    }
    public Order findOrder(String orderNr) {
        for(Order order : getOrders())
            if (order.getOrderNr().equals(orderNr))
                return order;
        return null;
    }

    public int amountOfOrders() { return getOrders().size(); }
    public ArrayList<Article> listArticles() {
        ArrayList<Article> list = new ArrayList<>();
        for (Order order: getOrders())
            for (OrderLine orderLine : order.getOrderLines())
                if (!list.contains(orderLine.getArticle()))
                    list.add(orderLine.getArticle());
        return list;
    }

}
