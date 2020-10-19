import java.lang.StringBuilder;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Represents a game of Nim.
 *
 * @author CS 4140 Fall 2020 class.
 */
public abstract class Nim {

    /**
     * Returns all the possible moves from this Nim game.
     */
    public abstract Collection<Nim> getMoves();
    
    /**
     * Returns the nimber value of a position.
     */
    public abstract int getNimber(); 
    
    /**
     * Returns whether there is a winning move from this game position.
     */
    public boolean hasWinningMove() {
        return this.getNimber() != 0;
    }

    
    //a single row in Nim
    private static class NimRow extends Nim {
        
        //the number of sticks in this row
        private int numSticks;
        
        //constructor
        public NimRow(int numSticks) {
            this.numSticks = numSticks;
        }
        
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.numSticks; i++) {
                builder.append("I");
            }
            return builder.toString();
        }
        
        @Override
        public Collection<Nim> getMoves() {
            Collection<Nim> moves = new ArrayList<Nim>();
            for (int sticks = 0; sticks < this.numSticks; sticks++) {
                Nim move = new NimRow(sticks);
                moves.add(move);
            }
            
            return moves;
        }
        
        @Override
        public int getNimber() {
            return numSticks;
        }
        
    
    } //end of NimRow
    
    
    //multiple rows in Nim
    private static class CompositeNim extends Nim {
    
        //the left hand child
        private Nim left;
        
        //the right hand child
        private Nim right;
        
        //constructor
        public CompositeNim(Nim left, Nim right) {
            this.left = left;
            this.right = right;
        }
        
        public String toString() {
            return this.left.toString() + "\n" + this.right.toString();
        }
        
        @Override
        public Collection<Nim> getMoves() {
            Collection<Nim> moves = new ArrayList<Nim>();
            
            //add the moves on the left-hand side
            Collection<Nim> leftMoves = this.left.getMoves();
            for (Nim leftMove : leftMoves) {
                Nim move = new CompositeNim(leftMove, this.right);
                moves.add(move);
            }
            
            //add the moves on the right-hand side
            Collection<Nim> rightMoves = this.right.getMoves();
            for (Nim rightMove : rightMoves) {
                Nim move = new CompositeNim(this.left, rightMove);
                moves.add(move);
            }
            
            return moves;
        }
        
        @Override
        public int getNimber() {
            return left.getNimber() ^ right.getNimber();
        }
    
    
    } //end of CompositeNim
    
    
    public static void main(String[] args) {
        
        /*Nim nim = new Nim(3, 5, 7);
        Nim nim = new Nim(new int[] {3, 5, 7});*/
        
        Nim nim = Nim.createNim(new int[] {3, 5, 7}); //this doesn't compile (yet)
    
        Nim top = new NimRow(3);
        Nim middle = new NimRow(5);
        Nim top2 = new CompositeNim(top, middle);
        Nim bottom = new NimRow(7);
        Nim all = new CompositeNim(top2, bottom);
        System.out.println("Wanna play a game?\n" + all.toString());
        System.out.println("Moves: ");
        for ( Nim move : all.getMoves()) {
            System.out.println("Move option:\n" + move);
            System.out.println("Is a winning move: " + (move.hasWinningMove() ? "Nope!" : "Yes!") + "\n");
        }
        
        int x = 5;
        int y = 6;
        System.out.println(x ^ y);
    }


} // end of Nim class
