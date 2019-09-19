package PF03.WeeklyProject02;

import PF03.WeeklyProject02.Model.*;

import javax.swing.JFrame;

public class Controller {
	private CustomerReg customerReg;
	private ArticleReg articleReg;
	private SupplierReg supplierReg;
	private JFrame frame;

    public Controller(JFrame frame) {
    	this.setCustomerReg(new CustomerReg());
    	this.setArticleReg(new ArticleReg());
    	this.setSupplierReg(new SupplierReg());
        this.setFrame(frame);
    }
    public Controller(CustomerReg customerReg, ArticleReg articleReg, SupplierReg supplierReg, JFrame frame) {
        this.setCustomerReg(customerReg);
        this.setArticleReg(articleReg);
        this.setSupplierReg(supplierReg);
        this.setFrame(frame);
    }

    public CustomerReg getCustomerReg() { return customerReg; }
    public void setCustomerReg(CustomerReg customerReg) { this.customerReg = customerReg; }

    public ArticleReg getArticleReg() { return articleReg; }
    public void setArticleReg(ArticleReg articleReg) { this.articleReg = articleReg; }

    public SupplierReg getSupplierReg() { return supplierReg; }
    public void setSupplierReg(SupplierReg supplierReg) { this.supplierReg = supplierReg; }

    public JFrame getFrame() { return frame; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    public void addCustomer(String type, String custId, String name, String address, String phone) { 
    	if (type.contentEquals("P"))
    			getCustomerReg().addCustomers(new CustomerPrivate(custId, name, address, phone)); 
    	else if (type.contentEquals("C"))
    		getCustomerReg().addCustomers(new CustomerCompany(custId, name, address, phone)); 
	}
    public Customer findCustomer(String id) { return getCustomerReg().findCustomer(id); }
    public void deleteCustomer(String id) { getCustomerReg().removeCustomer(id); }
    public void updateCustomerData(String custId, String name, String address, String phone) { getCustomerReg().updateCustomer(custId, name, address, phone); }

    public void addOrder(String custId, String orderNr, String orderDate) {
        getCustomerReg().findCustomer(custId).addOrder(new Order(orderNr, orderDate, findCustomer(custId)));
    }

    public void addOrderLine(String custId, String orderNr, String quantity, String articleId) {
        getCustomerReg().findCustomer(custId).findOrder(orderNr).addOrderLine(Integer.valueOf(quantity), getArticleReg().findArticle(articleId));;
    }

    public void deleteOrder(String custId, String orderNr) { getCustomerReg().findCustomer(custId).removeOrder(orderNr); }
    
    
    





    public void addArticle(String name, double price) {
        Article tmpArticle = new Article(String.valueOf(articleReg.getArticles().size()), name, price);
        articleReg.addArticle(tmpArticle);
    }

    public void addArticle(String name, double price, Supplier supplier) {
        Article tmpArticle = new Article(String.valueOf(articleReg.getArticles().size()), name, price, supplier);
        articleReg.addArticle(tmpArticle);
    }

    public void listArticles() {
        articleReg.getArticles().toString().substring(1, articleReg.getArticles().toString().length() - 1);
    }



}
