package PF03.WeeklyProject;

import PF02.Exs.Ex09.Order;

import java.util.ArrayList;

public class ArticleReg {
    private ArrayList<Article> articles = new ArrayList<>();

    ArticleReg() { }

    ArticleReg(ArrayList<Article> articles) { this.setArticles(articles); }

    public ArrayList<Article> getArticles() { return articles; }
    public void setArticles(ArrayList<Article> articles) { this.setArticles(articles); }
    public void addArticle(Article article) { getArticles().add(article); }
    public void removeArticle(Article article) { getArticles().remove(article); }
    public void removeArticle(String articleId) { getArticles().remove(findArticle(articleId)); }
    public Article findArticle(String id) {
        for (Article article : getArticles())
            if (article.getId().equals(id))
                return article;
        return null;
    }

    public Supplier findSupplierOf(Article article) {
        for (Article tempArticle: getArticles())
            if (tempArticle == article)
                return article.getSupplier();
        return null;
    }
    public Supplier findSupplierOf(String articleId) {
        for (Article article: getArticles())
            if (article.getId() == articleId)
                return article.getSupplier();
        return null;
    }

    public ArrayList<OrderLine> findOrderLines(Article article) {
        for (Article tempArticle: getArticles())
            if (tempArticle == article)
                return article.getOrderedInLines();
        return null;
    }
    public ArrayList<OrderLine> findOrderLines(String articleId) {
        for (Article article: getArticles())
            if (article.getId() == articleId)
                return article.getOrderedInLines();
        return null;
    }
}