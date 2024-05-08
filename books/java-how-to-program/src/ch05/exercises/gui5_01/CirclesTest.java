// GUI Exe. 5.1: CirclesTest.java
// Testing Circle class.
package ch05.exercises.gui5_01;

import javax.swing.JFrame;

/**
 * CirclesTest
 */
public class CirclesTest {
    public static void main(String[] args) {
        Circles panel = new Circles();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
    
}