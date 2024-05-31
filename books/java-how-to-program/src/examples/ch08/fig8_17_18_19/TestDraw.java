// Fig. 8.19: TestDraw.java
// Creating a JFrame to display a DrawPanel.
package ch08.fig8_17_18_19;

import javax.swing.JFrame;

public class TestDraw {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(300, 300);
        app.setVisible(true);

    }
    
}