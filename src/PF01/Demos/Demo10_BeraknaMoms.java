package PF01.Demos;

import java.util.Scanner;

public class Demo10_BeraknaMoms {
    public static void main (String[ ] args){
        Scanner scan = new Scanner (System.in);
        String ssn;         //social Security Number
        int yearOfBirth;
        String result;

        System.out.print ("Enter your Social Security Number: ");
        ssn = scan.nextLine();
        ssn = ssn.substring(0, 2);
        yearOfBirth = Integer.parseInt(ssn);                    //String to int!
        result = Integer.toString(119 - yearOfBirth);         //int to String!
        System.out.println ("You are / were " + result + " years this year ");
    }
}
