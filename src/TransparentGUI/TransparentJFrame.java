package TransparentGUI;

import javax.swing.*;
import java.awt.*;

class TransparentJFrame extends JFrame
{
    JButton b1;
    public TransparentJFrame()
    {
        setTitle("Transparent JFrame Demo");
        setSize(400,400);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //For Java 1.7 or above
        //setOpacity(0.4f);
        //For lower java versions
        //com.sun.awt.AWTUtilities.setWindowOpacity(this,0.4f);
        b1=new JButton("I am a button!");
        add(b1);
    }
    public static void main(String args[])
    {
        new TransparentJFrame();
    }
}