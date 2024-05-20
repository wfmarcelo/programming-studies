// Fig. 12.37: KeyDemo.java
// Testing KeyDemoFrame.
package ch12.examples.keyEvents;

import javax.swing.JFrame;

/**
 * KeyDemo
 */
public class KeyDemo {

    public static void main(String[] args) {
        KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
        keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyDemoFrame.setSize(350, 100);
        keyDemoFrame.setVisible(true);
    }
}