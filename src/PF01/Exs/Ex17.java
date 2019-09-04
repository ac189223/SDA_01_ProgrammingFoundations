package PF01.Exs;

import java.util.Random;

public class Ex17 {
    /*
    Use the Random class and write a program that creates a three-digit random number of the data type int.
     */

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i < 21; i++) {
            System.out.println(random.nextInt(900) + 100);
        }
    }
}
