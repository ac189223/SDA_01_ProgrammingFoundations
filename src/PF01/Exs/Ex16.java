package PF01.Exs;

import java.util.Scanner;

public class Ex16 {
    /*
    Write a program that reads two text strings, concatenate them together with a space between them and
calculates the new string's length. The concatenated string and its length have to be printed on the screen.

Console Window:
Type a word: Summer
Write one more word: time
Summer time
11
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a word: ");
        String firstText = scanner.nextLine();
        System.out.print("Write one more word: ");
        String lastText = scanner.nextLine();
        String text = firstText + " " + lastText;
        System.out.println(text);
        System.out.println(text.length());
    }
}
