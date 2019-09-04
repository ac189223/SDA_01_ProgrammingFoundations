package PF01.Exs;

public class Ex44 {
    /*
    Write a program that computes the sum of all integers from 1 to 100 (use for loop).
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        System.out.println("Sum of integers from 1 to 100 is " + sum + ".");
    }
}
