package Random.Concurrency_Multithreading_Johan.BeginnersBook;

/**
 * https://beginnersbook.com/2015/03/why-dont-we-call-run-method-directly-why-call-start-method/
 *
 * Why don’t we call run() method directly, why call start() method?
 *
 * We can call run() method if we want but then it would behave just like a
 * normal method and we would not be able to take the advantage of multithreading.
 * When the run method gets called though start() method then a new separate thread
 * is being allocated to the execution of run method, so if more than one thread
 * calls start() method that means their run method is being executed by
 * separate threads (these threads run simultaneously).
 *
 * On the other hand if the run() method of these threads are being called directly
 * then the execution of all of them is being handled by the same current thread
 * and no multithreading will take place, hence the output would reflect the
 * sequential execution of threads in the specified order.
 *
 * Lets have a look at the below code to understand this situation.
 */
public class Ex05_RunMethodExample_v02_Start implements Runnable {
    public void run() {
        for(int i=1; i<=3; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Thread th1 = new Thread(new Ex05_RunMethodExample_v02_Start(), "th1");
        Thread th2 = new Thread(new Ex05_RunMethodExample_v02_Start(), "th2");
        th1.start();
        th2.start();
    }
}