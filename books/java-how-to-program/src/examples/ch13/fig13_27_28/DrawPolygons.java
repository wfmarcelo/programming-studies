// Fig. 13.28: DrawPolygons.java
// Drawing polygons.
package ch13.fig13_27_28;

import javax.swing.JFrame;

public class DrawPolygons {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Polygons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PolygonsJPanel polygonsJPanel = new PolygonsJPanel();
        frame.add(polygonsJPanel);
        frame.setSize(280, 270);
        frame.setVisible(true);
    }
}
