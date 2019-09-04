package PF01.Demos;

import java.util.Scanner;

public class Demo12_IfStatement2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int score;
        int ratings;

        System.out.print("Enter your exam result (0 to 100 points): ");
        score = scan.nextInt();
        ratings = score / 10;

        if (ratings > 7){
            System.out.println("Your rate is: Excellent ");
        } else if (ratings < 5){
            System.out.println("Your rate is: Fail");
        } else{
            System.out.println("Your rate is: Past");
        }
    }
}
