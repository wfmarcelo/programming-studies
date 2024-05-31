// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.
package ch07.fig7_9_10_11;

/**
 * DeckOfCardsTest
 */
public class DeckOfCardsTest {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();

        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", myDeckOfCards.dealCard());

            if (i % 4 == 0)
                System.out.println();
        }
    }
    
}