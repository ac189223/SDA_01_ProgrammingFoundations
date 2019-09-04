package PF01.Demos;

import java.util.Scanner;

public class Demo17_Counter {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int tal;
        int max = 0;

        System.out.print("Skriv in ett heltal: ");
        tal = scan.nextInt();

        if (tal != 0) {
            do {
                if (tal > max) {
                    max = tal;
                }
                System.out.print("Skriv in ett heltal: ");
                tal = scan.nextInt();
            } while (tal > 0);
            System.out.println("Största talet är: " + max);
        } else {
            System.out.println("Inget tal inläst");
        }
    }
}
