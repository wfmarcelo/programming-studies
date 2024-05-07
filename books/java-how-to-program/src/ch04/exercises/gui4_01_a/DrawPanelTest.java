package ch04.exercises.gui4_01_a;

import javax.swing.JFrame;

/**
 * DrawPanelTest
 */
public class DrawPanelTest {
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(400, 400);
        application.setVisible(true);
    }

}