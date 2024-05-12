package ch07.exercises.gui7_01_a;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawSpiral extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int step = 20;
        int size = step;
        int direction = 1;

        g.setColor(Color.RED);
        for (int i = 1; i <= 16; i++) {
            
            if (i % 2 == 0) {
                g.drawLine(centerX, centerY, centerX - size, centerY);
                centerX = centerX - size;
                direction *= -1;
                if (i == 2)
                    size = step * (i) * direction;
                else
                    size = step * (i - 1) * direction;
            }
            else {
                g.drawLine(centerX, centerY, centerX, centerY + size);
                centerY = centerY + size;
            }

        }
    }
}
