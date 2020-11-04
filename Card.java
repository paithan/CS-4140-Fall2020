import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
        //int difference = other.getNumber() - this.getNumber();
        int difference = this.getNumber() - other.getNumber();
        System.out.println("Comparing " + this + " to " + other + "...");
        if (difference != 0) {
            System.out.println("difference: " + difference);
            return difference;
        } else {
            difference = this.getColor().getValue() - other.getColor().getValue();
            System.out.println("difference: " + difference);
            return difference;
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
     * Returns a graphical JavaFX version of this.
     */
    public Node getNode() {
        StackPane node = new StackPane();
        
        //add the colored rectangle to the bottom
        Rectangle colorRect = new Rectangle(125, 175, this.color.getGuiColor());
        node.getChildren().add(colorRect);
        
        //add the text number on top
        Text cardNumberText = new Text(Integer.toString(this.number));
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        node.getChildren().add(cardNumberText);
        
        cardNumberText = new Text("\n\n\n\n\n\n\n\n\n\n" + this.color.getRule());
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 10.0));
        cardNumberText.setFill(Color.WHITE);
        node.getChildren().add(cardNumberText);
        
        return node;
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
