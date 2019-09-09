package PF01.MVC_ModelViewController._04_VehiclesRental_JOptionPane.Vehicles;

public class VehicleController {
    private Vehicle model;
    private VehicleView view;

    VehicleController(Vehicle vehicle, VehicleView vehicleView) {
        this.model = vehicle;
        this.view = vehicleView;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public int getOwner() { return model.getOwner(); }

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

    public int getSafeSpeed() {
        return model.getSafeSpeed();
    }

    void setSafeSpeed(int safeSpeed) {
        model.setSafeSpeed(safeSpeed);
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

    public String updateView() { return view.printVehicleDetails(model); }
}
