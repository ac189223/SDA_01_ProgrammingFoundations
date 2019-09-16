package PF03.WeeklyProject;

import java.util.ArrayList;

public class SupplierReg {
    private ArrayList<Supplier> suppliers = new ArrayList<>();

    SupplierReg() { }

    SupplierReg(ArrayList<Supplier> suppliers) { this.setSuppliers(suppliers); }

    public ArrayList<Supplier> getSuppliers() { return suppliers; }
    public void setSuppliers(ArrayList<Supplier> suppliers) { this.setSuppliers(suppliers); }
    public void addSupplier(Supplier supplier) { getSuppliers().add(supplier); }
    public void removeSupplier(Supplier supplier) { getSuppliers().remove(supplier); }
    public void removeSupplier(String supplierId) { getSuppliers().remove(findSupplier(supplierId)); }
    public Supplier findSupplier(String id) {
        for (Supplier supplier : getSuppliers())
            if (supplier.getId().equals(id))
                return supplier;
        return null;
    }

    public void printArticlesOfCustomer(String supplierId) { findSupplier(supplierId).listArticles(); }
    public void printArticlesOfCustomer(Supplier supplier) { supplier.listArticles(); }

    public Supplier findSupplierOf(Article article) {
        for (Supplier supplier:getSuppliers())
            for (Article tempArticle: supplier.getSuppliesArticles())
                if (tempArticle == article)
                    return supplier;
        return null;
    }
    public Supplier findSupplierOf(String articleId) {
        for (Supplier supplier:getSuppliers())
            for (Article article: supplier.getSuppliesArticles())
                if (article.getId() == articleId)
                    return supplier;
        return null;
    }
}