package ch07.gui7_01_b;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawSpiral extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int step = 30;
        int size = step;
        int direction = 1;


        g.setColor(Color.RED);
        for (int i = 1; i <= 3; i++) {
            
            size = step * i;
            
            g.drawArc(centerX, centerY, size, size, 0, 180 * direction);
            direction *= -1;
            
            centerX = centerX - size / i;
                
        }
    }
}
