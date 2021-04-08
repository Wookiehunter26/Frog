/**
 * Class FrogPlayer - A player for a game of Frog.
 * 
 * Acknowledgments:I acknowledge that I have neither given nor received
 * assistance for this assignment except as noted below: N/A
 *
 * @author Michael Norton and Malachi Knight
 * @version PA4 ( April 7, 2021)
 */
public class FrogPlayer {

    public static final int WINNER = 100; // number of points to win

    private int current; // Player's score for the current roll
    private int score; // Player's total score.
    private int turnScore; // Player's score for the current turn

    private FrogDice dice; // Player's dice
    private String name; // Player's name.

    /**
     * Set player's name, instantiate the dice, and initialize the player's
     * scores to 0.
     *
     * @param nameArg The name of the player
     */
    public FrogPlayer( String nameArg ) {

        name = nameArg;
        dice = new FrogDice();
        turnScore = 0;
        score = 0;
        current = 0;

    } // method FrogPlayer (constructor)

    /**
     * Displays the human's or computer's turn.
     * 
     * @return takeTurn
     */
    public String takeTurn() {

        return "Roll = (" + dice.toString() + "), Roll Points = " + this.current
                        + ", Turn Points = " + this.turnScore
                        + " , Total Points = " + this.score;
    } // method takeTurn

    /**
     * Return the value of the most recent roll of the dice.
     *
     * @return the most recent roll of the dice
     */
    public int getCurrent() {
        if ( !dice.hasDoubleOnes() ) {
            this.current = 0;
        }
        return this.current;

    } // method getCurrentScore

    /**
     * Return the dice object.
     *
     * @return the FrogDice
     */
    public FrogDice getDice() {

        return dice;

    } // method getDice

    /**
     * Return the total score for the user.
     *
     * @return the total score
     */
    public int getScore() {

        return this.score;

    } // method getTotalScore.

    /**
     * Set score.
     * 
     * @param score.
     */
    public void setScore( int score ) {

        this.score = score;
    } // method setScore

    /**
     * Return the score for the the current turn.
     *
     * @return the turn score
     */
    public int getTurnScore() {

        return this.turnScore;
    } // method getTurnScore

    /**
     * Set TurnScore.
     * 
     * @param turnScore.
     */
    public void setTurnScore( int turnScore ) {

        // this.turnScore = this.turnScore + this.current;
        this.turnScore = turnScore;
    } // method setTurnScore

    /**
     * Return true if the player has won, false otherwise.
     *
     * @return boolean
     */
    public boolean hasWon() {

        return this.score >= 100;

    } // method hasWon

    /**
     * Reset the turn score to 0. This method should be called at the beginning
     * (or end) of each turn.
     */
    public void resetTurnScore() {

        turnScore = 0;
    } // method resetTurnScore

    /**
     * Roll the dice once. 
     *
     * @return false if the player rolls double 1s, true otherwise.
     */
    public boolean rollDice() {

        int temp = dice.roll();

        if ( dice.hasDoubles() ) {
            temp *= 2;
        }

        this.current = temp;
        this.turnScore += temp;
        this.score += temp;

        return !dice.hasDoubleOnes();
    } // method rollDice

    /**
     * Resets all values on double ones.
     */
    public void resetAll() {

        current = 0;
        turnScore = 0;
        score = 0;

    } // method resetAll

    /**
     * Return the player's name.
     * 
     * @return the player's name
     */
    public String toString() {

        return name;

    } // method toString

} // class FrogPlayer
