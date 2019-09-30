package PF03.Random.Snake04_SlowingWhenGrowing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    private static Test test = new Test();
    private Circle blue;
    private boolean hasTarget = false;
    private ArrayList<Circle> snake = new ArrayList<>();
    private ArrayList<Move> moves = new ArrayList<>();
    private Square targetSquare;
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
        blue.changeSize(0);
        blue.makeVisible();
        blue.slowChangeSize(120);
        canvas.wait(500);
        blue.changeSize(90);
        canvas.wait(500);
        blue.changeSize(60);
        canvas.wait(500);
        blue.changeSize(30);
        canvas.wait(500);
        canvas.erase(blue);
    }

    private void headAppears(Canvas canvas) {
        snake.add(new Circle(canvas.getWidth() / 4, canvas.getHeight() / 4, 6, "red"));
        moves.add(new Move(canvas.getHorizontal(), canvas.getVertical()));
        snake.get(0).makeVisible();
    }

    private void setTarget(Canvas canvas) {
        boolean check = false;
        while (!check) {
            targetSquare = new Square(random.nextInt(canvas.getWidth() - 20) + 10, random.nextInt(canvas.getHeight() - 20) + 10, 10, "green");
            if (checkIfDistanceFromHeadIsOk())
                check = true;
        }
        targetSquare.makeVisible();
        hasTarget = true;
    }

    private boolean checkIfDistanceFromHeadIsOk() {
        Circle snakesHead = snake.get(snake.size() - 1);
        return  //head on left far enough
                (snakesHead.getxPosition() < targetSquare.getxPosition() &&
                        snakesHead.getxPosition() + snakesHead.getDiameter() < targetSquare.getxPosition()) ||
                //head on right far enough
                (snakesHead.getxPosition() > targetSquare.getxPosition() &&
                        snakesHead.getxPosition() > targetSquare.getxPosition() + targetSquare.getSize()) ||
                //head higher and far enough
                (snakesHead.getyPosition() < targetSquare.getyPosition() &&
                        snakesHead.getyPosition() + snakesHead.getDiameter() < targetSquare.getyPosition()) ||
                //head lower and far enough
                (snakesHead.getyPosition() > targetSquare.getyPosition() &&
                        snakesHead.getyPosition() > targetSquare.getyPosition() + targetSquare.getSize());
    }

    private void moveSnake(Canvas canvas) {
        moves.remove(0);
        moves.add(new Move(canvas.getHorizontal(), canvas.getVertical()));
        int size = (int)snake.get(0).getDiameter();
        for (int i = 0; i < snake.size(); i++) {
            if (moves.get(i).getHorizontal() != 0)
                snake.get(i).moveHorizontal(moves.get(i).getHorizontal() * size);
            else
                snake.get(i).moveVertical(moves.get(i).getVertical() * size);
        }
        if (checkIfSnakeOnTarget()) {
            eatTarget();
            moves.add(new Move(canvas.getHorizontal(), canvas.getVertical()));
        }
        if (hitTheWall(canvas)) { //|| biteHimself()) {
            alive = false;
            targetSquare.makeInvisible();
            snake.forEach(Circle::makeInvisible);
        }
    }

    private boolean checkIfSnakeOnTarget() {
        return !checkIfDistanceFromHeadIsOk();
    }

    private void eatTarget() {
        int size = (int) snake.get(0).getDiameter();
        Circle last = snake.get(snake.size() - 1);
        last.changeColor("blue");
        if (moves.get(snake.size() - 1).getHorizontal() != 0)
            snake.add(new Circle(last.getxPosition() + size * moves.get(snake.size() - 1).getHorizontal(), last.getyPosition(), size, "red"));
        else
            snake.add(new Circle(last.getxPosition(), last.getyPosition() + size * moves.get(snake.size() - 1).getVertical(), size, "red"));
        targetSquare.makeInvisible();
        hasTarget = false;
        snake.get(snake.size() - 1).makeVisible();
    }

    private boolean hitTheWall(Canvas canvas) {
        return snake.get(snake.size() - 1).getxPosition() <= 0 || snake.get(snake.size() - 1).getyPosition() <= 0 ||
                snake.get(snake.size() - 1).getxPosition() + snake.get(snake.size() - 1).getDiameter() >= canvas.getWidth() ||
                snake.get(snake.size() - 1).getyPosition() + snake.get(snake.size() - 1).getDiameter() >= canvas.getHeight();
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
