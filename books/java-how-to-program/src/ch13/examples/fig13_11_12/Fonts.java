// Fig. 13.12: Fonts.java
// Using fonts.
package ch13.examples.fig13_11_12;

import javax.swing.JFrame;

public class Fonts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Using fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FontJPanel fontJPanel = new FontJPanel();
        frame.add(fontJPanel);
        frame.setSize(420, 120);
        frame.setVisible(true);
    }
}
