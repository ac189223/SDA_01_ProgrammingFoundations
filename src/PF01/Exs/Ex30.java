package PF01.Exs;

import java.util.Scanner;

public class Ex30 {
    /*
    Write a program that calculate and print the following, depending on the age of the person:
Years left to retirement
Number of years the person has been retired
If the person has been retired this year

You can assume that the retirement age is 65 years.
Below are three examples of what your program should return depending on input value:

Example 1:
Enter your age: 45                  You retire if: 20 years

Example 2:
Enter your age: 75                  You have been retired in: 10 years

Example 3:
Enter your age: 65                  Congratulations, you were retired this year !!!
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int currentAge = scanner.nextInt();
        if (currentAge > 65) {
            System.out.println("You have been retired " + (currentAge - 65) + " years ago");
        } else if (currentAge == 65) {
            System.out.println("Congratulations, you were retired this year !!!");
        } else {
            System.out.println("You retire in: " + (65 - currentAge) + " years");
        }
    }
}
