package PF01.PascalPyramid;

import java.util.Scanner;

public class PascalPyramid06_noLoops_all {

    private static void pascalTriangle(int row, int position) {
        if (row == position)
            if (row > 1)
                pascalTriangle(row -1, position -1);
        if (position > 1) {
            pascalTriangle(row, position - 1);
            if (position < row)
                System.out.print(countPascalNumber(row, position) + "  ");
            else
                System.out.println(1 + "  ");
        } else
            if (row == 1)
                System.out.println(1 + "  ");
            else
                System.out.print(1 + "  ");
    }

    private static int countPascalNumber(int row, int position) {
        if(position <= 1 || position >= row)
            return 1;
        return countPascalNumber(row - 1, position - 1) + countPascalNumber(row - 1, position);
    }

    public static void main(String[] args) {
        System.out.print("How many rows do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowsToHave = scanner.nextInt();
        pascalTriangle(rowsToHave, rowsToHave);
    }
}
