package PF01.Demos;

import java.util.Random;

public class Demo06_RandomNumbers {
    public static void main (String[] args){
        Random random = new Random();
        int number;

        number = random.nextInt();
        System.out.println ("A random number (integer): " + number);

        number = random.nextInt(7);
        System.out.println ("From 0 to 6: " + number);

        number = random.nextInt(6) + 1;

        System.out.println ("From 1 from 6: " + number);

        number = random.nextInt(20) - 10;
        System.out.println ("From -10 till 9: " + number);
    }
}
