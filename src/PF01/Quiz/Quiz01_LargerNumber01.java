package PF01.Quiz;

import java.util.Scanner;

public class Quiz01_LargerNumber01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNum = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the number: ");
            num = scanner.nextInt();
            if (num > maxNum)
                maxNum = num;
        }
        System.out.println("The largest number is " + maxNum);
    }
}