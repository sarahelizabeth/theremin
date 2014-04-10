import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

/* Created by Sarah */

public class MoveDot extends JFrame {
    public DotPanel panel;

    /** Creates a new panel with a point will move */
    public MoveDot(int width, int height)  {
        super("MoveDot");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	
                return;
            }
        });
        panel = new DotPanel(width, height);
        setContentPane(panel);
        pack();
        show();
    }

    /** Moves the dot to specified location */
    private class Dot extends MIDIt {
        public int DotX() {

           int x = getP();
            return x;
        }
        public int DotY() {
           int y = getV();
            return y;
        }
    }

    /* Creates a dot on the panel */
    class DotPanel extends JPanel {
        private int width;
        private int height;
        private String color;
        private Point dot;

        public DotPanel(int width, int height) {
            this.width = width;
            this.height = height;
            dot = new Point(width / 2, height / 2);
            setPreferredSize(new Dimension(width, height));
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(colorChanger(dot.x, dot.y));

            g.fillOval(dot.x - 1, dot.y - 1, 20, 20);
            
                    //decode(MIDIt.dotCol));


        }

        /** THIS IS THE PART I NEED HELP WITH */
        public void moveDot(float dx, float dy) {
            Dot d = new Dot();
            float invdy = 600- dy;
            float expdx = 600 + dx;

            //dot.x = d.DotX();
           // dot.y = d.DotX();

            dot.x = (int)expdx;
            dot.y = (int)invdy;

            repaint();
        }
        
        public Color colorChanger(float dx, float dy) {
        	Color color = Color.black;
        	// Left half of screen
        	if (dx < 600)
        		color = Color.red;
        	// Right half of screen
        	else
        		color = Color.blue;
        	return color;
        	
        }
        
        
    }
}