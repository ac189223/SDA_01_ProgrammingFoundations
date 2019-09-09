package PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane;

import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Owners.Owner;
import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Owners.OwnerController;
import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Owners.OwnerView;
import PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Vehicles.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

class CarRentalMethods {
    private static CarRentalMethods crm = new CarRentalMethods();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();
    private ArrayList<Integer> doors = new ArrayList<>();
    private ArrayList<Integer> seats = new ArrayList<>();
    private ArrayList[] attributes = {names, colors, doors, seats};
    private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    private int choice1 = -1;
    private String choice2 = "";
    private int choice3 = 0;
    private ArrayList<CarController> finalOffer = new ArrayList<>();
    private String finalChoice = " ";

    static void createOwners(CarRental carRental) {
        OwnerView view = new OwnerView();
        carRental.owners.add(new OwnerController(new Owner("Bob", "Patkinson", 33, "IRL"), view));
        carRental.owners.add(new OwnerController(new Owner("Caroline", "Huntzwoth", 53, "SCH"), view));
        carRental.owners.add(new OwnerController(new Owner("Patrice", "Dupoint", 80, "FR"), view));
        carRental.owners.add(new OwnerController(new Owner("Klaus", "Thomsen", 62, "DK"), view));
        carRental.owners.add(new OwnerController(new Owner("Hubert", "Walnut", 72, "GER"), view));
    }

    static void createCars(CarRental carRental) {
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
        JOptionPane.showMessageDialog(crm.frame,
                "Welcome in our CarRental!" +
                "\nWe have both manual and automatic cars to offer." +
                "\nYou can choose between " + crm.doors.toString().substring(1, crm.doors.toString().length() - 1)
                + " doors and " + crm.seats.toString().substring(1, crm.seats.toString().length() -1) + " seats." +
                "\nAvailable are " + crm.colors.toString().substring(1, crm.colors.toString().length() - 1) + " cars!" +
                "\nWe can offer you " + crm.names.toString().substring(1, crm.names.toString().length() - 1) + ".",
                "CarRental",
                JOptionPane.PLAIN_MESSAGE);
    }

    static void askForPreferences() {
        Object[] options = {"Gearbox", "Seats no", "Doors no", "Car color", "Brand"};
        while (crm.choice1 < 0 || crm.choice1 > 4)
            crm.choice1 = JOptionPane.showOptionDialog(crm.frame,
                 "Please tell us what is important for you!" +
                 "\nChoose from below options.",
                 "CarRental",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 options,
                 options[4]);

        if (crm.choice1 != 0) {
            Object[] possibilities = crm.attributes[4 - crm.choice1].toArray();
            if (crm.choice1 == 4 || crm.choice1 == 3)
                while (!crm.attributes[4 - crm.choice1].contains(crm.choice2))
                    crm.choice2 = (String) JOptionPane.showInputDialog(crm.frame,
                            "Please choose from below:",
                            "CarRental",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            possibilities[0]);
            else
                while (!crm.attributes[4 - crm.choice1].contains(crm.choice3))
                    crm.choice3 = (int) JOptionPane.showInputDialog(crm.frame,
                            "Please choose from below:",
                            "CarRental",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            possibilities[0]);
        } else {
            Object[] possibilities = {"Automatic", "Manual"};
            while (!crm.choice2.equals("Manual") && !crm.choice2.equals("Automatic"))
                crm.choice2 = (String) JOptionPane.showInputDialog(crm.frame,
                        "Please choose from below:",
                        "CarRental",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        possibilities[0]);
        }
    }

    static void offerCars(CarRental carRental) {
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented()) {
                    if (((crm.choice1 == 4) && (crm.choice2.equals(car.getName()))) ||
                            ((crm.choice1 == 3) && (crm.choice2.equals(car.getColor()))) ||
                            ((crm.choice1 == 2) && (crm.choice3 == car.getDoors())) ||
                            ((crm.choice1 == 1) && (crm.choice3 == car.getSeats())) ||
                            ((crm.choice1 == 0) && (crm.choice2.equals("Manual")) && car.isManual()) ||
                            ((crm.choice1 == 0) && !(crm.choice2.equals("Manual")) && !car.isManual())) {
                        crm.finalOffer.add(car);
                    }
                }
            }
        }
    }

    static void askForChoice(CarRental carRental) {
        Object[] possibilities = new Object[crm.finalOffer.size()];
        for (int i = 0; i < crm.finalOffer.size(); i++)
            possibilities[i] = crm.finalOffer.get(i).updateView();
        crm.finalChoice = (String) JOptionPane.showInputDialog(crm.frame,
                "Choose one from below cars:",
                "CarRental",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[0]);

        if (crm.finalChoice != null) {
            congratulate();
            markRented(carRental);
        }
        sayBye();
        System.exit(0);

    }

    private static void sayBye() {
        JOptionPane.showMessageDialog(crm.frame,
                "Thank you for visiting us and welcome again in the future !",
                "CarRental",
                JOptionPane.PLAIN_MESSAGE);
        crm.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void congratulate() {
        JOptionPane.showMessageDialog(crm.frame,
                "Great! Here is your car:\n" + crm.finalChoice,
                "CarRental",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static void markRented(CarRental carRental) {
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented() && car.updateView().equals(crm.finalChoice))
                    car.setRented(true);
            }
        }
    }

    private static void updateLists(CarRental carRental) {
        for (int i = 0; i < carRental.owners.size(); i++) {
            for (int j = 0; j < carRental.owners.get(i).getCars().size(); j++) {
                CarController car = carRental.owners.get(i).getCars().get(j);
                if (!car.isDamaged() && !car.isRented()) {
                    if (!crm.names.contains(car.getName()))
                        crm.names.add(car.getName());
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

