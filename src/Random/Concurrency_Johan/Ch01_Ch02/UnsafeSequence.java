package Random.Concurrency_Johan.Ch01_Ch02;

/**
 * http://sde.cs.lth.se/education/phd-courses/advanced-concurrent-programming-in-java/
 */
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }
}

class Racer extends Thread {

    public void run() {
        UnsafeSequence us = new UnsafeSequence();
        while (us.getNext() < 50) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException ie) {
//                ie.printStackTrace();
//            }
            System.out.println(us.getNext());
        }
    }
}

class Race {
    public static void main(String[] args) {
        Racer[] racers = new Racer[1000];
        for (int i = 0; i < 1000; i++) {
            racers[i] = new Racer();
            racers[i].start();
        }
    }
}