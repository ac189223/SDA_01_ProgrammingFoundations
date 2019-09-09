package PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Vehicles;

public class VehicleView {
    String printVehicleDetails(Vehicle vehicle) {
        String view = "This is " + vehicle.getColor() + " " + vehicle.getName() + ". ";
        if (vehicle.isDamaged())
            view += "Unfortunately this vehicle is damaged. You cannot rent it.";
        else if (vehicle.isRented())
                view += "Unfortunately this vehicle is rented. Choose another or come back later.";
        return view;
    }
}