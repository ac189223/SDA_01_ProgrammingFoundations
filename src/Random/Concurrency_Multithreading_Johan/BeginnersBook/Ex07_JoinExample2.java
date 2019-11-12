package Random.Concurrency_Multithreading_Johan.BeginnersBook;

public class Ex07_JoinExample2 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyClass2(), "th1");
        Thread th2 = new Thread(new MyClass2(), "th2");
        Thread th3 = new Thread(new MyClass2(), "th3");
        Thread th4 = new Thread(new MyClass2(), "th4");
        Thread th5 = new Thread(new MyClass2(), "th5");
        Thread th6 = new Thread(new MyClass2(), "th6");

        // start first thread immediately
        th1.start();

        // start second thread after first one is dead
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th2.start();

        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th3.start();

        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th4.start();

        try {
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th5.start();

        try {
            th5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th6.start();
    }
}

class MyClass2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Thread started: " + t.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Thread ended: " + t.getName());
    }
}