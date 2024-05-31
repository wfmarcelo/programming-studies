package ch04.gui4_01_b;

import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * DrawPanel
 */
public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int widthStep = width / 15;
        int heightSetp = height / 15;

        int atualWidth = widthStep;
        int atualHeight = height - heightSetp;
        
        int counter = 1;
        
        while (counter < 15) {
            
            
            g.drawLine(0, 0, atualWidth, atualHeight);
            g.drawLine(atualWidth, atualHeight, width, height);
            g.drawLine(width, 0, width - atualHeight, height - atualHeight);
            g.drawLine(0, height, width - atualHeight, height - atualHeight);
            
            atualHeight -= heightSetp;
            atualWidth += widthStep;
            
            counter++;
        }

    }

    
}