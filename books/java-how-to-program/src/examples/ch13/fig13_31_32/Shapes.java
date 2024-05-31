// Fig. 13.32: Shapes.java
// Demonstrating a general path.
package ch13.fig13_31_32;

import java.awt.Color;

import javax.swing.JFrame;

public class Shapes {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShapesJPanel shapesJPanel = new ShapesJPanel();
        frame.add(shapesJPanel);
        frame.setBackground(Color.WHITE);
        frame.setSize(315, 330);
        frame.setVisible(true);
    }
}
