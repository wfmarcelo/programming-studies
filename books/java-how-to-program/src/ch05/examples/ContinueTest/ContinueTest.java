// Fig. 5.14: ContinueTest.java
// continue statement terminating an iteration of a for statement.
package ch05.examples.ContinueTest;

public class ContinueTest {
    public static void main(String[] args) {
        for (int count = 1; count <= 10; count++) {
            if (count == 5) {
                continue;
            }

            System.out.printf("%d ", count);
        }

        System.out.printf("%nUsed continue to skipt printing 5%n");
    }
}
