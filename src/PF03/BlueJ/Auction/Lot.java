package PF03.BlueJ.Auction;

public class Lot {
    private final int number;
    private String description;
    private Bid highestBid;

    public Lot(int number, String description) {
        this.number = number;
        this.setDescription(description);
        this.setHighestBid(null);
    }

    public boolean bidFor(Bid bid) {
        if (highestBid == null) {
            highestBid = bid;
            return true;
        } else if (bid.getValue() > highestBid.getValue()) {
            highestBid = bid;
            return true;
        } else
            return false;
    }

    public String toString() {
        String details = number + ": " + description;
        if (highestBid != null)
            details += "    Bid: " + highestBid.getValue();
        else
            details += "    (No bid)";
        return details;
    }

    public int getNumber() { return number; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Bid getHighestBid() { return highestBid; }
    public void setHighestBid(Bid highestBid) { this.highestBid = highestBid; }
}
