package PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles;

class VehicleView {
    void printVehicleDetails(Vehicle vehicle) {
        System.out.print("This is " + vehicle.getColor() + " " + vehicle.getName() + ". ");
        if (vehicle.isDamaged())
            System.out.println("Unfortunately this vehicle is damaged. You cannot rent it.");
        else if (vehicle.isRented())
                System.out.println("Unfortunately this vehicle is rented. Choose another or come back later.");
    }
}