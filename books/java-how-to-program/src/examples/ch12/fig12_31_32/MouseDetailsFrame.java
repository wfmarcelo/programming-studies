// Fig. 12.31: MouseDetailsFrame.java
// Demonstrating mouse clicks and distinguishing between mouse buttons.
package ch12.fig12_31_32;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * MouseDetailsFrame
 */
public class MouseDetailsFrame extends JFrame {

    private String details;
    private final JLabel statusBar;

    public MouseDetailsFrame() {
        super("Mouse clicks and buttons");

        statusBar = new JLabel("Click the mouse");
        add(statusBar, BorderLayout.SOUTH);
        addMouseListener(new MouseClickHandler());
    }

    private class MouseClickHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int xPos = e.getX();
            int yPos = e.getY();

            details = String.format("Clicked %d time(s)", e.getClickCount());

            if (e.isMetaDown())
                details += " with right mouse button";
            else if (e.isAltDown())
                details += " with center mouse button";
            else
                details += " with left mouse button";

            statusBar.setText(details);
        }
    }
}