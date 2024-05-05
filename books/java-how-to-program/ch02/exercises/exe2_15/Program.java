// Exe. 2.15: Program.java
// Arithmetic: Program take takes two integers from user
// and calculate and prints the sum, product, difference and quotient

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;

        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        System.out.printf("%d + %d = %d%n", 
            number1, number2, number1 + number2);

        System.out.printf("%d * %d = %d%n", 
            number1, number2, number1 * number2);

        System.out.printf("%d - %d = %d%n", 
            number1, number2, number1 - number2);

        System.out.printf("%d / %d = %d%n", 
            number1, number2, number1 / number2);
    }
}
