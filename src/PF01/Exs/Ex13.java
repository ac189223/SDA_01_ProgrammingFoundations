package PF01.Exs;

import java.util.Scanner;

public class Ex13 {
    /*
Write a program that asks for first and last names. The program will then concatenate the names together
and put a comma between the first and last name.

Below is an example of how your application should behave:
Console Window:
Enter your first name: Magnus
Enter your last name: Wärja
Magnus, Wärja
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println(firstName + ", " + lastName);
    }

}
