package PF01.Demos;

import java.util.Random;
import java.util.Scanner;

public class Demo19_TwentyOne {
    public static void main (String [] args) {
        Random random = new Random ();
        Scanner scan = new Scanner (System.in);
        int sum = 0;
        int result;
        boolean play = true;

        while (play) {
            sum += random.nextInt (6) + 1;
            System.out.println ("Total: " + sum);
            if (sum <=21) {
                System.out.println ("Throw (Yes = 0 No = 1): ");
                result = scan.nextInt ();
                if (result!= 0) {
                    play = false;
                }
            } else {
                play = false;
            }
        }
        System.out.println ("Result: " + sum);
    }
}
