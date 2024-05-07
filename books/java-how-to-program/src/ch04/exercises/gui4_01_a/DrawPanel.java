package ch04.exercises.gui4_01_a;

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
        int atualHeight = height;
        
        int counter = 1;
        
        while (counter < 15) {
            
            atualHeight -= heightSetp;
            
            g.drawLine(0, 0, atualWidth, atualHeight);
            
            atualWidth += widthStep;
            
            counter++;
        }

    }

    
}