package PF01.Exs;

import java.util.Scanner;

public class Ex45 {
    /*
Write a program using a while loop that prints the text "ALARM!" repeatedly at separate lines.
The user shall be able to specify the number of times the "ALARM" to be written out.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many times do you want to scream ? ");
        int numberOfRepetitions = scanner.nextInt();
        for (int i = 0; i < numberOfRepetitions; i++) {
            System.out.println("ALARM!");
        }
    }
}
