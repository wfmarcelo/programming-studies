// Fig. 4.18: DrawPanel.java
// Using drawLine to connect the corners of a panel
package ch04.fig4_18_19;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
    }
}
