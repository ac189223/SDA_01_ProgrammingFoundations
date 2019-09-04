package PF01.PascalPyramid;

import java.util.ArrayList;
import java.util.Scanner;

public class pascalPyramid02 {
    public static void main(String[] args) {
        ArrayList<Integer> pyramid = new ArrayList<>();
        pyramid.add(1);
        System.out.print("Which row do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowToHave = scanner.nextInt();
        for (int row = 2; row <= rowToHave; row++) {
            int[] temp = new int[row - 1];
            for (int i = 0; i < pyramid.size(); i++) temp[i] = pyramid.get(i);
            for (int i = 2; i < row; i++) {
                pyramid.set(i - 1, temp[i - 2] + temp[i - 1]);
            }
            pyramid.add(1);
        }
        System.out.println(pyramid);
    }
}
