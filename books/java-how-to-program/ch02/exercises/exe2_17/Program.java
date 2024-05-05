// Exe. 2.17: Program.java
// Arithmetic, Smallest and largest.

import java.util.Scanner;

public class Program 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;
        int number3;
        int sum;
        int average;
        int product;
        int smallest;
        int largest;

        System.out.print("Enter first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        System.out.print("Enter third integer: ");
        number3 = input.nextInt();

        sum = number1 + number2 + number3;
        average = sum / 3;
        product = number1 * number2 * number3;

        smallest = largest = number1;

        if (number2 > largest)
            largest = number2;

        if (number3 > largest)
            largest = number3;

        if (number2 < smallest)
            smallest = number2;
        
        if (number3 < smallest)
            smallest = number3;

        System.out.printf("%d + %d + %d = %d%n", 
            number1, number2, number3, sum);
            
        System.out.printf("(%d + %d + %d)/ 3 = %d%n", 
            number1, number2, number3, average);
            
        System.out.printf("%d * %d * %d = %d%n", 
            number1, number2, number3, product);

        System.out.printf("%d is smallest%n", smallest);
        System.out.printf("%d is largest%n", largest);

    }
}
