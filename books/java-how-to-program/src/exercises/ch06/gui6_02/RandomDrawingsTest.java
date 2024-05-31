package ch06.gui6_02;

import javax.swing.JFrame;

public class RandomDrawingsTest {
    public static void main(String[] args) {
        RandomDrawings panel = new RandomDrawings();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);
    }
}
