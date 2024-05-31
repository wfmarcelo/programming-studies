// Fig. 6.6: RandomIntegers.java
// Shifted and scaled random integers.

package ch06.fig6_6;

import java.security.SecureRandom;

/**
 * RandomIntegers
 */
public class RandomIntegers {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();

        for (int counter = 1; counter <= 20; counter++) {
            int face = 1 + randomNumbers.nextInt(6);

            System.out.printf("%d  ", face);

            if (counter % 5 == 0)
                System.out.println();
        }
    }
    
}