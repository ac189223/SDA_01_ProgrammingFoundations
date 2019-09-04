package PF01.Exs;

import java.util.Scanner;

public class Ex15 {
    /*
    Write a program to replace all the "m" in a text string to the "x" and then writes out the string again.
Below is an example of how your application should behave (inumics and bold = input value):

Console Window:
Enter a text: Summer is here!
Suxxer is here!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String textLine = scanner.nextLine();
        System.out.println(textLine.replace('m','x').replace('M', 'X'));
    }
}
