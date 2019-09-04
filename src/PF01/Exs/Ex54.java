package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex54 {
    /*
Write a Java program to find the index of an array element.
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
                position = i;
                break;
            }
        }

        if (check) {
            System.out.println("Value found on position " + position);
        } else {
            System.out.println("Value not found");
        }
    }
}
