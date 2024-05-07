// Fig. 5.1: WhileCounter.java
// Coutner-controlled repetition with the while repetition statement.

package ch05.examples.WhileCounter;

/**
 * WhileCounter
 */
public class WhileCounter {

    public static void main(String[] args) {
        int counter = 1;

        while (counter <= 10) {
            System.out.printf("%d  ", counter);
            counter++;
        }

        System.out.println();
    }
}