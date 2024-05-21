// Exe. 12.9: CalculatorFrame.java
// Calculator frame.
package ch12.exercises.exe12_9;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CalculatorFrame
 */
public class CalculatorFrame extends JFrame {
    private final JButton[] buttons;
    private static final String[] buttonNames = 
        { "7", "8", "9", "/", "4", "5", "6", "*",
          "1", "2", "3", "-", "0", ".", "=", "+"};
    private JTextField inputTextField;
    private final JPanel inputPanel;
    private final JPanel buttonsPanel;
    
    public CalculatorFrame() {
        super("Calculator");

        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputTextField = new JTextField();
        inputTextField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        inputPanel.add(inputTextField, BorderLayout.CENTER);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 4, 4));

        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttonsPanel.add(buttons[i]);        
        }

        setLayout(new BorderLayout());

        add(inputPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);



    }
    
}