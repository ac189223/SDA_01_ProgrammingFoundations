package PF01.Exs;

import java.util.Scanner;

public class Ex14 {
    /*
    Write a program that reads a name and prints the number of characters in the name.

Console Window:
Enter your first name: Anna
Anna; there are 4 characters in your first name
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println(firstName + ", there are " + firstName.length() + " characters in your first name");
    }
}
