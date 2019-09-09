package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.Views;

import PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects.Vehicle;

public class VehicleView {
    public String printVehicleDetails(Vehicle vehicle) {
        String view = "This is " + vehicle.getColor() + " " + vehicle.getName() + ". ";
        if (vehicle.isDamaged())
            view += "Unfortunately this vehicle is damaged. You cannot rent it.";
        else if (vehicle.isRented())
                view += "Unfortunately this vehicle is rented. Choose another or come back later.";
        return view;
    }
}