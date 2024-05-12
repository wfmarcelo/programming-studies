package ch07.exercises.gui7_01_a;

import javax.swing.JFrame;

public class DrawSpiralTest {
    public static void main(String[] args) {
        DrawSpiral panel = new DrawSpiral();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(450, 450);
        application.setVisible(true);
    }
}
