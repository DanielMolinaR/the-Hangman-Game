# The Hangman Game
## Words for guessing

# Instead of having a hardcoded array of words I decided to consume an dictionary API for 
# having a bigger batch of possible words and hide them from the user. To retrieve the words 
# is needed to have the requests library installes. For that you only have to run the command:
# pip install requests

# imports
import requests
import random
import time


### Data manipulation

# As the list of words retrieved come as a bytes class we can't access randomly to a word. 
# For that we need to transform the bytes class to list. First we need to parse the bytes class 
# to string with decode(). decode() returns all the bytes class as one only string with the following 
# format: '["abreact","abreacted","abreacting","abreaction"..."zyzzyvas","zzz"]'. As you can see the 
# string is not yet a list and cannot be casted to list easily. To parse the string to list we must 
# replace the '["]' characters for empty and then use the method split to split a string into a list 
# where each word is a list item where the separator is the coma.
def clean_response(words_retrieved):
    words_as_string = words_retrieved.decode()
    words_manipulated = words_as_string.replace('"', '').replace('[', '').replace(']','')
    return(words_manipulated.split(','))
def retrieve_list_of_words_from_api():
    # The API returns a list of 2.115.215 words
    response = requests.get("https://random-word-api.herokuapp.com/all")
    words_retrieved= response.content

    return clean_response(words_retrieved)


## Game

# The Hangman is a guessing game for two or more players. One player thinks of a word, phrase or sentence 
# and the other(s) tries to guess it by suggesting letters within a certain number of guesses. In this 
# game the computer is the one who is going to think of a word and the user is going to be the guesser. 
# The user will have 7 attempts to guess the word that the computer is thinking of.

# Variable declarations
global error_count
global display_of_guesses
global word_to_guess
global already_guessed
global already_tried
global error_limit

# The parameters we require to execute the game:
def global_variables_initialization():
    global error_count
    global display_of_guesses
    global word_to_guess
    global already_guessed
    global already_tried
    global error_limit

    list_of_words_to_guess = retrieve_list_of_words_from_api()
    word_to_guess = random.choice(list_of_words_to_guess)
    error_count = 0
    display_of_guesses = '_' * len(word_to_guess)
    already_guessed = []
    already_tried = []
    error_limit = 7

# Checks if the letter given by the user has been used before or not
def letter_used_before(guess):
    global already_guessed
    global already_tried

    if guess in already_guessed or guess in already_tried:
        return True
    else: False
    
# Update the global variables of the game for the next guessing round
def update_variables(guess):
    global display_of_guesses
    global word_to_guess
    global already_guessed

    already_guessed.extend([guess])
    temp_word = word_to_guess

    # Runs through the word until all the appareances of the letter guessed are covered
    while (guess in temp_word):
        guess_index = temp_word.find(guess)
        temp_word = temp_word[:guess_index] + " " + temp_word[guess_index + 1:]
        display_of_guesses = display_of_guesses[:guess_index] + guess + display_of_guesses[guess_index + 1:]

# gameplay logic
def play_game():
    global error_count
    global display_of_guesses
    global word_to_guess
    global already_tried

    print("This is the Hangman Word: " + display_of_guesses)
    user_guess = input("Enter your guess: \n")
    cleaned_guess = user_guess.strip()

    # Uncomment this to know the word
    # print(word_to_guess)

    if cleaned_guess.isnumeric():

      # If the user's input is a number It will ask again for a guess
      print("Invalid guess, try a new one\n")
      play_game()

    elif (cleaned_guess in word_to_guess):
      # If the user instead of guessing a letter has guessed the word
      if (cleaned_guess == word_to_guess):
          display_of_guesses = cleaned_guess
      elif (len(cleaned_guess) > 1):
          error_count += 1
          already_tried.extend([cleaned_guess])
      else:
          update_variables(cleaned_guess)

    # If the letter is incorrect but the user has used before It will ask again for a guess
    elif letter_used_before(cleaned_guess):
      print("Try another letter.\n")
      play_game()
    else:

      error_count += 1
      already_tried.extend([cleaned_guess])
# Returns the draw of the Hangman to print it through terminal
def update_hangman(error_count):
    hangman_to_draw = ("   _____ \n"
                        "  |      \n"
                        "  |      \n"
                        "  |      \n"
                        "  |      \n"
                        "  |      \n"
                        "  |      \n"
                        "__|__\n")
    
    draw_step = error_count

    if draw_step == 7:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |     | \n"
                            "  |     O \n"
                            "  |    /|\ \n"
                            "  |    / \ \n"
                            "__|__\n")
    if draw_step == 6:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |     | \n"
                            "  |     O \n"
                            "  |    /|\ \n"
                            "  |        \n"
                            "__|__\n")
    if draw_step == 5:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |     | \n"
                            "  |     O \n"
                            "  |     | \n"
                            "  |       \n"
                            "__|__\n")        
    if draw_step == 4:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |     | \n"
                            "  |     O \n"
                            "  |      \n"
                            "  |      \n"
                            "__|__\n")
    if draw_step == 3:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |     | \n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "__|__\n")
    if draw_step == 2:
        hangman_to_draw = ("   _____ \n"
                            "  |     | \n"
                            "  |     |\n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "__|__\n")
    if draw_step == 1:
        hangman_to_draw = ("   _____ \n"
                            "  |    | \n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "  |      \n"
                            "__|__\n")
    return hangman_to_draw

# Print the state of the game and the guesses
def display_game():
    global error_count
    global already_tried
    global error_limit

    hangman = update_hangman( error_count)
    print(hangman)    
    print(str(error_limit - error_count) + " guesses remaining!!!!\n")
    print("Letters already tried: " + str(already_tried))

def display_result():
    global error_count
    global error_limit
    global display_of_guesses
    global word_to_guess

    if error_count == error_limit: 
        print("Oh! You have lost!")
        print(update_hangman(error_count))
    elif word_to_guess == display_of_guesses:
        print("Congrats! You have won!")
    print("The word was " + word_to_guess.upper())

# Checks if you have won or lost
def has_finished():
    global error_count
    global error_limit
    global display_of_guesses
    global word_to_guess

    game_is_finished = False
    if (error_count == error_limit or word_to_guess == display_of_guesses):
        game_is_finished = True
    return game_is_finished

# Makes a binary question where the answer can only be yes or no
def make_binary_question(question):
    answer = input(question)
    answer_in_upper_case = answer.upper()
    if (answer_in_upper_case=="Y" or answer_in_upper_case=="YES"):
        return True
    elif(answer_in_upper_case == "N" or answer_in_upper_case == "NO"):
        return False
    else:
        print("Invalid answer. Try again.")
        return make_binary_question(question)


# main

print("\nWELCOME TO THE HANGMAN\n")
name = input("Enter your desired username: ")
print("Hello " + name + "!")
time.sleep(0.5)
print("The game is going to start!")

answer = make_binary_question("Are you ready? (Y = yes, N = no): ")

# Contnue playing until the user doesn't want to play more
while (answer):
  # Initialize to default the global variable. They would be initialized to default each round.
  global_variables_initialization()
  still_in_game = True

  # Continue playing until you have lost or won
  while(still_in_game):
      play_game()
      if (has_finished()):
          still_in_game = False
          display_result()
      else:
          display_game()
  answer = make_binary_question("Do you want to play again? (Y = yes, N = no): ")
print("Thanks for playing!")
