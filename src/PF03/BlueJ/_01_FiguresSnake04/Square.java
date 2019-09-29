package PF03.BlueJ._01_FiguresSnake04;

import java.awt.*;

public class Square {
    private int xPosition;
    private int yPosition;
    private int size;
    private String color;
    private boolean isVisible;

    public Square(int xPosition, int yPosition, int size, String color) {
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        this.setSize(size);
        this.setColor(color);
    }

    public int getxPosition() { return xPosition; }
    public int getyPosition() { return yPosition; }
    public int getSize() { return size; }
    public String getColor() { return color; }
    public boolean isVisible() { return isVisible; }

    public void setxPosition(int xPosition) { this.xPosition = xPosition; }
    public void setyPosition(int yPosition) { this.yPosition = yPosition; }
    public void setSize(int size) { this.size = size; }
    public void setColor(String color) { this.color = color; }
    public void setVisible(boolean visible) { isVisible = visible; }

    public void makeVisible() {
        isVisible = true;
        draw();
    }

    public void makeInvisible() {
        erase();
        isVisible = false;
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

    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    private void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, size, size));
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
