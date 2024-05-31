// Fig. 12.15: ButtonFrame.java
// Command buttons and action events.
package ch12.fig12_15_16;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Icon;

/**
 * ButtonFrame
 */
public class ButtonFrame extends JFrame {
    private final JButton plainJButton;
    private final JButton fancyJButton;

    public ButtonFrame() {
        super("Testing Buttons");
        setLayout(new FlowLayout());

        plainJButton = new JButton("Plain Button");
        add(plainJButton);

        Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
        fancyJButton = new JButton("Fancy Button", bug1);
        fancyJButton.setRolloverIcon(bug2);
        add(fancyJButton);

        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(ButtonFrame.this, 
                String.format("You pressed: %s", event.getActionCommand()));
            
        }

    }
    
}