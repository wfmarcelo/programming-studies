package ch04.exercises.gui4_02_a;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * DrawPanel
 */
public class DrawPanel extends JPanel {

    private static final int STEPS = 15;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int widthStep = width / STEPS;
        int heightStep = height / STEPS;

        int initialWidth = 0;
        int initialHeight = heightStep;

        int finalWidth = widthStep;
        int finalHeight = height - heightStep;


        int counter = 1;

        while (counter < STEPS)
        {
            g.drawLine(0, initialHeight, finalWidth, height);

            initialHeight += heightStep;
            finalWidth += widthStep;
            finalHeight -= heightStep;


            counter++;
        }
    }
    
}