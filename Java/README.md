# Java Hangman Game

This is the Hangman Game developed in Java using the advantages of OOP.

## Requirements

- [Java11](https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html)

## Libraries

- [JUnit 4.13.2](https://mvnrepository.com/artifact/junit/junit/4.13.2)
- [Random WOrd Generator 1.1.0](https://github.com/Dhiraj072/random-word-generator) Sadly this library initialize a slf4j logger and It prints the inizalitation output.
- [Mockito 4.0.0](https://mvnrepository.com/artifact/org.mockito/mockito-inline/4.0.0)

## Execution

Reload the maven project and run the main class.

## Design

The development of the project is more focused for OO. This makes the prokect be more like a Game Machine where you can have different games. In my case I will only have the Hangman Game. To reach the implementation of a Game Machina I have used Polymorphism. Thanks to it I can add a new game easily and without reflecting any change or impact on the actual code.

### Interesting implementation decisions

- I've decided to user an external library to generate randomly the words.
- **Drawer** is the class in charge of drawing the board, in our case the Hangman.
- **HangmangGameController and HangmangGame**. The HangmanGameController manages the steps of the game and the HangmanGame manages the game logic. It has been designed like this for future implementations like it could be the AdvancedHangmanGame or another different game.

## Improvements

- **Add cache memory**: WOuld be nice to store the game from the users.
- **Change the Hangman Drawer**: The Hangman Drawer would be better if it has state or conditions to draw the hangman.
- **Improve testing**
- **Error management**

