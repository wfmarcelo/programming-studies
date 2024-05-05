package ch03.exercises.gui03_01;
// Exe. Gui. 3.1: Addition.java
// Addition program that inputs two numbers then displays their sum.
import javax.swing.JOptionPane;

public class Addition
{
    public static void main(String[] args)
    {
        int number1 = Integer.parseInt(
            JOptionPane.showInputDialog("Enter first integer:"));
        
        int number2 = Integer.parseInt(
            JOptionPane.showInputDialog("Enter second integer:"));

        int sum = number1 + number2;

        String message = String.format("%d + %d = %d", number1, number2, sum);

        JOptionPane.showMessageDialog(null, message);
    }
}