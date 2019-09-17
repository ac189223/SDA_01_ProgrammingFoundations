package PF03.WeeklyProject02;

import PF03.WeeklyProject02.Model.Article;
import PF03.WeeklyProject02.Model.ArticleReg;
import PF03.WeeklyProject02.Model.CustomerReg;
import PF03.WeeklyProject02.Model.Supplier;
import PF03.WeeklyProject02.Model.SupplierReg;

import javax.swing.JFrame;

public class Controller {
	private CustomerReg customers;
	private ArticleReg articles;
	private SupplierReg suppliers;
	private JFrame frame;

    public Controller(JFrame frame) {
    	this.customers = new CustomerReg();
    	this.articles = new ArticleReg();
    	this.suppliers = new SupplierReg();
        this.frame = frame;
    }
    public Controller(CustomerReg customers, ArticleReg articles, SupplierReg suppliers, JFrame frame) {
    	this.customers = customers;
        this.articles = articles;
        this.suppliers = suppliers;
        this.frame = frame;
    }

    public void addArticle(String name, double price) {
        Article tmpArticle = new Article(String.valueOf(articles.getArticles().size()), name, price);
        articles.addArticle(tmpArticle);
    }

    public void addArticle(String name, double price, Supplier supplier) {
        Article tmpArticle = new Article(String.valueOf(articles.getArticles().size()), name, price, supplier);
        articles.addArticle(tmpArticle);
    }

    public void listArticles() {
        articles.getArticles().toString().substring(1, articles.getArticles().toString().length() - 1);
    }
}
