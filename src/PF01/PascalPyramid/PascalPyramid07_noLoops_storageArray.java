package PF01.PascalPyramid;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalPyramid07_noLoops_storageArray {
    private static PascalPyramid07_noLoops_storageArray pyramid = new PascalPyramid07_noLoops_storageArray();
    private ArrayList<ArrayList<Integer>> storage = new ArrayList<>();

    private void pascalTriangle(int row, int position) {
        if (row == position)
            if (row > 1)
                pyramid.pascalTriangle(row -1, position -1);
        if (position > 1) {
            pyramid.pascalTriangle(row, position - 1);
            if (position < row)
                System.out.print(pyramid.countPascalNumber(row, position) + "  ");
            else
                System.out.println(1 + "  ");
        } else
            if (row == 1)
                System.out.println(1 + "  ");
            else
                System.out.print(1 + "  ");
    }

    private int countPascalNumber(int row, int position) {
        if (pyramid.storage.get(row - 1).get(position - 1) > 0) {
            return pyramid.storage.get(row - 1).get(position - 1);
        }
        else {
            if(position <= 1 || position >= row) {
                pyramid.storage.get(row - 1).add(1);
                return 1;
            }
            int pascalNumber = pyramid.countPascalNumber(row - 1, position - 1) + pyramid.countPascalNumber(row - 1, position);
            pyramid.storage.get(row - 1).add(pascalNumber);
            return pascalNumber;
        }
    }

    private void createStorage(int rowsToHave) {
        for (int i = 0; i < rowsToHave; i++) {
            pyramid.storage.add(new ArrayList<>());
            for (int j = 0; j <= i; j++)
                pyramid.storage.get(i).add(0);
        }
    }

    public static void main(String[] args) {
        System.out.print("How many rows do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowsToHave = scanner.nextInt();
        pyramid.createStorage(rowsToHave);
        pyramid.pascalTriangle(rowsToHave, rowsToHave);
    }
}
