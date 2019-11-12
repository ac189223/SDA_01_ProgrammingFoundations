package Random.Concurrency_Multithreading_Johan.Ch01_Ch02;

import java.util.ArrayList;

/**
 * http://sde.cs.lth.se/education/phd-courses/advanced-concurrent-programming-in-java/
 */
public class UnsafeSequence1 {
    private int value;

    public synchronized int getNext() {
        return value++;
    }
}

class Racer1 extends Thread {
    int finalResult;

    public void run() {
        UnsafeSequence1 us = new UnsafeSequence1();
        while (finalResult < 1000) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            finalResult = us.getNext();
        }
    }
}

class Race1 {
    private static Race1 race1 = new Race1();
    private Racer1[] racers;

    public static void main(String[] args) {
        race1.createRacers(100);
        race1.startRacing();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        race1.afterTheRace();
    }

    private void createRacers(int amountOfRacers) {
        racers = new Racer1[amountOfRacers];
        for (int i = 0; i < amountOfRacers; i++)
            racers[i] = new Racer1();
    }

    private void startRacing() {
        for (int i = 0; i < racers.length; i++)
            racers[i].start();
    }

    private void afterTheRace() {
        int bestResult = 0;
        int count = 0;
        ArrayList<Integer> bestRiders = new ArrayList<>();
        for (int i = 0; i < racers.length; i++) {
            if (racers[i].finalResult == bestResult)
                bestRiders.add(i);
            else if (racers[i].finalResult > bestResult) {
                bestResult = racers[i].finalResult;
                bestRiders = new ArrayList<>();
                bestRiders.add(i);
            }
            System.out.print(racers[i].finalResult + " ");
            count++;
            if (count == 20) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println("Best result " + bestResult + " was achieved by " + bestRiders.size() + " riders:");
        System.out.println(bestRiders.toString());
    }
}