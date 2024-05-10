package ch06.exercises.gui6_02;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class RandomDrawings extends JPanel {
    
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < 10; i++) {

            Color color = new Color(
                randomNumbers.nextInt(256),   
                randomNumbers.nextInt(256),   
                randomNumbers.nextInt(256)   
                );
                
            g.setColor(color);
                
            int shapeChoice = randomNumbers.nextInt(2);

            int x = randomNumbers.nextInt(width);
            int y = randomNumbers.nextInt(height);
            int randomWidth = randomNumbers.nextInt(width / 2);
            int randomHeight = randomNumbers.nextInt(height / 2);
            
            if (shapeChoice == 0) 
                g.fillRect(x, x, randomWidth, randomHeight);
            else
                g.fillOval(x, y, randomWidth, randomHeight);
            
        }
    }
}
