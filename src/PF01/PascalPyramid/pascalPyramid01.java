package PF01.PascalPyramid;

import java.util.ArrayList;
import java.util.Scanner;

public class pascalPyramid01 {
    public static void main(String[] args) {
        ArrayList<Integer> pyramid = new ArrayList<>();
        pyramid.add(1);
        System.out.print("Which row do you want to see: ");
        Scanner scanner = new Scanner(System.in);
        int rowToHave = scanner.nextInt();
        for (int row = 2; row <= rowToHave; row++) {
            for (int i = 2; i < row; i++) {
                pyramid.set(i - 1, pyramid.get(i - 2) + pyramid.get(i - 1));
                System.out.println(pyramid);
            }
            pyramid.add(1);
            System.out.println(pyramid);
        }
        System.out.println(pyramid);
    }
}
