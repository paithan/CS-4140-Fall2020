import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

/**
 * Models a single color in Red7.
 *
 * @author CS 4140 Fall 2020 class.
 */
public abstract class CardColor {

    //the number value of the color
    private int value;

    
    //constructors
    
    //creates a new CardColor.
    protected CardColor(int value) {
        this.value = value;
    }
    

    //TODO: implement equals

    
    /**
     * Returns an int indicating whether this color is higher than other.
     *
     * @param other  The CardColor to compare this to.
     * @return       Negative if this color ranks higher than other, zero if they're the same color, and positive otherwise.
     */
    public int compareTo(CardColor other) {
        return other.getValue() - this.getValue();
    }
    
    //returns the value of this color as an integer
    protected int getValue() {
        return this.value;
    }
    
    
    /**
     * Returns cards from a palette fitting the rule.
     *
     * @param palette  A player's palette of cards.
     * @return       The subset of cards that fit this color's rule.
     */
    public abstract Collection<Card> getFittingCards(Collection<Card> palette);
    
    
    /**
     * Models the color Red in Red7.
     */
    public static class Red extends CardColor {
    
        public Red() {
            super(7);
        }
        
        @Override
        public Collection<Card> getFittingCards(Collection<Card> palette) {
            
            Card highest = Collections.max(palette);
            
            Collection<Card> collection = new ArrayList<Card>();
            
            collection.add(highest);
            
            return collection;
        }
    
        @Override
        public String toString() {
            return "Red";
        }
    
    } //end of Red class
    
    /**
     * Models the color Indigo in Red7.
     */
    public static class Indigo extends CardColor {
        
        public Indigo() {
            super(2);
        } 
        
        @Override
        public Collection<Card> getFittingCards(Collection<Card> palette) {
        
            
            //put all cards into a list, then sort it.
            List<Card> cardList = new ArrayList<Card>();
            for (Card card : palette) {
                cardList.add(card);
            }
            Collections.sort(cardList);
            
            //this will have the highest of each number
            List<Card> highest = new ArrayList<Card>();
            
            int currentNumber = 8;
            for (Card card : cardList) {
                int newNumber = card.getNumber();
                if (newNumber == currentNumber) {
                    //do nothing
                } else {
                    highest.add(card);
                    currentNumber = newNumber;
                }
            }
            
            //this will contain all the runs of consecutive numbers
            List<List<Card>> runs = new ArrayList<List<Card>>();
            List<Card> currentRun = new ArrayList<Card>();
            runs.add(currentRun);
            currentNumber = 8;
            for (Card card : highest) {
                int newNumber = card.getNumber();
                if (newNumber == currentNumber - 1) {
                    //still in previous run 
                    //currentRun.add(card);
                } else {
                    //finished the last run; here's another one
                    currentRun = new ArrayList<Card>();
                    runs.add(currentRun);
                }
                currentRun.add(card);
                currentNumber = newNumber;
            }
            
            //go through the runs to find the longest length
            int maxLength = 0;
            for (List<Card> run : runs) {
                int length = run.size();
                maxLength = Math.max(length, maxLength);
            }
            
            
            //return the biggest run 
            for (List<Card> run : runs) {
                if (run.size() == maxLength) {
                    return run;
                }
            }
            
            //code should never reach this point
            System.out.println("OH no!!!!  Something went wrong when picking the longest run!!!!!!");
            
            throw new RuntimeException("Oh no!!!! This should never happen, but I somehow failed to pick the longest run!!!!!!!!!!!");
            
            //return runs.get(0);
            
        }
    
        @Override
        public String toString() {
            return "Indigo";
        }
        
    } //end of Indigo class
    
    /**
     * Models the color Violet in Red7.
     */
    public static class Violet extends CardColor {
        
        /**
         * Constructor.
         */
        public Violet() {
            super(1);
        } 
        
        @Override
        public Collection<Card> getFittingCards(Collection<Card> palette) {
            Collection<Card> belowFour = new ArrayList<Card>();
            for (Card card : palette) {
                if (card.getNumber() < 4) {
                    belowFour.add(card);
                }
            }
            return belowFour;
        }
        
    
        @Override
        public String toString() {
            return "Violet";
        }
    
    } //end of Violet class
    
    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        CardColor red = new Red();
        CardColor indigo = new Indigo();
        CardColor violet = new Violet();
        
        
        int compare = red.compareTo(red);
        if (compare != 0) {
            System.out.println("red should compare evenly to itself, but instead we got: " + compare);
        } else {
            System.out.println("compareTo works!");
        }
        int value = red.getValue();
        if (value != 7) {
            System.out.println("The color red does not have value 7, but " + value + " instead.");
        } else {
            System.out.println("getValue works!");
        }
        
        Collection<Card> cards = new ArrayList<Card>();
        cards.add(new Card(red, 7));
        cards.add(new Card(red, 1));
        cards.add(new Card(indigo, 7));
        
