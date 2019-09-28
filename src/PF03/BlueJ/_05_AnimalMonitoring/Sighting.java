package PF03.BlueJ._05_AnimalMonitoring;

public class Sighting {
    private final String spottedAnimal;
    private final int spotterId;
    private final int count;
    private final int area;
    private final int period;

    public Sighting(String spottedAnimal, int spotterId, int count, int area, int period) {
        this.spottedAnimal = spottedAnimal;
        this.spotterId = spotterId;
        this.count = count;
        this.area = area;
        this.period = period;
    }

    public String getSpottedAnimal() { return spottedAnimal; }
    public int getSpotterId() { return spotterId; }
    public int getCount() { return count; }
    public int getArea() { return area; }
    public int getPeriod() { return period; }

    public String getDetails() {
        return getSpottedAnimal() + ", count = " + getCount() +
                ", area = " + getArea() +
                ", spotter = " + getSpotterId() +
                ", period = " + getPeriod();
    }
}
