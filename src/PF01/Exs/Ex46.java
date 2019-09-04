package PF01.Exs;

import java.util.Scanner;

public class Ex46 {
    /*
    Write a program that reads five numbers and prints out the larger of the given numbers.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System will ask for five numbers.");
        int max = Integer.MIN_VALUE;
        int scannedNumber;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            scannedNumber = scanner.nextInt();
            if (scannedNumber > max) max = scannedNumber;
        }
        System.out.println(max);
    }
}
