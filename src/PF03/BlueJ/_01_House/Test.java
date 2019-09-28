package PF03.BlueJ._01_House;

import java.awt.*;

public class Test {
    private static Test test = new Test();
    private Picture picture = new Picture();

    public static void main(String[] args) {

        Canvas canvas = new Canvas("    =-_-=    ", 600, 250, Color.darkGray);
        canvas.setCanvasSingleton(canvas);

        test.picture.draw();
        canvas.wait(1000);
        test.picture.setBlackAndWhite();
        canvas.wait(1000);
        test.picture.setColor();
        canvas.wait(1000);
        System.exit(0);
    }
}
