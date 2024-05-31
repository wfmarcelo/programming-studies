// Fig. 12.26: MultipleSelectionTest.java
// Testing MultipleSelectionFrame.

package ch12.fig12_25_26;

import javax.swing.JFrame;

/**
 * MultipleSelectionTest
 */
public class MultipleSelectionTest {

    public static void main(String[] args) {
        MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
        multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        multipleSelectionFrame.setSize(350, 150);
        multipleSelectionFrame.setVisible(true);
    }
}