package PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles;

public class CarView extends VehicleView {

    void printCarDetails(Car car) {
        printVehicleDetails(car);
        if (!car.isDamaged() && !car.isRented()) {
            String engine = "";
            if (!car.isManual())
                engine = "not ";
            System.out.println("It is " + engine + "manual and has " + car.getDoors() + " doors and " + car.getSeats() + " seats.");
        }
    }
}
