package PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.Controllers;

import PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.CarRentalObjects.Car;
import PF01.MVC_ModelViewController._05_VehiclesRental_JOptionPane.Views.CarView;

public class CarController extends VehicleController{
    private Car model;
    private CarView view;

    public CarController(Car vehicle, CarView vehicleView) {
        super(vehicle, vehicleView);
        this.model = vehicle;
        this.view = vehicleView;
    }

    public int getDoors() { return ((Car)model).getDoors(); }

    public void setDoors(int doors) {
        model.setDoors(doors);
    }

    public int getSeats() {
        return model.getSeats();
    }

    public void setSeats(int seats) {
        model.setSeats(seats);
    }

    public boolean isManual() {
        return model.isManual();
    }

    public void setManual(boolean manual) {
        model.setManual(manual);
    }

    public String updateView() {
        return view.printCarDetails(model);
    }
}
