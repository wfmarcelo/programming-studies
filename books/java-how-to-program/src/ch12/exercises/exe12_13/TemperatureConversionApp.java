package ch12.exercises.exe12_13;

import javax.swing.JFrame;

/**
 * TemperatureConversionApp
 */
public class TemperatureConversionApp {

    public static void main(String[] args) {
        TemperatureConversionFrame temperatureConversionFrame = 
            new TemperatureConversionFrame();

        temperatureConversionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperatureConversionFrame.setSize(350, 150);
        temperatureConversionFrame.setVisible(true);
    }
}