package Random.Concurrency_Multithreading_Johan.BeginnersBook;

/**
 * show1() is non static and show() is static.
 * Now, show() is called by class name (or by object) and show1() is called by object,
 * then both methods can accessed simultaneously by two threads.
 */
class Shared{
    static int x;
    static synchronized void show(String s,int a){
        x=a;
        System.out.println("Starting in method "+s+" "+x);
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){ }
        System.out.println("Ending from method "+s+" "+x);
    }
    synchronized void show1(String s,int a){
        x=a;
        System.out.println("Starting show1 "+s);
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){ }
        System.out.println("Ending from show1 "+s);
    }
}

class CustomThread extends Thread{
    Shared s;
    public CustomThread(Shared s,String str){
        super(str);
        this.s=s;
        start();
    }
    public void run(){
        Shared.show(Thread.currentThread().getName(),10);
    }
}

class CustomThread1 extends Thread{
    Shared s;
    public CustomThread1(Shared s,String str){
        super(str);
        this.s=s;
        start();
    }
    public void run(){
        s.show1(Thread.currentThread().getName(),20);
    }
}

public class Ex10_Synchronized {
    public static void main(String[] args) {
        Shared sh=new Shared();
        CustomThread t1=new CustomThread(sh,"one");
        CustomThread1 t2=new CustomThread1(sh,"two");
    }
}