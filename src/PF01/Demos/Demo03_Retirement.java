package PF01.Demos;

import java.util.Scanner;

public class Demo03_Retirement {
    public static void main(String[] args){
        int retirementAge = 65;
        int age = 38;
        int yearsToRetirement;

        Scanner scan = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = scan.nextLine();

        System.out.print("How old are you? ");
        age = scan.nextInt();

        name = name.toUpperCase();
        yearsToRetirement = retirementAge - age;
        System.out.println(name + ", you retire in: " + yearsToRetirement + " years!");
    }
}
