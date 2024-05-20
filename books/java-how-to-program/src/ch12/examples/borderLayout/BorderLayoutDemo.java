// Fig. 12.42: BorderLayoutDemo.java
// Testing BorderLayoutFrame.
package ch12.examples.borderLayout;

import javax.swing.JFrame;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
        borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayoutFrame.setSize(300, 200);
        borderLayoutFrame.setVisible(true);
    }
}
