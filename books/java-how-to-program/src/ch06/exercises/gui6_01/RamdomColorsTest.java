package ch06.exercises.gui6_01;

import javax.swing.JFrame;

public class RamdomColorsTest {
    public static void main(String[] args) {
        RandomColors panel = new RandomColors();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
