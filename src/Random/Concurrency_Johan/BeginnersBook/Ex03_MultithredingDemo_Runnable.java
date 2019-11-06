package Random.Concurrency_Johan.BeginnersBook;

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