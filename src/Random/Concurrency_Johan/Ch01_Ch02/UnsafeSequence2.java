package Random.Concurrency_Johan.Ch01_Ch02;

/**
 * http://sde.cs.lth.se/education/phd-courses/advanced-concurrent-programming-in-java/
 */
public class UnsafeSequence2 {
    private int value;

    public int getNext() {
        return value++;
    }
}

class Racer2 extends Thread {
    public void run() {
        UnsafeSequence1 us = new UnsafeSequence1();
        while (us.getNext() < 50) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(us.getNext());
        }
    }
}

class Race2 {
    public static void main(String[] args) {
        Racer2[] racers = new Racer2[100];
        for (int i = 0; i < 100; i++) {
            racers[i] = new Racer2();
            racers[i].start();
        }
    }
}