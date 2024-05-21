// Exe. 12.8: AlignFrame.java
// Creating an align interface
package ch12.exercises.exe12_8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * AlignFrame
 */
public class AlignFrame extends JFrame {
    private final JCheckBox snapToGridJCheckBox;
    private final JCheckBox showGridJCheckBox;
    private final JLabel xLabel;
    private final JLabel yLabel;
    private JTextField xTextField;
    private JTextField yTextField;
    private final JButton[] buttons;
    private static final String[] buttonNames = 
        {"Ok", "Cancel", "Help"};
    
    private final JPanel optionsPanel;
    private final JPanel labelsPanel;
    private final JPanel textsPanel;
    private final JPanel buttonsPanel;


    public AlignFrame() {
        super("Align");
        optionsPanel = new JPanel();

        snapToGridJCheckBox = new JCheckBox("Snap to Grid");
        showGridJCheckBox = new JCheckBox("Show Grig");

        Box optionsBox = Box.createVerticalBox();
        optionsBox.add(snapToGridJCheckBox);
        optionsBox.add(showGridJCheckBox);
        optionsPanel.add(optionsBox);
    
        labelsPanel = new JPanel();
        
        xLabel = new JLabel("X:");
        yLabel = new JLabel("Y:");
        
        Box labelBox = Box.createVerticalBox();
        labelBox.add(xLabel);
        labelBox.add(yLabel);

        labelsPanel.add(labelBox);
        
        textsPanel = new JPanel();

        xTextField = new JTextField(3);
        yTextField = new JTextField(3);
        

        Box textBox = Box.createVerticalBox();
        textBox.add(xTextField);
        textBox.add(yTextField);;
        
        textsPanel.add(textBox);

        // Box xBox = Box.createHorizontalBox();
        // xBox.add(xLabel);
        // xBox.add(xTextField);
        // Box yBox = Box.createHorizontalBox();
        // yBox.add(yLabel);
        // yBox.add(yTextField);
        // Box textsBox = Box.createVerticalBox();
        // textsBox.add(xBox);
        // textsBox.add(yBox);
        // textsPanel.add(textsBox);
    
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1, 5, 5));
        
        buttons = new JButton[buttonNames.length];
        
        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttonsPanel.add(buttons[i]);
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        add(optionsPanel);
        add(labelsPanel);
        add(textsPanel);
        add(buttonsPanel);


    }

    
}