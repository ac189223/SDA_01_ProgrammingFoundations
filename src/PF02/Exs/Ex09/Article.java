package PF02.Exs.Ex09;

import java.util.ArrayList;

public class Article {
    private String articleId;
    private String name;
    private double price;
    private ArrayList<Supplier> suppliers;
    private ArrayList<OrderLine> orderedIn;

    Article() {}

    Article(String articleId, String name, double price) {
        this.articleId = articleId;
        this.name = name;
        this.price = price;
        this.suppliers = new ArrayList<>();
        this.orderedIn = new ArrayList<>();
    }

    public String getArticleId() { return articleId; }

    public void setArticleId(String articleId) { this.articleId = articleId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public ArrayList<Supplier> getSuppliers() { return suppliers; }

    public void setSuppliers(ArrayList<Supplier> suppliers) { this.suppliers = suppliers; }

    public ArrayList<OrderLine> getOrderedIn() { return orderedIn; }

    public void setOrderedIn(ArrayList<OrderLine> orderedIn) { this.orderedIn = orderedIn; }

    public void addSupplier(Supplier supplier) { getSuppliers().add(supplier); }

    public void addOrderLine(OrderLine orderLine) { getOrderedIn().add(orderLine); }

    public String orderedBy() {
        ArrayList<String> ordered = new ArrayList<>();
        for (OrderLine orderline: orderedIn)
            for (Order order: orderline.getInOrders())
                ordered.add(order.getCustomer().getName());
        if (ordered.size() > 0)
            return ordered.toString().substring(1, ordered.toString().length() - 1);
        else
            return " no one";
    }
}
