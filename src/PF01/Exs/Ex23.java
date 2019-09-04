package PF01.Exs;

import java.util.Random;
import java.util.Scanner;

public class Ex23 {
    /*
    Create a program that shows how two players throw dice (one each). At the presentation of the players'
results must the first letter of player names to be uppercase and the rest lowercase.

Below is an example of how your application should behave (inumics and bold = input value):
Console Window:
Name of player 11: MAGNUS
Name of player 2: eva
Magnus you got 3 points.
Eva, you got 2 points.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of player 1: ");
        String name1 = scanner.nextLine();
        System.out.print("Name of player 2: ");
        String name2 = scanner.nextLine();

        name1 = name1.substring(0, 1).toUpperCase() + name1.substring(1).toLowerCase();
        name2 = name2.substring(0, 1).toUpperCase() + name2.substring(1).toLowerCase();

        Random random = new Random();
        System.out.println(name1 + " you got " + (random.nextInt(6) + 1) + " points.");
        System.out.println(name2 + " you got " + (random.nextInt(6) + 1) + " points.");
    }
}
