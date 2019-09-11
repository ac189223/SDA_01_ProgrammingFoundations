package PF02.Exs.Ex09;

import java.util.ArrayList;

public class Supplier {
    private String supplierId;
    private String name;
    private ArrayList<Article> articles;

    Supplier(String supplierId, String name) {
        this.supplierId = supplierId;
        this.name = name;
        this.articles = new ArrayList<>();
    }

    public String getSupplierId() { return supplierId; }

    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Article> getArticles() { return articles; }

    public void setArticles(ArrayList<Article> articles) { this.articles = articles; }

    public void addArticle(Article article) { getArticles().add(article); }
}
