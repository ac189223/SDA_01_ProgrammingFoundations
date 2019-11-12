package Random.Concurrency_Multithreading_Johan.BeginnersBook;

class LockA implements Runnable {
    @Override
    public void run() {
        synchronized (LockA.class) {
            System.out.println("Class");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Ex11_TestClassVsInstanceLock {
    public static void main(String[] args) {
        final LockA a = new LockA();
        final LockA b = new LockA();
        try {
            Thread t = new Thread(a);
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    synchronized (b) {
                        System.out.println("Instance 1"+ currentThread().currentThread().holdsLock(b));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();
            t1.start();
            synchronized (a) {
                System.out.println("Instance2");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}