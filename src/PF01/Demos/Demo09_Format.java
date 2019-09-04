package PF01.Demos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Demo09_Format {
    public static void main(String[] args){
        double num1 =310;
        double num2 = 3;
        Scanner scan = new Scanner (System.in);
        DecimalFormat fmt1 = new DecimalFormat("0.###");

        System.out.print("Enter a number: ");
        num1 = scan.nextDouble();

        System.out.print("Enter additional numbers: ");
        num2 = scan.nextDouble();

        System.out.println(num1 +"/" + num2 + " = " + (num1/num2));
        System.out.println();
        System.out.println("With the class DecimalFormat");
        System.out.println(num1 +"/" + num2 + " = " + fmt1.format(num1/num2));
    }
}
