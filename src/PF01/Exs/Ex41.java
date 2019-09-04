package PF01.Exs;

import java.util.Scanner;

public class Ex41 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        double average = 0;
        int numbers = 0;
        int num;

        System.out.print("Enter an integer: ");
        num = scan.nextInt();

        while (num!= 0){
            System.out.print ("Enter a new integer: ");
            num = scan.nextInt();
            sum += num;
            numbers++;
        }
        if (numbers != 0) {
            average = sum / numbers;
        }
        System.out.println ("Average: " + average );
    }
}
