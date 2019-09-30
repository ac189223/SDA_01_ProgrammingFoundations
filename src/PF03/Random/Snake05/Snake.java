package PF03.Random.Snake05;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    static Snake snakeClassAccessor = new Snake();
    private ArrayList<Circle> snakeBody;
    private ArrayList<Move> snakeMoves;

    public Snake() {                                                        // Creates new head that will go somewhere
        snakeBody = new ArrayList<>();
        snakeBody.add(new Circle(DrawDrawDraw.WIDTH / 4, DrawDrawDraw.HEIGHT / 4, 6, "red"));
        snakeMoves = new ArrayList<>();
        snakeMoves.add(new Move(DrawDrawDraw.getHorizontal(), DrawDrawDraw.getVertical()));
        snakeBody.get(0).makeVisible();
    }

    public ArrayList<Circle> getSnakeBody() { return snakeBody; }
    public ArrayList<Move> getSnakeMoves() { return snakeMoves; }

    public void setSnakeBody(ArrayList<Circle> snakeBody) { this.snakeBody = snakeBody; }
    public void setSnakeMoves(ArrayList<Move> snakeMoves) { this.snakeMoves = snakeMoves; }

    public void draw(Graphics surface) {
        if (!DrawDetails.ifSnakeAlive()) {                                   // If snake does not exist
            Snake snake = new Snake();
        } else {
            moveSnake();
        }
    }

    private void moveSnake() {
        snakeMoves.remove(0);
        snakeMoves.add(new Move(DrawDrawDraw.getHorizontal(), DrawDrawDraw.getVertical()));
        int size = (int) snakeBody.get(0).getDiameter();
        for (int i = 0; i < snakeBody.size(); i++) {
            if (snakeMoves.get(i).getHorizontal() != 0)
                snakeBody.get(i).moveHorizontal(snakeMoves.get(i).getHorizontal() * size);
            else
                snakeBody.get(i).moveVertical(snakeMoves.get(i).getVertical() * size);
        }
        if (checkIfSnakeOnTarget()) {
            eatTarget();
            snakeMoves.add(new Move(DrawDrawDraw.getHorizontal(), DrawDrawDraw.getVertical()));
        }
        if (hitTheWall()) { //|| biteHimself()) {
            DrawDetails.setSnakeAlive(false);
            Target.targetClassAccessor.getTargetSquare().makeInvisible();
            snakeBody.forEach(Circle::makeInvisible);
        }
    }

    private boolean checkIfSnakeOnTarget() {
        return !checkIfDistanceFromHeadIsOk();
    }

    private boolean checkIfDistanceFromHeadIsOk() {
        Circle snakesHead = getSnakeBody().get(getSnakeBody().size() - 1);
        Square target  = Target.targetClassAccessor.getTargetSquare();
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

    private void eatTarget() {
        int size = (int) snakeBody.get(0).getDiameter();
        Circle last = snakeBody.get(snakeBody.size() - 1);
        last.changeColor("blue");
        if (snakeMoves.get(snakeBody.size() - 1).getHorizontal() != 0)
            snakeBody.add(new Circle(last.getxPosition() + size * snakeMoves.get(snakeBody.size() - 1).getHorizontal(), last.getyPosition(), size, "red"));
        else
            snakeBody.add(new Circle(last.getxPosition(), last.getyPosition() + size * snakeMoves.get(snakeBody.size() - 1).getVertical(), size, "red"));
        Target.targetClassAccessor.getTargetSquare().makeInvisible();
        DrawDetails.setHasTarget(false);
        snakeBody.get(snakeBody.size() - 1).makeVisible();
    }

    private boolean hitTheWall() {
        return snakeBody.get(snakeBody.size() - 1).getxPosition() <= 0 || snakeBody.get(snakeBody.size() - 1).getyPosition() <= 0 ||
                snakeBody.get(snakeBody.size() - 1).getxPosition() + snakeBody.get(snakeBody.size() - 1).getDiameter() >= DrawDrawDraw.WIDTH ||
                snakeBody.get(snakeBody.size() - 1).getyPosition() + snakeBody.get(snakeBody.size() - 1).getDiameter() >= DrawDrawDraw.HEIGHT;
    }

/**    private boolean biteHimself() {
        for (int i = 1; i < snake.size(); i++)
            if (!checkIfDistanceFromHeadIsOk())
                return true;
        return false;
    }
*/
}
