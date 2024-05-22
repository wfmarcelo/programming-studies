package ch12.exercises.exe12_14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GuessNumberFrame
 */
public class GuessNumberFrame extends JFrame {
    private final GuessNumber guessNumber;

    private final JLabel informationJLabel;
    private JTextField guessNumberJTextField;
    private JLabel statusJLabel;

    private final JButton restartButton;

    private final JPanel contentPanel;

    public GuessNumberFrame(GuessNumber guessNumber) {
        super("Guess-the-Number Game");

        this.guessNumber = guessNumber;

        contentPanel = new JPanel();

        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        

        informationJLabel = new JLabel("I have a number between 1 and 1000." +
            " Can you guess my number?");

        guessNumberJTextField = new JTextField(3);


        guessNumberJTextField.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {

                    try {
                        guessNumber.setGuessNumber(Integer.parseInt(event.getActionCommand()));
                        
                        if (guessNumber.isGameOver()) {
                            guessNumberJTextField.setEditable(false);
                            restartButton.setEnabled(true);
                            restartButton.requestFocus();
                        }
    
                        contentPanel.setBackground(guessNumber.getColorIndicator());
                        statusJLabel.setText(guessNumber.getGameStatus());
                        
                    } catch (NumberFormatException e) {
                        statusJLabel.setText("You must enter an integer 1-1000. Try again!");
                        guessNumberJTextField.setText("");
                    }
                }
                
            }
        );

        restartButton = new JButton("Play again!");
        restartButton.setEnabled(false);

        restartButton.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    guessNumberJTextField.setText("");
                    guessNumberJTextField.setEditable(true);
                    statusJLabel.setText("Please enter your first guess.");

                    guessNumber.startGame();
                    contentPanel.setBackground(Color.LIGHT_GRAY);
                    guessNumberJTextField.requestFocus();
                }
                
            }
        );

        contentPanel.add(informationJLabel);
        contentPanel.add(guessNumberJTextField);
        contentPanel.add(restartButton);

        statusJLabel = new JLabel("Please enter your first guess.");

        add(contentPanel, BorderLayout.CENTER);
        add(statusJLabel, BorderLayout.SOUTH);
    }
    
}