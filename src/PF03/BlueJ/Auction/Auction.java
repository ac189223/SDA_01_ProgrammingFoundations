package PF03.BlueJ.Auction;

import java.util.ArrayList;

public class Auction {
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    public Auction() {
        this.setLots(new ArrayList<>());
        this.setNextLotNumber(1);
    }

    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    public void showLots() {
        System.out.println(lots.toString());
    }

    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if (successful) {
                System.out.println(bidder.getName() + " bid for " +
                        value + " for lot number " + lotNumber + " was successful");
            } else {
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                        " already has a bid of " + highestBid.getValue());
            }
        }
    }

    public Lot getLot(int lotNumber) {
        if ((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            Lot selectedLot = lots.get(lotNumber - 1);
            if (selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " + selectedLot.getNumber() +
                        " was returned instead of " + lotNumber);
                selectedLot = null;
            }
            return selectedLot;
        } else {
            System.out.println("Lot number " + lotNumber + " does not exist");
            return null;
        }
    }


    public ArrayList<Lot> getLots() { return lots; }
    public void setLots(ArrayList<Lot> lots) { this.lots = lots; }
    public int getNextLotNumber() { return nextLotNumber; }
    public void setNextLotNumber(int nextLotNumber) { this.nextLotNumber = nextLotNumber; }
}
