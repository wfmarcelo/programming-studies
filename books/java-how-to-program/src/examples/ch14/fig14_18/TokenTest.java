// Fig. 14.18: TokenTest.java
// StringTokenizer object used to tokenize strings.
package ch14.fig14_18;

import java.util.Scanner;

public class TokenTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence and press Enter");
        String sentence = scanner.nextLine();

        String[] tokens = sentence.split(" ");
        System.out.printf("Number of elements: %d%nThe tokens are:%n", 
            tokens.length);

        for (String token : tokens) 
            System.out.println(token);
    }
}
