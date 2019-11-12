package Random.Concurrency_Multithreading_Johan.BeginnersBook;

public class Ex08_DeamonThreads1 extends Thread {

    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Deamon thread executing");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Deamon thread dying");
        } else {
            System.out.println("non-Deamon thread executing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("non-Deamon thread dying");
        }
    }

    public static void main(String[] args) {
        // create two non-Deamon
        Ex08_DeamonThreads1 threads1 = new Ex08_DeamonThreads1();
        Ex08_DeamonThreads1 threads2 = new Ex08_DeamonThreads1();

        // make one Deamon
        threads1.setDaemon(true);

        threads1.start();
        threads2.start();
    }
}
