package PF01.Demos;

import java.util.Scanner;

public class Demo13_Guess {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);

        int rightNumber = 4;
        int guessedNumber;

        System.out.print ("Guess a number between 1 and 10: ");
        guessedNumber = scan.nextInt();

        if (rightNumber == guessedNumber)
            System.out.println ("GOOD, RIGHT NUMBER !!!");
        else {
            System.out.println ("Your answer was wrong.");
            System.out.println ("The correct number was: " + rightNumber);
        }
    }
}
