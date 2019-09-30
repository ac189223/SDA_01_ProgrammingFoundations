package PF03.Random.Snake05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Displays window and calls drawing from DrawSnake
public class DrawDrawDraw extends JPanel implements Runnable {
    private boolean animate = true;
    private final int FRAME_DELAY = 50;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private DrawDetails draw;
    private static int horizontal = 1;
    private static int vertical = 0;

    //public DrawDrawDraw() { }

    public DrawDrawDraw(DrawDetails drawer) {
        this.draw = drawer;
    }

    public static int getHorizontal() { return horizontal; }
    public static int getVertical() { return vertical; }

    /** Paint callback from Swing. Draw graphics using g. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Enable anti-aliasing for better looking graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //    draw.draw(g2);
    }

    /** Enables periodic repaint calls. */
    public synchronized void start() {
        animate = true;
    }

    /** Pauses animation. */
    public synchronized void stop() {
        animate = false;
    }

    private synchronized boolean animationEnabled() {
        return animate;
    }

    @Override
    public void run() {
        while (true) {
            if (animationEnabled()) {
                repaint();
            }

            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String args[]) {
        final DrawDrawDraw content = new DrawDrawDraw(new DrawDetails());

        JFrame frame = new JFrame("    =-_-=    ");

        Color bgColor = Color.darkGray;
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        content.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_UP:
                        // handle up
                        horizontal = 0;
                        vertical = -1;
                        break;
                    case KeyEvent.VK_DOWN:
                        // handle down
                        horizontal = 0;
                        vertical = 1;
                        break;
                    case KeyEvent.VK_LEFT:
                        // handle left
                        horizontal = -1;
                        vertical = 0;
                        break;
                    case KeyEvent.VK_RIGHT :
                        // handle right
                        horizontal = 1;
                        vertical = 0;
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
            public void windowDeiconified(WindowEvent e) { content.start(); }
            public void windowIconified(WindowEvent e) { content.stop(); }
        });

        new Thread(content).start();

        frame.setVisible(true);
    }
}
