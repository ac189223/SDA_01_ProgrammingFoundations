package PF03.Random.Snake05;

import java.awt.*;
import java.util.Random;

public class Target {
    static Target targetClassAccessor = new Target();
    private Square targetSquare;
    private Random random = new Random();

    public Target() {                                         // Creates target in a random point
        setTargetSquare(new Square(random.nextInt(DrawDrawDraw.WIDTH - 20) + 10,
                random.nextInt(DrawDrawDraw.HEIGHT - 20) + 10, 10, "green"));
        targetSquare.makeVisible();
    }

    public Square getTargetSquare() { return targetSquare; }
    public void setTargetSquare(Square targetSquare) { this.targetSquare = targetSquare; }

    public void draw(Graphics surface) {
        if (!DrawDetails.ifHasTarget()) {                    // If target does not exist
            boolean check = false;
            while (!check) {
               Target target = new Target();
                if (checkIfDistanceFromHeadIsOk())          // If target does not touch snakes head
                    check = true;
            }
            getTargetSquare().makeVisible();
            DrawDetails.setHasTarget(true);
        }
    }

    private boolean checkIfDistanceFromHeadIsOk() {
        Circle snakesHead = Snake.snakeClassAccessor.getSnakeBody().get(Snake.snakeClassAccessor.getSnakeBody().size() - 1);
        Square target  = getTargetSquare();
        return  //head on left far enough
                (snakesHead.getxPosition() < target.getxPosition() &&
                        snakesHead.getxPosition() + snakesHead.getDiameter() < target.getxPosition()) ||
                //head on right far enough
                (snakesHead.getxPosition() > target.getxPosition() &&
                        snakesHead.getxPosition() > target.getxPosition() + target.getSize()) ||
                //head higher and far enough
                (snakesHead.getyPosition() < target.getyPosition() &&
                        snakesHead.getyPosition() + snakesHead.getDiameter() < target.getyPosition()) ||
                //head lower and far enough
                (snakesHead.getyPosition() > target.getyPosition() &&
                        snakesHead.getyPosition() > target.getyPosition() + target.getSize());
    }
}