        int testNumber = 0;
        Collection<Card> fitting = indigo.getFittingCards(cards);
        Card red7 = fitting.toArray(new Card[0])[0];
        assert fitting.size() == 1 && red7.equals(new Card(red, 7)) : "fitting is " + fitting + ", but should be [Red7]!";
        /*
        if (fitting.size() == 1 && red7.equals(new Card(red, 7))) {
            System.out.println("Test " + testNumber + " passes!");
        } else {
            System.out.println("Test " + testNumber + " fails!");
            System.out.println("Result of test " + testNumber + ": " + fitting);
            System.out.println("Should be:            [Red7]");
        }
        testNumber ++;*/
        
        cards.add(new Card(red, 7));
        fitting = indigo.getFittingCards(cards);
        red7 = fitting.toArray(new Card[0])[0];
        assert fitting.size() == 1 && red7.equals(new Card(red, 7)) : "fitting is " + fitting + ", but should be [Red7]!";
        /*
        if (fitting.size() == 1 && red7.equals(new Card(red, 7))) {
            System.out.println("Test " + testNumber + " passes!");
        } else {
            System.out.println("Test " + testNumber + " fails!");
            System.out.println("Result of test " + testNumber + ": " + fitting);
            System.out.println("Should be:            [Red7]");
        }
        testNumber ++;
        */
        
        fitting = indigo.getFittingCards(new ArrayList<Card>());
        assert fitting.size() == 0: "fitting is " + fitting + ", but should be []!";
        /*
        if (fitting.size() == 0) {
            System.out.println("Test " + testNumber + " passes!");
        } else {
            System.out.println("Test " + testNumber + " fails!");
            System.out.println("Result of test " + testNumber + ": " + fitting);
            System.out.println("Should be:            []");
        }
        testNumber ++;
        */
        
        cards = new ArrayList<Card>();
        cards.add(new Card(red, 2));
        cards.add(new Card(indigo, 3));
        cards.add(new Card(red, 5));
        fitting = indigo.getFittingCards(cards);
        assert fitting.size() == 2 && fitting.contains(new Card(red, 2)) && fitting.contains(new Card(indigo, 3)) : "fitting is " + fitting + "!";
        
        
        cards = new ArrayList<Card>();
        cards.add(new Card(indigo, 3));
        cards.add(new Card(red, 5));
        cards.add(new Card(red, 2));
        cards.add(new Card(indigo, 6));
        fitting = indigo.getFittingCards(cards);
        assert fitting.size() == 2 && fitting.contains(new Card(red, 5)) && fitting.contains(new Card(indigo, 6)) : "fitting is " + fitting + "!";
        
        cards = new ArrayList<Card>();
        cards.add(new Card(indigo, 3));
        cards.add(new Card(red, 5));
        cards.add(new Card(red, 2));
        cards.add(new Card(indigo, 6));
        cards.add(new Card(indigo, 1));
        cards.add(new Card(indigo, 2));
        fitting = indigo.getFittingCards(cards);
        assert fitting.size() == 3 && fitting.contains(new Card(red, 2)) 
                                   && fitting.contains(new Card(indigo, 3)) 
                                   && fitting.contains(new Card(indigo, 1)): "fitting is " + fitting + "!";
        
        
        //tests for Violet's rule!
        cards = new ArrayList<Card>();
        cards.add(new Card(indigo, 3));
        cards.add(new Card(red, 5));
        cards.add(new Card(red, 2));
        cards.add(new Card(indigo, 6));
        cards.add(new Card(indigo, 1));
        cards.add(new Card(indigo, 2));
        fitting = violet.getFittingCards(cards);
        assert fitting.size() == 4 && fitting.contains(new Card(red, 2)) 
                                   && fitting.contains(new Card(indigo, 3)) 
                                   && fitting.contains(new Card(indigo, 2)) 
                                   && fitting.contains(new Card(indigo, 1)): "fitting is " + fitting + "!";
                                   
        
        
        cards = new ArrayList<Card>();
        cards.add(new Card(violet, 3));
        cards.add(new Card(red, 5));
        cards.add(new Card(red, 2));
        cards.add(new Card(indigo, 6));
        cards.add(new Card(indigo, 1));
        cards.add(new Card(indigo, 2));
        fitting = violet.getFittingCards(cards);
        assert fitting.size() == 4 && fitting.contains(new Card(red, 2)) 
                                   && fitting.contains(new Card(violet, 3)) 
                                   && fitting.contains(new Card(indigo, 2)) 
                                   && fitting.contains(new Card(indigo, 1)): "fitting is " + fitting + "!";
        
        
        cards = new ArrayList<Card>();
        cards.add(new Card(red, 5));
        cards.add(new Card(indigo, 6));
        cards.add(new Card(indigo, 4));
        cards.add(new Card(indigo, 7));
        fitting = violet.getFittingCards(cards);
        assert fitting.size() == 0: "fitting is " + fitting + "!";
        
        System.out.println("All tests worked!");
    }
    

} //end of CardColor.java

































