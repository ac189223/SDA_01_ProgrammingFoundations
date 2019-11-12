package Random.Concurrency_Multithreading_Johan.BeginnersBook;

class PrintDemo {
    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter - " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
    }
}

class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;
    private PrintDemo printDemo;

    ThreadDemo(String threadName, PrintDemo printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    public void run() {
        printDemo.printCount();
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

public class Ex12_TutorialsPoint_Multithreading01 {
    public static void main(String[] args) {
        PrintDemo PD = new PrintDemo();
        ThreadDemo TD1 = new ThreadDemo("Thread 1", PD);
        ThreadDemo TD2 = new ThreadDemo("Thread 2", PD);

        TD1.start();
        TD2.start();

        // wait for threads to end
        try {
            TD1.join();
            TD2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
