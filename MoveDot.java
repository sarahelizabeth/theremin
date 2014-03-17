import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

/* Created by Sarah */

public class MoveDot extends JFrame {
    private DotPanel panel;

    /** Creates a new panel with a point will move */
    public MoveDot(int width, int height) throws FileNotFoundException {
        super("MoveDot");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
        panel = new DotPanel(width, height);
        setContentPane(panel);
        pack();
        show();
    }

    /** Moves the dot to specified location */
    private class DotX extends MIDIt {
        public void DotX(int x) {
            x = getP();
        }
        public void DotY(int y) {
            y = getV();
        }
    }

    /* Creates a dot on the panel */
    private class DotPanel extends JPanel{
        private int width;
        private int height;
        private Point dot;

        public DotPanel(int width, int height) {
            this.width = width;
            this.height = height;
            dot = new Point(width / 2, height / 2);
            setPreferredSize(new Dimension(width, height));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillRect(dot.x-1, dot.y-1, 3, 3);
        }

        /** THIS IS THE PART I NEED HELP WITH */
        public void moveDot(int dx, int dy) {
            dot.x = new DotX(int x);
            dot.y = new DotY(int y);
            repaint();
        }
    }
}
