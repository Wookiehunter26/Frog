import java.util.Random;

/**
 * Class FrogDice - A pair of dice for a game of Frog.
 * 
 * Acknowledgments:I acknowledge that I have neither given nor received
 * assistance for this assignment except as noted below: N/A
 *
 * @author Michael Norton and Malachi Knight
 * @version PA4 ( April 7, 2021)
 */
public class FrogDice {


    // Declarations
    
    private int die1; // Stores the value (1-6) of die1.
    private int die2; // Stores the value (1-6) of die2.

    private Random rand;

    /**
     * Instantiate the Random object and initialize die1 and die2 to 0.
     */
    public FrogDice() {

        rand = new Random();
        die1 = 0;
        die2 = 0;

    } // constructor

    /**
     * Return true if both die are equal to 1, false otherwise.
     *
     * @return true if each die == 1, false otherwise
     */
    public boolean hasDoubleOnes() {

        return die1 * die2 == 1;

    } // method hasDoubleOnes

    /**
     * Return true if both die are equal (other then ones), false otherwise.
     *
     * @return true if the dies are equal, false otherwise
     */
    public boolean hasDoubles() {

        return die1 == die2 && die1 * die2 != 1;

    } // method hasDoubles

    /**
     * Roll each of the two die. 
     *
     * @return The total value of the roll
     */
    public int roll() {

        die1 = rand.nextInt( 6 ) + 1;
        die2 = rand.nextInt( 6 ) + 1;

        return die1 + die2;

    } // method rollDice

    /**
     * Output the value of the first die, a comma, and the value of the second
     * die.
     *
     * @return die1, die2 as String
     */
    public String toString() {

        return die1 + ", " + die2;

    } // method toString

} // class FrogDice
