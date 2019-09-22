package PF03.WeeklyProject03;

import PF03.WeeklyProject03.Model.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Controller {
	private CustomerReg customerReg = new CustomerReg();
	private ArticleReg articleReg = new ArticleReg();
	private SupplierReg supplierReg = new SupplierReg();
	private Random random;
    private JFrame frame;
	private View view;

    public Controller(JFrame frame, View view) {
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
        // Go To EDIT CustomerData as Customer itself
        String custId;
        if (view.getTxtCustomerId().getSelectedIndex() == 0)
            custId = view.getTxtCustomerIdIn().getText();
        else
            custId = (String) view.getTxtCustomerId().getSelectedItem();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        if (tmpCustomer != null) {
            disableUpperPartOfCustomer();
            view.getTxtCustomerIdOld().setText(custId);
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
            view.getRdbtnCustomerPrivate().setEnabled(true);
            view.getRdbtnCustomerCorporate().setEnabled(true);
            view.getTxtCustomerIdIn().setText(custId);
            view.getBtnCustomerAdd().setText("Update");
            view.getBtnCustomerAdd().setEnabled(true);
            view.getButtonGroupIsCustomer().clearSelection();
        } else {
            setCustomerConfirmationNo();
            view.getTxtCustomerIdIn().setText("");
            view.getTxtCustomerId().setSelectedIndex(0);
        }
    }

    public void deleteCustomer() {
        // DELETE Customer by customer itself
        String custId;
        if (view.getTxtCustomerId().getSelectedIndex() == 0)
            custId = view.getTxtCustomerIdIn().getText();
        else
            custId = (String) view.getTxtCustomerId().getSelectedItem();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        if (tmpCustomer != null) {
            getCustomerReg().removeCustomer(custId);
            deleteCustomerFromComboBoxesList(custId);
            setCustomerConfirmationYes();
        } else {
            setCustomerConfirmationNo();
            view.getTxtCustomerIdIn().setText("");
            view.getTxtCustomerId().setSelectedIndex(0);
        }
    }

    public void updateCustomerTypeSelection() {
        try {
            if (view.getRdbtnCustomerCorporate().isSelected()) {
                view.getTxtCustomerIdIn().setText("");
                view.getTxtCustomerIdIn().setEnabled(true);
            }
            else if (view.getRdbtnCustomerPrivate().isSelected()) {
                view.getTxtCustomerIdIn().setText("");
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
            boolean fieldsFielledIn = !name.equals("") && !address.equals("") && !phone.equals("");
            if (!custId.equals("")) {
                if (view.getBtnCustomerAdd().getText().equals("Add")) {
                    if (getCustomerReg().findCustomer(custId) == null) {
                        if (fieldsFielledIn) {
                            if (view.getRdbtnCustomerPrivate().isSelected())
                                addCustomer("P", custId, name, address, phone);
                            else if (view.getRdbtnCustomerCorporate().isSelected())
                                addCustomer("C", custId, name, address, phone);
                            addCustomerToComboBoxesList(custId);
                            setCustomerConfirmationYes();
                        } else {
                            setCustomerConfirmationNo();
                        }
                    } else {
                        setCustomerConfirmationNo();
                        view.getTxtCustomerIdIn().setText("");
                    }
                } else if (view.getBtnCustomerAdd().getText().equals("Update")) {
                    String oldCustId = view.getTxtCustomerIdOld().getText();
                    boolean classChange = false;
                    if (view.getRdbtnCustomerPrivate().isSelected()) {
                        if (CustomerPrivate.class != getCustomerReg().findCustomer(oldCustId).getClass())
                            classChange = true;
                    } else if (view.getRdbtnCustomerCorporate().isSelected()) {
                        if (CustomerCompany.class != getCustomerReg().findCustomer(oldCustId).getClass())
                            classChange = true;
                    }
                    if (!oldCustId.equals(custId)) {
                        if (getCustomerReg().findCustomer(custId) == null) {
                            if (fieldsFielledIn) {
                                getCustomerReg().removeCustomer(oldCustId);
                                view.getTxtCustomerId().removeItem(oldCustId);
                                if (view.getRdbtnCustomerPrivate().isSelected())
                                    addCustomer("P", custId, name, address, phone);
                                else if (view.getRdbtnCustomerCorporate().isSelected())
                                    addCustomer("C", custId, name, address, phone);
                                addCustomerToComboBoxesList(custId);
                                setCustomerConfirmationYes();
                            } else {
                                setCustomerConfirmationNo();
                            }
                        } else {
                            setCustomerConfirmationNo();
                            view.getTxtCustomerIdIn().setText("");
                        }
                    } else if (oldCustId.equals(custId) && classChange) {
                        if (fieldsFielledIn) {
                            getCustomerReg().removeCustomer(oldCustId);
                            view.getTxtCustomerId().removeItem(oldCustId);
                            if (view.getRdbtnCustomerPrivate().isSelected())
                                addCustomer("P", custId, name, address, phone);
                            else if (view.getRdbtnCustomerCorporate().isSelected())
                                addCustomer("C", custId, name, address, phone);
                            addCustomerToComboBoxesList(custId);
                            setCustomerConfirmationYes();
                        } else {
                            setCustomerConfirmationNo();
                        }
                    } else {
                        updateCustomerData(custId, name, address, phone);
                        setCustomerConfirmationYes();
                    }
                } else {
                    setCustomerConfirmationNo();
                }
            } else {
                setCustomerConfirmationNo();
            }
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void addCustomer(String type, String custId, String name, String address, String phone) {
        if (type.contentEquals("P"))
            getCustomerReg().addCustomers(new CustomerPrivate(custId, name, address, phone));
        else if (type.contentEquals("C"))
            getCustomerReg().addCustomers(new CustomerCompany(custId, name, address, phone));
    }

    public void updateCustomerData(String custId, String name, String address, String phone) {
        getCustomerReg().updateCustomer(custId, name, address, phone);
    }

    public void searchForCustomer() {
        // SEARCH for Customer by customer itself
        String custId = view.getTxtCustomerCheckId().getText();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        if (tmpCustomer != null) {
            view.getTxtCustomerName().setText(tmpCustomer.getName());
            view.getTxtCustomerAddress().setText(tmpCustomer.getAddress());
            view.getTxtCustomerPhone().setText(tmpCustomer.getPhoneNr());
            if (tmpCustomer.getClass() == CustomerPrivate.class)
                view.getRdbtnCustomerPrivate().setSelected(true);
            else if (tmpCustomer.getClass() == CustomerCompany.class)
                view.getRdbtnCustomerCorporate().setSelected(true);
            view.getButtonGroupIsCustomer().clearSelection();
            view.getTxtCustomerIdIn().setText(custId);
            view.getBtnCustomerEdit().setText("Edit");
            view.getBtnCustomerEdit().setEnabled(true);
            view.getBtnCustomerDelete().setText("Delete");
            view.getBtnCustomerDelete().setEnabled(true);
            disableLowerPartOfCustomer();
            setCustomerConfirmationYes();
        } else {
            setCustomerConfirmationNo();
            view.getTxtCustomerCheckId().setText("");
        }
    }

    public void goToOrderTabAsCustomer() {
        // GO TO ORDER Tab as Customer with proper Id
        String custId;
        int custIdIndex = 0;
        if (view.getTxtCustomerId().getSelectedIndex() != 0) {
            custId = (String) view.getTxtCustomerId().getSelectedItem();
            custIdIndex = view.getTxtCustomerId().getSelectedIndex();
            Customer tmpCustomer = getCustomerReg().findCustomer(custId);
            if (tmpCustomer != null) {
                disableUpperPartOfCustomer();
                disableMiddlePartOfCustomer();
                disableLowerPartOfCustomer();
                view.getButtonGroupIsCustomer().clearSelection();
                view.getPanel02().setEnabled(true);
                view.getTabbedPane().setSelectedIndex(1);
                view.getRdbtnOrderCreate().setEnabled(true);
                view.getRdbtnOrderAddLine().setEnabled(true);
                view.getRdbtnOrderDeleteArticle().setEnabled(true);
                enableBtnOrderProceed();
                createOrderForCustomerToComboBoxesList(tmpCustomer);
                view.getTxtOrderCustId().setText(custId);
                view.getTxtOrderCustIdDuplicate().setText(custId);
            } else {
                setCustomerConfirmationNo();
                view.getTxtCustomerId().setSelectedIndex(0);
            }
        } else {
            setCustomerConfirmationNo();
        }
    }

    public void adminLinkPressed() {
        if (view.getTabbedPane().getSelectedIndex() == 0) {
            view.getTxtCustomerAdminPassword().setVisible(true);
            view.getTxtCustomerAdminPassword().setEnabled(true);
            view.getTxtCustomerAdminPassword().setEchoChar((char)0);
            view.getTxtCustomerAdminPassword().setText("Enter password");
            view.getBtnCustomerPasswordCheck().setVisible(true);
            view.getBtnCustomerPasswordCheck().setEnabled(true);
            view.getBtnCustomerPasswordCheck().setText("Go");
        } else if (view.getTabbedPane().getSelectedIndex() == 1) {
            view.getTxtOrderAdminPassword().setVisible(true);
            view.getTxtOrderAdminPassword().setEnabled(true);
            view.getTxtOrderAdminPassword().setEchoChar((char)0);
            view.getTxtOrderAdminPassword().setText("Enter password");
            view.getBtnOrderPasswordCheck().setVisible(true);
            view.getBtnOrderPasswordCheck().setEnabled(true);
            view.getBtnOrderPasswordCheck().setText("Go");
        } else if (view.getTabbedPane().getSelectedIndex() == 1) {
            view.getTxtPreviewAdminPassword().setVisible(true);
            view.getTxtPreviewAdminPassword().setEnabled(true);
            view.getTxtPreviewAdminPassword().setEchoChar((char)0);
            view.getTxtPreviewAdminPassword().setText("Enter password");
            view.getBtnPrevievPasswordCheck().setVisible(true);
            view.getBtnPrevievPasswordCheck().setEnabled(true);
            view.getBtnPrevievPasswordCheck().setText("Go");
        }
    }

    public void goToAdminTab() {
        // GO TO ADMIN Tab as Admin
        char[] enteredPassword = null;
        if (view.getTabbedPane().getSelectedIndex() == 0) {
            enteredPassword = view.getTxtCustomerAdminPassword().getPassword();
            view.getTxtCustomerAdminPassword().setText("");
            view.getTxtCustomerAdminPassword().setEnabled(false);
            view.getTxtCustomerAdminPassword().setVisible(false);
            view.getBtnCustomerPasswordCheck().setText("");
            view.getBtnCustomerPasswordCheck().setEnabled(false);
            view.getBtnCustomerPasswordCheck().setVisible(false);
        } else if (view.getTabbedPane().getSelectedIndex() == 1) {
            enteredPassword = view.getTxtOrderAdminPassword().getPassword();
            view.getTxtOrderAdminPassword().setText("");
            view.getTxtOrderAdminPassword().setEnabled(false);
            view.getTxtOrderAdminPassword().setVisible(false);
            view.getBtnOrderPasswordCheck().setText("");
            view.getBtnOrderPasswordCheck().setEnabled(false);
            view.getBtnOrderPasswordCheck().setVisible(false);
        } else if (view.getTabbedPane().getSelectedIndex() == 1) {
            enteredPassword = view.getTxtPreviewAdminPassword().getPassword();
            view.getTxtPreviewAdminPassword().setText("");
            view.getTxtPreviewAdminPassword().setEnabled(false);
            view.getTxtPreviewAdminPassword().setVisible(false);
            view.getBtnPrevievPasswordCheck().setText("");
            view.getBtnPrevievPasswordCheck().setEnabled(false);
            view.getBtnPrevievPasswordCheck().setVisible(false);
        }
        if (String.copyValueOf(enteredPassword).equals("AdminPass")) {
            disableUpperPartOfCustomer();
            disableMiddlePartOfCustomer();
            disableLowerPartOfCustomer();
            view.getButtonGroupIsCustomer().clearSelection();
            disableUpperPartOfOrder();
            disableMiddlePartOfOrder();
            disableLowerPartOfOrder();
            view.getButtonGroupOrderActivity().clearSelection();
            view.getPanel04().setEnabled(true);
            view.getRdbtnAdminArticles().setEnabled(true);
            view.getRdbtnAdminSuppliers().setEnabled(true);
            view.getRdbtnAdminClients().setEnabled(true);
            view.getButtonGroupAdminActivity().clearSelection();
            view.getTabbedPane().setSelectedIndex(3);
        }
    }

    public void addNewOrderAsClient() {
        // ADD new Order as Client
        String custId;
        if (!view.getTxtOrderCustId().getText().equals(""))
            custId = view.getTxtOrderCustId().getText();
        else
            custId = view.getTxtOrderCustIdDuplicate().getText();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        if (tmpCustomer != null) {
            String orderNumber = view.getTxtOrderNumberCreate().getText();
            String orderDate = view.getTxtOrderDate().getText();
            addOrder(custId, orderNumber, orderDate);
            disableUpperPartOfOrder();
            enableMiddlePartOfOrder();
            view.getRdbtnOrderAddLine().setSelected(true);
            addOrderForCustomerToComboBoxesList(orderNumber);
            view.getComboOrderNumberAdd().setSelectedItem(orderNumber);
            view.getComboOrderNumberAdd().setEnabled(true);
            setOrderConfirmationYes();
        } else {
            setOrderConfirmationNo();
        }
    }

    public void addOrder(String custId, String orderNr, String orderDate) {
        getCustomerReg().findCustomer(custId).addOrder(new Order(orderNr, orderDate, getCustomerReg().findCustomer(custId)));
    }

    public void addNewOrderLineAsClient() {
        // ADD new OrderLine to Order as Client
        String custId;
        if (!view.getTxtOrderCustId().getText().equals(""))
            custId = view.getTxtOrderCustId().getText();
        else
            custId = view.getTxtOrderCustIdDuplicate().getText();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        String orderNumber = (String) view.getComboOrderNumberAdd().getSelectedItem();
        int orderNumberIndex = view.getComboOrderNumberAdd().getSelectedIndex();
        Order tmpOrder = getCustomerReg().findCustomer(custId).findOrder(orderNumber);
        String quantity = (String) view.getTxtOrderQuantityAdd().getSelectedItem();
        String articleId = (String) view.getComboOrderArticleAdd().getSelectedItem();
        Article tmpArticle = getArticleReg().findArticle(articleId);
        if (tmpCustomer != null && tmpOrder != null && ifInt(quantity) && tmpArticle != null) {
            addOrderLine(custId, orderNumber, quantity, articleId);
            enableMiddlePartOfOrder();
            view.getComboOrderNumberAdd().setSelectedIndex(orderNumberIndex);
            view.getComboOrderNumberAdd().setEnabled(false);
            setOrderConfirmationYes();
        } else {
            setOrderConfirmationNo();
        }
    }

    public void addOrderLine(String custId, String orderNr, String quantity, String articleId) {
        Article tmpArticle = getArticleReg().findArticle(articleId);
        getCustomerReg().findCustomer(custId).findOrder(orderNr).addOrderLine(Integer.valueOf(quantity), tmpArticle );;
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
        String custId;
        if (!view.getTxtOrderCustId().getText().equals(""))
            custId = view.getTxtOrderCustId().getText();
        else
            custId = view.getTxtOrderCustIdDuplicate().getText();
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        String orderNumber = (String) view.getComboOrderNumberDelete().getSelectedItem();
        Order tmpOrder = getCustomerReg().findCustomer(custId).findOrder(orderNumber);
        if (tmpCustomer != null && tmpOrder != null) {
            if (view.getComboOrderArticleDelete().getSelectedIndex() == 0 && view.getTxtOrderQuantityDelete().getSelectedIndex() == 0) {
                deleteOrder(custId, orderNumber);
                deleteOrderForCustomerFromComboBoxesList(orderNumber);
                view.getButtonGroupOrderActivity().clearSelection();
                enableLowerPartOfOrder();
                setOrderConfirmationYes();
            } else if (view.getComboOrderArticleDelete().getSelectedIndex() != 0) {
                Article tmpArticle = getArticleReg().findArticle((String) view.getComboOrderArticleDelete().getSelectedItem());
                if (tmpCustomer.listArticles().contains(tmpArticle)) {
                    if (view.getTxtOrderQuantityDelete().getSelectedItem().equals("all")) {
                        for (OrderLine orderLine: tmpOrder.getOrderLines())
                            if (orderLine.getArticle() == tmpArticle) {
                                tmpOrder.removeOrderLine(orderLine);
                                view.getComboOrderArticleDelete().removeItem(tmpArticle.getId());
                                break;
                            }
                        setOrderConfirmationYes();
                    } else if (!view.getTxtOrderQuantityDelete().getSelectedItem().equals("")) {
                        int tmpQuantity = Integer.parseInt((String)view.getTxtOrderQuantityDelete().getSelectedItem());
                        for (OrderLine orderLine: tmpOrder.getOrderLines())
                            if (orderLine.getArticle() == tmpArticle) {
                                if (orderLine.getQuantity() > tmpQuantity) {
                                    orderLine.setQuantity(orderLine.getQuantity() - tmpQuantity);
                                    setOrderConfirmationYes();
                                    break;
                                } else if (orderLine.getQuantity() == tmpQuantity) {
                                    tmpOrder.removeOrderLine(orderLine);
                                    view.getComboOrderArticleDelete().removeItem(tmpArticle.getId());
                                    setOrderConfirmationYes();
                                    break;
                                } else {
                                    setOrderConfirmationNo();
                                }
                            }
                    } else {
                        setOrderConfirmationNo();
                    }
                } else {
                    setOrderConfirmationNo();
                }
            }
        } else {
            setOrderConfirmationNo();
        }
    }


    public void deleteOrder(String custId, String orderNr) {
        getCustomerReg().findCustomer(custId).removeOrder(orderNr);
    }

    public void goToPreview() {
        String custId;
        if (!view.getTxtOrderCustId().getText().equals(""))
            custId = view.getTxtOrderCustId().getText();
        else
            custId = view.getTxtOrderCustIdDuplicate().getText();
        String orderNumber = "";
        if (view.getComboOrderNumberAdd().getSelectedIndex() != 0)
            orderNumber = (String) view.getComboOrderNumberAdd().getSelectedItem();
        else if (view.getComboOrderNumberDelete().getSelectedIndex() != 0)
            orderNumber = (String) view.getComboOrderNumberDelete().getSelectedItem();
        if (orderNumber != "") {
            prepareOrderPreviev(custId, orderNumber);
        } else if (orderNumber == ""){
            prepareCustomerPreviev(custId);
        } else {
            setOrderConfirmationNo();
        }

    }

    private void prepareOrderPreviev(String custId, String orderNumber) {
        view.getTabbedPane().setSelectedIndex(2);
        view.getLblPreviewAdmin().setEnabled(true);
        Order tmpOrder = getCustomerReg().findCustomer(custId).findOrder(orderNumber);
        view.getLblPreviewOrderNumer().setText("Order nr " + orderNumber);
        String textLines1 = "ITEM";
        String textLines2 = "NAME";
        String textLines3 =  "QUANTITY";
        String textLines4 = "VALUE";
        for (OrderLine orderLine: tmpOrder.getOrderLines()) {
            textLines1 += "\n" + orderLine.getArticle().getId();
            textLines2 += "\n" + orderLine.getArticle().getName();
            textLines3 += "\n" + orderLine.getQuantity();
            textLines4 += "\n" + (orderLine.getArticle().getPrice() * orderLine.getQuantity());
        }
        view.getLblPreviewOrderDetails1().setText(textLines1);
        view.getLblPreviewOrderDetails2().setText(textLines2);
        view.getLblPreviewOrderDetails3().setText(textLines3);
        view.getLblPreviewOrderDetails4().setText(textLines4);
        double totalAmount = tmpOrder.valueOfOrder();
        view.getLblPreviewOrderTotal().setText("Total " + totalAmount + " SEK");
        view.getBtnPreviewBackToOrder().setText("Back");
        view.getBtnPreviewBackToOrder().setEnabled(true);
    }

    private void prepareCustomerPreviev(String custId) {
        view.getTabbedPane().setSelectedIndex(2);
        view.getLblPreviewAdmin().setEnabled(true);
        Customer tmpCustomer = getCustomerReg().findCustomer(custId);
        view.getLblPreviewOrderNumer().setText("Customer nr " + custId);
        String textLines1 = "ORDER";
        String textLines2 = "DATE";
        String textLines3 =  "ITEMS";
        String textLines4 = "VALUE";
        for (Order order: tmpCustomer.getOrders()) {
            textLines1 += "\n" + order.getOrderNr();
            textLines2 += "\n" + order.getDate();
            textLines3 += "\n" + order.amountOfArticles();
            textLines4 += "\n" + order.valueOfOrder();
        }
        view.getLblPreviewOrderDetails1().setText(textLines1);
        view.getLblPreviewOrderDetails2().setText(textLines2);
        view.getLblPreviewOrderDetails3().setText(textLines3);
        view.getLblPreviewOrderDetails4().setText(textLines4);
        int totalAmount = tmpCustomer.amountOfOrders();
        view.getLblPreviewOrderTotal().setText("Total " + totalAmount + " orders");
        view.getBtnPreviewBackToOrder().setText("Back");
        view.getBtnPreviewBackToOrder().setEnabled(true);
    }

    public void goToOrderFromPreview() {
        view.getLblPreviewOrderNumer().setText("");
        view.getLblPreviewOrderDetails().setText("");
        view.getBtnPreviewBackToOrder().setText("");
        view.getBtnPreviewBackToOrder().setEnabled(false);
        view.getTabbedPane().setSelectedIndex(1);
    }

    private void addCustomerToComboBoxesList(String custId) {
        view.getTxtCustomerId().addItem(custId);
        view.getComboAdminClientId().addItem(custId);
    }

    private void deleteCustomerFromComboBoxesList(String custId) {
        view.getTxtCustomerId().removeItem(custId);
        view.getComboAdminClientId().removeItem(custId);
    }

    private void addOrderToComboBoxesList(String orderId) {
    }

    private void deleteOrderFromComboBoxesList(String orderId) {
    }

    private void createOrderForCustomerToComboBoxesList(Customer customer) {
        view.getComboOrderNumberAdd().removeAllItems();
        view.getComboOrderNumberDelete().removeAllItems();
        view.getComboOrderNumberAdd().addItem("");
        view.getComboOrderNumberDelete().addItem("");
        for (Order order: customer.getOrders()) {
            view.getComboOrderNumberAdd().addItem(order.getOrderNr());
            view.getComboOrderNumberDelete().addItem(order.getOrderNr());
        }
    }

    private void addOrderForCustomerToComboBoxesList(String orderId) {
        view.getComboOrderNumberAdd().addItem(orderId);
        view.getComboOrderNumberDelete().addItem(orderId);
    }

    private void deleteOrderForCustomerFromComboBoxesList(String orderId) {
        view.getComboOrderNumberAdd().removeItem(orderId);
        view.getComboOrderNumberDelete().removeItem(orderId);
    }

    private void addArticleToComboBoxesList(String articleId) {
        view.getComboOrderArticleAdd().addItem(articleId);
        view.getComboOrderArticleDelete().addItem(articleId);
        view.getComboAdminArticleId().addItem(articleId);
        view.getComboAdminSupplierArticle().addItem(articleId);
    }

    private void deleteArticleFromComboBoxesList(String articleId) {
        view.getComboOrderArticleAdd().removeItem(articleId);
        view.getComboOrderArticleDelete().removeItem(articleId);
        view.getComboAdminArticleId().removeItem(articleId);
        view.getComboAdminSupplierArticle().removeItem(articleId);
    }

    public void customizeArticleToComboBoxesList() {
        try {
            String custId;
            if (!view.getTxtOrderCustId().getText().equals(""))
                custId = view.getTxtOrderCustId().getText();
            else
                custId = view.getTxtOrderCustIdDuplicate().getText();
            Customer tmpCustomer = getCustomerReg().findCustomer(custId);
            view.getComboOrderArticleDelete().removeAllItems();
            view.getComboOrderArticleDelete().addItem("");
            if (view.getComboOrderNumberDelete().getSelectedIndex() != 0) {
                Order tmpOrder = tmpCustomer.findOrder((String) view.getComboOrderNumberDelete().getSelectedItem());
                for (Article article: tmpOrder.listArticles())
                    view.getComboOrderArticleDelete().addItem(article.getId());
            }
        } catch (NullPointerException err) { }
    }

    private void addSupplierToComboBoxesList(String supplierId) {
        view.getComboAdminSupplierId().addItem(supplierId);
        view.getComboAdminArticleSupplier().addItem(supplierId);
    }

    private void deleteSupplierFromComboBoxesList(String supplierId) {
        view.getComboAdminSupplierId().removeItem(supplierId);
        view.getComboAdminArticleSupplier().removeItem(supplierId);
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
        view.getTxtCustomerId().setSelectedIndex(0);
        view.getTxtCustomerId().setEnabled(true);
        view.getBtnCustomerEdit().setText("Edit");
        view.getBtnCustomerEdit().setEnabled(true);
        view.getBtnCustomerDelete().setText("Delete");
        view.getBtnCustomerDelete().setEnabled(true);
        view.getBtnCustomerCreateAnOrder().setText("Create an order");
        view.getBtnCustomerCreateAnOrder().setEnabled(true);
    }

    public void disableUpperPartOfCustomer() {
        view.getTxtCustomerId().setSelectedIndex(0);
        view.getTxtCustomerId().setEnabled(false);
        view.getBtnCustomerEdit().setText("");
        view.getBtnCustomerEdit().setEnabled(false);
        view.getBtnCustomerDelete().setText("");
        view.getBtnCustomerDelete().setEnabled(false);
        view.getBtnCustomerCreateAnOrder().setText("");
        view.getBtnCustomerCreateAnOrder().setEnabled(false);
    }

    public void enableMiddlePartOfCustomer() {
        view.getTxtCustomerName().setText("");
        view.getTxtCustomerName().setEnabled(true);
        view.getTxtCustomerAddress().setText("");
        view.getTxtCustomerAddress().setEnabled(true);
        view.getTxtCustomerPhone().setText("");
        view.getTxtCustomerPhone().setEnabled(true);
        view.getButtonGroupPrivateCorporate().clearSelection();
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
        view.getTxtCustomerCheckId().setText("");
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
            enableBtnOrderProceed();
            setOrderConfirmationBlank();
        }
    }

    public void enableOrderMiddle() {
        if (view.getRdbtnOrderAddLine().isSelected()) {
            disableUpperPartOfOrder();
            enableMiddlePartOfOrder();
            disableLowerPartOfOrder();
            enableBtnOrderProceed();
            setOrderConfirmationBlank();
        }
    }

    public void enableOrderLower() {
        if (view.getRdbtnOrderDeleteArticle().isSelected()) {
            disableUpperPartOfOrder();
            disableMiddlePartOfOrder();
            enableLowerPartOfOrder();
            enableBtnOrderProceed();
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
        view.getComboOrderNumberAdd().setSelectedIndex(0);
        view.getComboOrderNumberAdd().setEnabled(true);
        view.getTxtOrderQuantityAdd().setSelectedIndex(0);
        view.getTxtOrderQuantityAdd().setEnabled(true);
        view.getComboOrderArticleAdd().setSelectedIndex(0);
        view.getComboOrderArticleAdd().setEnabled(true);
        view.getBtnOrderAddLine().setText("Add");
        view.getBtnOrderAddLine().setEnabled(true);
    }
    public void disableMiddlePartOfOrder() {
        view.getComboOrderNumberAdd().setSelectedIndex(0);
        view.getComboOrderNumberAdd().setEnabled(false);
        view.getTxtOrderQuantityAdd().setSelectedIndex(0);
        view.getTxtOrderQuantityAdd().setEnabled(false);
        view.getComboOrderArticleAdd().setSelectedIndex(0);
        view.getComboOrderArticleAdd().setEnabled(false);
        view.getBtnOrderAddLine().setText("");
        view.getBtnOrderAddLine().setEnabled(false);
    }
    public void enableLowerPartOfOrder() {
        view.getComboOrderNumberDelete().setSelectedIndex(0);
        view.getComboOrderNumberDelete().setEnabled(true);
        view.getTxtOrderQuantityDelete().setSelectedIndex(0);
        view.getTxtOrderQuantityDelete().setEnabled(true);
        view.getComboOrderArticleDelete().setSelectedIndex(0);
        view.getComboOrderArticleDelete().setEnabled(true);
        view.getBtnOrderDelete().setText("Delete");
        view.getBtnOrderDelete().setEnabled(true);
    }
    public void disableLowerPartOfOrder() {
        view.getComboOrderNumberDelete().setSelectedIndex(0);
        view.getComboOrderNumberDelete().setEnabled(false);
        view.getTxtOrderQuantityDelete().setSelectedIndex(0);
        view.getTxtOrderQuantityDelete().setEnabled(false);
        view.getComboOrderArticleDelete().setSelectedIndex(0);
        view.getComboOrderArticleDelete().setEnabled(false);
        view.getBtnOrderDelete().setText("");
        view.getBtnOrderDelete().setEnabled(false);
    }

    public void enableBtnOrderProceed() {
        view.getBtnOrderProceed().setText("Preview");
        view.getBtnOrderProceed().setEnabled(true);
        view.getBtnOrderProceedDuplicate().setText("Preview");
        view.getBtnOrderProceedDuplicate().setEnabled(true);
    }

    public void disableBtnOrderProceed() {
        view.getBtnOrderProceed().setText("");
        view.getBtnOrderProceed().setEnabled(false);
        view.getBtnOrderProceedDuplicate().setText("");
        view.getBtnOrderProceedDuplicate().setEnabled(false);
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
        view.getComboAdminArticleId().setSelectedIndex(0);
        view.getComboAdminArticleId().setEnabled(true);
        view.getTxtAdminArticleName().setText("");
        view.getTxtAdminArticleName().setEnabled(true);
        view.getTxtAdminArticlePrice().setText("");
        view.getTxtAdminArticlePrice().setEnabled(true);
        view.getComboAdminArticleSupplier().setSelectedIndex(0);
        view.getComboAdminArticleSupplier().setEnabled(true);
    }
    public void disableUpperPartOfAdmin() {
        view.getComboAdminArticleId().setSelectedIndex(0);
        view.getComboAdminArticleId().setEnabled(false);
        view.getTxtAdminArticleName().setText("");
        view.getTxtAdminArticleName().setEnabled(false);
        view.getTxtAdminArticlePrice().setText("");
        view.getTxtAdminArticlePrice().setEnabled(false);
        view.getComboAdminArticleSupplier().setSelectedIndex(0);
        view.getComboAdminArticleSupplier().setEnabled(false);
    }
    public void enableMiddlePartOfAdmin() {
        view.getComboAdminSupplierId().setSelectedIndex(0);
        view.getComboAdminSupplierId().setEnabled(true);
        view.getTxtAdminSupplierName().setText("");
        view.getTxtAdminSupplierName().setEnabled(true);
        view.getTxtAdminSupplierPhone().setText("");
        view.getTxtAdminSupplierPhone().setEnabled(true);
        view.getComboAdminSupplierArticle().setSelectedIndex(0);
        view.getComboAdminSupplierArticle().setEnabled(true);
    }
    public void disableMiddlePartOfAdmin() {
        view.getComboAdminSupplierId().setSelectedIndex(0);
        view.getComboAdminSupplierId().setEnabled(false);
        view.getTxtAdminSupplierName().setText("");
        view.getTxtAdminSupplierName().setEnabled(false);
        view.getTxtAdminSupplierPhone().setText("");
        view.getTxtAdminSupplierPhone().setEnabled(false);
        view.getComboAdminSupplierArticle().setSelectedIndex(0);
        view.getComboAdminSupplierArticle().setEnabled(false);
    }
    public void enableLowerPartOfAdmin() {
        view.getComboAdminClientId().setSelectedIndex(0);
        view.getComboAdminClientId().setEnabled(true);
        view.getTxtAdminClientName().setText("");
        view.getTxtAdminClientName().setEnabled(true);
        view.getTxtAdminClientAddress().setText("");
        view.getTxtAdminClientAddress().setEnabled(true);
        view.getTxtAdminClientPhone().setText("");
        view.getTxtAdminClientPhone().setEnabled(true);
        view.getComboAdminClientType().setSelectedIndex(0);
        view.getComboAdminClientType().setEnabled(true);
    }
    public void disableLowerPartOfAdmin() {
        view.getComboAdminClientId().setSelectedIndex(0);
        view.getComboAdminClientId().setEnabled(false);
        view.getTxtAdminClientName().setText("");
        view.getTxtAdminClientName().setEnabled(false);
        view.getTxtAdminClientAddress().setText("");
        view.getTxtAdminClientAddress().setEnabled(false);
        view.getTxtAdminClientPhone().setText("");
        view.getTxtAdminClientPhone().setEnabled(false);
        view.getComboAdminClientType().setSelectedIndex(0);
        view.getComboAdminClientType().setEnabled(false);
    }

    public void enableButtonsOfAdmin() {
        view.getBtnAdminAdd().setText("Add");
        view.getBtnAdminAdd().setEnabled(true);
        view.getBtnAdminUpdate().setText("Update");
        view.getBtnAdminUpdate().setEnabled(true);
        view.getBtnAdminDelete().setText("Delete");
        view.getBtnAdminDelete().setEnabled(true);
        view.getBtnAdminFind().setText("Find");
        view.getBtnAdminFind().setEnabled(true);
    }
    public void disableButtonsOfAdmin() {
        view.getBtnAdminAdd().setText("");
        view.getBtnAdminAdd().setEnabled(false);
        view.getBtnAdminUpdate().setText("");
        view.getBtnAdminUpdate().setEnabled(false);
        view.getBtnAdminDelete().setText("");
        view.getBtnAdminDelete().setEnabled(false);
        view.getBtnAdminFind().setText("");
        view.getBtnAdminFind().setEnabled(false);
    }

    public void setAdminConfirmationYes() { view.getTxtAdminConfirmation().setText("V"); }
    public void setAdminConfirmationNo() { view.getTxtAdminConfirmation().setText("X"); }
    public void setAdminConfirmationBlank() { view.getTxtAdminConfirmation().setText(""); }

    public void clearTabCustomer() {
        disableUpperPartOfCustomer();
        disableMiddlePartOfCustomer();
        disableLowerPartOfCustomer();
        setCustomerConfirmationBlank();
        view.getButtonGroupIsCustomer().clearSelection();
        view.getButtonGroupPrivateCorporate().clearSelection();
    }

    public void clearTabOrder() {
        disableUpperPartOfOrder();
        disableMiddlePartOfOrder();
        disableLowerPartOfOrder();
        setOrderConfirmationBlank();
        view.getButtonGroupOrderActivity().clearSelection();
        view.getTxtOrderCustId().setText("");
    }

    public void clearTabPreview() {

    }

    public void clearTabAdmin() {
        disableUpperPartOfAdmin();
        disableMiddlePartOfAdmin();
        disableLowerPartOfAdmin();
        disableButtonsOfAdmin();
        setAdminConfirmationBlank();
        view.getButtonGroupAdminActivity().clearSelection();
    }

    public void initializeData() {
        // create Customers Private
        customerReg.addCustomers(new CustomerPrivate("860528-5634", "Anna", "Miami, USA", "75-47635644"));
        addCustomerToComboBoxesList("860528-5634");
        // create Customers Corporate
        customerReg.addCustomers(new CustomerCompany("54-986-23", "Monodrake", "Helsinki, FIN", "87-4367572"));
        addCustomerToComboBoxesList("54-986-23");

        // create Suppliers
        supplierReg.addSupplier(new Supplier("s034", "Kreatonix", "745-0983247"));
        addSupplierToComboBoxesList("s034");
        supplierReg.addSupplier(new Supplier("s739", "AmtaRe", "243-8576604"));
        addSupplierToComboBoxesList("s739");

        // create Articles
        articleReg.addArticle(new Article("a124","clock", 210, supplierReg.getSuppliers().get(1)));
        addArticleToComboBoxesList("a124");
        articleReg.addArticle(new Article("a118","lamp", 90, supplierReg.getSuppliers().get(1)));
        addArticleToComboBoxesList("a118");
        articleReg.addArticle(new Article("a492","blanket", 72, supplierReg.getSuppliers().get(0)));
        addArticleToComboBoxesList("a492");
        articleReg.addArticle(new Article("a404","carpet", 276, supplierReg.getSuppliers().get(0)));
        addArticleToComboBoxesList("a404");
        articleReg.addArticle(new Article("a109","sofa", 620, supplierReg.getSuppliers().get(0)));
        addArticleToComboBoxesList("a109");

        // create Orders With Order Lines
        Order tmpOrder;

        customerReg.getCustomers().get(0).getOrders().add(new Order("o738", "20190902"));
        addOrderToComboBoxesList("o738");
        tmpOrder = customerReg.getCustomers().get(0).getOrders().get(0);
        tmpOrder.setOrderedBy(customerReg.getCustomers().get(0));
        tmpOrder.addOrderLine(new OrderLine(10, articleReg.getArticles().get(1)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(5, articleReg.getArticles().get(0)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(6, articleReg.getArticles().get(2)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(21, articleReg.getArticles().get(4)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);

        customerReg.getCustomers().get(0).getOrders().add(new Order("o256", "20171128"));
        addOrderToComboBoxesList("o256");
        tmpOrder = customerReg.getCustomers().get(0).getOrders().get(1);
        tmpOrder.setOrderedBy(customerReg.getCustomers().get(0));
        tmpOrder.addOrderLine(new OrderLine(4, articleReg.getArticles().get(3)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(12, articleReg.getArticles().get(0)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);

        customerReg.getCustomers().get(1).getOrders().add(new Order("o771", "20190221"));
        addOrderToComboBoxesList("o771");
        tmpOrder = customerReg.getCustomers().get(1).getOrders().get(0);
        tmpOrder.setOrderedBy(customerReg.getCustomers().get(1));
        tmpOrder.addOrderLine(new OrderLine(4, articleReg.getArticles().get(1)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(11, articleReg.getArticles().get(3)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(7, articleReg.getArticles().get(2)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);

        customerReg.getCustomers().get(1).getOrders().add(new Order("o356", "20180906"));
        addOrderToComboBoxesList("o356");
        tmpOrder = customerReg.getCustomers().get(1).getOrders().get(1);
        tmpOrder.setOrderedBy(customerReg.getCustomers().get(1));
        tmpOrder.addOrderLine(new OrderLine(2, articleReg.getArticles().get(1)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);

        customerReg.getCustomers().get(1).getOrders().add(new Order("o924", "20180415"));
        addOrderToComboBoxesList("o924");
        tmpOrder = customerReg.getCustomers().get(1).getOrders().get(2);
        tmpOrder.setOrderedBy(customerReg.getCustomers().get(1));
        tmpOrder.addOrderLine(new OrderLine(3, articleReg.getArticles().get(2)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
        tmpOrder.addOrderLine(new OrderLine(2, articleReg.getArticles().get(4)));
        tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);

    }

    public void addAsAdmin() {
        if (view.getRdbtnAdminArticles().isSelected()) {
            addArticleAsAdmin();
        } else if (view.getRdbtnAdminSuppliers().isSelected()) {
            addSupplierAsAdmin();
        } else if (view.getRdbtnAdminClients().isSelected()) {
            addClientAsAdmin();
        } else {
            setAdminConfirmationNo();
        }
    }

    private void addArticleAsAdmin() {
        String tmpArticleId = (String) view.getComboAdminArticleId().getSelectedItem();
        String tmpArticleName = view.getTxtAdminArticleName().getText();
        String tmpArticlePrice = view.getTxtAdminArticlePrice().getText();
        String tmpArticleSupplierId = (String) view.getComboAdminArticleSupplier().getSelectedItem();
        if (getArticleReg().findArticle(tmpArticleId) == null) {
            if (!tmpArticleName.equals("") && !tmpArticlePrice.equals("")) {
                if (canDouble(tmpArticlePrice)) {
                    if (!tmpArticleSupplierId.equals("")) {
                        if (getSupplierReg().findSupplier(tmpArticleSupplierId) != null) {
                            getArticleReg().addArticle(new Article(tmpArticleId, tmpArticleName, Double.parseDouble(tmpArticlePrice), getSupplierReg().findSupplier(tmpArticleSupplierId)));
                            addArticleToComboBoxesList(tmpArticleId);
                            setAdminConfirmationYes();
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminArticleSupplier().setSelectedIndex(0);
                        }
                    } else {
                        getArticleReg().addArticle(new Article(tmpArticleId, tmpArticleName, Double.parseDouble(tmpArticlePrice)));
                        addArticleToComboBoxesList(tmpArticleId);
                        setAdminConfirmationYes();
                    }
                } else {
                    setAdminConfirmationNo();
                    view.getTxtAdminArticlePrice().setText("");
                }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            setAdminConfirmationNo();
            view.getComboAdminArticleId().setSelectedIndex(0);
        }
    }

    private void addSupplierAsAdmin() {
        String tmpSupplierId = (String) view.getComboAdminSupplierId().getSelectedItem();
        String tmpSupplierName = view.getTxtAdminSupplierName().getText();
        String tmpSupplierPhone = view.getTxtAdminSupplierPhone().getText();
        String tmpSupplierArticleId = (String) view.getComboAdminSupplierArticle().getSelectedItem();
        if (getSupplierReg().findSupplier(tmpSupplierId) == null) {
            if (!tmpSupplierName.equals("") && !tmpSupplierPhone.equals("")) {
                if (!tmpSupplierArticleId.equals("")) {
                    if (getArticleReg().findArticle(tmpSupplierArticleId) != null) {
                        Article tmpArticle = getArticleReg().findArticle(tmpSupplierArticleId);
                        if (tmpArticle.getSupplier() == null) {
                            getSupplierReg().addSupplier(new Supplier(tmpSupplierId, tmpSupplierName, tmpSupplierPhone));
                            getSupplierReg().findSupplier(tmpSupplierId).addArticle(tmpArticle);
                            tmpArticle.setSupplier(getSupplierReg().findSupplier(tmpSupplierId));
                            addSupplierToComboBoxesList(tmpSupplierId);
                            setAdminConfirmationYes();
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminSupplierArticle().setSelectedIndex(0);
                        }
                    } else {
                        setAdminConfirmationNo();
                        view.getComboAdminSupplierArticle().setSelectedIndex(0);
                    }
                } else {
                    getSupplierReg().addSupplier(new Supplier(tmpSupplierId, tmpSupplierName, tmpSupplierPhone));
                    addSupplierToComboBoxesList(tmpSupplierId);
                    setAdminConfirmationYes();
                }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            setAdminConfirmationNo();
            view.getComboAdminSupplierId().setSelectedIndex(0);
        }
    }

    private void addClientAsAdmin() {
        String tmpCustomerId = (String) view.getComboAdminClientId().getSelectedItem();
        String tmpCustomerName = view.getTxtAdminClientName().getText();
        String tmpCustomerAddress = view.getTxtAdminClientAddress().getText();
        String tmpCustomerPhone = view.getTxtAdminClientPhone().getText();
        int tmpCustomerType = view.getComboAdminClientType().getSelectedIndex();
        if (getCustomerReg().findCustomer(tmpCustomerId) == null) {
            if (!tmpCustomerName.equals("") && !tmpCustomerAddress.equals("") && !tmpCustomerPhone.equals("")) {
                if (tmpCustomerType != 0) {
                    if (tmpCustomerType == 1)
                        getCustomerReg().addCustomers(new CustomerPrivate(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    else
                        getCustomerReg().addCustomers(new CustomerCompany(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    addCustomerToComboBoxesList(tmpCustomerId);
                    setAdminConfirmationYes();
                } else {
                    setAdminConfirmationNo();
                    view.getComboAdminClientType().setSelectedIndex(0);
                }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            setAdminConfirmationNo();
            view.getComboAdminClientId().setSelectedIndex(0);
        }
    }

    private boolean canDouble(String tmpArticlePrice) {
        try {
            Double.parseDouble(tmpArticlePrice);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }

    public void deleteAsAdmin() {
        if (view.getRdbtnAdminArticles().isSelected()) {
            deleteArticleAsAdmin();
        } else if (view.getRdbtnAdminSuppliers().isSelected()) {
            deleteSupplierAsAdmin();
        } else if (view.getRdbtnAdminClients().isSelected()) {
            deleteClientAsAdmin();
        } else {
            setAdminConfirmationNo();
        }
    }

    private void deleteArticleAsAdmin() {
        String tmpArticleId = (String) view.getComboAdminArticleId().getSelectedItem();
        if (getArticleReg().findArticle(tmpArticleId) != null) {
            getArticleReg().removeArticle(tmpArticleId);
            deleteArticleFromComboBoxesList(tmpArticleId);
            enableUpperPartOfAdmin();
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableUpperPartOfAdmin();
        }
    }

    private void deleteSupplierAsAdmin() {
        String tmpSupplierId = (String) view.getComboAdminSupplierId().getSelectedItem();
        if (getSupplierReg().findSupplier(tmpSupplierId) != null) {
            getSupplierReg().removeSupplier(tmpSupplierId);
            deleteSupplierFromComboBoxesList(tmpSupplierId);
            enableMiddlePartOfAdmin();
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableMiddlePartOfAdmin();
        }
    }

    private void deleteClientAsAdmin() {
        String tmpClientId = (String) view.getComboAdminClientId().getSelectedItem();
        if (getCustomerReg().findCustomer(tmpClientId) != null) {
            getCustomerReg().removeCustomer(tmpClientId);
            deleteCustomerFromComboBoxesList(tmpClientId);
            enableLowerPartOfAdmin();
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableLowerPartOfOrder();
        }
    }

    public void updateAsAdmin() {
        if (view.getRdbtnAdminArticles().isSelected()) {
            updateArticleAsAdmin();
        } else if (view.getRdbtnAdminSuppliers().isSelected()) {
            updateSupplierAsAdmin();
        } else if (view.getRdbtnAdminClients().isSelected()) {
            updateClientAsAdmin();
        } else {
            setAdminConfirmationNo();
        }
    }

    private void updateArticleAsAdmin() {
        String tmpArticleId = (String) view.getComboAdminArticleId().getSelectedItem();
        String tmpArticleName = view.getTxtAdminArticleName().getText();
        String tmpArticlePrice = view.getTxtAdminArticlePrice().getText();
        String tmpArticleSupplierId = (String) view.getComboAdminArticleSupplier().getSelectedItem();
        if (getArticleReg().findArticle(tmpArticleId) == null) {
            if (!tmpArticleName.equals("") && !tmpArticlePrice.equals("")) {
                if (canDouble(tmpArticlePrice)) {
                    if (!tmpArticleSupplierId.equals("")) {
                        if (getSupplierReg().findSupplier(tmpArticleSupplierId) != null) {
                            getArticleReg().addArticle(new Article(tmpArticleId, tmpArticleName, Double.parseDouble(tmpArticlePrice), getSupplierReg().findSupplier(tmpArticleSupplierId)));
                            addArticleToComboBoxesList(tmpArticleId);
                            setAdminConfirmationYes();
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminArticleSupplier().setSelectedIndex(0);
                        }
                    } else {
                        getArticleReg().addArticle(new Article(tmpArticleId, tmpArticleName, Double.parseDouble(tmpArticlePrice)));
                        addArticleToComboBoxesList(tmpArticleId);
                        setAdminConfirmationYes();
                    }
                } else {
                    setAdminConfirmationNo();
                    view.getTxtAdminArticlePrice().setText("");
                }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            if (!tmpArticleName.equals("") && !tmpArticlePrice.equals("")) {
                if (canDouble(tmpArticlePrice)) {
                    if (!tmpArticleSupplierId.equals("")) {
                        if (getSupplierReg().findSupplier(tmpArticleSupplierId) != null) {
                            Article tmpArticle = getArticleReg().findArticle(tmpArticleId);
                            tmpArticle.setName(tmpArticleName);
                            tmpArticle.setPrice(Double.parseDouble(tmpArticlePrice));
                            if (getSupplierReg().findSupplier(tmpArticleSupplierId) != null)
                                tmpArticle.setSupplier(getSupplierReg().findSupplier(tmpArticleSupplierId));
                            setAdminConfirmationYes();
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminArticleSupplier().setSelectedIndex(0);
                        }
                    } else {
                        Article tmpArticle = getArticleReg().findArticle(tmpArticleId);
                        tmpArticle.setName(tmpArticleName);
                        tmpArticle.setPrice(Double.parseDouble(tmpArticlePrice));
                        setAdminConfirmationYes();
                    }
                } else {
                    setAdminConfirmationNo();
                    view.getTxtAdminArticlePrice().setText("");
                }
            } else {
                setAdminConfirmationNo();
            }
        }
    }

    private void updateSupplierAsAdmin() {
        String tmpSupplierId = (String) view.getComboAdminSupplierId().getSelectedItem();
        String tmpSupplierName = view.getTxtAdminSupplierName().getText();
        String tmpSupplierPhone = view.getTxtAdminSupplierPhone().getText();
        String tmpSupplierArticleId = (String) view.getComboAdminSupplierArticle().getSelectedItem();
        if (getSupplierReg().findSupplier(tmpSupplierId) == null) {
            if (!tmpSupplierName.equals("") && !tmpSupplierPhone.equals("")) {
                    if (!tmpSupplierArticleId.equals("")) {
                        if (getArticleReg().findArticle(tmpSupplierArticleId) != null) {
                            Article tmpArticle = getArticleReg().findArticle(tmpSupplierArticleId);
                            if (tmpArticle.getSupplier() == null) {
                                getSupplierReg().addSupplier(new Supplier(tmpSupplierId, tmpSupplierName, tmpSupplierPhone));
                                getSupplierReg().findSupplier(tmpSupplierId).addArticle(tmpArticle);
                                tmpArticle.setSupplier(getSupplierReg().findSupplier(tmpSupplierId));
                                addSupplierToComboBoxesList(tmpSupplierId);
                                setAdminConfirmationYes();
                            } else {
                                setAdminConfirmationNo();
                                view.getComboAdminSupplierArticle().setSelectedIndex(0);
                            }
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminSupplierArticle().setSelectedIndex(0);
                        }
                    } else {
                        getSupplierReg().addSupplier(new Supplier(tmpSupplierId, tmpSupplierName, tmpSupplierPhone));
                        addSupplierToComboBoxesList(tmpSupplierId);
                        setAdminConfirmationYes();
                    }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            if (!tmpSupplierName.equals("") && !tmpSupplierPhone.equals("")) {
                    if (!tmpSupplierArticleId.equals("")) {
                        if (getArticleReg().findArticle(tmpSupplierArticleId) != null) {
                            Article tmpArticle = getArticleReg().findArticle(tmpSupplierArticleId);
                            if (tmpArticle.getSupplier() == null) {
                                Supplier tmpSupplier = getSupplierReg().findSupplier(tmpSupplierId);
                                tmpSupplier.setName(tmpSupplierName);
                                tmpSupplier.setPhoneNr(tmpSupplierPhone);
                                tmpSupplier.addArticle(tmpArticle);
                                tmpArticle.setSupplier(tmpSupplier);
                                setAdminConfirmationYes();
                            } else {
                                setAdminConfirmationNo();
                                view.getComboAdminSupplierArticle().setSelectedIndex(0);
                            }
                        } else {
                            setAdminConfirmationNo();
                            view.getComboAdminSupplierArticle().setSelectedIndex(0);
                        }
                    } else {
                        Supplier tmpSupplier = getSupplierReg().findSupplier(tmpSupplierId);
                        tmpSupplier.setName(tmpSupplierName);
                        tmpSupplier.setPhoneNr(tmpSupplierPhone);
                        setAdminConfirmationYes();
                    }
            } else {
                setAdminConfirmationNo();
            }
        }
    }

    private void updateClientAsAdmin() {
        String tmpCustomerId = (String) view.getComboAdminClientId().getSelectedItem();
        String tmpCustomerName = view.getTxtAdminClientName().getText();
        String tmpCustomerAddress = view.getTxtAdminClientAddress().getText();
        String tmpCustomerPhone = view.getTxtAdminClientPhone().getText();
        int tmpCustomerType = view.getComboAdminClientType().getSelectedIndex();
        boolean fieldsFilledIn = !tmpCustomerName.equals("") && !tmpCustomerAddress.equals("") && !tmpCustomerPhone.equals("");
        if (getCustomerReg().findCustomer(tmpCustomerId) == null) {
            if (fieldsFilledIn) {
                if (tmpCustomerType != 0) {
                    if (tmpCustomerType == 1)
                        getCustomerReg().addCustomers(new CustomerPrivate(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    else
                        getCustomerReg().addCustomers(new CustomerCompany(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    addCustomerToComboBoxesList(tmpCustomerId);
                    setAdminConfirmationYes();
                } else {
                    setAdminConfirmationNo();
                    view.getComboAdminClientType().setSelectedIndex(0);
                }
            } else {
                setAdminConfirmationNo();
            }
        } else {
            if (fieldsFilledIn) {
                if (tmpCustomerType != 0) {
                    getCustomerReg().removeCustomer(tmpCustomerId);
                    if (tmpCustomerType == 1)
                        getCustomerReg().addCustomers(new CustomerPrivate(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    else
                        getCustomerReg().addCustomers(new CustomerCompany(tmpCustomerId, tmpCustomerName, tmpCustomerAddress, tmpCustomerPhone));
                    setAdminConfirmationYes();
                } else {
                    setAdminConfirmationNo();
                    view.getComboAdminClientType().setSelectedIndex(0);
                }
            } else {
                setAdminConfirmationNo();
            }
        }
    }

    public void findAsAdmin() {
        if (view.getRdbtnAdminArticles().isSelected()) {
            findArticleAsAdmin();
        } else if (view.getRdbtnAdminSuppliers().isSelected()) {
            findSupplierAsAdmin();
        } else if (view.getRdbtnAdminClients().isSelected()) {
            findClientAsAdmin();
        } else {
            setAdminConfirmationNo();
        }
    }

    private void findArticleAsAdmin() {
        String tmpArticleId = (String) view.getComboAdminArticleId().getSelectedItem();
        if (getArticleReg().findArticle(tmpArticleId) != null) {
            Article tmpArticle = getArticleReg().findArticle(tmpArticleId);
            view.getTxtAdminArticleName().setText(tmpArticle.getName());
            view.getTxtAdminArticlePrice().setText(String.valueOf(tmpArticle.getPrice()));
            if (tmpArticle.getSupplier().getId() != null)
                view.getComboAdminArticleSupplier().setSelectedItem(tmpArticle.getSupplier().getId());
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableUpperPartOfAdmin();
        }
    }

    private void findSupplierAsAdmin() {
        String tmpSupplierId = (String) view.getComboAdminSupplierId().getSelectedItem();
        if (getSupplierReg().findSupplier(tmpSupplierId) != null) {
            Supplier tmpSupplier = getSupplierReg().findSupplier(tmpSupplierId);
            view.getTxtAdminSupplierName().setText(tmpSupplier.getName());
            view.getTxtAdminSupplierPhone().setText(tmpSupplier.getPhoneNr());
            view.getComboAdminSupplierArticle().setSelectedItem(0);
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableMiddlePartOfAdmin();
        }
    }

    private void findClientAsAdmin() {
        String tmpCustomerId = (String) view.getComboAdminClientId().getSelectedItem();
        if (getCustomerReg().findCustomer(tmpCustomerId) != null) {
            Customer tmpCustomer = getCustomerReg().findCustomer(tmpCustomerId);
            view.getTxtAdminClientName().setText(tmpCustomer.getName());
            view.getTxtAdminClientAddress().setText(tmpCustomer.getAddress());
            view.getTxtAdminClientPhone().setText(tmpCustomer.getPhoneNr());
            if (tmpCustomer.getClass() == CustomerPrivate.class)
                view.getComboAdminClientType().setSelectedIndex(1);
            else if (tmpCustomer.getClass() == CustomerCompany.class)
                view.getComboAdminClientType().setSelectedIndex(2);
            setAdminConfirmationYes();
        } else {
            setAdminConfirmationNo();
            enableLowerPartOfAdmin();
        }
    }
}
