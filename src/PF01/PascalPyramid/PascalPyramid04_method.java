package PF01.PascalPyramid;

import java.util.Scanner;

public class PascalPyramid04_method {

    private static int pascalTriangle(int row, int position) {
        if(position <= 1 || position >= row) return 1;
        return pascalTriangle(row - 1, position - 1) + pascalTriangle(row - 1, position);
    }

    public static void main(String[] args) {
        System.out.print("How many rows do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowsToHave = scanner.nextInt();

        for (int row = 1; row <= rowsToHave; row++) {
            for (int position = 1; position <= row; position++) {
                System.out.print(pascalTriangle(row, position) + " ");
            }
            System.out.println();
        }
    }
}
