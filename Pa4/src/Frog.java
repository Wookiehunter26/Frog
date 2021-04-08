/**
 * Class Frog - Driver class for application. This class is complete. Do NOT add
 * any additional code.
 *
 * @author Michael L. Norton
 * @version 22 March 2021
 */
public class Frog {

    /**
     * The Game of Frog - Entry point.
     * 
     * @param args The command line arguments.
     */
    public static void main( String[] args ) {

        // -----------------------------------------------------------------
        // Create 2 players, send them to the game, and then start the
        // game
        // -----------------------------------------------------------------
        FrogPlayer human;
        FrogPlayer computer;
        FrogGame game;

        human = new FrogPlayer( "Human" );
        computer = new FrogPlayer( "Computer" );

        game = new FrogGame( human, computer );

        game.play();

    } // method main

} // class Frog
