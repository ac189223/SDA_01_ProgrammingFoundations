package PF01.Exs;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex20 {
    /*
    Write a program that calculates the price per square meter for an apartment. The program will read the
apartment owner's name, apartment size and monthly rent. The program then:
• calculate the price per square meter per month.
• change the name to uppercase.
• print the name and the price per square meter (per month) in SEK (kr) (use the class Number Format).

Console Window:
Enter your name: magnus
Enter your monthly rent: 3550
Enter the apartment size in square meters: 45
MAGNUS you pay 78.89 kr per square meter per month.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your monthly rent: ");
        double monthlyRent = scanner.nextDouble();
        System.out.println("Enter the apartment size in square meters: ");
        double size = scanner.nextDouble();

        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        String rentPerSquareMeter = decimalFormat.format( monthlyRent / size);
        name = name.toUpperCase();
        System.out.println(name + " you pay " + rentPerSquareMeter + " kr per square meter per month.");

    }

}
