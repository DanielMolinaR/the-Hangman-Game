package games;

import drawers.Drawer;
import drawers.HangmanDrawer;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame implements Game{

    // Variable declarations
    private int errorLimit;
    private int errorCount;
    private String wordToGuess;
    private ArrayList<String> alreadyGuessed;
    private ArrayList<String> alreadyTried;
    private String[] displayOfGuesses;
    private final Drawer drawer = new HangmanDrawer();

    // Gettters
    public String getWordToGuess() {
        return this.wordToGuess;
    }

    public int getErrorLimit() {
        return errorLimit;
    }

    public ArrayList<String> getAlreadyGuessed() {
        return alreadyGuessed;
    }

    public ArrayList<String> getAlreadyTried() {
        return alreadyTried;
    }

    public String[] getdisplayOfGuesses() {
        return displayOfGuesses;
    }

    @Override
    public Boolean isFinished() {
        String guess = convertStringArrayToString(displayOfGuesses);
        return wordToGuess.equals(guess) || errorCount == errorLimit;
    }

    @Override
    public void newGame(String wordToGuess) {
        this.errorLimit = 7;
        this.errorCount = 0;
        this.wordToGuess = wordToGuess;
        this.alreadyGuessed = new ArrayList<>();
        this.alreadyTried = new ArrayList<>();
        this.displayOfGuesses = new String[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            this.displayOfGuesses[i] = "_";
        }
    }

    @Override
    public void play(){
        System.out.println("The Hangman word is: " + convertStringArrayToString(displayOfGuesses));

        // If you want to know the word unccoment the next line
        // System.out.println(wordToGuess);

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your guess: ");
        String guess = input.next();
        String cleanedGuess = guess.strip().toLowerCase();

        if (isNotNumeric(cleanedGuess) && letterNotUsedBefore(cleanedGuess)) {
            if (wordToGuess.contains(cleanedGuess)){
                if (cleanedGuess.equals(wordToGuess)) {
                    displayOfGuesses = wordToGuess.split("");
                } else {
                    updateGame(cleanedGuess);
                }
            } else {
                errorCount ++;
                this.alreadyTried.add(guess);
            }
        } else {
            System.out.println("Invalid input. Try again.");
            this.play();
        }
    }

    private Boolean isNotNumeric(String input){
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    
    private Boolean letterNotUsedBefore(String guess) {
        return !alreadyTried.contains(guess) && !alreadyGuessed.contains(guess);
    }

    private void updateGame(String guess){
        alreadyGuessed.add(guess);
        String[] tempWordToGuess = wordToGuess.split("");
        for (int i = 0; i < tempWordToGuess.length; i++){
            String letter = tempWordToGuess[i];
            if (guess.equals(letter)) {
                this.displayOfGuesses[i] = guess;
            }
        }
    }

    @Override
    public void displayGame() {
        this.drawer.draw(errorCount);
        System.out.println("The words that you already tried are: " + alreadyTried.toString());
        System.out.println("You have " + (errorLimit-errorCount) + " remaining guesses!!!");

    }

    @Override
    public void displayResult() {
        if (wordToGuess.equals(convertStringArrayToString(displayOfGuesses))) {
            System.out.println("\nCONGRATULATION YOU HAVE WON!!!!!\n");
        } else {
            System.out.println("\nOh... You have lost....\n");
        }
        System.out.println("The word was: " + wordToGuess.toUpperCase() + "!!!");
    }

    private static String convertStringArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str);
        return sb.substring(0, sb.length());
    }
}
