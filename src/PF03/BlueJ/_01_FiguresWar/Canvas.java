package PF03.BlueJ._01_FiguresWar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Canvas {

    private static Canvas canvasSingleton;

    public Canvas getCanvasSingleton() { return canvasSingleton; }
    public void setCanvasSingleton(Canvas canvasSingleton) { Canvas.canvasSingleton = canvasSingleton; }

    public static Canvas getCanvas() {
        if (canvasSingleton == null)
            canvasSingleton = new Canvas("Picture Demo", 300, 300, Color.white);
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;
    
    Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    public int getWidth() { return canvas.getWidth(); }
    public int getHeight() { return canvas.getHeight(); }

    public void setVisible(boolean visible) {
        if (graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }
 
    public void erase(Object referenceObject) {
        objects.remove(referenceObject);
        shapes.remove(referenceObject);
        redraw();
    }

    public void setForegroundColor(String colorString) {
        if (colorString.equals("red"))
            graphic.setColor(new Color(235, 25, 25));
        else if (colorString.equals("black"))
            graphic.setColor(Color.black);
        else if (colorString.equals("blue"))
            graphic.setColor(new Color(30, 75, 220));
        else if (colorString.equals("yellow"))
            graphic.setColor(new Color(255, 230, 0));
        else if (colorString.equals("green"))
            graphic.setColor(new Color(80, 160, 60));
        else if (colorString.equals("magenta"))
            graphic.setColor(Color.magenta);
        else if (colorString.equals("white"))
            graphic.setColor(Color.white);
        else if (colorString.equals("gray"))
            graphic.setColor(Color.gray);
        else
            graphic.setColor(Color.black);
    }

    public void wait(int milliseconds) {
        try { Thread.sleep(milliseconds); } catch (Exception e) { }
    }

    private void redraw() {
        erase();
        for (Object shape : objects)
            shapes.get(shape).draw(graphic);
        canvas.repaint();
    }
       
    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    private class ShapeDescription {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

}
