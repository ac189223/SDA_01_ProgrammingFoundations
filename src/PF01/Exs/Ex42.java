package PF01.Exs;

import java.util.Scanner;

public class Ex42 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        double average = 0;
        int numbers = 0;
        int num;

        System.out.print("Enter an integer: : ");
        num = scan.nextInt();

        while (num != 0){
            sum += num;
            numbers++;
            System.out.print ("Enter a new integer: : ");
            num = scan.nextInt();
        }
        if (numbers != 0)
            average = sum / numbers;
        System.out.println ("Average: " + average );

    }

}