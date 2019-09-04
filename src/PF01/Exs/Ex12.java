package PF01.Exs;

import java.util.Scanner;

public class Ex12 {
    /*
    Develop the exercise from above so the program also divides the input values. The program shall be able to
present the quotient as a decimal (use forecasting). You can assume that both the numerator and
denominator are positive and the numerator is greater than the denominator.

Below is an example of how your application should behave (inumics and bold = input value):
Console Window:
Enter a number: 9
Enter additional numbers: 2
9 + 2 = 11
9-2 = 7
9 * 2 = 18
9/2 = 4.5
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter additional number: ");
        int secondNum = scanner.nextInt();
        System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
        System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
        System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
        System.out.println(firstNum + " / " + secondNum + " = " + (double)firstNum / secondNum);
    }
}
