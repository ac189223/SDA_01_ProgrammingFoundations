package PF01.MVC_ModelViewController._02_VehiclesRental.Vehicles;

public class MopedView extends VehicleView {

    public void printMopedDetails(Moped moped) {
        printVehicleDetails(moped);
        if (!moped.isDamaged() && !moped.isRented()) {
            String luggageSpace = "";
            if (!moped.hasLuggageSpace())
                luggageSpace = "not ";
            System.out.println("It has " + moped.getWheels() + " and has " + luggageSpace + "a space for luggage.");
        }
    }
}
