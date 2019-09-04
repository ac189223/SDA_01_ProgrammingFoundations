package PF01.Exs;

public class Ex43 {
    /*
        Write a program that prints all the odd numbers from 1 to 99 (use a for loop).
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            if (i % 2 == 1) System.out.println(i);
        }
    }
}
