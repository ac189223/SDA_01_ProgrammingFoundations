package PF03.WeeklyProject03;

import PF03.WeeklyProject03.Model.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Controller {
	private CustomerReg customerReg;
	private ArticleReg articleReg;
	private SupplierReg supplierReg;
	private Random random;
    private JFrame frame;
	private View view;

    public Controller(JFrame frame, View view) {
    	this.setCustomerReg(new CustomerReg());
    	this.setArticleReg(new ArticleReg());
    	this.setSupplierReg(new SupplierReg());
        this.setFrame(frame);
        this.setView(view);
    }
    public Controller(CustomerReg customerReg, ArticleReg articleReg, SupplierReg supplierReg, JFrame frame, View view) {
        this.setCustomerReg(customerReg);
        this.setArticleReg(articleReg);
        this.setSupplierReg(supplierReg);
        this.setFrame(frame);
        this.setView(view);
    }

    public CustomerReg getCustomerReg() { return customerReg; }
    public void setCustomerReg(CustomerReg customerReg) { this.customerReg = customerReg; }

    public ArticleReg getArticleReg() { return articleReg; }
    public void setArticleReg(ArticleReg articleReg) { this.articleReg = articleReg; }

    public SupplierReg getSupplierReg() { return supplierReg; }
    public void setSupplierReg(SupplierReg supplierReg) { this.supplierReg = supplierReg; }

    public JFrame getFrame() { return frame; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    public View getView() { return view; }
    public void setView(View view) { this.view = view; }

    public void editCustomerData() {
        // EDIT CustomerData as Customer itself
        String custId;
        if (view.getTxtCustomerId().getText().equals(""))
            custId = view.getTxtCustomerIdIn().getText();
        else
            custId = view.getTxtCustomerId().getText();
        Customer tmpCustomer = findCustomer(custId);
        if (tmpCustomer != null) {
            disableUpperPartOfCustomer();
            view.getTxtCustomerName().setText(tmpCustomer.getName());
            view.getTxtCustomerName().setEnabled(true);
            view.getTxtCustomerAddress().setText(tmpCustomer.getAddress());
            view.getTxtCustomerAddress().setEnabled(true);
            view.getTxtCustomerPhone().setText(tmpCustomer.getPhoneNr());
            view.getTxtCustomerPhone().setEnabled(true);
            if (tmpCustomer.getClass() == CustomerPrivate.class)
                view.getRdbtnCustomerPrivate().setSelected(true);
            else if (tmpCustomer.getClass() == CustomerCompany.class)
                view.getRdbtnCustomerCorporate().setSelected(true);
            view.getTxtCustomerIdIn().setText(custId);
            view.getBtnCustomerAdd().setText("Update");
            view.getBtnCustomerAdd().setEnabled(true);
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void deleteCustomer() {
        // DELETE Customer by customer itself
        String custId;
        if (view.getTxtCustomerId().getText().equals(""))
            custId = view.getTxtCustomerIdIn().getText();
        else
            custId = view.getTxtCustomerId().getText();
        Customer tmpCustomer = findCustomer(custId);
        if (tmpCustomer != null) {
            getCustomerReg().removeCustomer(custId);
            setCustomerConfirmationYes();
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void updateCustomerTypeSelection() {
        try {
            if (view.getRdbtnCustomerCorporate().isSelected()) {
                view.getTxtCustomerIdIn().setText("Enter corporate Id");
                view.getTxtCustomerIdIn().setEnabled(true);
            }
            else if (view.getRdbtnCustomerPrivate().isSelected()) {
                view.getTxtCustomerIdIn().setText("Enter social security number");
                view.getTxtCustomerIdIn().setEnabled(true);
            }
        } catch (NullPointerException e) {
        }
    }

    public void addCustomerUpdateData() {
        // ADD Customer & UPDATE CustomerData by Customer itself
        if (view.getRdbtnCustomerPrivate().isSelected() || view.getRdbtnCustomerCorporate().isSelected()) {
            String custId = view.getTxtCustomerIdIn().getText();
            String name = view.getTxtCustomerName().getText();
            String address = view.getTxtCustomerAddress().getText();
            String phone = view.getTxtCustomerPhone().getText();
            if (view.getBtnCustomerAdd().getText().equals("Add")) {
                if (view.getRdbtnCustomerPrivate().isSelected())
                    addCustomer("P", custId, name, address, phone);
                else if (view.getRdbtnCustomerCorporate().isSelected())
                    addCustomer("C", custId, name, address, phone);
            } else if (view.getBtnCustomerAdd().getText().equals("Update")) {
                String oldCustId = view.getTxtCustomerId().getText();
                if (!oldCustId.equals(custId)) {
                    getCustomerReg().removeCustomer(oldCustId);
                    if (view.getRdbtnCustomerPrivate().isSelected())
                        addCustomer("P", custId, name, address, phone);
                    else if (view.getRdbtnCustomerCorporate().isSelected())
                        addCustomer("C", custId, name, address, phone);
                } else {
                    updateCustomerData(custId, name, address, phone);
                }
            }
            setCustomerConfirmationYes();
        }
    }

    public void addCustomer(String type, String custId, String name, String address, String phone) {
        if (type.contentEquals("P"))
            getCustomerReg().addCustomers(new CustomerPrivate(custId, name, address, phone));
        else if (type.contentEquals("C"))
            getCustomerReg().addCustomers(new CustomerCompany(custId, name, address, phone));
    }

    public Customer findCustomer(String id) {
        return getCustomerReg().findCustomer(id);
    }

    public void updateCustomerData(String custId, String name, String address, String phone) {
        getCustomerReg().updateCustomer(custId, name, address, phone);
    }

    public void searchForCustomer() {
        // SEARCH for Customer by customer itself
        String custId = view.getTxtCustomerCheckId().getText();
        Customer tmpCustomer = findCustomer(custId);
        if (tmpCustomer != null) {
            view.getTxtCustomerName().setText(tmpCustomer.getName());
            view.getTxtCustomerAddress().setText(tmpCustomer.getAddress());
            view.getTxtCustomerPhone().setText(tmpCustomer.getPhoneNr());
            if (tmpCustomer.getClass() == CustomerPrivate.class)
                view.getRdbtnCustomerPrivate().setSelected(true);
            else if (tmpCustomer.getClass() == CustomerCompany.class)
                view.getRdbtnCustomerCorporate().setSelected(true);
            view.getTxtCustomerId().setText(custId);
            view.getTxtCustomerIdIn().setText(custId);
            view.getBtnCustomerEdit().setText("Edit");
            view.getBtnCustomerEdit().setEnabled(true);
            view.getBtnCustomerDelete().setText("Delete");
            view.getBtnCustomerDelete().setEnabled(true);
            view.getBtnCustomerCreateAnOrder().setText("Create an order");
            view.getBtnCustomerCreateAnOrder().setEnabled(true);
            disableLowerPartOfCustomer();
            setCustomerConfirmationYes();
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void goToOrderTabAsCustomer() {
        // GO TO ORDER Tab as Customer with proper Id
        String custId;
        if (view.getTxtCustomerId().getText().equals(""))
            custId = view.getTxtCustomerIdIn().getText();
        else
            custId = view.getTxtCustomerId().getText();
        Customer tmpCustomer = findCustomer(custId);
        if (tmpCustomer != null) {
            disableUpperPartOfCustomer();
            disableMiddlePartOfCustomer();
            disableLowerPartOfCustomer();
            view.getPanel02().setEnabled(true);
            view.getTabbedPane().setSelectedIndex(1);
            view.getTxtOrderCustId().setText(custId);
            view.getRdbtnOrderCreate().setEnabled(true);
            view.getRdbtnOrderAddLine().setEnabled(true);
            view.getRdbtnOrderDeleteArticle().setEnabled(true);
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void goToAdminTab() {
        // GO TO ADMIN Tab as Admin
        view.getPanel03().setEnabled(true);
        view.getRdbtnAdminArticles().setEnabled(true);
        view.getRdbtnAdminSuppliers().setEnabled(true);
        view.getRdbtnAdminClients().setEnabled(true);
        view.getTabbedPane().setSelectedIndex(2);
    }

    public void addNewOrderAsClient() {
        // ADD new Order as Client
        String custId = view.getTxtOrderCustId().getText();
        Customer tmpCustomer = findCustomer(custId);
        if (tmpCustomer != null) {
            String orderNumber = view.getTxtOrderNumberCreate().getText();
            String orderDate = view.getTxtOrderDate().getText();
            addOrder(custId, orderNumber, orderDate);
            disableUpperPartOfOrder();
            enableMiddlePartOfOrder();
            view.getRdbtnOrderAddLine().setSelected(true);
            view.getComboOrderNumberAdd().setText(orderNumber);
            view.getComboOrderNumberAdd().setEnabled(false);
            setOrderConfirmationYes();
        } else {
            setOrderConfirmationNo();
        }
    }

    public void addOrder(String custId, String orderNr, String orderDate) {
        getCustomerReg().findCustomer(custId).addOrder(new Order(orderNr, orderDate, findCustomer(custId)));
    }

    public void addNewOrderLineAsClient() {
        // ADD new OrderLine to Order as Client
        String custId = view.getTxtOrderCustId().getText();
        Customer tmpCustomer = findCustomer(custId);
        String orderNumber = view.getComboOrderNumberAdd().getText();
        Order tmpOrder = findCustomer(custId).findOrder(orderNumber);
        String quantity = view.getTxtOrderQuantity().getText();
        String articleId = view.getComboOrderArticleAdd().getText();
        Article tmpArticle = getArticleReg().findArticle(articleId);
        if (tmpCustomer != null && tmpOrder != null && ifInt(quantity) && tmpArticle != null) {
            addOrderLine(custId, orderNumber, quantity, articleId);
            enableMiddlePartOfOrder();
            view.getComboOrderNumberAdd().setText(orderNumber);
            view.getComboOrderNumberAdd().setEnabled(false);
            setOrderConfirmationYes();
        } else {
            setOrderConfirmationNo();
        }
    }

    public void addOrderLine(String custId, String orderNr, String quantity, String articleId) {
        Article tmpArticle = getArticleReg().findArticle(articleId);
        findCustomer(custId).findOrder(orderNr).addOrderLine(Integer.valueOf(quantity), tmpArticle );;
    }

    private boolean ifInt(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void deleteOrderAsClient() {
        // DELETE order as Customer
        String custId = view.getTxtOrderCustId().getText();
        Customer tmpCustomer = findCustomer(custId);
        String orderNumber = view.getComboOrderNumberDelete().getText();
        Order tmpOrder = findCustomer(custId).findOrder(orderNumber);
        if (tmpCustomer != null && tmpOrder != null) {
            deleteOrder(custId, orderNumber);
            enableLowerPartOfOrder();
            setOrderConfirmationYes();
        } else {
            setOrderConfirmationNo();
        }
    }

    public void deleteOrder(String custId, String orderNr) {
        getCustomerReg().findCustomer(custId).removeOrder(orderNr);
    }













    public void enableCustomerUpper() {
        if (view.getRdbtnCustomerAlreadyAClient().isSelected()) {
            enableUpperPartOfCustomer();
            disableMiddlePartOfCustomer();
            disableLowerPartOfCustomer();
            setCustomerConfirmationBlank();
        }
    }

    public void enableCustomerMiddle() {
        if (view.getRdbtnCustomerNotYet().isSelected()) {
            disableUpperPartOfCustomer();
            enableMiddlePartOfCustomer();
            disableLowerPartOfCustomer();
            setCustomerConfirmationBlank();
        }
    }

    public void enableCustomerLower() {
        if (view.getRdbtnCustomerNotSure().isSelected()) {
            disableUpperPartOfCustomer();
            disableMiddlePartOfCustomer();
            enableLowerPartOfCustomer();
            setCustomerConfirmationBlank();
        }
    }

    public void enableUpperPartOfCustomer() {
        view.getTxtCustomerId().setText("Enter customer Id");
        view.getTxtCustomerId().setEnabled(true);
        view.getBtnCustomerEdit().setText("Edit");
        view.getBtnCustomerEdit().setEnabled(true);
        view.getBtnCustomerDelete().setText("Delete");
        view.getBtnCustomerDelete().setEnabled(true);
        view.getBtnCustomerCreateAnOrder().setText("Create an order");
        view.getBtnCustomerCreateAnOrder().setEnabled(true);
    }

    public void disableUpperPartOfCustomer() {
        view.getTxtCustomerId().setText("");
        view.getTxtCustomerId().setEnabled(false);
        view.getBtnCustomerEdit().setText("");
        view.getBtnCustomerEdit().setEnabled(false);
        view.getBtnCustomerDelete().setText("");
        view.getBtnCustomerDelete().setEnabled(false);
        view.getBtnCustomerCreateAnOrder().setText("");
        view.getBtnCustomerCreateAnOrder().setEnabled(false);
    }

    public void enableMiddlePartOfCustomer() {
        view.getTxtCustomerName().setText("Enter name");
        view.getTxtCustomerName().setEnabled(true);
        view.getTxtCustomerAddress().setText("Enter address");
        view.getTxtCustomerAddress().setEnabled(true);
        view.getTxtCustomerPhone().setText("Enter phone number");
        view.getTxtCustomerPhone().setEnabled(true);
        view.getRdbtnCustomerPrivate().setEnabled(true);
        view.getRdbtnCustomerCorporate().setEnabled(true);
        view.getBtnCustomerAdd().setText("Add");
        view.getBtnCustomerAdd().setEnabled(true);
    }

    public void disableMiddlePartOfCustomer() {
        view.getTxtCustomerName().setText("");
        view.getTxtCustomerName().setEnabled(false);
        view.getTxtCustomerAddress().setText("");
        view.getTxtCustomerAddress().setEnabled(false);
        view.getTxtCustomerPhone().setText("");
        view.getTxtCustomerPhone().setEnabled(false);
        view.getButtonGroupPrivateCorporate().clearSelection();
        view.getRdbtnCustomerPrivate().setEnabled(false);
        view.getRdbtnCustomerCorporate().setEnabled(false);
        view.getTxtCustomerIdIn().setText("");
        view.getTxtCustomerIdIn().setEnabled(false);
        view.getBtnCustomerAdd().setText("");
        view.getBtnCustomerAdd().setEnabled(false);
    }

    public void enableLowerPartOfCustomer() {
        view.getTxtCustomerCheckId().setText("Enter personal/customer Id");
        view.getTxtCustomerCheckId().setEnabled(true);
        view.getBtnCustomerCheck().setText("Check");
        view.getBtnCustomerCheck().setEnabled(true);
    }

    public void disableLowerPartOfCustomer() {
        view.getTxtCustomerCheckId().setText("");
        view.getTxtCustomerCheckId().setEnabled(false);
        view.getBtnCustomerCheck().setText("");
        view.getBtnCustomerCheck().setEnabled(false);
    }

    public void setCustomerConfirmationYes() { view.getTxtCustomerConfirmation().setText("V"); }
    public void setCustomerConfirmationNo() { view.getTxtCustomerConfirmation().setText("X"); }
    public void setCustomerConfirmationBlank() { view.getTxtCustomerConfirmation().setText(""); }

    public void enableOrderUpper() {
        if (view.getRdbtnOrderCreate().isSelected()) {
            enableUpperPartOfOrder();
            disableMiddlePartOfOrder();
            disableLowerPartOfOrder();
            setOrderConfirmationBlank();
        }
    }

    public void enableOrderMiddle() {
        if (view.getRdbtnOrderAddLine().isSelected()) {
            disableUpperPartOfOrder();
            enableMiddlePartOfOrder();
            disableLowerPartOfOrder();
            setOrderConfirmationBlank();
        }
    }

    public void enableOrderLower() {
        if (view.getRdbtnOrderDeleteArticle().isSelected()) {
            disableUpperPartOfOrder();
            disableMiddlePartOfOrder();
            enableLowerPartOfOrder();
            setOrderConfirmationBlank();
        }
    }

    public void enableUpperPartOfOrder() {
        random = new Random();
        String orderIdInt = String.valueOf(random.nextInt(100));
        String orderId = "o" + "0".repeat(4 - orderIdInt.length()) + orderIdInt;
        view.getTxtOrderNumberCreate().setText(orderId);
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
        view.getTxtOrderDate().setText(timeStamp);
        view.getBtnOrderCreate().setText("Create");
        view.getBtnOrderCreate().setEnabled(true);
    }
    public void disableUpperPartOfOrder() {
        view.getTxtOrderNumberCreate().setText("");
        view.getTxtOrderDate().setText("");
        view.getBtnOrderCreate().setText("");
        view.getBtnOrderCreate().setEnabled(false);
    }
    public void enableMiddlePartOfOrder() {
        view.getComboOrderNumberAdd().setText("Enter order Id");
        view.getComboOrderNumberAdd().setEnabled(true);
        view.getTxtOrderQuantity().setText("Enter quantity");
        view.getTxtOrderQuantity().setEnabled(true);
        view.getComboOrderArticleAdd().setText("Enter item Id");
        view.getComboOrderArticleAdd().setEnabled(true);
        view.getBtnOrderAddLine().setText("Append");
        view.getBtnOrderAddLine().setEnabled(true);
    }
    public void disableMiddlePartOfOrder() {
        view.getComboOrderNumberAdd().setText("");
        view.getComboOrderNumberAdd().setEnabled(false);
        view.getTxtOrderQuantity().setText("");
        view.getTxtOrderQuantity().setEnabled(false);
        view.getComboOrderArticleAdd().setText("");
        view.getComboOrderArticleAdd().setEnabled(false);
        view.getBtnOrderAddLine().setText("");
        view.getBtnOrderAddLine().setEnabled(false);
    }
    public void enableLowerPartOfOrder() {
        view.getComboOrderNumberDelete().setText("Enter order Id");
        view.getComboOrderNumberDelete().setEnabled(true);
        view.getBtnOrderDelete().setText("Delete");
        view.getBtnOrderDelete().setEnabled(true);
    }
    public void disableLowerPartOfOrder() {
        view.getComboOrderNumberDelete().setText("");
        view.getComboOrderNumberDelete().setEnabled(false);
        view.getBtnOrderDelete().setText("");
        view.getBtnOrderDelete().setEnabled(false);
    }

    public void setOrderConfirmationYes() { view.getTxtOrderConfirmation().setText("V"); }
    public void setOrderConfirmationNo() { view.getTxtOrderConfirmation().setText("X"); }
    public void setOrderConfirmationBlank() { view.getTxtOrderConfirmation().setText(""); }

    public void enableAdminUpper() {
        if (view.getRdbtnAdminArticles().isSelected()) {
            enableUpperPartOfAdmin();
            disableMiddlePartOfAdmin();
            disableLowerPartOfAdmin();
            enableButtonsOfAdmin();
            setAdminConfirmationBlank();
        }
    }

    public void enableAdminMiddle() {
        if (view.getRdbtnAdminSuppliers().isSelected()) {
            disableUpperPartOfAdmin();
            enableMiddlePartOfAdmin();
            disableLowerPartOfAdmin();
            enableButtonsOfAdmin();
            setAdminConfirmationBlank();
        }
    }

    public void enableAdminLower() {
        if (view.getRdbtnAdminClients().isSelected()) {
            disableUpperPartOfAdmin();
            disableMiddlePartOfAdmin();
            enableLowerPartOfAdmin();
            enableButtonsOfAdmin();
            setAdminConfirmationBlank();
        }
    }

    public void enableUpperPartOfAdmin() {
        view.getComboAdminArticleId().setText("Enter item Id");
        view.getComboAdminArticleId().setEnabled(true);
        view.getTxtAdminArticleName().setText("Enter name");
        view.getTxtAdminArticleName().setEnabled(true);
        view.getTxtAdminArticlePrice().setText("Enter price");
        view.getTxtAdminArticlePrice().setEnabled(true);
        view.getComboAdminArticleSupplier().setText("Enter supplier");
        view.getComboAdminArticleSupplier().setEnabled(true);
    }
    public void disableUpperPartOfAdmin() {
        view.getComboAdminArticleId().setText("");
        view.getComboAdminArticleId().setEnabled(false);
        view.getTxtAdminArticleName().setText("");
        view.getTxtAdminArticleName().setEnabled(false);
        view.getTxtAdminArticlePrice().setText("");
        view.getTxtAdminArticlePrice().setEnabled(false);
        view.getComboAdminArticleSupplier().setText("");
        view.getComboAdminArticleSupplier().setEnabled(false);
    }
    public void enableMiddlePartOfAdmin() {
        view.getComboAdminSupplierId().setText("Enter supplier Id");
        view.getComboAdminSupplierId().setEnabled(true);
        view.getTxtAdminSupplierName().setText("Enter name");
        view.getTxtAdminSupplierName().setEnabled(true);
        view.getTxtAdminSupplierPhone().setText("Enter price");
        view.getTxtAdminSupplierPhone().setEnabled(true);
        view.getComboAdminSupplierArticle().setText("Enter item Id");
        view.getComboAdminSupplierArticle().setEnabled(true);
    }
    public void disableMiddlePartOfAdmin() {
        view.getComboAdminSupplierId().setText("");
        view.getComboAdminSupplierId().setEnabled(false);
        view.getTxtAdminSupplierName().setText("");
        view.getTxtAdminSupplierName().setEnabled(false);
        view.getTxtAdminSupplierPhone().setText("");
        view.getTxtAdminSupplierPhone().setEnabled(false);
        view.getComboAdminSupplierArticle().setText("");
        view.getComboAdminSupplierArticle().setEnabled(false);
    }
    public void enableLowerPartOfAdmin() {
        view.getComboAdminClientId().setText("Enter client Id");
        view.getComboAdminClientId().setEnabled(true);
        view.getTxtAdminClientName().setText("Enter name");
        view.getTxtAdminClientName().setEnabled(true);
        view.getTxtAdminClientAddress().setText("Enter address");
        view.getTxtAdminClientAddress().setEnabled(true);
        view.getTxtAdminClientPhone().setText("Enter phone");
        view.getTxtAdminClientPhone().setEnabled(true);
        view.getComboAdminClientOrder().setText("Enter order Id");
        view.getComboAdminClientOrder().setEnabled(true);
    }
    public void disableLowerPartOfAdmin() {
        view.getComboAdminClientId().setText("");
        view.getComboAdminClientId().setEnabled(false);
        view.getTxtAdminClientName().setText("");
        view.getTxtAdminClientName().setEnabled(false);
        view.getTxtAdminClientAddress().setText("");
        view.getTxtAdminClientAddress().setEnabled(false);
        view.getTxtAdminClientPhone().setText("");
        view.getTxtAdminClientPhone().setEnabled(false);
        view.getComboAdminClientOrder().setText("");
        view.getComboAdminClientOrder().setEnabled(false);
    }

    public void enableButtonsOfAdmin() {
        view.getBtnAdminAdd().setText("Add");
        view.getBtnAdminAdd().setEnabled(true);
        view.getBtnAdminCreate().setText("Create");
        view.getBtnAdminCreate().setEnabled(true);
        view.getBtnAdminDelete().setText("Delete");
        view.getBtnAdminDelete().setEnabled(true);
        view.getBtnAdminFind().setText("Find");
        view.getBtnAdminFind().setEnabled(true);
    }
    public void disableButtonsOfAdmin() {
        view.getBtnAdminAdd().setText("");
        view.getBtnAdminAdd().setEnabled(false);
        view.getBtnAdminCreate().setText("");
        view.getBtnAdminCreate().setEnabled(false);
        view.getBtnAdminDelete().setText("");
        view.getBtnAdminDelete().setEnabled(false);
        view.getBtnAdminFind().setText("");
        view.getBtnAdminFind().setEnabled(false);
    }

    public void setAdminConfirmationYes() { view.getTxtAdminConfirmation().setText("V"); }
    public void setAdminConfirmationNo() { view.getTxtAdminConfirmation().setText("X"); }
    public void setAdminConfirmationBlank() { view.getTxtAdminConfirmation().setText(""); }
}
