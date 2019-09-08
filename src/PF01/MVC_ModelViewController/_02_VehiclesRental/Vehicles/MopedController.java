package PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles;

public class MopedController {
    private Moped model;
    private MopedView view;

    MopedController(Moped moped, MopedView mopedView) {
        this.model = moped;
        this.view = mopedView;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
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

    public int getWheels() {
        return model.getWheels();
    }

    public void setWheels(int wheels) {
        model.setWheels(wheels);
    }

    public boolean hasLuggageSpace() {
        return model.hasLuggageSpace();
    }

    public void setLuggageSpace(boolean luggageSpace) {
        model.setLuggageSpace(luggageSpace);
    }

    public void updateView() {
        view.printVehicleDetails(model);
    }
}
