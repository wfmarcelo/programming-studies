package ch02.exe2_16;

// Exe. 2.16: Program.java
// Comparing Integers: displays the larger number of two.

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;

        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        if (number1 == number2)
            System.out.println("These numbers are equal");

        if (number1 > number2)
            System.out.printf("%d is larger%n", number1);

        if (number1 < number2)
            System.out.printf("%d is larger%n", number2);

        input.close();
    }
}
