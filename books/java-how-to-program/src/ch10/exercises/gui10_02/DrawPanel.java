// Fig. 8.18: DrawPanel.java
// Program that uses class MyLine
// to draw random lines.

package ch10.exercises.gui10_02;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private SecureRandom randomNumbers = new SecureRandom();
    private MyShape[] shapes;

    public DrawPanel(int shapeQuantity) {
        setBackground(Color.WHITE);

        shapes = new MyShape[shapeQuantity];
        
        for (int count = 0; count < shapes.length; count++)
        {
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);

            Color color = new Color(randomNumbers.nextInt(256),
                randomNumbers.nextInt(256), randomNumbers.nextInt(256));

            boolean filled = randomNumbers.nextInt(2) == 1 ? true : false;

            int shapeType = randomNumbers.nextInt(3);

            switch (shapeType) {
                case 0:
                    shapes[count] = new MyLine(x1, y1, x2, y2, color);
                    break;
                    
                case 1:
                    shapes[count] = new MyRectangle(x1, y1, x2, y2, color, filled);
                    break;
                
                case 2:
                    shapes[count] = new MyOval(x1, y1, x2, y2, color, filled);
                    break;
            }


        }
        

    }

    public String getStatusMessage() {
        int lines = 0;
        int ovals = 0;
        int rectangles = 0;

        for (MyShape shape : shapes) {
            if (shape instanceof MyLine)
                lines++;
            else if (shape instanceof MyRectangle)
                rectangles++;
            else
                ovals++;
        }

        return String.format("%s: %d, %s: %d, %s: %d", 
            "Lines", lines,
            "Ovals", ovals,
            "Rectangles", rectangles);
    }

    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyShape shape : shapes) {
            shape.draw(g);
        }
    }
}