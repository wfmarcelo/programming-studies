// Fig. 11.8: AssertTest.java
// Checking with assert that a value is within range
package ch11.examples.assertTest;

import java.util.Scanner;

public class AssertTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 10: ");
        int number = input.nextInt();

        assert (number >= 0 && number <= 10) : "bad number: " + number;

        System.out.printf("you entered %d%n", number);
    }
}
