package PF01.Exs;

import java.util.Scanner;

public class Ex48 {
    /*
    Write a program that reads a series of optional numbers.
After that it prints the minimum and the maximum of the given numbers. The process should be stopped by
the number zero. If the first number is zero, the text shall be printed "No numbers loaded"
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System will ask for numbers. For stop the process enter \"0\".");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int scannedNumber;
        while (true) {
            System.out.print("Enter a number: ");
            scannedNumber = scanner.nextInt();
            if (scannedNumber == 0) break;
            if (scannedNumber > max) max = scannedNumber;
            if (scannedNumber < min) min = scannedNumber;
        }
        if (max == Integer.MIN_VALUE) {
            System.out.println("No numbers loaded");
        } else {
            System.out.println("The largest number is " + max);
            System.out.println("The smallest number is " + min);
        }
    }
}
