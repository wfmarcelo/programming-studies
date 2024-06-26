// Fig. 5.27: Shapes.java
// Drawing a cascade of shapes based on the user's choice
package ch05.fig5_27_28;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Shapes
 */
public class Shapes extends JPanel {
    private int choice;

    public Shapes(int userChoice) {
        choice = userChoice;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 10; i++) {
            switch (choice) {
                case 1:
                    g.drawRect(10 + i * 10, 10 + i * 10, 
                        50 + i * 10, 50 + i * 10);
                    break;
                
                case 2:
                    g.drawOval(10 + i * 10, 10 + i * 10, 
                        50 + i * 10, 50 + i * 10);
                    break;
            }
        }
    }
    
}