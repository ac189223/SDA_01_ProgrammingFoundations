package PF03.BlueJ.Auction;

import java.util.Random;
import java.util.stream.IntStream;

public class Test {
    private static Test test = new Test();
    private Auction auction = new Auction();

    public static void main(String[] args) {
        test.auction.enterLot("painting");
        test.auction.enterLot("sofa");
        test.auction.enterLot("bed");
        test.auction.enterLot("table");
        Person bidder1 = new Person("Phil");
        Person bidder2 = new Person("Alice");
        test.auction.getLots()
                .forEach(lot -> System.out.println(lot.getNumber() +
                        " - " + lot.getDescription() +
                        " - " + lot.getHighestBid()));
        Random r = new Random();
        IntStream.range(0, 20).forEach(i -> {
            if (i % 2 == 0)
                test.auction.makeABid(r.nextInt(4) + 1, bidder1, (r.nextInt(10) + 1 + i) * 100);
            else
                test.auction.makeABid(r.nextInt(4) + 1, bidder2, (r.nextInt(10) + 1 + i) * 100);
        });
        test.auction.getLots().stream()
                .filter(lot -> lot.getHighestBid() != null)
                .forEach(lot -> System.out.println(lot.getNumber() +
                        " - " + lot.getDescription() +
                        " - " + lot.getHighestBid().getValue() +
                        " - " + lot.getHighestBid().getBidder().getName()));
        test.auction.getLots().stream()
                .filter(lot -> lot.getHighestBid() == null)
                .forEach(lot -> System.out.println(lot.getNumber() +
                        " - " + lot.getDescription()));
    }
}
