// Fig. 13.7: ShowColors2JFrame.java
// Choosing colors with JColorChooser.
package ch13.examples.fig13_7_8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ch13.examples.fig13_5_6.ColorJPanel;

public class ShowColors2JFrame extends JFrame {
    private final JButton changeColorJButton;
    private Color color = Color.LIGHT_GRAY;
    private final JPanel colorJPanel;

    public ShowColors2JFrame() {
        super("Using JColorChooser");

        colorJPanel = new JPanel();
        colorJPanel.setBackground(color);

        changeColorJButton = new JButton("Change Color");
        changeColorJButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    color = JColorChooser.showDialog(
                        ShowColors2JFrame.this, "Choose a color", color);

                    if (color == null) 
                        color = Color.LIGHT_GRAY;    
                    
                        colorJPanel.setBackground(color);
                }
                
            }
        );

        add(colorJPanel, BorderLayout.CENTER);
        add(changeColorJButton, BorderLayout.SOUTH);

        setSize(400, 130);
        setVisible(true);
    }
}
