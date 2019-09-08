package PF01.MVC_ModelViewController._03_VehiclesRental_JOptionPane.Vehicles;

public class CarController {
    private Car model;
    private CarView view;

    public CarController(Car car, CarView carView) {
        this.model = car;
        this.view = carView;
    }

    public String getCarName() {
        return model.getName();
    }

    public void setCarName(String name) {
        model.setName(name);
    }

    public int getOwner() {
        return model.getOwner();
    }

    public void setOwner(int owner) {
        model.setOwner(owner);
    }

    public boolean isRented() {
        return model.isRented();
    }

    public void setRented(boolean rented) {
        model.setRented(rented);
    }

    public boolean isRunning() {
        return model.isRunning();
    }

    public void setRunning(boolean running) {
        model.setRunning(running);
    }

    public String getColor() {
        return model.getColor();
    }

    public void setColor(String color) {
        model.setColor(color);
    }

    public boolean isDamaged() {
        return model.isDamaged();
    }

    public void setDamaged(boolean damaged) {
        model.setDamaged(damaged);
    }

    public int getDoors() {
        return model.getDoors();
    }

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
