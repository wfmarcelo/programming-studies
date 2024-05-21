// Exe. 12.12: TemperatureConversionFrame.java
// Program to convert from Fahrenheit to Celsius
package ch12.exercises.exe12_12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
    private JTextField originalTemperatureTextField;
    private final JLabel convertedTemperatureLabel;
    private JTextField convertedTemperatureTextField;
    private final JLabel equalsLabel;


    private final Box originalTemperatureBox;
    private final Box convertedTemperatureBox;


    public TemperatureConversionFrame() {
        super("Temperature Converter");

        
        originalTemperatureBox = Box.createVerticalBox();
        originalTemperatureLabel = new JLabel("Fahrenheit:");
        originalTemperatureTextField = new JTextField(5);

        originalTemperatureBox.add(originalTemperatureLabel);
        originalTemperatureBox.add(originalTemperatureTextField);

        equalsLabel = new JLabel("=");

        convertedTemperatureBox = Box.createVerticalBox();
        convertedTemperatureLabel = new JLabel("Celsius");
        convertedTemperatureTextField = new JTextField(5);

        convertedTemperatureBox.add(convertedTemperatureLabel);
        convertedTemperatureBox.add(convertedTemperatureTextField);

        
        originalTemperatureTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                   
                    try {
                        double convertedTemp = TemperatureConverter.fahrenheitToCelsius(
                            Double.parseDouble(originalTemperatureTextField.getText()));
                        
                        convertedTemperatureTextField.setText(String.format("%.2f", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        originalTemperatureTextField.setText("");
                    }
                }
            }
        );

        convertedTemperatureTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        double convertedTemp = TemperatureConverter.celsiusToFahrenheit(
                            Double.parseDouble(convertedTemperatureTextField.getText()));
                        
                        originalTemperatureTextField.setText(String.format("%.2f", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        convertedTemperatureTextField.setText("");
                    }
                }
                
            }
        );

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        add(originalTemperatureBox);
        add(equalsLabel);
        add(convertedTemperatureBox);
    }
    
}