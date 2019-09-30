package PF03.Random.Snake05;

import java.awt.*;
import java.util.ArrayList;

public class DrawDetails {
    static Snake snake;
    static Target target;
    static boolean hasTarget;
    static boolean snakeAlive;

    public DrawDetails() {                                 // Calls creation of snake & target
        Snake snake = new Snake();
        Target target = new Target();
        hasTarget = false;
        snakeAlive = false;
    }

    public Snake getSnake() { return snake; }
    public Target getTarget() { return target; }
    public static boolean ifHasTarget() { return hasTarget; }
    public static boolean ifSnakeAlive() { return snakeAlive; }

    public void setSnake(Snake snake) { DrawDetails.snake = snake; }
    public void setTarget(Target target) { DrawDetails.target = target; }
    public static void setHasTarget(boolean hasTarget) { DrawDetails.hasTarget = hasTarget; }
    public static void setSnakeAlive(boolean snakeAlive) { DrawDetails.snakeAlive = snakeAlive; }

    public void draw(Graphics surface) {                // Calls drawing or moving of snake & target
        target.draw(surface);
        snake.draw(surface);
    }
}
