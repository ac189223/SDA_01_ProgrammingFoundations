package PF01.Exs;

import java.util.Scanner;

public class Ex47 {
    /*
    Write a program that reads five numbers and prints the smallest and the largest number.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System will ask for five numbers.");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int scannedNumber;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            scannedNumber = scanner.nextInt();
            if (scannedNumber > max) max = scannedNumber;
            if (scannedNumber < min) min = scannedNumber;
        }
        System.out.println("The largest number is " + max);
        System.out.println("The smallest number is " + min);
    }
}
