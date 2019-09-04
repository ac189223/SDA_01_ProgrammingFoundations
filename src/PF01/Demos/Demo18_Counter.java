package PF01.Demos;

import java.util.Scanner;

public class Demo18_Counter {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        int sum = 0;
        int number;

        System.out.print ("Enter an integer: ");
        number = scan.nextInt ();
        for (int index = 1; index <= number; index ++) {
            sum = sum + index;
        }
        System.out.println ("1 + 2 + 3 + ... " + number + " = " + sum);
    }
}
