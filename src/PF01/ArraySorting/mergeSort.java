package PF01.ArraySorting;

import java.util.Random;
import java.util.Scanner;

public class mergeSort {

    private void merge(int[] arrayToMerge, int start, int middle, int end) {

        // Prepare two half-arrays
        int sizeF = middle - start + 1;
        int[] tempF = new int[sizeF];
        System.arraycopy(arrayToMerge, start, tempF, 0, sizeF);

        int sizeS = end - middle;
        int[] tempS = new int[sizeS];
        System.arraycopy(arrayToMerge, middle + 1, tempS, 0, sizeS);

        // Sort both into start array
        int indexF = 0, indexS = 0, index = start;
        while (indexF < sizeF && indexS < sizeS) {
            if (tempF[indexF] <= tempS[indexS]) {
                arrayToMerge[index] = tempF[indexF];
                indexF++;
            } else {
                arrayToMerge[index] = tempS[indexS];
                indexS++;
            }
            index++;
        }

        // Remaining part into start array
        while (indexF < sizeF) {
            arrayToMerge[index] = tempF[indexF];
            indexF++;
            index++;
        }
        while (indexS < sizeS) {
            arrayToMerge[index] = tempS[indexS];
            indexS++;
            index++;
        }
    }

    private void sort(int[] arrayToSort, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(arrayToSort, start, middle);
            sort(arrayToSort , middle + 1, end);

            // Merge sorted halves
            merge(arrayToSort, start, middle, end);
        }
    }

    private static void printArray(int[] arrayToPrint) {
        for (int value : arrayToPrint)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.print("How big array would you like to have: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1001);
        }

        System.out.println("Array in the beginning");
        printArray(array);

        mergeSort mS = new mergeSort();
        mS.sort(array, 0, array.length-1);

        System.out.println("Sorted array");
        printArray(array);
    }
}
