package Random.Concurrency_Johan.BeginnersBook;

public class Ex06_MyThread_02_Runnable implements Runnable {

    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        Ex06_MyThread_02_Runnable obj = new Ex06_MyThread_02_Runnable();
        Thread tobj = new Thread(obj);
        tobj.start();

        Thread t = new Thread(new Ex06_MyThread_02_Runnable());
        t.start();
    }
}