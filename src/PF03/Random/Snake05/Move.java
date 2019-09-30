package PF03.Random.Snake05;

public class Move {
    private int horizontal;
    private int vertical;

    public Move(int horizontal, int vertical) {
        this.setHorizontal(horizontal);
        this.setVertical(vertical);
    }

    public int getHorizontal() { return horizontal; }
    public int getVertical() { return vertical; }

    public void setHorizontal(int horizontal) { this.horizontal = horizontal; }
    public void setVertical(int vertical) { this.vertical = vertical; }
}
