// Fig. 12.18: CheckBoxText.java
// Testing CheckBoxFrame.
package ch12.examples.checkboxEvents;

import javax.swing.JFrame;

/**
 * CheckBoxTest
 */
public class CheckBoxTest {

    public static void main(String[] args) {
        CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
        checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkBoxFrame.setSize(275, 100);
        checkBoxFrame.setVisible(true);
    }
}