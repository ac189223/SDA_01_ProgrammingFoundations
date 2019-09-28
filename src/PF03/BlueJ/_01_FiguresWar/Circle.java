package PF03.BlueJ._01_FiguresWar;

import java.awt.geom.Ellipse2D;

public class Circle {
    private double xPosition;
    private double yPosition;
    private double diameter;
    private String color;
    private boolean isVisible;
    
    public Circle() {
        this.setxPosition(270);
        this.setyPosition(100);
        this.setDiameter(60);
        this.setColor("blue");
    }

    public Circle(double xMiddle, double yMiddle, double radius) {
        this.setxPosition(xMiddle - radius);
        this.setyPosition(yMiddle - radius);
        this.setDiameter(radius * 2);
        this.setColor("blue");
    }

    public Circle(double xMiddle, double yMiddle, double radius, String color) {
        this.setxPosition(xMiddle - radius);
        this.setyPosition(yMiddle - radius);
        this.setDiameter(radius * 2);
        this.setColor(color);
    }

    public double getxPosition() { return xPosition; }
    public double getyPosition() { return yPosition; }
    public double getDiameter() { return diameter; }
    public String getColor() { return color; }
    public boolean isVisible() { return isVisible; }

    public void setxPosition(double xPosition) { this.xPosition = xPosition; }
    public void setyPosition(double yPosition) { this.yPosition = yPosition; }
    public void setDiameter(double diameter) { this.diameter = diameter; }
    public void setColor(String color) { this.color = color; }
    public void setVisible(boolean visible) { isVisible = visible; }

    public double getXMiddle() { return xPosition + diameter / 2; }
    public void setXMiddle(double xPosition) { this.xPosition = xPosition; }

    public double getYMiddle() { return yPosition + diameter / 2; }
    public void setYMiddle(double yPosition) { this.yPosition = yPosition; }

    public double getRadius() { return diameter / 2; }
    public void setRadius(double diameter) { this.diameter = diameter; }

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

    public void moveHorizontal(double distance) {
        erase();
        xPosition += distance;
        draw();
    }

    public void moveVertical(double distance) {
        erase();
        yPosition += distance;
        draw();
    }

    public void slowMoveHorizontal(double distance) {
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

    public void slowMoveVertical(double distance) {
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

    public void changeSize(double newDiameter) {
        erase();
        xPosition += (diameter - newDiameter) / 2;
        yPosition += (diameter - newDiameter) / 2;
        diameter = newDiameter;
        draw();
    }

    public void slowChangeSize(double newDiameter) {
        int delta = 1;
        double diff = newDiameter - getDiameter();
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
