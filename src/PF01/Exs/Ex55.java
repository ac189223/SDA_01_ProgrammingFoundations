package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex55 {
    /*
Write a Java program to remove a specific element from an array.
Remove means exchange to zero.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How long array do you want (integer): ");
        int length = scanner.nextInt();
        int[] numbers = new int[length];

        System.out.print("Enter the value that you are looking for: ");
        int value = scanner.nextInt();
        boolean check = false;
        int position = length;

        for (int i = 1; i <numbers.length; i++) {
            numbers[i] = random.nextInt(length) + 1;
            if (numbers[i] == value) {
                check = true;
                numbers[i] = 0;
            }
        }

        if (check) {
            System.out.println("Value found and removed (exchanged to zero)");
        } else {
            System.out.println("Value not found");
        }
    }
}
