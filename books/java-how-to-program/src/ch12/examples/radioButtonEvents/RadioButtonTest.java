// Fig. 12.20: RadioButtonTest.java
// Testing RadioButtonFrame.
package ch12.examples.radioButtonEvents;

import javax.swing.JFrame;

/**
 * RadioButtonTest
 */
public class RadioButtonTest {

    public static void main(String[] args) {
        RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
        radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radioButtonFrame.setSize(300, 100);
        radioButtonFrame.setVisible(true);
    }
}