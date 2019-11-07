package Random.Concurrency_Johan.BeginnersBook;

public class Ex06_MyThread_01_Thread extends Thread {

    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        Ex06_MyThread_01_Thread obj = new Ex06_MyThread_01_Thread();
        obj.start();
    }
}