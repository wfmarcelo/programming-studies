// Fig. 5.28: ShapesTest.java
// Obtaining user input and creating a JFrame to display Shapes.

package ch05.fig5_27_28;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ShapesTest
 */
public class ShapesTest {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
            "Enter 1 to draw rectangles\n" +
            "Enter 2 to draw ovals"
        );

        int choice = Integer.parseInt(input);

        Shapes panel = new Shapes(choice);

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
    
}