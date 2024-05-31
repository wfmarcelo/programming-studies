package ch06.fig6_3;
// Fig. 6.3: MaximumFinder.java
// Programmer-declared method maximum with three double parameters.

import java.util.Scanner;

public class MaximumFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter three floating-point values separeted by spaces: ");
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        double result = maximum(number1, number2, number3);

        System.out.printf("Maximum is: %.2f%n", result);

        input.close();
    }

    public static double maximum(double x, double y, double z) {
        double maximumValue = x;

        if (y > maximumValue)
            maximumValue = y;

        if (z > maximumValue)
            maximumValue = z;

        return maximumValue;
    }
    
}