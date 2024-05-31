// Exe. 12.11: PrinterDemo.java

package ch12.exe12_11;

import javax.swing.JFrame;

/**
 * PrinterDemo
 */
public class PrinterDemo {

    public static void main(String[] args) {
        PrinterFrame printerFrame = new PrinterFrame();
        printerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printerFrame.setSize(450, 150);
        printerFrame.setVisible(true);
    }
}