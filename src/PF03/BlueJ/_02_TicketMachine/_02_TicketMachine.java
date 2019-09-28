package PF03.BlueJ._02_TicketMachine;

import java.util.Random;
import java.util.stream.IntStream;

public class _02_TicketMachine {
    private static _02_TicketMachine test;
    private int price;
    private int moneyEntered;
    private int moneyInsideMachine;
    private static int ticketsToPrint = 0;

    public _02_TicketMachine(int cost) {
        price = cost;
        moneyEntered = 0;
        moneyInsideMachine = 0;
    }

    public int getPrice() { return price; }
    public int getMoneyEntered() { return moneyEntered; }
    public void insertMoney(int amount) {
        moneyEntered = moneyEntered + amount;
        if (moneyEntered >= price) {
            canAffordTicket();
        }
    }

    private void canAffordTicket() {
        moneyInsideMachine += price;
        moneyEntered -= price;
        ticketsToPrint++;
    }

    public void printTicket() {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();
    }

    public static void main(String[] args) {
    Random random = new Random();
    test = new _02_TicketMachine((random.nextInt(9) + 1) * 10);
    IntStream.range(0, 15)
            .forEach(i -> test.insertMoney(random.nextInt(50)));
    IntStream.range(0, ticketsToPrint)
            .forEach(i -> test.printTicket());
    System.out.println("Printed " + ticketsToPrint + " tickets and there is " +
            test.moneyEntered + "cents change for you" +
            "\n There is " + test.moneyInsideMachine + "cents collected in the machine");
    }
}
