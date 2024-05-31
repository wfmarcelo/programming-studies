// Fig. 8.19: TestDraw.java
// Creating a JFrame to display a DrawPanel.
package ch09.gui9_01;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDraw {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        JLabel statusLabel = new JLabel(panel.getStatusMessage());


        JFrame app = new JFrame();
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.add(statusLabel, BorderLayout.SOUTH);
        app.setSize(300, 300);
        app.setVisible(true);

    }
    
}