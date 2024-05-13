package ch02.exercises.exe2_06;

// Exe. 2.6: Program.java
// Input three variables and calculate their product.
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int x;
        int y;
        int z;
        int result;

        System.out.print("Enter first integer: ");
        x = input.nextInt();

        System.out.print("Enter second integer: ");
        y = input.nextInt();

        System.out.print("Enter third integer: ");
        z = input.nextInt();

        result = x * y * z;

        System.out.printf("Product is %d%n", result);

        input.close();
    }
}