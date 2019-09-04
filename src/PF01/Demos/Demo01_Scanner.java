package PF01.Demos;

import java.util.Scanner;

public class Demo01_Scanner {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        final int CURRENTYEAR = 2019;
        int yearOfBirth;
        int age;

        System.out.print("What year were you born? ");
        yearOfBirth = scan.nextInt(); //1985
        age = CURRENTYEAR - yearOfBirth;
        System.out.println("You are " + age + " years old!");
    }
}
