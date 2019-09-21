package PF03.WeeklyProject03.Model;

import java.util.ArrayList;

public class Order {
    private String orderNr;
    private String date;
    private ArrayList<OrderLine> orderLines = new ArrayList<>();
    private Customer orderedBy;

    public Order() { }

    public Order(String orderNr, String date) {
        this.setOrderNr(orderNr);
        this.setDate(date);
        this.setOrderLines(new ArrayList<>());
    }
    public Order(String orderNr, String date, Customer orderedBy) {
        this.setOrderNr(orderNr);
        this.setDate(date);
        this.setOrderLines(new ArrayList<>());
        this.setOrderedBy(orderedBy);
    }

    public Order(String orderNr, String date, ArrayList<OrderLine> orderLines, Customer orderedBy) {
        this.setOrderNr(orderNr);
        this.setDate(date);
        this.setOrderLines(orderLines);
        this.setOrderedBy(orderedBy);
    }

    public String getOrderNr() { return orderNr; }
    public void setOrderNr(String orderNr) { this.orderNr = orderNr; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public ArrayList<OrderLine> getOrderLines() { return orderLines; }
    public void setOrderLines(ArrayList<OrderLine> orderLines) { this.orderLines = orderLines; }
    public void addOrderLine(OrderLine orderLine) {
        if (!getOrderLines().contains(orderLine)) {
            if (!listArticles().contains(orderLine.getArticle())) {
                getOrderLines().add(orderLine);
                try { orderLine.setOrder(this); } catch (NullPointerException e) { }
            } else {
                OrderLine tmpOrderLine = findOrderLine(orderLine.getArticle());
                tmpOrderLine.setQuantity(tmpOrderLine.getQuantity() + orderLine.getQuantity());
            }
        }
    }
    public void addOrderLine(int quantity, Article article) {
    	OrderLine orderLine = new OrderLine(quantity, article);
    	addOrderLine(orderLine);
    }
    public void removeOrderLine(OrderLine orderLine) {
        if (getOrderLines().contains(orderLine)) {
            getOrderLines().remove(orderLine);
            try { orderLine.setOrder(null); } catch (NullPointerException e) { }
        }
    }
    public OrderLine findOrderLine(Article article) {
        for (OrderLine orderLine: getOrderLines()) {
            if (orderLine.getArticle() == article)
                return orderLine;
        }
        return null;
    }


    public Customer getOrderedBy() { return orderedBy; }
    public void setOrderedBy(Customer orderedBy) {
        if (this.orderedBy != orderedBy) {
            this.orderedBy = orderedBy;
            try { orderedBy.addOrder(this); } catch (NullPointerException e) { }
        }
    }
    public void removeOrderedBy() {
        if (this.orderedBy == orderedBy) {
            this.orderedBy = null;
            try { orderedBy.removeOrder(this); } catch (NullPointerException e) { }
        }
    }

        public int amountOfLines() { return getOrderLines().size(); }
    public int amountOfArticles() {
        int amount = 0;
        for (OrderLine orderLine : getOrderLines()) {
            amount += orderLine.getQuantity();
        }
        return amount;
    }
    public ArrayList<Article> listArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        for (OrderLine orderLine : getOrderLines()) {
            if (!articles.contains(orderLine.getArticle()))
                articles.add(orderLine.getArticle());
        }
        return articles;
    }
    public double valueOfOrder() {
        double sum = 0;
        for (OrderLine orderLine: getOrderLines()) {
            sum += orderLine.getValue();
        }
        return sum;
    }

    public ArrayList<Supplier> listSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        for (OrderLine orderLine: getOrderLines()) {
            if (!suppliers.contains(orderLine.getArticle().getSupplier()))
                suppliers.add(orderLine.getArticle().getSupplier());
        }
        return suppliers;
    }

}