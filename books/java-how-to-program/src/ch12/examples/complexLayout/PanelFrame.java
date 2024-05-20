// Fig. 12.45: PanelFrame.java
// Using a JPanel to help lay out components.
package ch12.examples.complexLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelFrame extends JFrame {
    private final JPanel buttonJPanel;
    private final JButton[] buttons;

    public PanelFrame() {
        super("Panel Demo");
        buttons = new JButton[5];
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(1, buttons.length));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            buttonJPanel.add(buttons[i]);
        }

        add(buttonJPanel, BorderLayout.SOUTH);
    }
}
