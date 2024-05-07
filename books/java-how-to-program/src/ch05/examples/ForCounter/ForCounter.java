// Fig. 5.2: ForCounter.java
// Counter-controlled repetition with the for repetition statement.
package ch05.examples.ForCounter;

/**
 * ForCounter
 */
public class ForCounter {
    public static void main(String[] args) {
        for (int counter = 1; counter <= 10; counter++)
            System.out.printf("%d  ", counter);

        System.out.println();
    }
    
}