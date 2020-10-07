/**
 * Models a single Red7 card.
 *
 * @author CS 4140 Class
 */
public class Card implements Comparable<Card> {

    //fields
    
    //the color of this card
    private CardColor color;
    
    //the number of this card
    private int number;
    
    
    //constructors
    
    /**
     * Class constructors.
     *
     * @param color  The color of the card.
     * @param number  The number of this card.
     */
    public Card(CardColor color, int number) {
        this.color = color;
        this.number = number;
    }
    
    /**
     * constructor
     *
     * @param color  The color of the card as a String.
     * @param number  The number of this card.
     */
    public Card(String color, int number) {
        this.number = number;
        if (color.equalsIgnoreCase("Red")) {
            this.color = new CardColor.Red();
        } else if (color.equalsIgnoreCase("Indigo")) {
            this.color = new CardColor.Indigo();
        } else if (color.equalsIgnoreCase("Violet")) {
            this.color = new CardColor.Violet();
        } else {
            throw new RuntimeException("Illegal color for Card Constructor: " + color);
        }
    }
    
    //implements a max comparator
    @Override
    public int compareTo(Card other) {
        int difference = other.getNumber() - this.getNumber();
        if (difference != 0) {
            return difference;
        } else {
            return other.getColor().getValue() - this.getColor().getValue();
        }
    }
    
    
    //public methods
    
    /**
     * Gets the color.
     *
     * @return The color of this card.
     */
    public CardColor getColor() {
        return this.color;
    }
    
    /**
     * Gets the number.
     *
     * @return  The number of this card.
     */
    public int getNumber() {
        return this.number;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        try {
            Card other = (Card) obj;
            return this.equals(other);
        } catch (ClassCastException e) {
            return false;
        }
    }
    
    /**
     * Determines whether this card equals another.
     *
     * @param other  The other card to test.
     * @return       Whether this equals the other card.
     */
    public boolean equals(Card other) {
        return this.color.equals(other.color) && (this.number == other.number);
    }
    
    @Override
    public String toString() {
        return this.getColor().toString() + this.getNumber();
    }

} //end of Card class
