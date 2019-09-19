package PF03.WeeklyProject03.Model;

public class OrderLine {
    private int quantity;
    private Article article;
    private Order order;

    public OrderLine() {}

    public OrderLine(int quantity, Article article) {
        this.setQuantity(quantity);
        this.setArticle(article);
    }

    public OrderLine(int quantity, Article article, Order order) {
        this.setQuantity(quantity);
        this.setArticle(article);
        this.setOrder(order);
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Article getArticle() { return article; }
    public void setArticle(Article article) {
        if (this.article != article) {
            this.article = article;
            try { article.addOrderedInLine(this); } catch (NullPointerException e) { }
        }
    }

    public Order getOrder() { return order; }
    public void setOrder(Order order) {
        if (this.order != order) {
            this.order = order;
            try { order.addOrderLine(this); } catch (NullPointerException e) { }
        }
    }

    public Supplier getSupplierOf() { return getArticle().getSupplier(); }

    public double getValue() { return getQuantity() * getArticle().getPrice(); }

    public String printStatus() { return "Order for " + getQuantity() + " pieces of article number " + getArticle().getId() + "."; }
}