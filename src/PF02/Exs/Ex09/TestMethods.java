package PF02.Exs.Ex09;

import java.util.ArrayList;
import java.util.Random;

class TestMethods {
    private static TestMethods tm = new TestMethods();
    private ArrayList<Article> articleReg = new ArrayList<>();
    private ArrayList<Customer> customerReg = new ArrayList<>();
    private ArrayList<Order> orderReg = new ArrayList<>();
    private ArrayList<OrderLine> orderLineReg = new ArrayList<>();
    private ArrayList<Supplier> supplierReg = new ArrayList<>();
    private Random random = new Random();

    static void prepareData() {
        createSuppliers();
        createArticles();
        createCustomers();
        createOrderLines();
        createOrders();
        createConnections();
    }

    private static void createArticles() {
        tm.articleReg.add(new Article("art01", "Toy", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art02", "Bug", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art03", "Horse", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art04", "Mouse", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art05", "Cat", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art06", "Ant", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art07", "Bear", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art08", "Owl", (double) (tm.random.nextInt(100) + 1) / 10));
        tm.articleReg.add(new Article("art09", "Butterfly", (double) (tm.random.nextInt(100) + 1) / 10));
    }

    private static void createCustomers() {
        tm.customerReg.add(new Customer("cust01", "John D", "Malmo"));
        tm.customerReg.add(new Customer("cust02", "Bob F", "Lund"));
        tm.customerReg.add(new Customer("cust03", "Ursula R", "Kivik"));
        tm.customerReg.add(new Customer("cust04", "Greg G", "Lomma"));
        tm.customerReg.add(new Customer("cust05", "Malin B", "Arlov"));
        tm.customerReg.add(new Customer("cust06", "Maurice A", "Ystad"));
    }

    private static void createOrders() {
        tm.orderReg.add(new Order("ord01", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord02", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord03", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord04", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord05", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord06", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
        tm.orderReg.add(new Order("ord07", "201" + tm.random.nextInt(10) + "0" + (tm.random.nextInt(9) + 1) + String.format("%02d", (tm.random.nextInt(28) + 1))));
    }

    private static void createOrderLines() {
        for (int i = 0; i < 20; i++)
            tm.orderLineReg.add(new OrderLine(tm.random.nextInt(150) + 15));
    }

    private static void createSuppliers() {
        tm.supplierReg.add(new Supplier("supp01", "Tretton"));
        tm.supplierReg.add(new Supplier("supp02", "Divine"));
        tm.supplierReg.add(new Supplier("supp03", "Mistrun"));
        tm.supplierReg.add(new Supplier("supp04", "Aberoni"));
        tm.supplierReg.add(new Supplier("supp05", "DH"));
    }

    private static void createConnections() {
        tm.assignArticlesToSuppliers();
        tm.assignOrderLinesToArticles();
        tm.assignOrderToOrderLines();
        tm.assignOrderToCustomer();
    }

    private void assignArticlesToSuppliers() {
        // Both ways, many - many
        for (int i = 0; i < tm.articleReg.size(); i++)
            for (int j = 0; j < tm.random.nextInt(2) + 1; j++) {
                Supplier tmpSupplier = tm.supplierReg.get(tm.random.nextInt(tm.supplierReg.size()));
                if (!tm.articleReg.get(i).getSuppliers().contains(tmpSupplier))
                    tm.articleReg.get(i).addSupplier(tmpSupplier);
                if (!tmpSupplier.getArticles().contains(tm.articleReg.get(i)))
                    tmpSupplier.addArticle(tm.articleReg.get(i));
            }
    }

    private void assignOrderLinesToArticles() {
        // Both ways, one - many
        for (int i = 0; i < tm.orderLineReg.size(); i++) {
            Article tpmArticle = tm.articleReg.get(tm.random.nextInt(tm.articleReg.size()));
            tm.orderLineReg.get(i).setArticle(tpmArticle);
            if (!tpmArticle.getOrderedIn().contains(tm.orderLineReg.get(i)))
                tpmArticle.addOrderLine(tm.orderLineReg.get(i));
        }
    }

    private void assignOrderToOrderLines() {
        // Both ways, many - many
        for (int i = 0; i < tm.orderReg.size(); i++)
            for (int j = 0; j < tm.random.nextInt(4) + 1; j++) {
                OrderLine tmpOrderLine = tm.orderLineReg.get(tm.random.nextInt(tm.orderLineReg.size()));
                if (!tm.orderReg.get(i).getOrderLines().contains(tmpOrderLine))
                    tm.orderReg.get(i).addOrderLine(tmpOrderLine);
                if (!tmpOrderLine.getInOrders().contains(tm.orderReg.get(i)))
                    tmpOrderLine.addOrder(tm.orderReg.get(i));
            }
    }

    private void assignOrderToCustomer() {
        // Both ways, one - many
        for (int i = 0; i < tm.orderReg.size(); i++) {
            Customer tmpCustomer = tm.customerReg.get(tm.random.nextInt(tm.customerReg.size()));
            tm.orderReg.get(i).setCustomer(tmpCustomer);
            if (!tmpCustomer.getOrders().contains(tm.orderReg.get(i)))
                tmpCustomer.addOrder(tm.orderReg.get(i));
        }
    }

    static void presentData() {
        // Customers - orders - orderlines
        tm.listCustomers();
        // Suppliers - articles
        tm.listSuppliers();
        // Article - customers
        tm.listArticles();
    }

    private void listCustomers() {
        for (Customer customer: tm.customerReg)
            if (customer.getOrders().size() > 0) {
                System.out.println(customer.getName() + " lives in " + customer.getAddress() + " and he ordered for total " +
                        customer.totalPrice() + " SEK:");
                tm.printOrders(customer.getOrders());
                System.out.println();
            }
    }

    private void printOrders(ArrayList<Order> orders) {
        for (Order order: orders) {
            System.out.print("    " + order.getDate() + ": ");
            tm.printOrderLines(order.getOrderLines());
            System.out.println();
        }
    }

    private void printOrderLines(ArrayList<OrderLine> orderLines) {
        for (OrderLine orderLine: orderLines) {
            System.out.print(orderLine.getQuantity() + " times " + orderLine.getArticle().getName() + " for " + orderLine.getArticle().getPrice() + " SEK, ");
        }
    }

    private void listSuppliers() {
        for (Supplier supplier: tm.supplierReg)
            if (supplier.getArticles().size() > 0) {
                System.out.print(supplier.getName() + " provides: ");
                tm.printArticles(supplier.getArticles());
                System.out.println();
            }
        System.out.println();
    }

    private void printArticles(ArrayList<Article> articles) {
        for (Article article: articles)
            System.out.print(article.getName() + ", ");
    }

    private void listArticles() {
        for (Article article: tm.articleReg)
            System.out.println(article.getName() + " was ordered by " + article.orderedBy());
    }
}