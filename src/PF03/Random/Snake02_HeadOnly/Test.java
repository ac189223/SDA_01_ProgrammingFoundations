package PF03.Random.Snake02_HeadOnly;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    private static Test test = new Test();
    private Circle blue;
    private boolean hasTarget = false;
    private boolean onTarget = false;
    private Circle headOfSnake;
    private ArrayList<Circle> snake = new ArrayList<>();
    private Circle targetCircle;
    private boolean alive = true;
    private Random random = new Random();

    public static void main(String[] args) {

        Canvas canvas = new Canvas("    =-_-=    ", 600, 600, Color.darkGray);
        canvas.setCanvasSingleton(canvas);

        test.blueStarter(canvas);
        test.headAppears(canvas);
        while (test.alive) {
            if (!test.hasTarget)
                test.setTarget(canvas);
            test.moveSnake(canvas);
        }
        test.closure(canvas);
        System.exit(0);
    }

    private Circle blueStarter(Canvas canvas) {
        blue = new Circle();
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

    private Circle headAppears(Canvas canvas) {
        headOfSnake = new Circle(canvas.getWidth() / 4, canvas.getHeight() / 4, 8, "red");
        snake.add(headOfSnake);
        headOfSnake.makeVisible();
        return headOfSnake;
    }

    private void setTarget(Canvas canvas) {
        boolean check = false;
        while (!check) {
            targetCircle = new Circle(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()), 8, "green");
            for (Circle fromSnake: snake)
                if (!checkDistance(fromSnake, targetCircle)) {
                    check = false;
                    break;
                } else
                    check = true;
        }
        targetCircle.makeVisible();
        hasTarget = true;
    }

    private boolean checkDistance(Circle circle1, Circle circle2) {
        if (distance(circle1, circle2) < circle1.getDiameter() / 2 + circle2.getDiameter() / 2 - 2)
            return false;
        return true;
    }

    private double distance(Circle circle1, Circle circle2) {
        return squareRoot(square(circle1.getxPosition() - circle2.getxPosition()) +
                square(circle1.getyPosition() - circle2.getyPosition()));
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

    private void moveSnake(Canvas canvas) {
        if (canvas.getHorizontal() != 0)
            moveSnakeHorizontal(canvas.getHorizontal());
        else
            moveSnakeVertical(canvas.getVertical());
        if (snakeOnTarget())
            eatTarget();
        if (hitTheWall(canvas)) { //|| biteHimself()) {
            alive = false;
            targetCircle.makeInvisible();
            snake.forEach(circle -> circle.makeInvisible());
        }
    }

    private void moveSnakeHorizontal(int step) {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setxPosition(snake.get(i - 1).getxPosition());
            snake.get(i).setyPosition(snake.get(i - 1).getyPosition());
        }
        headOfSnake.moveHorizontal(step);
    }

    private void moveSnakeVertical(int step) {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setxPosition(snake.get(i - 1).getxPosition());
            snake.get(i).setyPosition(snake.get(i - 1).getyPosition());
        }
        headOfSnake.moveVertical(step);
    }

    private boolean snakeOnTarget() {
        return !checkDistance(headOfSnake, targetCircle);
    }

    private void eatTarget() {
        Circle tempC = snake.get(snake.size() - 1);
        snake.add(new Circle(tempC.getxPosition(), tempC.getyPosition(), tempC.getDiameter(), "blue"));
        snake.get(snake.size() - 1).setVisible(true);
        for (int i = snake.size() - 2; i > 0; i--) {
            snake.get(i).setxPosition(snake.get(i - 1).getxPosition());
            snake.get(i).setyPosition(snake.get(i - 1).getyPosition());
        }
        targetCircle.makeInvisible();
        headOfSnake.setxPosition(targetCircle.getxPosition());
        headOfSnake.setyPosition(targetCircle.getyPosition());
        hasTarget = false;
    }

    private boolean hitTheWall(Canvas canvas) {
        return headOfSnake.getxPosition() <= 0 || headOfSnake.getyPosition() <= 0 ||
                headOfSnake.getxPosition() + headOfSnake.getDiameter() >= canvas.getWidth() ||
                headOfSnake.getyPosition() + headOfSnake.getDiameter() >= canvas.getHeight();
    }

    private boolean biteHimself() {
        for (int i = 1; i < snake.size(); i++)
            if (!checkDistance(snake.get(i), headOfSnake))
                return true;
        return false;
    }

    private void closure(Canvas canvas) {
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
