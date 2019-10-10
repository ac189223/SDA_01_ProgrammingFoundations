package PF03.FinalTest;

public class Test {
    private static Register register = new Register();

    public static void main(String[] args) {

        register.addNewCar( new Car("DJS 674", "opel"));
        register.addNewCar( new Car("KDH 536", "mazda"));

        register.getRegister().get(0).setOwner(new Owner("7804196352", "Peter"));
        register.getRegister().get(1).setOwner(new Owner("8703226653", "John"));

        register.printAllOwners();

        System.out.println(register.findOwner("DJS 674").getName());

        register.removeCar("DJS 674");

        System.out.println(register.getRegister().size());
    }
}


