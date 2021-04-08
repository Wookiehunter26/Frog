import java.util.Scanner;

/**
 * FrogGame - This class handles all aspect of playing the game of "Frog". All
 * interaction with the user (the human), including getting input and showing
 * output should happen here.
 * 
 * Acknowledgments: I acknowledge that I have neither given nor received
 * assistance for this assignment except as noted below: N/A
 *
 * @author Michael Norton and Malachi Knight
 * @version PA4 ( April 7, 2021)
 */
public class FrogGame {

    public static final int COMPUTER = 0;
    public static final int HUMAN = 1;
    public static final int MAX = 20;

    private FrogPlayer human;
    private FrogPlayer computer;

    private Scanner scan;

    /**
     * Explicit value constructor for FrogGame.
     *
     * @param humanArg A FrogPlayer (human)
     * @param computerArg A FrogPlayer (computer)
     */
    public FrogGame( FrogPlayer humanArg, FrogPlayer computerArg ) {

        human = humanArg;
        computer = computerArg;

        scan = new Scanner( System.in );

    } // method FrogGame (constructor)

    /**
     * This method begins the game. 
     * 
     */
    public void play() {

        FrogPlayer winner;

        showGreeting();
        winner = playTheGame();
        showWinner( winner );

    } // method play

    /****************************** private methods ***************************/

    /**
     * 
     * @return the winner of the game (computer or human)
     */
    private FrogPlayer playTheGame() {

        while ( human.getScore() < 100 && computer.getScore() < 100 ) {

            System.out.println( "" );
            System.out.println( "Player: Human Total Points = "
                            + human.getScore() );
            playAgain();
            // if ( human.getScore() < 100 ) {
            // comTurn();
            // }

        }

        if ( human.hasWon() ) {

            return human;

        } else {
            return computer;
        }

    }

    /**
     * Cycles between human and computer.
     */
    private void playAgain() {

        String answer = "";
        System.out.print( "Roll again (Y/N)? " );
        answer = scan.nextLine();

        if ( human.getScore() < 100 && ( ( answer.toLowerCase().equals( "yes" )
                        || answer.toLowerCase().equals( "y" ) ) ) ) {

            if ( !human.rollDice() ) {
                human.resetAll();
                System.out.println( human.takeTurn() );
                System.out.println( "" );
                comTurn();
            } else {
                System.out.println( human.takeTurn() );
            }

            playAgain();

        } else if ( human.getScore() < 100
                        && ( answer.toLowerCase().equals( "no" ) || answer
                                        .toLowerCase().equals( "n" ) ) ) {

            human.resetTurnScore();
            computer.resetTurnScore();

            System.out.println( "Player: Human Total Points = "
                            + human.getScore() );
            System.out.println( "" );

            comTurn();

        } else if ( human.getScore() >= 100 ) {
            System.out.println( "" );
        } else {
            playAgain();
        }

    }

    /**
     * Starts the computer's turn.
     */
    private void comTurn() {

        System.out.println( "Player: Computer Total Points = "
                        + computer.getScore() );
        while ( computer.getTurnScore() < MAX && computer.getScore() < 100 ) {
            if ( !computer.rollDice() ) {
                computer.resetAll();
                System.out.println( computer.takeTurn() );
                playAgain();
            } else {
                System.out.println( computer.takeTurn() );
            }
        }

        System.out.println( "Player: Computer Total Points = "
                        + computer.getScore() );
        System.out.println( "" );
    }

    /**
     * Show a greeting to the user.
     */
    private void showGreeting() {

        System.out.println( "Welcome to the \"Game of Frog\"" );
        System.out.println( "" );
        System.out.println( "You will be playing against the computer. "
                        + "Your goal is to be the first\r\n"
                        + "to reach 100 points by rolling a pair of dice. "
                        + "You can roll as many times\r\n"
                        + "as you wish, but you will lose your turn a"
                        + " well as all of your points if\r\n"
                        + "you roll snake-eyes (2 1's). If you roll "
                        + "any other doubles (e.g., 2 6s), \r\n"
                        + "your points will be doubled for that roll. "
                        + "You can give up your turn to \r\n"
                        + "the computer at any time.  To ensure fairness, "
                        + "the computer will give up \r\n"
                        + "the dice once it has accumulated 20 "
                        + "or more points." );
        System.out.println( "" );
        System.out.println( "Good luck!!" );

    }

    /**
     * Show the winner of the game (winner is an alias for either the human or
     * computer player.
     * 
     * @param winner The winner of the game (computer or human)
     */
    private void showWinner( FrogPlayer winner ) {

        System.out.println( "Winner is: " + winner.toString() );
    }

} // class FrogGame
