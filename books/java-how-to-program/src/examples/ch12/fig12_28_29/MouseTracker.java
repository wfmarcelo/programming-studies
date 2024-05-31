// Fig. 12.29: MouseTracker.java
// Testing MouseTrackerFrame.
package ch12.fig12_28_29;

import javax.swing.JFrame;

/**
 * MouseTracker
 */
public class MouseTracker {

    public static void main(String[] args) {
        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300, 100);
        mouseTrackerFrame.setVisible(true);
    }
}