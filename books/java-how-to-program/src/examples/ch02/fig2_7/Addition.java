package ch02.fig2_7;
// Fig. 2.7: Addition.java
// Addition program that inputs two numbers then displays their sum.
import java.util.Scanner;

public class Addition
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int number1, number2, sum;

        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        sum = number1 + number2;

        System.out.printf("Sum is %d%n", sum);

        input.close();
    }
}