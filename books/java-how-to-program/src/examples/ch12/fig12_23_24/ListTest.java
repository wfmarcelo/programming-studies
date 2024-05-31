// Fig. 12.24: ListTest.java
// Selecting colors from a JList.
package ch12.fig12_23_24;

import javax.swing.JFrame;

/**
 * ListTest
 */
public class ListTest {

    public static void main(String[] args) {
        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setSize(350, 130);
        listFrame.setVisible(true);
    }
}