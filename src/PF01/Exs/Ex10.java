package PF01.Exs;

import java.util.Scanner;

public class Ex10 {
    /*
    Write a program that calculate how many years a person has left to retirement. You can assume that the
retirement age is 65 and that the person is not a retiree. Below is an example of how your application should
behave (bold = input value):

Console Window:
Enter your age: 45
You retire in: 20 years
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int currentAge = scanner.nextInt();
        if (currentAge >= 65) {
            System.out.println("You are already retired");
        } else if (currentAge <= 0) {
            System.out.println("You are not alive");
        } else {
            System.out.println("You retire in: " + (65 - currentAge) + " years");
        }
    }
}
