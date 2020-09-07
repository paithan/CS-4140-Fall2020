import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

/**
 * Models a deck of Red7 cards.
 *
 * @author CS4140 Fall 2020 class.
 */
public class Deck {

    //fields
    private List<Card> cards; 
    
    
    //constuctors
    
    /**
     * Class constructor.  Creates a new deck of cards.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
        String[] colors = new String[] {"Indigo", "Violet"};
        for (String color : colors) {
            for (int i = 1; i < 8; i++) {
                Card card = new Card(color, i);
                this.cards.add(card); 
            }
        }
        Collections.shuffle(this.cards);
    }
    
    
    //methods
    
    
    /**
     * Deals a card.
     *
     * @return  The next card in the deck, which is also removed from the deck.
     */
    public Card dealCard() {
        return this.cards.remove(this.cards.size() - 1);
    }
    
    


} //end of Deck class
