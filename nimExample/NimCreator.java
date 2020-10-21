
/**
 * An object that creates Nim positions.
 * @author CS 4140 Fall 2020 class.
 */
public abstract class NimCreator {
    
    /**
     * Creates and returns a new Nim object.
     */
    public abstract Nim createNim();
    
    /**
     * Creates the same board.
     */
    public static class SpecificNimGenerator extends NimCreator {
    
        //the piles that we will create from
        private int[] piles;
    
        /**
         * Class Constructor.
         */
        public SpecificNimGenerator(int[] piles) {
            this.piles = new int[piles.length];
            for (int i = 0; i < piles.length; i++) {
                this.piles[i] = piles[i];
            }
        }
        
        public Nim createNim() {
            Nim total = new NimRow(this.piles[0]);
            for (int i = 1; i < this.piles.length; i++) {
                Nim nimParent = new CompositeNim(total, new NimRow(this.piles[i]));
                total = nimParent;
            }
            return total;
        }
    
    } //end of SpecificNimGenerator
    
    public static void main(String[] args) {
        
        NimCreator generator = new SpecificNimGenerator(new int[] {3, 5, 7});
        
        Nim nim = generator.createNim();
    }

} //end of NimCreator.java
