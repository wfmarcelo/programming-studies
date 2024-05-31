// Exe. 12.12: TemperatureConversionFrame.java
// Program to convert from Fahrenheit to Celsius
package ch12.exe12_13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ch12.exe12_12.TemperatureConverter;

/**
 * TemperatureConversionFrame
 */
public class TemperatureConversionFrame extends JFrame {
    private static final String[] temperatures = 
        { "Fahrenheit", "Celsius", "Kelvin"};
    
    private final JComboBox<String> fromTempComboBox;
    private JTextField originalTemperatureTextField;
    
    private final JComboBox<String> toTempComboBox;
    private JTextField toTempTextField;
    private final JLabel equalsLabel;


    private final Box fromTempBox;
    private final Box toTempBox;

    private boolean updateComboBox = true;


    public TemperatureConversionFrame() {
        super("Temperature Converter");

        
        fromTempBox = Box.createVerticalBox();
        fromTempComboBox = new JComboBox<String>(temperatures);
        originalTemperatureTextField = new JTextField(5);

        fromTempBox.add(originalTemperatureTextField);
        fromTempBox.add(fromTempComboBox);

        equalsLabel = new JLabel("=");

        toTempBox = Box.createVerticalBox();
        toTempComboBox = new JComboBox<String>(temperatures);
        toTempComboBox.setSelectedIndex(1);
        toTempTextField = new JTextField(5);

        toTempBox.add(toTempTextField);
        toTempBox.add(toTempComboBox);

        originalTemperatureTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                   
                    try {
                        double convertedTemp = convertTemperature(
                            Double.parseDouble(event.getActionCommand()), 
                            fromTempComboBox.getSelectedItem().toString(), toTempComboBox.getSelectedItem().toString());
                        
                        toTempTextField.setText(String.format("%.2f", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        originalTemperatureTextField.setText("");
                    }
                }
            }
        );

        toTempTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        double convertedTemp = convertTemperature(
                            Double.parseDouble(event.getActionCommand()), 
                            toTempComboBox.getSelectedItem().toString(), fromTempComboBox.getSelectedItem().toString());
                        
                        originalTemperatureTextField.setText(String.format("%.2f", convertedTemp));
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value informed", "Error", JOptionPane.ERROR_MESSAGE);
                        toTempTextField.setText("");
                    }
                }
                
            }
        );

        fromTempComboBox.addItemListener(
            new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getItem() == toTempComboBox.getSelectedItem()) {
                        
                        if (updateComboBox) {
                            updateComboBox = false;
                            
                            if (toTempComboBox.getSelectedIndex() + 1 >= temperatures.length)
                                toTempComboBox.setSelectedIndex(toTempComboBox.getSelectedIndex() - 1);
                            else
                                toTempComboBox.setSelectedIndex(toTempComboBox.getSelectedIndex() + 1);

                            updateComboBox = true;
                        }
                    }
                }
                
            }
        );
        
        toTempComboBox.addItemListener(
            new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getItem() == fromTempComboBox.getSelectedItem()) {
                        if (updateComboBox) {
                            updateComboBox = false;
                            
                            if (fromTempComboBox.getSelectedIndex() + 1 >= temperatures.length)
                                fromTempComboBox.setSelectedIndex(fromTempComboBox.getSelectedIndex() - 1);
                            else
                                fromTempComboBox.setSelectedIndex(fromTempComboBox.getSelectedIndex() + 1);

                            updateComboBox = true;
                        }
                        
                    }
                }
                
            }
        );

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        add(fromTempBox);
        add(equalsLabel);
        add(toTempBox);
    }

    private double convertTemperature(double temp, String fromTemp, String toTemp) {
        
        if (fromTemp == "Fahrenheit" && toTemp == "Celsius")
            return TemperatureConverter.fahrenheitToCelsius(temp);
        else if (fromTemp == "Fahrenheit" && toTemp == "Kelvin")
            return TemperatureConverter.fahrenheitToKelvin(temp);
        else if (fromTemp == "Celsius" && toTemp == "Fahrenheit")
            return TemperatureConverter.celsiusToFahrenheit(temp);
        else if (fromTemp == "Celsius" && toTemp == "Kelvin")
            return TemperatureConverter.celsiusToKelvin(temp);
        else if (fromTemp == "Kelvin" && toTemp == "Celsius")
            return TemperatureConverter.kelvinToCelius(temp);
        else if (fromTemp == "Kelvin" && toTemp == "Fahrenheit")
            return TemperatureConverter.kelvinToFahrenheit(temp);

        return temp;
    }
    
}