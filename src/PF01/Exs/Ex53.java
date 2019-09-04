package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex53 {
    /*
Write a Java program to test if an array contains a specific value.
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

        for (int number : numbers) {
            numbers[number] = random.nextInt(length) + 1;
            if (numbers[number] == value) {
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Value found");
        } else {
            System.out.println("Value not found");
        }
    }
}
