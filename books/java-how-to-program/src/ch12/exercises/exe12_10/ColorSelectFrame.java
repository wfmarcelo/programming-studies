// Exe. 12.10: ColorSelectFrame,java
package ch12.exercises.exe12_10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ColorSelectFrame
 */
public class ColorSelectFrame extends JFrame {
    private final JComboBox<String> colorsComboBox;
    private static final String[] colorsName = 
        {"RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "PURPLE", "BLACK", "WHITE"};
    private final JCheckBox backgroundJCheckBox;
    private final JCheckBox foregroundJCheckBox;
    private final JButton[] buttons;
    private static final String[] buttonNames = { "Ok", "Cancel" };

    private final Box locationBox;
    
    private final JPanel buttonsPanel;
    private final JPanel optionsPanel;
    

    public ColorSelectFrame() {
        super("ColorSelect");

        colorsComboBox = new JComboBox<String>(colorsName);

        locationBox = Box.createHorizontalBox();

        backgroundJCheckBox = new JCheckBox("Background");
        foregroundJCheckBox = new JCheckBox("Foreground");

        locationBox.add(backgroundJCheckBox);
        locationBox.add(foregroundJCheckBox);


        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));

        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttonsPanel.add(buttons[i]);
        }

        optionsPanel = new JPanel();
        optionsPanel.add(locationBox);
        optionsPanel.add(buttonsPanel);


        add(colorsComboBox, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
    }
    
}