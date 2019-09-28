package PF03.BlueJ._01_FiguresWar;

import java.awt.*;
import java.util.Random;

public class Test {
    private static Test test = new Test();
    private boolean caught = false;
    private Circle winner;
    private Random random = new Random();

    public static void main(String[] args) {

        Canvas canvas = new Canvas("    =-_-=    ", 600, 250, Color.darkGray);
        canvas.setCanvasSingleton(canvas);

        Circle blue = test.blueStarter(canvas);
        Circle redFighter = test.redAppears(canvas);
        Circle yellowRunner = test.yellowAppears(canvas);
        while (!test.caught) {
            test.moveRedFighter(canvas, redFighter, yellowRunner);
            test.check(redFighter, yellowRunner);
            if (!test.caught) {
                test.moveYellowRunner(canvas, yellowRunner);
                test.check(yellowRunner, redFighter);
            }
        }
        canvas.wait(1000);
        redFighter.makeInvisible();
        yellowRunner.makeInvisible();
        test.closure(canvas, blue);
        System.exit(0);
    }

    private Circle blueStarter(Canvas canvas) {
        Circle blue = new Circle();
        blue.makeVisible();
        canvas.wait(1000);
        canvas.erase(blue);
        canvas.wait(1000);
        blue.makeVisible();
        canvas.wait(200);
        for (int i = 0; i < 2; i++) {
            blue.moveHorizontal(100);
            blue.slowMoveHorizontal(-100);
            blue.moveHorizontal(-100);
            blue.slowMoveHorizontal(100);
        }
        blue.changeSize(30);
        canvas.wait(1000);
        blue.changeSize(10);
        canvas.wait(500);
        canvas.erase(blue);
        return blue;
    }

    private Circle redAppears(Canvas canvas) {
        Circle redFighter = new Circle(canvas.getWidth() / 4, canvas.getHeight() / 2, 10, "red");
        redFighter.makeVisible();
        return redFighter;
    }

    private Circle yellowAppears(Canvas canvas) {
        Circle yellowRunner = new Circle(3 * canvas.getWidth() / 4, canvas.getHeight() / 2, 10, "yellow");
        yellowRunner.makeVisible();
        return yellowRunner;
    }

    private void moveRedFighter(Canvas canvas, Circle redFighter, Circle yellowRunner) {
        if (redFighter.getXMiddle() - yellowRunner.getXMiddle() > 0)
            redFighter.slowMoveHorizontal(-2);
        else
            redFighter.slowMoveHorizontal(2);
        if (redFighter.getYMiddle() - yellowRunner.getYMiddle() > 0)
            redFighter.slowMoveVertical(-2);
        else
            redFighter.slowMoveVertical(2);
    }

    private void moveYellowRunner(Canvas canvas, Circle yellowRunner) {
        int xMove = random.nextInt(2);
        int yMove = random.nextInt(2);
        int speed = random.nextInt(15);
        if (xMove == 0)
            yellowRunner.slowMoveHorizontal(speed);
        else
            yellowRunner.slowMoveHorizontal(-speed);
        if (yMove == 0)
            yellowRunner.slowMoveVertical(speed);
        else
            yellowRunner.slowMoveVertical(-speed);
    }

    private void check(Circle ifWinner, Circle ifLooser) {
        if (distance(ifWinner, ifLooser) < ifWinner.getRadius() + ifLooser.getRadius()) {
            caught = true;
            winner = ifWinner;
        }
    }

    private double distance(Circle ifWinner, Circle ifLooser) {
        return squareRoot(square(ifWinner.getXMiddle() - ifLooser.getXMiddle()) + square(ifWinner.getYMiddle() - ifLooser.getYMiddle()));
    }

    private double square(double number) { return number * number; }

    private double squareRoot(double number) {
        double squareRoot = 0;
        double startValue = 0;
        double endValue = number;
        double precision = 0.00001;

        if (number < 0)
            squareRoot = -1;
        else if (number == 0 || number == 1)
            squareRoot = number;
        else {
            // we will use binary search to narrow down.
            while (endValue - startValue > precision) {
                double midValue = (startValue + endValue) / 2;
                squareRoot = midValue * midValue;

                if (squareRoot == number)
                    return squareRoot;
                else if (squareRoot > number)
                    endValue = midValue;
                else
                    startValue = midValue;
            }
            // if a match is not found
            squareRoot = (startValue + endValue) / 2;
        }
        return squareRoot;
    }

    private void closure(Canvas canvas, Circle blue) {
        blue.changeColor(winner.getColor());
        blue.makeVisible();
        canvas.wait(500);
        blue.changeSize(30);
        canvas.wait(500);
        blue.changeSize(60);
        canvas.wait(500);
        blue.changeSize(90);
        canvas.wait(500);
        blue.changeSize(120);
        blue.slowChangeSize(0);
        canvas.erase(blue);
    }
}
