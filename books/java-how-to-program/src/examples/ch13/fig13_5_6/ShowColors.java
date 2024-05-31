package ch13.fig13_5_6;

import javax.swing.JFrame;

public class ShowColors {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Using colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ColorJPanel colorJPanel = new ColorJPanel();
        frame.add(colorJPanel);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }
}
