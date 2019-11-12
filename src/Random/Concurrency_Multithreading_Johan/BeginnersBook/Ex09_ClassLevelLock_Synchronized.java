package Random.Concurrency_Multithreading_Johan.BeginnersBook;

public class Ex09_ClassLevelLock_Synchronized implements Runnable {
    @Override
    public void run() {
        Lock();
    }

    public void Lock() {
        System.out.println(Thread.currentThread().getName());
        synchronized(Ex09_ClassLevelLock_Synchronized.class) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args) {
        Ex09_ClassLevelLock_Synchronized b1 = new Ex09_ClassLevelLock_Synchronized();
        Thread t1b1 = new Thread(b1);
        Thread t2b1 = new Thread(b1);
        Ex09_ClassLevelLock_Synchronized b2 = new Ex09_ClassLevelLock_Synchronized();
        Thread t3b2 = new Thread(b2);
        t1b1.setName("t1b1");
        t2b1.setName("t2b1");
        t3b2.setName("t3b2");
        t1b1.start();
        t2b1.start();
        t3b2.start();
    }
}