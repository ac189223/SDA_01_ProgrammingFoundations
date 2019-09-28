package PF03.BlueJ._05_AnimalMonitoring;

public class Test {
    public static void main(String[] args) {
        AnimalMonitor animalMonitor = new AnimalMonitor();

        //animalMonitor.addSightings("/Users/andrzejcalka/IdeaProjects/ProgrammingFoundations/src/PF03/BlueJ/Resources/sightings.csv");
        animalMonitor.addSightings("src/PF03/BlueJ/Resources/sightings.csv");
        animalMonitor.printList();
        System.out.println("========================================");
        animalMonitor.printSightingsOf("Buffalo");
        System.out.println("========================================");
        animalMonitor.printSightingsBy(3);
        System.out.println("========================================");
        animalMonitor.printEndangered(20);
        System.out.println("========================================");
        System.out.println("Buffalo was seen " + animalMonitor.getCount("Buffalo") + " times");
        System.out.println("========================================");
        animalMonitor.removeZeroCounts();
        animalMonitor.printList();
        System.out.println("========================================");
        animalMonitor.getSightingsInArea("Topi",1);
        System.out.println("========================================");
        animalMonitor.getSightingsOf("Elephant");
    }
}
