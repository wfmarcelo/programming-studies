// Fig. 5.7: DoWhileTest.java
// do...while repetition statement.
package ch05.examples.DoWhileTest;

/**
 * DoWhileTest
 */
public class DoWhileTest {
    public static void main(String[] args) {
        int counter = 1;

        do {
            System.out.printf("%d  ", counter);
            counter++;
        } while (counter <= 10);

        System.out.println();
    }
    
}