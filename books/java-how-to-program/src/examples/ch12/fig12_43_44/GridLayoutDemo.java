// Fig. 12.44: GridLayoutDemo.java
// Testing GridLayoutFrame.
package ch12.fig12_43_44;

import javax.swing.JFrame;

public class GridLayoutDemo {
    public static void main(String[] args) {
        GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
        gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.setSize(300, 200);
        gridLayoutFrame.setVisible(true);
    }
}
