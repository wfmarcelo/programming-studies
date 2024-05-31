// Fig. 13.16: Metrics.java
// Displaying font metrics.
package ch13.fig13_15_16;

import javax.swing.JFrame;

public class Metrics {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demonstrating FontMetrics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MetricsJPanel metricsJPanel = new MetricsJPanel();
        frame.add(metricsJPanel);
        frame.setSize(510, 240);
        frame.setVisible(true);
    }
}
