package PF01.Demos;

import java.util.Scanner;

public class Demo14_IfStatement3 {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        int result;

        System.out.print ("Enter your rate: ");
        result = scan.nextInt ();
        if (result> 0 && result <10) {
            if (result> 4 && result <= 7) {
                System.out.println ("Result = Past");
            } else if (result> 7) {
                System.out.println ("Result = Excellent ");
            } else {
                System.out.println ("Result = Fail");
            }
        } else {
            System.out.println("You have entered an incorrect value!");
        }
    }
}
