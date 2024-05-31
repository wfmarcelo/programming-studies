// Fig. 8.19: TestDraw.java
// Creating a JFrame to display a DrawPanel.
package ch10.gui10_01;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestDraw {
    public static void main(String[] args) {
        int shapesQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity of shapes:"));
        
        DrawPanel panel = new DrawPanel(shapesQuantity);
        JLabel statusLabel = new JLabel(panel.getStatusMessage());

        JFrame app = new JFrame();
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.add(statusLabel, BorderLayout.SOUTH);
        app.setSize(300, 300);
        app.setVisible(true);

    }
    
}