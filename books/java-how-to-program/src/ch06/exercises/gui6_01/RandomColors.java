// GUI Exe. 6.1: RandomColors.java
// Painting concentrict circles with random colors
package ch06.exercises.gui6_01;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class RandomColors extends JPanel {
    
    private static SecureRandom randomNumbers = new SecureRandom();
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color1 = new Color(
                randomNumbers.nextInt(256),
                randomNumbers.nextInt(256),
                randomNumbers.nextInt(256));
        Color color2 = new Color(
                randomNumbers.nextInt(256),
                randomNumbers.nextInt(256),
                randomNumbers.nextInt(256));

        int width = getWidth();
        int height = getHeight();

        int x = width / 2;
        int y = height / 2;


        for (int i = 5; i > 0; i--) {
            int diameter = i * (width / 6);
            int radius = diameter / 2;

            if (i % 2 == 0)
                g.setColor(color1);
            else
                g.setColor(color2);

            g.fillOval(x - radius, y - radius, diameter, diameter);
        }


    }
    
}
