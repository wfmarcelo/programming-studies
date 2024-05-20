// Fig. 12.43: GridLayoutFrame.java
// GridLayout containing six buttons.
package ch12.examples.gridLayout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame implements ActionListener {

    private final JButton[] buttons;
    private static final String[] names = 
        { "one", "two", "three", "four", "five", "six" };
    private boolean toggle = true;
    private final Container container;
    private final GridLayout gridLayout1;
    private final GridLayout gridLayout2;

    public GridLayoutFrame() {
        super("GridLayout Demo");
        gridLayout1 = new GridLayout(2, 3, 5, 5);
        gridLayout2 = new GridLayout(3, 2);
        container = getContentPane();
        setLayout(gridLayout1);
        buttons = new JButton[names.length];

        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(this);
            add(buttons[i]);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (toggle)
            container.setLayout(gridLayout2);
        else
            container.setLayout(gridLayout1);

        toggle = !toggle;
        container.validate();
    }
    
}
