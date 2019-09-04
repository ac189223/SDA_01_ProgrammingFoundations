package PF01.Exs;

import java.util.Scanner;

public class Ex11 {
    /*
    Write a program that reads in two integers and perform three calculations as below.
Console Window:
Enter a number: 20
Enter additional numbers: 5
20 + 5 = 25
20-5 = 15
20 * 5 = 100
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter additional number: ");
        int secondNum = scanner.nextInt();
        System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
        System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
        System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
    }
}
