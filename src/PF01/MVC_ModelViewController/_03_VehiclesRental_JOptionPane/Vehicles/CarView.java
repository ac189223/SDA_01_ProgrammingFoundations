package PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane.Vehicles;

public class CarView extends VehicleView {

    String printCarDetails(Car car) {
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
