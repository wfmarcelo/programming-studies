package ch07.gui7_01_b;

import javax.swing.JFrame;

public class DrawSpiralTest {
    public static void main(String[] args) {
        DrawSpiral panel = new DrawSpiral();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
    }
}
