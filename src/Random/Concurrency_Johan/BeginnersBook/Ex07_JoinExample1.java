package Random.Concurrency_Johan.BeginnersBook;

public class Ex07_JoinExample1 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyClass2(), "th1");
        Thread th2 = new Thread(new MyClass2(), "th2");
        Thread th3 = new Thread(new MyClass2(), "th3");
        Thread th4 = new Thread(new MyClass2(), "th4");
        Thread th5 = new Thread(new MyClass2(), "th5");
        Thread th6 = new Thread(new MyClass2(), "th6");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }
}

class MyClass1 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Thread started: " + t.getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Thread ended: " + t.getName());
    }
}