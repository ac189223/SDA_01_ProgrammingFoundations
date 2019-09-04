package PF01.Demos;

import java.text.NumberFormat;
import java.util.Scanner;

public class Demo08_Formatering {
    public static void main(String[] args){
        double discount = 0.25;
        int quantity;
        double price;

        Scanner scan = new Scanner (System.in);
        NumberFormat percent = NumberFormat.getPercentInstance();

        System.out.print("Enter quantity: ");
        quantity = scan.nextInt();

        System.out.print("Enter price: ");
        price = scan.nextDouble();

        System.out.println("Total price: " + (quantity * price));
        System.out.println("Total price with " + percent.format(discount) +
                " discount are: " + (quantity * price) * (1-discount));
    }
}
