package PF03.Random.BouncingBoxes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawGraphics {
    private BouncingBox box1;
    private BouncingBox box2;
    private BouncingBox box3;
    private BouncingBox box4;
    private BouncingBox box5;
    private BouncingBox box6;
    private ArrayList<BouncingBox> boxes;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box1 = new BouncingBox(200, 50, Color.RED);
        box2 = new BouncingBox(10, 100, Color.GREEN);
        box3 = new BouncingBox(10, 100, Color.BLUE);
        box4 = new BouncingBox(10, 100, Color.BLACK);
        box5 = new BouncingBox(200, 50, Color.CYAN);
        box6 = new BouncingBox(200, 50, Color.PINK);

        boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);
        boxes.add(box5);
        boxes.add(box6);

        for (BouncingBox box : boxes) {
            Random rand = new Random();
            box.setMovementVector(rand.nextInt(10) - 5,rand.nextInt(6) - 3);
        }
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        for (BouncingBox box : boxes) {
            box.draw(surface);
        }
    }
}