package Random.Concurrency_Johan.BeginnersBook;

public class Ex07_JoinExample3 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyClass3(), "th1");
        Thread th2 = new Thread(new MyClass3(), "th2");

        // start first thread immediately
        th1.start();

        // start second thread after first one is dead
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th2.start();
    }
}

class MyClass3 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Thread started: " + t.getName());
        for (int i = 1; i < 4; i++) {
            System.out.println(i + " " + t.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Thread ended: " + t.getName());
    }
}