// Fig. 12.32: MouseDetails.java
// Testing MouseDetailsFrame.
package ch12.fig12_31_32;

import javax.swing.JFrame;

/**
 * MouseDetails
 */
public class MouseDetails {

    public static void main(String[] args) {
        MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
        mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseDetailsFrame.setSize(400, 150);
        mouseDetailsFrame.setVisible(true);
    }
}