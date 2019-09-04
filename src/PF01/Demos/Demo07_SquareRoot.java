package PF01.Demos;

import java.util.Scanner;

public class Demo07_SquareRoot {
    public static void main (String[ ] args){
        double number;
        double squareRoot;

        Scanner scan = new Scanner (System.in);
        System.out.print ("Enter a number: ");

        number = scan.nextDouble();
        squareRoot = Math.sqrt(number); //Static method (no object!)
        System.out.println ("The square root is: " + squareRoot);
    }
}
