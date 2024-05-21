// Exe. 12.12: TemperatureConversionFrame.java
// Program to convert from Fahrenheit to Celsius
package ch12.exercises.exe12_13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch12.exercises.exe12_12.TemperatureConverter;

/**
 * TemperatureConversionFrame
 */
public class TemperatureConversionFrame extends JFrame {
    private static final String[] temperatures = 
        { "Fahrenheit", "Celsius", "Kelvin"};
    
    private final JComboBox<String> originalTempComboBox;
    private JTextField originalTemperatureTextField;
    
    private final JComboBox<String> convertedTempComboBox;
    private JTextField convertedTemperatureTextField;
    private final JLabel equalsLabel;


    private final Box originalTemperatureBox;
    private final Box convertedTemperatureBox;


    public TemperatureConversionFrame() {
        super("Temperature Converter");

        
        originalTemperatureBox = Box.createVerticalBox();
        originalTempComboBox = new JComboBox<String>(temperatures);
        originalTemperatureTextField = new JTextField(5);

        originalTemperatureBox.add(originalTemperatureTextField);
        originalTemperatureBox.add(originalTempComboBox);

        equalsLabel = new JLabel("=");

        convertedTemperatureBox = Box.createVerticalBox();
        convertedTempComboBox = new JComboBox<String>(temperatures);
        convertedTempComboBox.setSelectedIndex(1);
        convertedTemperatureTextField = new JTextField(5);

        convertedTemperatureBox.add(convertedTemperatureTextField);
        convertedTemperatureBox.add(convertedTempComboBox);

        originalTemperatureTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                   
                    try {
                        double convertedTemp = convertTemperature(
                            Double.parseDouble(event.getActionCommand()));
                        
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
                        double convertedTemp = convertTemperature(
                            Double.parseDouble(event.getActionCommand()));
                        
                        originalTemperatureTextField.setText(String.format("%.2f", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        convertedTemperatureTextField.setText("");
                    }
                }
                
            }
        );

        originalTempComboBox.addItemListener(
            new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getItem() == convertedTempComboBox.getSelectedItem()) {
                        if (convertedTempComboBox.getSelectedIndex() + 1 >= temperatures.length)
                            convertedTempComboBox.setSelectedIndex(convertedTempComboBox.getSelectedIndex() - 1);
                        else
                            convertedTempComboBox.setSelectedIndex(convertedTempComboBox.getSelectedIndex() + 1);
                    }
                }
                
            }
        );
        
        convertedTempComboBox.addItemListener(
            new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getItem() == originalTempComboBox.getSelectedItem()) {
                        if (originalTempComboBox.getSelectedIndex() + 1 >= temperatures.length)
                            originalTempComboBox.setSelectedIndex(originalTempComboBox.getSelectedIndex() - 1);
                        else
                            originalTempComboBox.setSelectedIndex(originalTempComboBox.getSelectedIndex() + 1);
                    }
                }
                
            }
        );

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        add(originalTemperatureBox);
        add(equalsLabel);
        add(convertedTemperatureBox);
    }

    private double convertTemperature(double temp) {
        if (originalTempComboBox.getSelectedItem() == "Fahrenheit" && 
            convertedTempComboBox.getSelectedItem() == "Celsius")
            temp = TemperatureConverter.fahrenheitToCelsius(
                Double.parseDouble(originalTemperatureTextField.getText()));
        else if (originalTempComboBox.getSelectedItem() == "Fahrenheit" && 
            convertedTempComboBox.getSelectedItem() == "Kelvin")
            temp = TemperatureConverter.fahrenheitToKelvin(
                Double.parseDouble(originalTemperatureTextField.getText()));
        else if (originalTempComboBox.getSelectedItem() == "Celsius" && 
            convertedTempComboBox.getSelectedItem() == "Fahrenheit")
            temp = TemperatureConverter.celsiusToFahrenheit(
                Double.parseDouble(originalTemperatureTextField.getText()));
        else if (originalTempComboBox.getSelectedItem() == "Celsius" && 
            convertedTempComboBox.getSelectedItem() == "Kelvin")
            temp = TemperatureConverter.celsiusToKelvin(
                Double.parseDouble(originalTemperatureTextField.getText()));
        else if (originalTempComboBox.getSelectedItem() == "Kelvin" && 
            convertedTempComboBox.getSelectedItem() == "celsius")
            temp = TemperatureConverter.kelvinToCelius(
                Double.parseDouble(originalTemperatureTextField.getText()));
        else if (originalTempComboBox.getSelectedItem() == "Kelvin" && 
            convertedTempComboBox.getSelectedItem() == "Fahrenheit")
            temp = TemperatureConverter.kelvinToFahrenheit(
                Double.parseDouble(originalTemperatureTextField.getText()));
        return temp;
    }
    
}