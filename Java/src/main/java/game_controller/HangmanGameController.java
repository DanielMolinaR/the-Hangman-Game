package game_controller;

import games.Game;
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;
import java.util.Scanner;

public class HangmanGameController implements GameController{

    private final Game game;

    Scanner input = new Scanner(System.in);

    public HangmanGameController(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    @Override
    public void gamePlay(String username){
        System.out.println("WELCOME " + username + " TO THE HANGMAN!!!");
        System.out.println("The game is about to start");
        Boolean playing = makeBinaryQuestion("Are you ready? (Y = yes, N = no): ");

        if (playing) {
            this.game.newGame(RandomWordGenerator.getRandomWord().toLowerCase());
            while (!this.game.isFinished()) {
                this.game.play();
                this.game.displayGame();
            }
        }

        if (playing) {
            this.game.displayResult();
            Boolean continuePlaying = makeBinaryQuestion("Do you want to play again? (Y = yes, N = no): ");
            if (continuePlaying) this.gamePlay(username);
        }
    }

    private Boolean makeBinaryQuestion(String question){
        System.out.println(question);
        String answer = input.next();
        if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")) return true;
        else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("NO")) return false;
        else return makeBinaryQuestion(question);
    }

}
