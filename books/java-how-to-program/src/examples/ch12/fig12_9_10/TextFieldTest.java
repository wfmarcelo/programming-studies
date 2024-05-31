// Fig. 12.10: TextFieldTest.java
// Testing TextFieldFrame.

package ch12.fig12_9_10;

import javax.swing.JFrame;

/**
 * TextFieldTest
 */
public class TextFieldTest {

    public static void main(String[] args) {
        TextFieldFrame textFieldFrame = new TextFieldFrame();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(350, 100);
        textFieldFrame.setVisible(true);
    }
}