package PF01.Exs;

import java.util.Scanner;

public class Ex19 {
    /*
    Write a program that reads and calculates the square of a number. For example, four squared is equal to 16
(4 × 4 = 16). You should use the method pow in the Math class.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number (integer): ");
        int number = scanner.nextInt();
        System.out.println("Square of " + number + " is " + (int)Math.pow(number,2));
    }
}
