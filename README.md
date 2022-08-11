# JavaHangMan
Hangman in Java

Hangman logic:

Get a word and hide it.
Split the word into an array.
get the player to guess a letter:

a) if the letter is in the array
       show the letter and add it to the guessed letters set

b) if it is not in the array
      show the letter, increment the guess counter and hangman UI, then add it to the guessed letters set

This loop continues until the player has guessed the word or has hanged the man
An enum will be used to check the state of the game
