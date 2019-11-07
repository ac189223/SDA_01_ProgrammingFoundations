package Random.Concurrency_Johan.BeginnersBook;

/**
 * https://beginnersbook.com/2013/03/multithreading-in-java/
 *
 * Creating a thread in Java
 *
 * There are two ways to create a thread in Java:
 * 1) By extending Thread class.
 * 2) By implementing Runnable interface.
 */
class Ex02_Count_Thread extends Thread {

    Ex02_Count_Thread() {
        super("my extending thread");
        System.out.println("      My thread that was created is " + this);
        start();    // this starts run() method
    }

    public void run() {
        try {
            for (int i=0; i<10; i++) {
                System.out.println("      Printing the count " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("      My thread was interrupted");
        }
        System.out.println("      My thread run is over" );
    }
}

class ExtendingExample {
    public static void main(String args[]) {
        Ex02_Count_Thread cnt = new Ex02_Count_Thread();
        try {
            while(cnt.isAlive()) {
                System.out.println("Main thread will be alive till the child thread is alive");
                Thread.sleep(1500);
            }
        } catch(InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread's run is over" );
    }
}