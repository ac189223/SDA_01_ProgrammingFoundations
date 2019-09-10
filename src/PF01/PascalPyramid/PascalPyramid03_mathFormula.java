package PF01.PascalPyramid;

import java.util.Scanner;

public class PascalPyramid03_mathFormula {
    /*
                   ( n )       n!
            a(i) = (   ) =  ---------       -->       a(0) = n! / 0! * n! = 1
                   ( i )    i!*(n-i)!                 a(1) = n! / 1! * (n-1)! = a(0) * n = n
                                                      a(2) = n! / 2! * (n-2)! = a(1) * (n-1) / 2
                                                      ...
     */
    public static void main(String[] args) {
        int a, num;

        System.out.print("How many rows do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowsToHave = scanner.nextInt();

        for (int i = 0; i <= rowsToHave - 1; i++) {
            num = 1;
            a = i + 1;
            for (int j = 0; j <= i; j++) {
                if (j > 0) num = num * (a - j) / j;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
