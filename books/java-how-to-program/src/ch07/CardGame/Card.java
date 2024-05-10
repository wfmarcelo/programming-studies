// Fig. 7.9: Card.java
// Card class represents a playing card.
package ch07.CardGame;

/**
 * Card
 */
public class Card {
    private final String face;
    private final String suit;

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
    
}