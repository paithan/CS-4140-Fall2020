/**
 * Models a single Red7 card.
 *
 * @author CS 4140 Class
 */
public class Card {

    //fields
    
    //the color of this card
    private String color;
    
    //the number of this card
    private int number;
    
    
    //constructors
    
    /**
     * Class constructors.
     *
     * @param color  The color of the card.
     * @param number  The number of this card.
     */
    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }
    
    
    //public methods
    
    /**
     * Gets the color.
     *
     * @return The color of this card.
     */
    public String getColor() {
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

} //end of Card class
