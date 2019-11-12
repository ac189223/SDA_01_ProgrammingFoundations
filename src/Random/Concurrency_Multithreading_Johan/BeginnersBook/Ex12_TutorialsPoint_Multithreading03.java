package Random.Concurrency_Multithreading_Johan.BeginnersBook;

class PrintDemo3 {
    public void printCount3() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter - " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
    }
}

class ThreadDemo3 extends Thread {
    private Thread thread;
    private String threadName;
    private PrintDemo3 printDemo;

    ThreadDemo3(String threadName, PrintDemo3 printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    public void run() {
        synchronized (printDemo) {
            printDemo.printCount3();
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

class ThreadDemo33 extends Thread {
    private Thread thread;
    private String threadName;
    private PrintDemo3 printDemo;

    ThreadDemo33(String threadName, PrintDemo3 printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    public void run() {
        printDemo.printCount3();
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

public class Ex12_TutorialsPoint_Multithreading03 {
    public static void main(String[] args) {
        PrintDemo3 PD = new PrintDemo3();
        ThreadDemo3 TD1 = new ThreadDemo3("Thread 1", PD);
        ThreadDemo3 TD2 = new ThreadDemo3("Thread 2", PD);
        ThreadDemo3 TD3 = new ThreadDemo3("Thread 3", PD);

        ThreadDemo33 TD4 = new ThreadDemo33("Thread 4", PD);
        ThreadDemo33 TD5 = new ThreadDemo33("Thread 5", PD);
        ThreadDemo33 TD6 = new ThreadDemo33("Thread 6", PD);

        TD1.start();
        TD2.start();
        TD3.start();

        TD4.start();
        TD5.start();
        TD6.start();

    }
}
