package PF01.Demos;

import java.util.Scanner;

public class Demo11_IfStatement {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        double hourlySalary = 100;
        int hours;
        double payment;

        System.out.print("Enter the weekly hours worked: ");
        hours = scan.nextInt();

        if (hours > 40) {
            payment = 40 * hourlySalary + (hours - 40) * (hourlySalary * 1.5);
        } else {
            payment = hours * hourlySalary;
        }

        System.out.println("Weekly salary: " + payment + " SEK");
    }
}
