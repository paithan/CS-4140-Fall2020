import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Models a single color in Red7.
 *
 * @author CS 4140 Fall 2020 class.
 */
public abstract class CardColor {

    //TODO: implement equals

    
    /**
     * Returns an int indicating whether this color is higher than other.
     *
     * @param other  The CardColor to compare this to.
     * @return       Negative if this color ranks higher than other, zero if they're the same color, and positive otherwise.
     */
    public abstract int compareTo(CardColor other);
    
    
    /**
     * Returns cards from a palette fitting the rule.
     *
     * @param cards  A player's palette of cards.
     * @return       The subset of cards that fit this color's rule.
     */
    public abstract Collection<Card> getFittingCards(Collection<Card> cards);
    
    
    //returns the numeric value of this color
    protected abstract int getValue();
    
    
    public static class Red extends CardColor {
    
        public Red() {
            //do nothing.
        }
        
        @Override
        public int compareTo(CardColor other) {
            
            return other.getValue() - this.getValue();
        }
        
        
        protected int getValue() {
            return 7;
        }
        
        public Collection<Card> getFittingCards(Collection<Card> palette) {
            
            Card highest = Collections.max(palette);
            
            Collection<Card> collection = new ArrayList<Card>();
            
            collection.add(highest);
            
            return collection;
        }
    
    } //end of Red class
    

} //end of CardColor.java
