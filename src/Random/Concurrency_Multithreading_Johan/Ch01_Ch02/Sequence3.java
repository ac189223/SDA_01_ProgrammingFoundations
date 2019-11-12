package Random.Concurrency_Multithreading_Johan.Ch01_Ch02;

/**
 * http://sde.cs.lth.se/education/phd-courses/advanced-concurrent-programming-in-java/
 */
public class Sequence3 {
    private int value;

    public int getNext() {
        return value++;
    }
}

class Racer3 extends Thread {
    public void run() {
        Sequence3 us = new Sequence3();
        while (us.getNext() < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(us.getNext());
        }
    }
}

class Race3 {
    public static void main(String[] args) {
        Racer3[] racers = new Racer3[4];
        for (int i = 0; i < 4; i++) {
            racers[i] = new Racer3();
            racers[i].start();
        }
    }
}