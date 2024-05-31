package ch12.exe12_10;

import javax.swing.JFrame;

/**
 * ColorSelectDemo
 */
public class ColorSelectDemo {

    public static void main(String[] args) {
        ColorSelectFrame colorSelectFrame = new ColorSelectFrame();
        colorSelectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSelectFrame.setSize(300,100);
        colorSelectFrame.setVisible(true);
    }
}