package PF01.Demos;

import java.util.Scanner;

public class Demo15_Counter {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        int sum = 0;
        int number;
        int index = 1;

        System.out.print ("Enter an integer: ");
        number = scan.nextInt ();

        while (index <= number) {
            sum += index; // sum = sum + index
            index ++; // index = index + 1;
        }
        System.out.println ("1 + 2 + 3 + ... " + number + " = " + sum);
    }
}
