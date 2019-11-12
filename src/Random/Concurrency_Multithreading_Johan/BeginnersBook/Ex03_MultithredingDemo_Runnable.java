package Random.Concurrency_Multithreading_Johan.BeginnersBook;

/**
 * https://beginnersbook.com/2013/03/multithreading-in-java/
 *
 * Creating a thread in Java
 *
 * There are two ways to create a thread in Java:
 * 1) By extending Thread class.
 * 2) By implementing Runnable interface.
 */
class Ex03_MultithreadingDemo_Runnable implements Runnable{

    public void run(){
        System.out.println("My thread is in running state.");
        System.out.println(this.getClass());
        System.out.println("My thread is dying slowly.");
    }

    public static void main(String args[]){
        Ex03_MultithreadingDemo_Runnable obj = new Ex03_MultithreadingDemo_Runnable();
        Thread tobj =new Thread(obj);
        tobj.start();
    }
}