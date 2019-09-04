package PF01.Exs;

import java.util.Scanner;

public class Ex49 {
    /*
    Write a program that reads a text string using the Scanner class.
The program writes then the number of times the letter 'a’ appears in the loaded text string.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter line of text to investigate: ");
        String textLine = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < textLine.length(); i++) {
            if (textLine.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("The letter \"a\" appears " + count + " times.");
    }
}
