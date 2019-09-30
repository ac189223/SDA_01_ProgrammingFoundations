package PF03.Random.Snake03_SquareLoosingTail;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    private static Test test = new Test();
    private Circle blue;
    private boolean hasTarget = false;
    private ArrayList<Square> snake = new ArrayList<>();
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

    private void blueStarter(Canvas canvas) {
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
    }

    private void headAppears(Canvas canvas) {
        snake.add(new Square(canvas.getWidth() / 4, canvas.getHeight() / 4, 6, "red"));
        snake.get(0).makeVisible();
    }

    private void setTarget(Canvas canvas) {
        boolean check = false;
        while (!check) {
            targetCircle = new Circle(random.nextInt(canvas.getWidth()), random.nextInt(canvas.getHeight()), 10, "green");
            if (checkIfDistanceFromHeadIsOk())
                check = true;
        }
        targetCircle.makeVisible();
        hasTarget = true;
    }

    private boolean checkIfDistanceFromHeadIsOk() {
        return  //head on left far enough
                (snake.get(0).getxPosition() < targetCircle.getxPosition() &&
                        snake.get(0).getxPosition() + snake.get(0).getSize() < targetCircle.getxPosition()) ||
                //head on right far enough
                (snake.get(0).getxPosition() > targetCircle.getxPosition() &&
                        snake.get(0).getxPosition() > targetCircle.getxPosition() + targetCircle.getDiameter()) ||
                //head higher and far enough
                (snake.get(0).getyPosition() < targetCircle.getyPosition() &&
                        snake.get(0).getyPosition() + snake.get(0).getSize() < targetCircle.getyPosition()) ||
                //head lower and far enough
                (snake.get(0).getyPosition() > targetCircle.getyPosition() &&
                        snake.get(0).getyPosition() > targetCircle.getyPosition() + targetCircle.getDiameter());
    }


    private void moveSnake(Canvas canvas) {
        if (canvas.getHorizontal() != 0)
            moveSnakeHorizontal(canvas.getHorizontal());
        else
            moveSnakeVertical(canvas.getVertical());
        if (checkIfSnakeOnTarget())
            eatTarget();
        if (hitTheWall(canvas)) { //|| biteHimself()) {
            alive = false;
            targetCircle.makeInvisible();
            snake.forEach(Square::makeInvisible);
        }
    }

    private void moveSnakeHorizontal(int step) {
        moveSnakeBody();
        snake.get(0).moveHorizontal(step);
    }

    private void moveSnakeVertical(int step) {
        moveSnakeBody();
        snake.get(0).moveVertical(step);
    }

    private void moveSnakeBody() {
        for (int i = snake.size() - 1; i > 0; i--) {
            if (snake.get(i).getxPosition() == snake.get(i - 1).getxPosition()) {
                if (snake.get(i).getyPosition() < snake.get(i - 1).getyPosition())
                    snake.get(i).moveHorizontal(1);
                else
                    snake.get(i).moveHorizontal(-1);
            } else if (snake.get(i).getxPosition() < snake.get(i - 1).getxPosition()) {
                snake.get(i).moveVertical(1);
            } else {
                snake.get(i).moveVertical(-1);
            }
        }
    }

    private boolean checkIfSnakeOnTarget() {
        return !checkIfDistanceFromHeadIsOk();
    }

    private void eatTarget() {
        int size = snake.get(0).getSize();
        Square last = snake.get(snake.size() - 1);
        if (snake.size() > 1) {
            Square beforeLast = snake.get(snake.size() - 2);
            if (last.getxPosition() == beforeLast.getxPosition()) {
                if (last.getyPosition() < beforeLast.getyPosition())
                    snake.add(new Square(last.getxPosition(),last.getyPosition() - size, size, "blue"));
                else
                    snake.add(new Square(last.getxPosition(), last.getyPosition(), size, "blue"));
            } else if (last.getxPosition() < beforeLast.getxPosition()) {
                snake.add(new Square(last.getxPosition() - size, last.getyPosition(), size, "blue"));
            } else {
                snake.add(new Square(last.getxPosition() + size, last.getyPosition(), size, "blue"));
            }
        } else {
                snake.add(new Square(last.getxPosition() - size, last.getyPosition(), size, "blue"));
        }
        targetCircle.makeInvisible();
        hasTarget = false;
        snake.get(snake.size() - 1).makeVisible();
    }

    private boolean hitTheWall(Canvas canvas) {
        return snake.get(0).getxPosition() <= 0 || snake.get(0).getyPosition() <= 0 ||
                snake.get(0).getxPosition() + snake.get(0).getSize() >= canvas.getWidth() ||
                snake.get(0).getyPosition() + snake.get(0).getSize() >= canvas.getHeight();
    }

    private boolean biteHimself() {
        for (int i = 1; i < snake.size(); i++)
            if (!checkIfDistanceFromHeadIsOk())
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
