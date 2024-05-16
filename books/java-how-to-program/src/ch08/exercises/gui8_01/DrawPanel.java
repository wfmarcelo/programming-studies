// Fig. 8.18: DrawPanel.java
// Program that uses class MyLine
// to draw random lines.

package ch08.exercises.gui8_01;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private SecureRandom randomNumbers = new SecureRandom();
    private MyLine[] lines;
    private MyRectangle[] rectangles;
    private MyOval[] ovals;

    public DrawPanel() {
        setBackground(Color.WHITE);

        lines = new MyLine[1 + randomNumbers.nextInt(5)];
        rectangles = new MyRectangle[1 + randomNumbers.nextInt(5)];
        ovals = new MyOval[1 + randomNumbers.nextInt(5)];

        for (int count = 0; count < lines.length; count++)
        {
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);

            Color color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));

            lines[count] = new MyLine(x1, y1, x2, y2, color);

        }
        
        for (int count = 0; count < rectangles.length; count++)
        {
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);

            boolean isFilled = randomNumbers.nextInt(2) == 1 ? true : false;

            Color color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));

            rectangles[count] = new MyRectangle(x1, y1, x2, y2, color, isFilled);
        }
        
        for (int count = 0; count < ovals.length; count++)
        {
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);

            boolean isFilled = randomNumbers.nextInt(2) == 1 ? true : false;

            Color color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));

            ovals[count] = new MyOval(x1, y1, x2, y2, color, isFilled);
        }
    }

    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyLine line : lines) {
            line.draw(g);
        }

        for (MyRectangle rectangle : rectangles) {
            rectangle.draw(g);
        }
        
        for (MyOval oval : ovals) {
            oval.draw(g);
        }
    }


    
}