
/**
 * An object that creates Nim positions.
 * @author CS 4140 Fall 2020 class.
 */
public abstract class NimCreator {
    
    /**
     * Creates and returns a new Nim object.
     */
    public abstract Nim createNim();
    
    
    public static void main(String[] args) {
        
        NimCreator generator = new Nim.SpecificNimGenerator(new int[] {3, 5, 7});
        
        Nim nim = generator.createNim();
    }

} //end of NimCreator.java
