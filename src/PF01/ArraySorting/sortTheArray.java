package PF01.ArraySorting;

import java.util.Random;
import java.util.Scanner;

public class sortTheArray {
    private static int[] arrayToSort;

    private static void changePosition(int[] arrayToSort, int i, int j) {
        int temp = arrayToSort[i];
        for (int position = i; position > j; position--)
            arrayToSort[position] = arrayToSort[position - 1];
        arrayToSort[j] = temp;
    }

    public static void main(String[] args) {

        System.out.print("How big array would you like to have: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        arrayToSort = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayToSort[i] = random.nextInt(1001);
        }

        for (int i = 1; i < size; i++)
            for (int j = 0; j < i; j++)
                if (arrayToSort[i] <= arrayToSort[j])
                    changePosition(arrayToSort, i, j);

        for (int i : arrayToSort) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
