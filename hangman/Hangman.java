/*
 * This class represents a Hangman game
 * 
 * @author William Horton - CS 152-03
 */

package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import homework4.LinkedList;

public class Hangman {

  /*
   * <p> Hangman Game - represents a Hangman game</p>
   */
  public static void main(String[] args) {

    // Load LinkedList with dictionary file and catch FileNotFoundException

    LinkedList list = new LinkedList("0");
    try {
      // Change to file path
      File file = new File(
          "E:\\OneDrive - CCSU\\Shared Eclipse Folder\\CS152\\src\\hangman\\wordlist10000.txt");
      Scanner fileScanner = new Scanner(file);
      fileScanner.nextLine();
      String nextWord = null;
      while (fileScanner.hasNextLine()) {
        nextWord = fileScanner.nextLine();
        if (5 <= nextWord.length() && nextWord.length() <= 12) {
          list.add(nextWord);
        }
      }
      fileScanner.close();
    } catch (FileNotFoundException fileNotFound) {
      fileNotFound.printStackTrace();
    } //
    // System.out.println(list);

    // Find random word and create a character array out of the word
    Random generator = new Random();
    char[] selectedWord = list.getIndexData(generator.nextInt(list.size())).toCharArray();

    // Fill display word with '_' characters
    char[] displayWord = new char[selectedWord.length];
    for (int index = 0; index < selectedWord.length; index++) {
      displayWord[index] = '_';
    }

    // Scanner object
    Scanner scan = new Scanner(System.in);

    // Tracks the amount of user errors
    int errors = 0;

    // Entry message
    System.out.println("Welcome to Hangman!");

    // boolean for gamewon
    boolean gameWon = false;

    // Game turn loop
    while (errors < 7 && !gameWon) {

      // Draw the hangman based on the amount of turns passed
      hangmanPrint(errors);
      System.out.println();

      // Print display word
      for (int index = 0; index < displayWord.length; index++) {
        System.out.print(displayWord[index] + " ");
      }
      System.out.println();

      // Check if user inputed letter's length is equal to 1 to avoid invalid input
      boolean turnContinue = false;
      String userLetter = null;
      while (!turnContinue) {
        System.out.println("Enter a letter: ");
        userLetter = scan.nextLine();
        if (userLetter.length() == 1) {
          turnContinue = true;
        } else {
          System.out.println("Input only a single character. ");
        }
      }

      // check selected word for character user inputed
      char userCharacter = userLetter.charAt(0);

      boolean foundLetter = false;
      for (int index = 0; index < selectedWord.length; index++) {
        if (selectedWord[index] == userCharacter) {
          if (displayWord[index] == userCharacter) {
            System.out.println(
                "You already inputted that correct character. You are not penalized however. ");
          }
          displayWord[index] = userCharacter;
          foundLetter = true;
        }
      }

      // if the letter is not found, progress the hangman
      if (!foundLetter) {
        errors++;
      }

      // Check for a game win
      boolean containsUnderscore = false;

      for (int index = 0; index < displayWord.length; index++) {
        if (displayWord[index] == '_') {
          containsUnderscore = true;
        }
      }
      gameWon = !containsUnderscore;
    }


    // Print final hangman
    hangmanPrint(errors);
    System.out.println();

    // Print display word
    for (int index = 0; index < displayWord.length; index++) {
      System.out.print(displayWord[index] + " ");
    }
    System.out.println();



    // Print win or lose message
    if (gameWon == true) {
      System.out.println("You Won, congrats!");

    } else {
      System.out.println("You didn't complete the word in time, you lost!");
      System.out.println("The correct word is \'" + String.valueOf(selectedWord) + "\'.");
    }

    scan.close();

  }



  /*
   * <p> hangmanPrint method - prints out the possible hangmans depending on the amount of errors
   * the player has made</p>
   */
  public static void hangmanPrint(int gameTurn) {


    // Each case represents the amount of errors a user has
    switch (gameTurn) {
      case 0: {
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      ");
        System.out.println("     |       ");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 1: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |       ");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 2: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |       |");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 3: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |      \\|");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 4: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |      \\|/");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 5: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |      \\|/");
        System.out.println("     |       |");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 6: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |      \\|/");
        System.out.println("     |       |");
        System.out.println("     |      / ");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }
      case 7: {
        System.out.println("\n\n");
        System.out.println("      _______");
        System.out.println("     |/      |");
        System.out.println("     |      (_)");
        System.out.println("     |      \\|/");
        System.out.println("     |       |");
        System.out.println("     |      / \\");
        System.out.println("     |");
        System.out.println("    _|___");
        break;
      }

    }

  }


}


