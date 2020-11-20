/**
 * Represents the game (ruleset) Elephants and Rhinos.  The Left player moves the Elephants, the Right player moves the Rhinos.
 * 
 * @author Kyle Burke <paithanq@gmail.com>
 * 
 */
//package something;
 
import java.lang.*;
import java.io.*;
import java.util.*;

public class ElephantsAndRhinos extends CombinatorialGame {

    //instance variables
    
    private ArrayList<String> spaces;
    
    //constants
    
    /**
     * The String that indicates an Elephant.
     */
    public static final String ELEPHANT = "E";
    
    /**
     * The String that indicates a Rhino.
     */
    public static final String RHINO = "R";
    
    /**
     * The String that indicates neither an elephant nor a rhino.
     */
    public static final String EMPTY = " ";
    
    /** Constructors **/
    
    /**
     * Creates a 
     *
     * @param spaces  An ArrayList of the different positions of pachyderms.  Each element must be either "E", "R", or " ".
     * @throws IllegalArgumentException  If any element in spaces is not a legal string.
     */
    public ElephantsAndRhinos(ArrayList<String> spaces) {
        this.spaces = new ArrayList<String>();
        for (String pachyderm : spaces) {
            if (pachyderm.length() != 1 || !(ELEPHANT + RHINO + EMPTY).contains(pachyderm)) {
                throw new IllegalArgumentException("Argument contains " + pachyderm + ", which is not a legal string for a space!");
            }
            this.spaces.add(pachyderm);
        }
    }
    
    //public methods
    
    //@override 
    public Collection<CombinatorialGame> getOptions(int player) {
        Collection<CombinatorialGame> options = new ArrayList<CombinatorialGame>();
        
        for (int i = 0; i < this.spaces.size(); i++) {
            if (this.spaces.get(i).equals(ELEPHANT) && player == CombinatorialGame.LEFT) {
                if (i + 1 < this.spaces.size() && this.spaces.get(i+1).equals(EMPTY)) {
                    //add a move for Left
                    ElephantsAndRhinos option = (ElephantsAndRhinos) this.clone();
                    option.spaces.set(i, EMPTY);
                    option.spaces.set(i+1, ELEPHANT);
                    options.add(option);
                }
            } else if (this.spaces.get(i).equals(RHINO) && player == CombinatorialGame.RIGHT) {
                if (i > 0 && this.spaces.get(i-1).equals(EMPTY)) {
                    //add a move for Right
                    ElephantsAndRhinos option = (ElephantsAndRhinos) this.clone();
                    option.spaces.set(i, EMPTY);
                    option.spaces.set(i-1, RHINO);
                    options.add(option);
                }
            }
        }
        
        return options;
    }
    
    /**
     * Returns the name of this game.
     * 
     * @return  The String "Elephants and Rhinos".
     */
    public static String getName() {
        return "Elephants and Rhinos";
    }
    
    /**
     * Returns the spaces.
     *
     * @return  An ArrayList representation of this, with Strings for each element.  (This is a deep copy of the list used in the constructor.)
     */
    public ArrayList<String> getSpaces() {
        ArrayList<String> spacesCopy = new ArrayList<String>();
        for (String pachyderm : this.spaces) {
            spacesCopy.add(pachyderm);
        }
        return spacesCopy;
    }
    
    /**
     * Returns a deep clone of this.
     *
     * @return  A deep clone of this position.
     */
    public CombinatorialGame clone() {
        return new ElephantsAndRhinos(this.spaces);
    }
    
    //@override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        ElephantsAndRhinos other = (ElephantsAndRhinos) obj;
        return this.equals(other);
    }
    
    //@override
    public boolean equals(CombinatorialGame other) {
        return this.equals((Object) other);
    }
    
    /**
     * Returns whether this equals another position.
     *
     * @param other     Another position.
     * @return          Whether this position equals the other.  This should compare identity, *NOT* equivalence.
     */
    public boolean equals(ElephantsAndRhinos other) {
         return this.spaces.equals(other.spaces);
    }
    
    
    //@override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String pachyderm : this.spaces) {
            builder.append(" " + pachyderm + " |");
        }
        if (builder.length() == 1) {
            builder.append("]");
        } else {
            builder.setCharAt(builder.length() - 1, ']');
        }
        return builder.toString();
    }
    
    /**
     * Generator for Elephants and Rhinos positions.
     */
    public static class PositionBuilder implements PositionFactory<ElephantsAndRhinos> {
        //max length of the board
        private int maxBoardSize;
        
        //probability each space will have an elephant or rhino
        private double density;
        
        /**
         * Constructor
         * @param maxBoardSize  The maximum number of spaces in the board.
         * @param density  The probability that each space will have an elephant or rhino.
         */
        public PositionBuilder(int maxBoardSize, double density) {
            this.maxBoardSize = maxBoardSize;
            this.density = density;
        }
        
        /**
         * Generate a position!
         *
         * @return  A new ElephantsAndRhinos position.
         */
        public ElephantsAndRhinos getPosition() {
            Random random = new Random();
            int boardSize = random.nextInt(this.maxBoardSize + 1);
            ArrayList<String> board = new ArrayList<String>();
            for (int i = 0; i < boardSize; i++) {
                if (random.nextDouble() < this.density) {
                    //add a pachyderm
                    if (random.nextDouble() < .5) {
                        board.add(ELEPHANT);
                    } else {
                        board.add(RHINO);
                    }
                } else {
                    //add an empty space
                    board.add(EMPTY);
                }
            }
            return new ElephantsAndRhinos(board);
        }
    
    } //end of ElephantsAndRhinos.PositionBuilder
    
    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        PositionFactory<ElephantsAndRhinos> factory = new ElephantsAndRhinos.PositionBuilder(20, .3);
        ElephantsAndRhinos game = factory.getPosition();
        System.out.println("game: " + game);
        System.out.println("\nOptions for Left from \n" + game + ": \n - - - - - - - - - - - - - - - - - - - ");
        for (CombinatorialGame option : game.getOptions(CombinatorialGame.LEFT)) {
            System.out.println(option + "; ");
        }
        System.out.println("\nOptions for Right from \n" + game + ": \n - - - - - - - - - - - - - - - - - - - ");
        for (CombinatorialGame option : game.getOptions(CombinatorialGame.RIGHT)) {
            System.out.println(option + "; ");
        }
    }
   
   
} //end of ElephantsAndRhinos.java