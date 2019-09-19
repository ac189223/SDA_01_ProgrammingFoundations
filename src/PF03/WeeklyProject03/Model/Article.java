package PF03.WeeklyProject03.Model;

import java.util.ArrayList;

public class Article {
    private String id;
    private String name;
    private double price;
    private Supplier supplier;
    private ArrayList<OrderLine> orderedInLines = new ArrayList<>();

    public Article () { }

    public Article(String id, String name, double price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setSupplier(new Supplier());
        this.setOrderedInLines(new ArrayList<>());
    }

    public Article(String id, String name, double price, Supplier supplier) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setSupplier(supplier);
        this.setOrderedInLines(new ArrayList<>());
    }

    public Article(String id, String name, double price, Supplier supplier, ArrayList<OrderLine> orderedInLines) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setSupplier(supplier);
        this.setOrderedInLines(orderedInLines);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) {
        if (this.supplier != supplier) {
            this.supplier = supplier;
            try { supplier.addArticle(this); } catch (NullPointerException e) { }
        }
    }

    public ArrayList<OrderLine> getOrderedInLines() { return orderedInLines; }
    public void setOrderedInLines(ArrayList<OrderLine> orderedInLines) { this.orderedInLines = orderedInLines; }
    public void addOrderedInLine(OrderLine orderedInLine) {
        if (!getOrderedInLines().contains(orderedInLine)) {
            getOrderedInLines().add(orderedInLine);
            try { orderedInLine.setArticle(this); } catch (NullPointerException e) { }
        }
    }

    public void removeOrderedInLine(OrderLine orderedInLine) {
        if (getOrderedInLines().contains(orderedInLine)) {
            getOrderedInLines().remove(orderedInLine);
            try { orderedInLine.setArticle(null); } catch (NullPointerException e) { }
        }
    }

    public String printStatus() { return "Article number " + getId() + " is named " + getName() + " and costs " + getPrice() + "."; }
}