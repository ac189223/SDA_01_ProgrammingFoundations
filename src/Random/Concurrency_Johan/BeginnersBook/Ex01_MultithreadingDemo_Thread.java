package Random.Concurrency_Johan.BeginnersBook;

/**
 *https://beginnersbook.com/2013/03/multithreading-in-java/
 *
 * Creating a thread in Java
 *
 * There are two ways to create a thread in Java:
 * 1) By extending Thread class.
 * 2) By implementing Runnable interface.
 */
class Ex01_MultithreadingDemo_Thread extends Thread{

    public void run(){
        System.out.println("My thread is in running state.");
    }

    public static void main(String args[]){
        Ex01_MultithreadingDemo_Thread obj = new Ex01_MultithreadingDemo_Thread();
        obj.start();
    }
}
