package PF03.BlueJ._01_Figures;

import java.awt.*;
import java.util.ArrayList;

public class Test {
    private static Test test = new Test();

    public static void main(String[] args) {

        Canvas canvas = new Canvas("    =-_-=    ", 600, 250, Color.darkGray);
        canvas.setCanvasSingleton(canvas);

        Circle blue = test.blueStarter(canvas);
        Person paul = test.paulAppears(canvas);
        Triangle paulCrusher = test.paulCrusherAppears(canvas);
        test.chasingPaul(canvas, paul, paulCrusher);
        test.paulDies(canvas, paul, paulCrusher);
        test.crusherLaughs(canvas, paulCrusher);
        test.closure(canvas, blue);
        System.exit(0);
    }

    private void closure(Canvas canvas, Circle blue) {
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

    private void crusherLaughs(Canvas canvas, Triangle paulCrusher) {
        ArrayList<Circle> face = prepareFace (paulCrusher);
        paulCrusher.slowMoveVertical(-45);
        for (int i = 0; i < 5; i++) {
            paulCrusher.changeSize(60,60);
            for (Circle circle: face)
                circle.makeVisible();
            canvas.wait(300);
            for (Circle circle: face)
                circle.makeInvisible();
            face.get(1).moveVertical(-i);
            paulCrusher.changeSize(30,30);
            canvas.wait(300);
        }
        canvas.erase(paulCrusher);
    }

    private ArrayList<Circle> prepareFace(Triangle paulCrusher) {
        ArrayList<Circle> face = new ArrayList<>();
        face.add(new Circle());
        face.add(new Circle());
        for(Circle circle: face) {
            circle.changeColor("yellow");
            circle.moveHorizontal(- circle.getxPosition());
            circle.moveVertical(- circle.getyPosition());
            circle.changeSize(10);
        }
        face.add(new Circle());
        face.get(2).changeColor("black");
        face.get(2).moveHorizontal(-face.get(2).getxPosition());
        face.get(2).moveVertical(-face.get(2).getyPosition());
        face.get(2).changeSize(20);
        int x = paulCrusher.getxPosition();
        int y = paulCrusher.getyPosition();
        face.get(2).moveHorizontal(x - 25);
        face.get(2).moveVertical(y - 30);
        face.get(0).moveHorizontal(x - 30);
        face.get(0).moveVertical(y - 45);
        face.get(1).moveHorizontal(x - 20);
        face.get(1).moveVertical(y - 40);
        return face;
    }

    private void paulDies(Canvas canvas, Person paul, Triangle paulCrusher) {
        for (int i = 0; i < 9; i++) {
            paul.changeSize(paul.getHeight() - 5, paul.getWidth() - 1);
            paul.moveVertical(5);
            canvas.wait(300);
            paulCrusher.slowMoveHorizontal(-5);
            paulCrusher.slowMoveHorizontal(5);
            paulCrusher.moveVertical(5);
        }
        paul.makeInvisible();
    }

    private void chasingPaul(Canvas canvas, Person paul, Triangle paulCrusher) {
        for (int i = 0; i < 6; i++) {
            paul.slowMoveHorizontal(-20);
            paulCrusher.slowMoveHorizontal(-15 * i);
        }
        paulCrusher.slowMoveHorizontal(-5);
        canvas.wait(1000);

    }

    private Triangle paulCrusherAppears(Canvas canvas) {
        Triangle paulCrusher = new Triangle();
        paulCrusher.changeColor("red");
        paulCrusher.makeVisible();
        for (int i = 0; i < 4; i++) {
            paulCrusher.slowMoveHorizontal(-25);
            canvas.wait(1000);
        }
        return paulCrusher;
    }

    private Person paulAppears(Canvas canvas) {
        Person paul = new Person();
        paul.makeVisible();
        paul.slowMoveHorizontal(-270);
        paul.slowMoveHorizontal(200);
        paul.slowMoveHorizontal(-50);
        paul.slowMoveHorizontal(80);
        return paul;
    }

    private Circle blueStarter(Canvas canvas) {
        Circle blue = new Circle();
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
        return blue;
    }
}
