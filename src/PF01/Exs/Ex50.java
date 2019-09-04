package PF01.Exs;

import java.util.Scanner;

public class Ex50 {
    /*
    Write a program that reads a name using the Scanner class.
The program writes then every other character in the name beginning with the first letter.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter line of text to investigate: ");
        String textLine = scanner.nextLine();
        String otherTextLine = "";
        for (int i = 0; i < textLine.length(); i++) {
            otherTextLine += textLine.charAt(i);
            i++;
        }
        System.out.println("Text made from every other letter of your string is: " + otherTextLine + ".");
    }
}
