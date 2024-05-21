// Exe. 12.12: TemperatureConversionFrame.java
// Program to convert from Fahrenheit to Celsius
package ch12.exercises.exe12_12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TemperatureConversionFrame
 */
public class TemperatureConversionFrame extends JFrame {
    private final JLabel originalTemperatureLabel;
    private JTextField temperatureTextField;
    private JLabel convertedTemperatureLabel;

    private final JPanel optionsPanel;

    public TemperatureConversionFrame() {
        super("Temperature Converter");

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 1, 5, 5));
        
        originalTemperatureLabel = new JLabel("Fahrenheit:");
        temperatureTextField = new JTextField(5);

        convertedTemperatureLabel = new JLabel();

        optionsPanel.add(originalTemperatureLabel);
        optionsPanel.add(temperatureTextField);
        optionsPanel.add(convertedTemperatureLabel);
        
        temperatureTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                   
                    try {
                        double convertedTemp = TemperatureConverter.fahrenheitToCelsius(
                            Double.parseDouble(temperatureTextField.getText()));
                        
                        convertedTemperatureLabel.setText(String.format("%.2f Celsius", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        temperatureTextField.setText("");
                    }
                }
            }
        );

        add(optionsPanel, BorderLayout.CENTER);
    }
    
}