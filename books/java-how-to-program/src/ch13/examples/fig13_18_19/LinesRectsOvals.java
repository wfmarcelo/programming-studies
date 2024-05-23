// Fig. 13.19: LinesRectsOvals.java
// Testing LinesRectsOvalsJPanel.
package ch13.examples.fig13_18_19;

import java.awt.Color;

import javax.swing.JFrame;

public class LinesRectsOvals {
    public static void main(String[] args) {
        JFrame frame =
            new JFrame("Drawing lines, rectangles and ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LinesRectsOvalsJPanel linesRectsOvalsJPanel =
            new LinesRectsOvalsJPanel();
        linesRectsOvalsJPanel.setBackground(Color.WHITE);
        frame.add(linesRectsOvalsJPanel);
        frame.setSize(400, 210);
        frame.setVisible(true);
    }
}
