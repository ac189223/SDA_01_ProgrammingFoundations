package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex51 {
    /*
    Write a Java program to sum values of an array.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How long array do you want (integer): ");
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        int sum = 0;

        for (int number : numbers) {
            numbers[number] = random.nextInt(length) + 1;
            System.out.println(numbers[number]);
            sum += numbers[number];
        }

        System.out.println("The total is: " + sum);
    }
}
