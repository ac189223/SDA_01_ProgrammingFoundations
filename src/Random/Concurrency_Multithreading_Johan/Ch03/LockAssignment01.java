package Random.Concurrency_Multithreading_Johan.Ch03;

public class LockAssignment01 {
    public static void main(String[] args) {

//        NotLockedThread NLT = null;
//        LockedThread LT = null;
//        for (int i = 1; i < 8; i += 2) {
//            NLT = new NotLockedThread(String.valueOf(i), i * 2);
//            NLT.start();
//            LT = new LockedThread(String.valueOf(i + 1), (i + 1) * 2);
//            LT.start();
//        }
//        try {
//            LT.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        NotLockedThread NLT1 = new NotLockedThread(String.valueOf(1), 1 * 2);
//        NLT1.start();
//        NotLockedThread NLT2 = new NotLockedThread(String.valueOf(2), 2 * 2);
//        NLT2.start();
//        NotLockedThread NLT3 = new NotLockedThread(String.valueOf(3), 3 * 2);
//        NLT3.start();
//        NotLockedThread NLT4 = new NotLockedThread(String.valueOf(4), 4 * 2);
//        NLT4.start();
        LockedThread LT1 = new LockedThread(String.valueOf(1 + 1), (1 + 1) * 2);
        LT1.start();
        LockedThread LT2 = new LockedThread(String.valueOf(2 + 1), (2 + 1) * 2);
        LT2.start();
//        LockedThread LT3 = new LockedThread(String.valueOf(3 + 1), (3 + 1) * 2);
//        LT3.start();
//        LockedThread LT4 = new LockedThread(String.valueOf(4 + 1), (4 + 1) * 2);
//        LT4.start();
        try {
            LT1.join();
            LT2.join();
//            LT3.join();
//            LT4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {
    Thread thread;
    String threadName;
    int maxNumber;
    PrintOut printOut = new PrintOut();

    MyThread(String threadName, int maxNumber) {
        this.threadName = threadName;
        this.maxNumber = maxNumber;
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this ,threadName);
            thread.start();
        }
    }
}

class PrintOut {
    public void printOut(String threadName, int maxNumber) {
        System.out.println("Starting thread " + threadName);
        for (int i = 0; i < maxNumber; i++) {
            System.out.println("Printed out " + i + " from thread " + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Closing thread " + threadName);
    }
}

class NotLockedThread extends MyThread {

    NotLockedThread(String threadName, int maxNumber) {
        super(threadName, maxNumber);
    }

    public void run() {
        System.out.println("Born of not locked thread " + threadName);
        printOut.printOut(threadName, maxNumber);
        System.out.println("Death of not locked thread " + threadName);
    }

}

class LockedThread extends MyThread {

    LockedThread(String threadName, int maxNumber) {
        super(threadName, maxNumber);
    }

    public void run() {
        synchronized (printOut) {
            System.out.println("Born of locked thread " + threadName);
            printOut.printOut(threadName, maxNumber);
            System.out.println("Death of locked thread " + threadName);
        }
    }
}