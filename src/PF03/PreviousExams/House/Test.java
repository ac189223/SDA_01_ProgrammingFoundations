package PF03.PreviousExams.House;

public class Test {
    public static void main(String[] args) {
        AccountRegister aR = new AccountRegister();
        //create apartments
        aR.addApartmentToHouse(new Apartment("001", 65, 2300));
        aR.addApartmentToHouse(new Apartment("002", 75, 2630));
        aR.addApartmentToHouse(new Apartment("003", 45, 1500));
        //create tenants
        Tenant tenant1 = new Tenant("800101-0101", "Pablo");
        Tenant tenant2 = new Tenant("800202-0202", "Pina");
        //rent apartments
        System.out.println("============== Pablo moves into 001 ==============");
        aR.setTenantOfApartment("001", tenant1);
        System.out.println("First tenant " + aR.findTenantOfApartment(tenant1.getApartment().getaNr()).getName() +
                " lives in " + tenant1.getApartment().getaNr());

        System.out.println("============== Pablo exchange to 002 ==============");
        aR.setTenantOfApartment("002", tenant1);
        System.out.println("First tenant " + aR.findTenantOfApartment(tenant1.getApartment().getaNr()).getName() +
                " lives in " + tenant1.getApartment().getaNr());

        System.out.println("============== Pina moves into 003 ==============");
        aR.setTenantOfApartment("003", tenant2);
        System.out.println("Second tenant " + aR.findTenantOfApartment(tenant2.getApartment().getaNr()).getName() +
                " lives in " + tenant2.getApartment().getaNr());

        System.out.println("============== They exchange ==============");
        aR.changeTenantOfApartment(tenant1, tenant2);
        System.out.println("First tenant " + aR.findTenantOfApartment(tenant1.getApartment().getaNr()).getName() +
                " lives in " + tenant1.getApartment().getaNr());
        System.out.println("Second tenant " + aR.findTenantOfApartment(tenant2.getApartment().getaNr()).getName() +
                " lives in " + tenant2.getApartment().getaNr());
        //delete apartment
        System.out.println("============== Pina's apartment is destroyed !!!");
        aR.removeApartmentFromHouse("002");
        if (tenant2.getApartment() == null)
            System.out.println("Second tenant lives nowhere");
        else
            System.out.println("Second tenant lives still in " + tenant2.getApartment().getaNr());
        System.out.println("============== Pina moves into 001 ==============");
        aR.setTenantOfApartment("001", tenant2);
        System.out.println("Second tenant " + aR.findTenantOfApartment(tenant2.getApartment().getaNr()).getName() +
                " lives in " + tenant2.getApartment().getaNr());
        System.out.println("============== Btw, average price is " + aR.averagePriceOfApartment());
    }
}
