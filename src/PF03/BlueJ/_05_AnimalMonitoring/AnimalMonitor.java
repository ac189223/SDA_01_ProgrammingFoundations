package PF03.BlueJ._05_AnimalMonitoring;

import java.util.ArrayList;

public class AnimalMonitor {
    private ArrayList<Sighting> sightings;

    public AnimalMonitor() { this.sightings = new ArrayList<>(); }

    // add from file
    public void addSightings(String filename) {
        SightingReader sightingReader = new SightingReader();
        sightingReader.getSightings(filename)
                .forEach(sighting -> sightings.add(sighting));
    }

    // printout
    public void printList() {
        sightings.forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    // printout by animal
    public void printSightingsOf(String animal) {
        sightings.stream()
                .filter(sighting -> sighting.getSpottedAnimal().equals(animal))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    // printout by spotter
    public void printSightingsBy(int spotterId) {
        sightings.stream()
                .filter(sighting -> sighting.getSpotterId() == spotterId)
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    // printout endangered animals
    public void printEndangered(int dangerThreshold) {
        sightings.stream()
                .map(sighting -> sighting.getSpottedAnimal())
                .distinct()
                .filter(s -> getCount(s) <= dangerThreshold)
                .forEach(s -> System.out.println(s + " is endangered."));
    }

    public int getCount(String animal) {
        int total = (int) sightings.stream()
                .filter(sighting -> sighting.getSpottedAnimal().equals(animal))
                .mapToInt(Sighting::getCount).sum();
        return total;
    }

    public void removeZeroCounts() {
        sightings.removeIf(sighting -> sighting.getCount() == 0);
    }

    public void getSightingsInArea(String animal, int area) {
        sightings.stream()
                .filter(sighting -> sighting.getArea() == area && sighting.getSpottedAnimal().equals(animal))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    public void getSightingsOf(String animal) {
        sightings.stream()
                .filter(sighting -> sighting.getSpottedAnimal().equals(animal))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

}
