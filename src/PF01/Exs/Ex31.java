package PF01.Exs;

import java.util.Scanner;

public class Ex31 {
    /*
    Write a program that takes two integers and prints out the largest number

Enter the first number: 88
Enter the second number: 53
88 is greater than 53

Enter the first number: 10
Enter the second number: 10
The numbers are equal
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " is greater than " + secondNumber);
        } else if (secondNumber > firstNumber) {
            System.out.println(secondNumber + " is greater than " + firstNumber);
        } else {
            System.out.println("The numbers are equal");
        }



    }

}
