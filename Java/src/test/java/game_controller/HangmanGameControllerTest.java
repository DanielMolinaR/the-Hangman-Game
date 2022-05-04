package game_controller;

import games.HangmanGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class HangmanGameControllerTest {

    private HangmanGameController hangmanGameController;

    @BeforeEach
    public void setUp() { this.hangmanGameController = new HangmanGameController(new HangmanGame()); }

    @Test
    void checkContructor(){
        assertNotNull(this.hangmanGameController.getGame());
    }

    @Test
    void gamePlay(){
        GameController controller = mock(HangmanGameController.class);
        doNothing().when(controller).gamePlay(isA(String.class));
        controller.gamePlay("test");

        verify(controller, times(1)).gamePlay( "test");
    }

}
