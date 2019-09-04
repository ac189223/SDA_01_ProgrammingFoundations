package PF01.Demos;

public class Demo16_Operators {
    public static void main (String[] args){
        int a = 5;
        int b = 5;
        int c = 10;

        System.out.println(a++);
        System.out.println(++b);
        System.out.println(a);
        System.out.println(b);

        System.out.println(String.valueOf(c++) + String.valueOf(++c));

        System.out.println(c++ + ++c);
        System.out.println(c++);
        System.out.println(++c);
    }
}
