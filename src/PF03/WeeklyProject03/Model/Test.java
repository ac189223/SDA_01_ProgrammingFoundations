package PF03.WeeklyProject03.Model;

public class Test {
    public static Test t = new Test();
    private CustomerReg customers = new CustomerReg();
    private SupplierReg suppliers = new SupplierReg();
    private ArticleReg articles = new ArticleReg();

    public static void main(String[] args) {
        t.createData();
        t.connectData();
        t.printData();
        t.testData();
    }

    private void createData() {
        t.createCustomers();
        t.createSuppliers();
        t.createArticles();
        t.createOrdersWithOrderLines();
    }

    private void createCustomers() {
        for (int i = 0; i < 2; i++)
            if (i % 2 == 0)
                customers.addCustomers(new CustomerPrivate((String.valueOf(i)),"private" + i, "address" + i, "phone" + i));
            else
                customers.addCustomers(new CustomerCompany((String.valueOf(i)),"company" + i, "address" + i, "phone" + i));
    }

    private void createSuppliers() {
        for (int i = 0; i < 3; i++)
            suppliers.addSupplier(new Supplier((String.valueOf(i)),"supplier" + i, "address" + i));
    }

    private void createArticles() {
        for (int i = 0; i < 4; i++) {
            Supplier tempSupplier = t.suppliers.findSupplier(String.valueOf (i % t.suppliers.getSuppliers().size()));
            articles.addArticle(new Article((String.valueOf(i)),"article" + i, (double)i + 1, tempSupplier));
        }
    }

    private void createOrdersWithOrderLines() {
        int counter = 0;
        int articlesAmount = articles.getArticles().size();
        for (int customer = 0; customer < customers.getCustomers().size(); customer++)
            for (int order = 0; order < 3; order++) {
                customers.getCustomers().get(customer).getOrders().add(new Order(String.valueOf(order), "2019090" + order));
                Order tmpOrder = customers.getCustomers().get(customer).getOrders().get(order);
                tmpOrder.setOrderedBy(customers.getCustomers().get(customer));
                for (int line = 0; line < 3; line++) {
                    counter++;
                    tmpOrder.addOrderLine(new OrderLine(customer + order + line + 1, articles.findArticle(String.valueOf(counter % articlesAmount))));
                    tmpOrder.getOrderLines().get(tmpOrder.getOrderLines().size() - 1).setOrder(tmpOrder);
                }
            }
    }

    private void connectData() {
        // Order - ordered by - Customer

    }

    private void printData() {
        for (Customer customer: customers.getCustomers()) {
            System.out.println(customer.getName() + ", " + customer.getAddress() + ", " + customer.getPhoneNr());
            for (Order order: customer.getOrders()) {
                System.out.println("    " + order.getOrderNr() + ", " + order.getDate() + ", " + order.amountOfLines() + ", " + order.amountOfArticles() + ", " + order.valueOfOrder());
                for (OrderLine orderLine: order.getOrderLines()) {
                    System.out.println("        " + orderLine.getQuantity() + ", " + orderLine.getArticle().getName() + ", " + orderLine.getSupplierOf().getName() + ", " + orderLine.getValue());
                }
            }
        }
    }

    private void testData() {
        // Article - Supplier
        System.out.println(articles.getArticles().get(0).getName() +
                "    " + articles.getArticles().get(0).getSupplier().listArticles());

        System.out.println(suppliers.getSuppliers().get(0).getName() +
                "    " + suppliers.getSuppliers().get(0).getSuppliesArticles().get(0).getSupplier().getName());

        // Article - OrderLine
        System.out.println(articles.getArticles().get(0).getName() +
                "    " + articles.getArticles().get(0).getOrderedInLines().get(0).getArticle().getName());

        // Customer - Order
        System.out.println(customers.getCustomers().get(0).getName() +
                "    " + customers.getCustomers().get(0).getOrders().get(0).getOrderedBy().getName());

        // Order - OrderLine
        System.out.println(customers.getCustomers().get(0).getOrders().get(0).getDate() +
                "    " + customers.getCustomers().get(0).getOrders().get(0).getOrderLines().get(0).getOrder().getDate());
    }
}

// to compare class
// this.customers.getCustomers().get(i).getClass().getName().equals("Customer.CustomerPrivate"))