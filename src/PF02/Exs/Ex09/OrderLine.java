package PF02.Exs.Ex09;

import java.util.ArrayList;

public class OrderLine {
    private int quantity;
    private Article article;
    private ArrayList<Order> inOrders;

    OrderLine(int quantity) {
        this.quantity = quantity;
        this.article = new Article();
        this.inOrders = new ArrayList<>();
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Article getArticle() { return article; }

    public void setArticle(Article article) { this.article = article; }

    public double getPrice() { return quantity * getArticle().getPrice(); }

    public ArrayList<Order> getInOrders() { return inOrders; }

    public void setInOrders(ArrayList<Order> inOrders) { this.inOrders = inOrders; }

    public void addOrder(Order order) { getInOrders().add(order); }
}