package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.Views;

import PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects.Car;

public class CarView extends VehicleView {

    public String printCarDetails(Car car) {
        String view = printVehicleDetails(car);
        if (!car.isDamaged() && !car.isRented()) {
            String engine = "";
            if (!car.isManual())
                engine = "not ";
            view += "It is " + engine + "manual and has " + car.getDoors() + " doors and " + car.getSeats() + " seats.";
        }
        return view;
    }
}
