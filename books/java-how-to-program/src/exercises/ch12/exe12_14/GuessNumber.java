// Exe. 12.14: GuessNumber.java
package ch12.exe12_14;

import java.awt.Color;
import java.security.SecureRandom;

/**
 * GuessNumber
 */
public class GuessNumber {

    private final SecureRandom randomNumbers;
    private int currentNumber;
    private int guessNumber;

    public GuessNumber() {
        randomNumbers = new SecureRandom();

        startGame();
    }

    public void startGame() {
        setCurrentNumber(1 + randomNumbers.nextInt(1000));
    }

    public void setGuessNumber(int guessNumber) {

        if (guessNumber < 0 || guessNumber > 1000)
            throw new IllegalArgumentException("Number must be 0-1000");

        this.guessNumber = guessNumber;
    }

    public boolean isGameOver() {
        if (guessNumber == currentNumber) {
            return true;
        }

        return false;
    }

    public String getGameStatus() {
        if (guessNumber < currentNumber)
            return guessNumber + " Too Low";
        else if (guessNumber > currentNumber)
            return guessNumber + " Too High";
        else
            return "Correct!";
    }

    public Color getColorIndicator() {

        if (isGameOver()) 
            return Color.GREEN;

        return new Color(getRedAmount(), 0, getBlueAmount());
    }

    private void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    private int getCurrentNumber() {
        return currentNumber;
    }

    private int getGuessNumber() {
        return guessNumber;
    }

    private int getProximityPercentual() {
        return Math.abs(getCurrentNumber() - getGuessNumber()) * 100 / 1000;
    }

    private int getBlueAmount() {
        getProximityPercentual();

        return getProximityPercentual() * 255 / 100;
    }

    private int getRedAmount() {
        return Math.abs(getBlueAmount() - 255);
    }

}