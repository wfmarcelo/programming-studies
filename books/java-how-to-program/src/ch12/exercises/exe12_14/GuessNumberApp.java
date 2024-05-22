package ch12.exercises.exe12_14;

import javax.swing.JFrame;

/**
 * GuessNumberApp
 */
public class GuessNumberApp {

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        GuessNumberFrame guessNumberFrame = new GuessNumberFrame(guessNumber);

        guessNumberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessNumberFrame.setSize(400,100);
        guessNumberFrame.setVisible(true);
    }
}