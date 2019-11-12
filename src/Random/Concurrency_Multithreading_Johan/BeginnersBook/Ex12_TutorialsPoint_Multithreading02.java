package Random.Concurrency_Multithreading_Johan.BeginnersBook;

class PrintDemo2 {
    public void printCount2() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter - " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
    }
}

class ThreadDemo2 extends Thread {
    private Thread thread;
    private String threadName;
    private PrintDemo2 printDemo;

    ThreadDemo2(String threadName, PrintDemo2 printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    public void run() {
        synchronized (printDemo) {
            printDemo.printCount2();
        }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this ,threadName);
            thread.start();
        }
    }
}

public class Ex12_TutorialsPoint_Multithreading02 {
    public static void main(String[] args) {
        PrintDemo2 PD = new PrintDemo2();
        ThreadDemo2 TD1 = new ThreadDemo2("Thread 1", PD);
        ThreadDemo2 TD2 = new ThreadDemo2("Thread 2", PD);
        ThreadDemo2 TD3 = new ThreadDemo2("Thread 3", PD);
        ThreadDemo2 TD4 = new ThreadDemo2("Thread 4", PD);

        TD1.start();
        TD2.start();
        TD3.start();
        TD4.start();

        // wait for threads to end
//        try {
//            TD1.join();
//            TD2.join();
//        } catch (Exception e) {
//            System.out.println("Interrupted");
//        }
    }
}
