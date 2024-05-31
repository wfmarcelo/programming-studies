// Fig. 12.35: Painter.java
// Testing PaintPanel.
package ch12.fig12_34_35;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Painter
 */
public class Painter {

    public static void main(String[] args) {
        JFrame app = new JFrame("A simple paint program");
        
        PaintPanel paintPanel = new PaintPanel();
        app.add(paintPanel, BorderLayout.CENTER);

        app.add(new JLabel("Drag the mouse to draw"), 
            BorderLayout.SOUTH);

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 200);
        app.setVisible(true);

        
    }
}