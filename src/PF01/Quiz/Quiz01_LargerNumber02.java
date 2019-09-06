package PF01.Quiz;

import java.util.Scanner;

public class Quiz01_LargerNumber02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int secondNum = scanner.nextInt();
        if (firstNum > secondNum)
            System.out.println(firstNum + " is greater than " + secondNum);
        else if (secondNum > firstNum)
            System.out.println(secondNum + " is greater than " + firstNum);
        else
            System.out.println("The numbers are equal");
    }
}