// Fig. 12.17: CheckBoxFrame.java
// JCheckBoxes and item events.
package ch12.fig12_17_18;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * CheckBoxFrame
 */
public class CheckBoxFrame extends JFrame {
    private final JTextField textField;
    private final JCheckBox boldJCheckBox;
    private final JCheckBox italicJCheckBox;

    public CheckBoxFrame() {
        super("JCheckBox Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italicJCheckBox);

        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    }
    
    private class CheckBoxHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent arg0) {
            Font font = null;

            if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            else if (italicJCheckBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            else
                font = new Font("Serif", Font.PLAIN, 14);

            textField.setFont(font);
        }

    }
}