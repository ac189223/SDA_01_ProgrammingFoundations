package PF03.BlueJ._01_House;

public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private boolean drawn;

    public Picture() {
        this.setWall(new Square());
        this.setWindow(new Square());
        this.setRoof(new Triangle());
        this.setSun(new Circle());
        this.setDrawn(false);
    }

    public void setWall(Square wall) { this.wall = wall; }
    public void setWindow(Square window) { this.window = window; }
    public void setRoof(Triangle roof) { this.roof = roof; }
    public void setSun(Circle sun) { this.sun = sun; }
    public void setDrawn(boolean drawn) { this.drawn = drawn; }

    public void draw() {
        if (!drawn) {
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();

            window.changeColor("black");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();

            roof.changeSize(60, 180);
            roof.moveHorizontal(-225);
            roof.moveVertical(-60);
            roof.makeVisible();

            sun.changeColor("yellow");
            sun.moveHorizontal(100);
            sun.moveVertical(-40);
            sun.changeSize(80);
            sun.makeVisible();

            drawn = true;
        }
    }

    public void setBlackAndWhite() {
        wall.changeColor("black");
        roof.changeColor("black");
        sun.changeColor("black");
        window.changeColor("white");
    }

    public void setColor() {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        sun.changeColor("yellow");
    }
}
