package ch04.gui4_02_b;

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

        int startHeight = 0;
        int startWidth = widthStep;

        int counter = 1;

        while (counter < STEPS) {
            g.drawLine(0, startHeight, startWidth, height);
            g.drawLine(0, height - startHeight, startWidth, 0);
            g.drawLine(startWidth, 0, width, startHeight);
            g.drawLine(width, startHeight, width - startWidth, height);

            startHeight += heightStep;
            startWidth += widthStep;

            counter++;
        }
    }

}