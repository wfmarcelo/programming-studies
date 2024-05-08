// GUI Exe. 5.1: Circles.java
// Drawing concentric circles.
package ch05.exercises.gui5_01;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Circles
 */
public class Circles extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int x = width / 2;
        int y = height / 2;

        for (int i = 0; i < 10; i++) {
            int radius = 10 + i * 10;
            int diameter = radius * 2;
            
            g.drawOval(x - radius, y - radius, diameter, diameter);
        }
    }
    
}