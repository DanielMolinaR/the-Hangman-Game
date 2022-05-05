# Python Hangman Game

This is the Hangman Game developed in Python using the advantages of the easy syntax and fast development of Python.

## Requirements

The game was developed in a [notebook](https://colab.research.google.com/drive/1fhDjqEZLXIsEKmIjr1HCPkX0dT_aRNaE?usp=sharing) in Google Collaborative but I also added the code in .py file and the requirements.txt.

- [Python 3.9.^](https://www.python.org/downloads/release/python-390/)

## Library

- [requests 2.26.0](https://pypi.org/project/requests/)

## Execution

- [Google Collaborative](https://colab.research.google.com/drive/1fhDjqEZLXIsEKmIjr1HCPkX0dT_aRNaE?usp=sharing). You will have to copy the notebook on your personal Drive and then run all the cells in order until you reach the last one which executes the game. Before running all the cells make sure you have the "requests" library installed.
- Local: For the execution in local you will have to run in your command line:
<center><pre><code>pip install -r requirements.txt</center></pre></code>
After that you will have to run the .py file with:
<center><pre><code>Python3 The_Hangman_Game.py</center></pre></code>

## Design

The game has been developed and designed in a simplified way to compare the time inversion in this development with the Java one.

### Interesting implementations

- I decided to consume the words from an external [source](https://random-word-api.herokuapp.com/all) via API.

## Improvements

- **Add test**
- **Object oriented design**: There is a lot of global variables needed. This guides me to need an OO solution.
- **Error handling**
