// Exe. 12.11: PrinterFrame.java
package ch12.exercises.exe12_11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * PrinterFrame
 */
public class PrinterFrame extends JFrame {
    private final JLabel printerLabel;
    private final JTextArea printerTextArea;

    private final JCheckBox imageCheckBox;
    private final JCheckBox textCheckBox;
    private final JCheckBox codeCheckBox;

    private final JLabel printQualityLabel;
    private final JComboBox<String> printQualityComboBoxs;
    private static final String[] printQualityNames = 
        {"High", "Standard", "Low" };

    private final JRadioButton selectionRadioButton;
    private final JRadioButton allRadioButton;
    private final JRadioButton appleRadioButton;
    private final ButtonGroup optionsGroup;

    private final JCheckBox printToFileCheckBox;

    private final JButton[] buttons;
    private static final String[] buttonNames = 
        { "OK", "Cancel", "Setup...", "Help" };

    private final JTextArea typeTextArea;
    private final JTextArea selectionTextArea;

    private final JPanel buttonsPanel;
    private final JPanel optionsPanel;

    public PrinterFrame() {
        super("Printer");

        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BorderLayout());

        printerLabel = new JLabel("Printer: MyPrinter");

        Box optionsBox = Box.createHorizontalBox();

        printerTextArea = new JTextArea(4,5);

        Box typeBox = Box.createVerticalBox();

        imageCheckBox = new JCheckBox("Image");
        textCheckBox = new JCheckBox("Text");
        codeCheckBox = new JCheckBox("Code");

        typeBox.add(imageCheckBox);
        typeBox.add(textCheckBox);
        typeBox.add(codeCheckBox);

        typeTextArea = new JTextArea(4, 3);

        Box selectionBox = Box.createVerticalBox();

        selectionRadioButton = new JRadioButton("Selection", false);
        allRadioButton = new JRadioButton("All", true);
        appleRadioButton = new JRadioButton("Applet", false);
        optionsGroup = new ButtonGroup();
        optionsGroup.add(selectionRadioButton);
        optionsGroup.add(allRadioButton);
        optionsGroup.add(appleRadioButton);
        
        selectionBox.add(selectionRadioButton);
        selectionBox.add(allRadioButton);
        selectionBox.add(appleRadioButton);

        selectionTextArea = new JTextArea(4, 5);
        
        optionsBox.add(printerTextArea);
        optionsBox.add(typeBox);
        optionsBox.add(typeTextArea);
        optionsBox.add(selectionBox);
        optionsBox.add(selectionTextArea);

        Box printerQualityBox = Box.createHorizontalBox();

        printQualityLabel = new JLabel("Print Quality:");
        printQualityComboBoxs = new JComboBox<String>(printQualityNames);

        printToFileCheckBox = new JCheckBox("Print to File");

        printerQualityBox.add(printQualityLabel);
        printerQualityBox.add(printQualityComboBoxs);
        printerQualityBox.add(printToFileCheckBox);


        optionsPanel.add(printerLabel, BorderLayout.NORTH);
        optionsPanel.add(optionsBox, BorderLayout.CENTER);
        optionsPanel.add(printerQualityBox, BorderLayout.SOUTH);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(buttonNames.length, 1, 5, 10));

        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttonsPanel.add(buttons[i]);
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        add(optionsPanel);
        add(buttonsPanel);

        

    }
    
}