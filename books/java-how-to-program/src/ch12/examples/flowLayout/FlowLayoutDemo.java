// Fig. 12.40: FlowLayoutDemo.java
// Testing FlowLayoutFrame.
package ch12.examples.flowLayout;

import javax.swing.JFrame;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
        flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowLayoutFrame.setSize(300, 75);
        flowLayoutFrame.setVisible(true);
    }
}
