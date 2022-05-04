package games;

public interface Game {

    void newGame(String randonWord);

    /**
     * Executes the concrete gameplay of the game
     */
    void play();

    /**
     * Checks if the running game is finished
     * @return Boolean
     */
    Boolean isFinished();

    /**
     * Display through terminal how is the game going
     */
    void displayGame();

    /**
     * Display the final result of the game
     */
    void displayResult();
}
