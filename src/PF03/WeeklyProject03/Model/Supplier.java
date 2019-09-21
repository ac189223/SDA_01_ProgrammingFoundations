package PF03.WeeklyProject03.Model;

import java.util.ArrayList;

public class Supplier {
    private String id;
    private String name;
    private String phoneNr;
    private ArrayList<Article> suppliesArticles;

    public Supplier() {}

    public Supplier(String id, String name, String phoneNr) {
        this.setId(id);
        this.setName(name);
        this.setPhoneNr(phoneNr);
        this.setSuppliesArticles(new ArrayList<>());
    }

    public Supplier(String id, String name, String phoneNr, ArrayList<Article> suppliesArticles) {
        this.setId(id);
        this.setName(name);
        this.setPhoneNr(phoneNr);
        this.setSuppliesArticles(suppliesArticles);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNr() { return phoneNr; }
    public void setPhoneNr(String phoneNr) { this.phoneNr = phoneNr; }

    public ArrayList<Article> getSuppliesArticles() { return suppliesArticles; }
    public void setSuppliesArticles(ArrayList<Article> suppliesArticles) { this.suppliesArticles = suppliesArticles; }
    public void addArticle(Article article) {
        if (!getSuppliesArticles().contains(article)) {
            getSuppliesArticles().add(article);
            try { article.setSupplier(this); } catch (NullPointerException e) { }
        }
    }
    public void removeArticle(Article article) {
        if (getSuppliesArticles().contains(article)) {
            getSuppliesArticles().remove(article);
            try { article.setSupplier(null); } catch (NullPointerException e) { }
        }
    }
    public void removeArticle(String id) {
        if (getSuppliesArticles().contains(findArticle(id))) {
            getSuppliesArticles().remove(findArticle(id));
            findArticle(id).setSupplier(null);
        }
    }
    public Article findArticle(String id) {
        for(Article article : getSuppliesArticles()) {
            if (article.getId().equals(id))
                return article;
        }
        return null;
    }

    public int amountOfArticles() { return getSuppliesArticles().size(); }
    public String listArticles() {
        String list = "";
        for (Article article : getSuppliesArticles()) {
            list += article.getName() + ", ";
        }
        return list;
    }

    public String printStatus() {
        return "Supplier number " + getId() + " is " + getName() + "." +
                " Phone number is " + getPhoneNr() + " and amount of supplied articles is " + amountOfArticles() + " articles.";
    }
}
