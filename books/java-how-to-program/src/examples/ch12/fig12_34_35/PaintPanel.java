// Fig. 12.34: PaintPanel.java
// Adapter class used to implement event handlers.
package ch12.fig12_34_35;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * PaintPanel
 */
public class PaintPanel extends JPanel {
    private final ArrayList<Point> points = new ArrayList<>();

    public PaintPanel() {
        addMouseMotionListener(
            new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent event) {
                    points.add(event.getPoint());
                    repaint();
                }
            }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Point point : points) {
            g.fillOval(point.x, point.y, 4, 4);
        }
    }
    
}