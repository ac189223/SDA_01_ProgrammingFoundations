package Random.Concurrency_Johan.BeginnersBook;

public class Ex09_ObjectLevelLock_Synchronized implements Runnable {

    @Override
    public void run() {
        Lock();
    }
    public void Lock() {
        System.out.println(Thread.currentThread().getName());
        synchronized(this) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args) {
        Ex09_ObjectLevelLock_Synchronized b1 = new Ex09_ObjectLevelLock_Synchronized();
        Thread t1b1 = new Thread(b1);
        Thread t2b1 = new Thread(b1);
        Ex09_ObjectLevelLock_Synchronized b2 = new Ex09_ObjectLevelLock_Synchronized();
        Thread t3b2 = new Thread(b2);
        t1b1.setName("t1b1");
        t2b1.setName("t2b1");
        t3b2.setName("t3b2");
        t1b1.start();
        t2b1.start();
        t3b2.start();
    }
}