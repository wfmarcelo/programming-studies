// Fig. 12.39: FlowLayoutFrame.java
// FlowLayout allows components to flow over multiple lines.
package ch12.fig12_39_40;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
    private final JButton leftJButton;
    private final JButton centerJButton;
    private final JButton rightJButton;
    private final FlowLayout layout;
    private final Container container;

    public FlowLayoutFrame() {
        super("FlowLayout Demo");

        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);

        leftJButton = new JButton("Left");
        add(leftJButton);
        leftJButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    layout.setAlignment(FlowLayout.LEFT);

                    layout.layoutContainer(container);
                }
            }
        );

        centerJButton = new JButton("Center");
        add(centerJButton);
        centerJButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    layout.setAlignment(FlowLayout.CENTER);

                    layout.layoutContainer(container);
                }
            }
        );

        rightJButton = new JButton("Right");
        add(rightJButton);
        rightJButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    layout.setAlignment(FlowLayout.RIGHT);

                    layout.layoutContainer(container);
                }
            }
        );


    }
}
