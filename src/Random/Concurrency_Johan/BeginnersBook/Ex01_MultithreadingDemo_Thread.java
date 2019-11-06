package Random.Concurrency_Johan.BeginnersBook;

class Ex01_MultithreadingDemo_Thread extends Thread{

    public void run(){
        System.out.println("My thread is in running state.");
    }

    public static void main(String args[]){
        Ex01_MultithreadingDemo_Thread obj = new Ex01_MultithreadingDemo_Thread();
        obj.start();
    }
}
