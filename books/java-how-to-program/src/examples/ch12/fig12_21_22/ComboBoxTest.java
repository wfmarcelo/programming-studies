// Fig. 12.22: ComboBoxTest.java
// Testing ComboBoxFrame.
package ch12.comboBoxEvents;

import javax.swing.JFrame;

/**
 * ComboBoxTest
 */
public class ComboBoxTest {

    public static void main(String[] args) {
        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
        comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBoxFrame.setSize(350, 150);
        comboBoxFrame.setVisible(true);
    }
}