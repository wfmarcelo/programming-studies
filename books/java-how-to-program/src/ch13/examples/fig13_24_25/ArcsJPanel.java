// Fig. 13.24: ArcsJPanel.java
// Arcs displayed with drawArc and fillArc.
package ch13.examples.fig13_24_25;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArcsJPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRect(15, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(15, 35, 80, 80, 0, 360);

        g.setColor(Color.RED);
        g.drawRect(100, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(100, 35, 80, 80, 0, 110);

        g.setColor(Color.RED);
        g.drawRect(185, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(185, 35, 80, 80, 0, -270);

        g.fillArc(15, 120, 80, 40, 0, 360);
        
        g.fillArc(100, 120, 80, 40, 270, -90);

        g.fillArc(185, 120, 80, 40, 2, -270);
    }
}
