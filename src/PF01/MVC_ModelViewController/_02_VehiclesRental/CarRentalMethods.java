package PF01.MVC_ModelViewController._02_VehiclesRental;

import PF01.MVC_ModelViewController._02_VehiclesRental.Owners.Owner;
import PF01.MVC_ModelViewController._02_VehiclesRental.Owners.OwnerController;
import PF01.MVC_ModelViewController._02_VehiclesRental.Owners.OwnerView;
import PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles.Car;
import PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles.CarController;
import PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles.CarView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class CarRentalMethods {
    private static CarRentalMethods crm = new CarRentalMethods();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();
    private ArrayList<Integer> doors = new ArrayList<>();
    private ArrayList<Integer> seats = new ArrayList<>();
    private ArrayList[] attributes = {names, colors, doors, seats};
    private int choice1 = 0;
    private String choice2 = "";
    private int choice3 = 0;
    private HashMap<Integer, CarController> finalOffer = new HashMap<>();
    private int choice = 0;

    static void createOwners(CarRental carRental) {
        OwnerView view = new OwnerView();
        carRental.owners.add(new OwnerController(new Owner("Bob", "Patkinson", 33, "IRL"), view));
        carRental.owners.add(new OwnerController(new Owner("Caroline", "Huntzwoth", 53, "SCH"), view));
        carRental.owners.add(new OwnerController(new Owner("Patrice", "Dupoint", 80, "FR"), view));
        carRental.owners.add(new OwnerController(new Owner("Klaus", "Thomsen", 62, "DK"), view));
        carRental.owners.add(new OwnerController(new Owner("Hubert", "Walnut", 72, "GER"), view));
    }

    static void createVehicles(CarRental carRental) {
        CarView view = new CarView();
        carRental.owners.get(0).buyCar(new CarController(new Car("Volvo", 0, "grey", 4, 5, true), view));
        carRental.owners.get(0).buyCar(new CarController(new Car("Volvo", 0, "black", 5, 5, false), view));
        carRental.owners.get(0).buyCar(new CarController(new Car("Volvo", 0, "burgundy", 4, 5, true), view));
        carRental.owners.get(1).buyCar(new CarController(new Car("Mazda", 1, "violet", 3, 4, true), view));
        carRental.owners.get(1).buyCar(new CarController(new Car("Toyota", 1, "silver", 4, 5, false), view));
        carRental.owners.get(1).buyCar(new CarController(new Car("Nissan", 1, "green", 5, 5, true), view));
        carRental.owners.get(1).buyCar(new CarController(new Car("Mazda", 1, "red", 5, 7, true), view));
        carRental.owners.get(1).buyCar(new CarController(new Car("Nissan", 1, "yellow", 4, 5, false), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Mazda", 2, "red", 2, 4,true), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Honda", 2, "blue", 3, 5,false), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Ford", 2, "red", 5, 5,false), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Audi", 2, "yellow", 4, 5,false), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Opel", 2, "orange", 5, 7,true), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Suzuki", 2, "black", 3, 4,true), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Opel", 2, "magenta", 5, 5, false), view));
        carRental.owners.get(2).buyCar(new CarController(new Car("Suzuki", 2, "orange", 4, 5, true), view));
        carRental.owners.get(3).buyCar(new CarController(new Car("BMW", 3, "black", 4, 5, false), view));
        carRental.owners.get(3).buyCar(new CarController(new Car("Mercedes", 3, "grey", 4, 5, false), view));
        carRental.owners.get(3).buyCar(new CarController(new Car("BMW", 3, "white", 3, 2, true), view));
        carRental.owners.get(4).buyCar(new CarController(new Car("Kia", 4, "grey", 4, 5, false), view));
        carRental.owners.get(4).buyCar(new CarController(new Car("Hyundai", 4, "grey", 4, 5, false), view));
        carRental.owners.get(4).buyCar(new CarController(new Car("Citroen", 4, "purple", 3,4 ,true), view));
        carRental.owners.get(4).buyCar(new CarController(new Car("Renault", 4, "pink", 4,5, true), view));
        for (OwnerController owner : carRental.owners)
            owner.countVehicles();
    }

    static void presentOffer(CarRental carRental) {
        updateLists(carRental);
        System.out.println("Welcome in our CarRental!");
        System.out.println("We have both manual and automatic cars to offer.");
        System.out.println("You can choose between " + crm.doors.toString().substring(1, crm.doors.toString().length() - 1)
                + " doors and " + crm.seats.toString().substring(1, crm.seats.toString().length() -1) + " seats.");
        System.out.println("Available are " + crm.colors.toString().substring(1, crm.colors.toString().length() - 1) + " cars!");
        System.out.println("We can offer you " + crm.names.toString().substring(1, crm.names.toString().length() - 1) + ".");
     }

     static void askForPreferences() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("\nPlease tell us what is important for you:");
        System.out.print("1. Brand   2. Color   3. Doors number   4. Seats number   5. Manual/Automatic   ");
        while (crm.choice1 < 1 || crm.choice1 > 5)
            crm.choice1 = scanner.nextInt();
        if (crm.choice1 != 5) {
            System.out.println("\nPlease choose from below:");
            System.out.println(crm.attributes[crm.choice1 - 1].toString().substring(1, crm.attributes[crm.choice1 - 1].toString().length() -1));
            if (crm.choice1 == 1 || crm.choice1 == 2)
                while (!crm.attributes[crm.choice1 - 1].contains(crm.choice2))
                    crm.choice2 = scanner.next();
            else
                while (!crm.attributes[crm.choice1 - 1].contains(crm.choice3))
                    crm.choice3 = scanner.nextInt();
        } else {
            System.out.println("\nPlease choose between manual and automatic: ");
            while (!crm.choice2.equals("manual") && !crm.choice2.equalsIgnoreCase("automatic"))
                crm.choice2 = scanner.next().toLowerCase();
        }
     }

    static void offerCars(CarRental carRental) {
        System.out.println("\nPlease choose car from below:");
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented()) {
                    if (((crm.choice1 == 1) && (crm.choice2.equals(car.getCarName()))) ||
                            ((crm.choice1 == 2) && (crm.choice2.equals(car.getColor()))) ||
                            ((crm.choice1 == 3) && (crm.choice3 == car.getDoors())) ||
                            ((crm.choice1 == 4) && (crm.choice3 == car.getSeats())) ||
                            ((crm.choice1 == 5) && (crm.choice2.equals("manual")) && car.isManual()) ||
                            ((crm.choice1 == 5) && !(crm.choice2.equals("manual")) && !car.isManual())) {
                        crm.choice++;
                        crm.finalOffer.put(crm.choice, car);
                        System.out.print(crm.choice + ". ");
                        car.updateView();
                    }
                }
            }
        }
    }

    static void askForChoice(CarRental carRental) {
        System.out.print("\nYour choice: ");
        Scanner scanner = new Scanner(System.in);
        int finalChoise = 0;
        while (finalChoise < 1 || finalChoise > crm.choice)
            finalChoise = scanner.nextInt();
        System.out.print("\nGreat! Here is your car: ");
        crm.finalOffer.get(finalChoise).updateView();
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented() &&
                        (car.getOwner() == crm.finalOffer.get(finalChoise).getOwner()) &&
                        (car.getSeats() == crm.finalOffer.get(finalChoise).getSeats()) &&
                        (car.getDoors() == crm.finalOffer.get(finalChoise).getDoors()) &&
                        (car.getColor().equals(crm.finalOffer.get(finalChoise).getColor())) &&
                        (car.getCarName().equals(crm.finalOffer.get(finalChoise).getCarName())))
                    car.setRented(true);
            }
        }
    }

    private static void updateLists(CarRental carRental) {
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented()) {
                    if (!crm.names.contains(car.getCarName()))
                        crm.names.add(car.getCarName());
                    if (!crm.colors.contains(car.getColor()))
                        crm.colors.add(car.getColor());
                    if (!crm.doors.contains(car.getDoors()))
                        crm.doors.add(car.getDoors());
                    if (!crm.seats.contains(car.getSeats()))
                        crm.seats.add(car.getSeats());
                }
            }
        }
        Collections.sort(crm.doors);
        Collections.sort(crm.seats);
        Collections.sort(crm.names);
        Collections.sort(crm.colors);
    }

}

