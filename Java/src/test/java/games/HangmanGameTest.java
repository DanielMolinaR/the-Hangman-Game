package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class HangmanGameTest {

    private HangmanGame hangmanGame;

    @BeforeEach
    public void setUp() { this.hangmanGame = new HangmanGame(); }

    @Test
    void testStartNewGame(){
        String word = "test";
        this.hangmanGame.newGame(word);
        assertEquals(word, this.hangmanGame.getWordToGuess());
        assertEquals(7, this.hangmanGame.getErrorLimit());
        assertTrue(this.hangmanGame.getAlreadyGuessed().isEmpty());
        assertTrue(this.hangmanGame.getAlreadyTried().isEmpty());
        assertTrue(guessIsInitialized(this.hangmanGame.getdisplayOfGuesses()));
    }
    
    private Boolean guessIsInitialized(String[] guesses){
        boolean isInitialized = true;
        if (guesses.length > 0) {
            for (String letter : guesses) {
                if (!letter.equals("_")) {
                    isInitialized = false;
                    break;
                }
            }
        } else isInitialized = false;
        return isInitialized;
    }

    @Test
    void playGame(){
        Game game = mock(HangmanGame.class);
        doNothing().when(game).play();
        game.play();

        verify(game, times(1)).play();
    }
}
