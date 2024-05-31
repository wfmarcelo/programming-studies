package ch12.exe12_9;

import javax.swing.JFrame;

/**
 * CalculatorDemo
 */
public class CalculatorDemo {

    public static void main(String[] args) {
        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setSize(300,250);
        calculatorFrame.setVisible(true);
    }
}