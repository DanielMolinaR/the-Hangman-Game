import game_controller.*;
import games.HangmanGame;

import java.util.Scanner;

public class main {

    public static void main(String[] args){

        GameController gameController;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the GAME MACHINE!!!");
        System.out.println("Insert you username: ");

        String username = input.next();

        System.out.println("Which game do you want to play? (H = Hangman): ");
        String game = input.next();

        while(!game.equalsIgnoreCase("H")) {
            System.out.println("Sadly we only have the Hangman available");
            System.out.println("Which game do you want to play? (H = Hangman)");
            game = input.next();
        }

        gameController = new HangmanGameController(new HangmanGame());
        gameController.gamePlay(username);

        System.out.println("Thanks for playing!!!");
        System.exit(0);
    }

}
