package PF03.BlueJ._01_House;

import java.awt.geom.Ellipse2D;

public class Circle {
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    
    public Circle() {
        diameter = 60;
        xPosition = 270;
        yPosition = 100;
        color = "blue";
    }

    public int getDiameter() { return diameter; }
    public int getxPosition() { return xPosition; }
    public int getyPosition() { return yPosition; }

    public void makeVisible() {
        isVisible = true;
        draw();
    }
    
    public void makeInvisible() {
        erase();
        isVisible = false;
    }
    
    public void moveRight()
    {
        moveHorizontal(20);
    }
    public void moveLeft()
    {
        moveHorizontal(-20);
    }
    public void moveUp()
    {
        moveVertical(-20);
    }
    public void moveDown()
    {
        moveVertical(20);
    }

    public void moveHorizontal(int distance) {
        erase();
        xPosition += distance;
        draw();
    }

    public void moveVertical(int distance) {
        erase();
        yPosition += distance;
        draw();
    }

    public void slowMoveHorizontal(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            xPosition += delta;
            draw();
        }
    }

    public void slowMoveVertical(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            yPosition += delta;
            draw();
        }
    }

    public void changeSize(int newDiameter) {
        erase();
        xPosition += (diameter - newDiameter) / 2;
        yPosition += (diameter - newDiameter) / 2;
        diameter = newDiameter;
        draw();
    }

    public void slowChangeSize(int newDiameter) {
        int delta = 1;
        int diff = newDiameter - getDiameter();
        if (newDiameter < getDiameter()) {
            delta = - delta;
            diff = - diff;
        }
        for (int i = 0; i < diff; i++) {
            changeSize(getDiameter() + delta);
        }
    }

    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    private void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
                                                          diameter, diameter));
            canvas.wait(10);
        }
    }

    private void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
