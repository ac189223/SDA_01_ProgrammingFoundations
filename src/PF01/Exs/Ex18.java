package PF01.Exs;

import java.util.Random;

public class Ex18 {
    /*
    Create a simple program that randomizing a phone number in the following format; XXXX-XXXXXX.
     */

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i < 21; i++) {
            System.out.println((random.nextInt(9000) + 1000) + "-" + (random.nextInt(900000) + 100000));
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j <= 4; j++) System.out.print(random.nextInt(9));
            System.out.print("-");
            for (int j = 1; j <= 6; j++) System.out.print(random.nextInt(9));
            System.out.println("");
        }
    }
}
