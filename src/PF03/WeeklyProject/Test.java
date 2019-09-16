package PF03.WeeklyProject;

public class Test {
    public static Test t = new Test();
    private CustomerReg customers = new CustomerReg();
    private SupplierReg suppliers = new SupplierReg();
    private ArticleReg articles = new ArticleReg();

    public static void main(String[] args) {
        t.createData();
        t.printData();
        t.connectData();
    }

    private void createData() {
        t.createCustomers();
        t.createSuppliers();
        t.createArticles();
        t.createOrdersWithOrderLines();
    }

    private void createCustomers() {
        for (int i = 0; i < 4; i++)
            if (i % 2 == 0)
                t.customers.addCustomers(new CustomerPrivat((String.valueOf(i)),"name" + i, "address" + i, "phone" + i));
            else
                t.customers.addCustomers(new CustomerCompany((String.valueOf(i)),"name" + i, "address" + i, "phone" + i));
    }

    private void createSuppliers() {
        for (int i = 0; i < 4; i++)
            t.suppliers.addSupplier(new Supplier((String.valueOf(i)),"name" + i, "address" + i));
    }

    private void createArticles() {
        for (int i = 0; i < 8; i++)
            t.articles.addArticle(new Article((String.valueOf(i)),"name" + i, (double)i + 10, t.suppliers.findSupplier(String.valueOf (i % t.suppliers.getSuppliers().size()))));
    }

    private void createOrdersWithOrderLines() {
        int counter = 0;
        int articlesAmount = t.articles.getArticles().size();
        for (int customer = 0; customer < t.customers.getCustomers().size(); customer++)
            for (int order = 0; order < 4; order++) {
                t.customers.getCustomers().get(customer).getOrders().add(new Order(String.valueOf(order), "2019090" + order));
                Order tmpOrder = t.customers.getCustomers().get(customer).getOrders().get(order);
                for (int line = 0; line < 6; line++) {
                    counter++;
                    tmpOrder.addOrderLine(new OrderLine(line + 10, t.articles.findArticle(String.valueOf(counter % articlesAmount))));
                }
            }
    }

    private void connectData() {

    }



    private void printData() {
        for (Customer customer: t.customers.getCustomers()) {
            System.out.println(customer.getName() + " " + customer.getAddress() + " " + customer.getPhoneNr() + "  " + customer.listArticles().toString());
            for (Order order: customer.getOrders()) {
                System.out.println("    " + order.getOrderNr() + " " + order.getDate() + " " + order.amountOfLines() + " " + order.amountOfArticles() + " " + order.listArticles().toString());
                for (OrderLine orderLine: order.getOrderLines()) {
                    System.out.println("        " + orderLine.getQuantity() + " " + orderLine.getArticle().getName() + " " + orderLine.getSupplierOf().getName() + " " + orderLine.getValue());
                }
            }
        }
    }
}
