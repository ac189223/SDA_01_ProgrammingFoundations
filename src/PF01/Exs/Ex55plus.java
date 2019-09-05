package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex55plus {
    /*
Write a Java program to remove a specific element from an array.
     */
    static int[] numbers;
    static int times;

    private static void remove(int i) {
        for (int position = i; position < numbers.length - times; position++)
            numbers[position] = numbers[position + 1];
        numbers[numbers.length - times] = 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How long array do you want (integer): ");
        int length = scanner.nextInt();
        numbers = new int[length];

        System.out.print("Enter the value that you are looking for: ");
        int value = scanner.nextInt();
        boolean check = false;
        int position = length;

        for (int i = 1; i <numbers.length; i++) {
            numbers[i] = random.nextInt(length) + 1;
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

        for (int i = 1; i <numbers.length; i++) {
            if (numbers[i] == value) {
                check = true;
                times++;
                remove(i);
            }
        }

        if (check) {
            System.out.println("Value found " + times + " times and removed (see below)");
            for (int i = 1; i <numbers.length; i++) {
                System.out.print(numbers[i] + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Value not found");
        }
    }
}
