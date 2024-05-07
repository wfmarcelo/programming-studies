// Fig. 5.5: Sum.java
// Summing integers with the for statement.
package ch05.examples.SumV1;

/**
 * Sum
 */
public class Sum {
    public static void main(String[] args) {
        int total = 0;

        for (int number = 2; number <= 20;number += 2) {
            total += number;
        }

        System.out.printf("Sum is %d%n", total);
    }
    
}