// Fig. 7.7: RollDie.java
// Die-rolling program using arrays instead of switch.
package ch07.fig7_7;

import java.security.SecureRandom;

/**
 * RollDie
 */
public class RollDie {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] frequency = new int[7];

        for (int roll = 0; roll <= 6000000; roll++)
            ++frequency[1 + randomNumbers.nextInt(6)];

        System.out.printf("%s%10s%n", "Face", "Frequency");

        for (int face = 1; face < frequency.length; face++)
            System.out.printf("%4d%10d%n", face, frequency[face]);
    }
    
}