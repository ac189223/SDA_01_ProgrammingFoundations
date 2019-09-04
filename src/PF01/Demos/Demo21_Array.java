package PF01.Demos;

import java.util.Scanner;

public class Demo21_Array {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int sum = 0;
        int[] list = new int[5];

        System.out.println("Enter five numbers: ");

        for (int i = 0; i < 5; i ++){
            System.out.print("Enter a number " + (i + 1) + ": ");
            num = scan.nextInt();
            list[i] = num;
        }
        for (int i = 0; i < 5; i ++){
            sum += list[i];
        }

        System.out.println("The total is: " + sum);
    }
}
