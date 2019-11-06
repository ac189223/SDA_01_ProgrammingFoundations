package Random.Concurrency_Johan.BeginnersBook;

class Ex04_Count_Runnable implements Runnable {
    Thread mythread ;
    Ex04_Count_Runnable() {
        mythread = new Thread(this, "my runnable thread");
        System.out.println("My thread created " + mythread);
        mythread.start();
    }

    public void run() {
        try {
            for (int i=0 ; i<10; i++) {
                System.out.println("      Printing the count " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("      My thread was interrupted");
        }
        System.out.println("      My thread run is over" );
    }
}

class RunnableExample {
    public static void main(String args[]) {
        Ex04_Count_Runnable cnt = new Ex04_Count_Runnable();
        try {
            while(cnt.mythread.isAlive()) {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread run is over" );
    }
}