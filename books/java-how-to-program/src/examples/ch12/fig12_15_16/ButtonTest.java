// Fig. 12.16: ButtonTest.java
// Testing ButtonFrame.
package ch12.fig12_15_16;

import javax.swing.JFrame;

/**
 * ButtonTest
 */
public class ButtonTest {

    public static void main(String[] args) {
        ButtonFrame buttonFrame = new ButtonFrame();
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(280, 110);
        buttonFrame.setVisible(true);
    }
}