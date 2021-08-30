
/**
 * Memory game which user tries to match card values with a variety of topics
 * @author Michael Ching
 * 2/24/2020
 *
 */

import java.io.*;
import java.util.Scanner;

public class MemoryGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Array of type string 4x4 holding value of card
		String[][] cards = new String[4][4];

		// Array of type boolean 4x4 to hold the side of card shown
		boolean[][] side = new boolean[4][4];

		boolean allMatch = false;
		int cardOne = 0;
		int cardTwo = 0;

		readFile(cards, getFileChoice());

		shuffle(cards);

		displayBoard(cards, side);

		// while not all the cards are matched
		while (!allMatch) {

			System.out.println("Please enter choice:");
			cardOne = getChoice();

			// checks if the first card has not been flipped yet
			if (checkFlipped(cardOne, side) == false) {

				flipChoice(cardOne, side);
				displayBoard(cards, side);

			}

			// if the chosen card has been flipped already
			else {

				// until card chosen has not been flipped yet
				while (checkFlipped(cardOne, side)) {

					System.out.println("Location already entered");
					System.out.println("Please enter another choice:");
					cardOne = getChoice();

				}

				flipChoice(cardOne, side);
				displayBoard(cards, side);

			}

			// second card the user picks
			System.out.println("Please enter choice:");
			cardTwo = getChoice();

			// checks if the second card has not been flipped yet
			if (checkFlipped(cardTwo, side) == false) {

				flipChoice(cardTwo, side);
				displayBoard(cards, side);

			}

			// if the chosen card has been flipped already
			else {

				// until card chosen has not been flipped yet
				while (checkFlipped(cardTwo, side)) {

					System.out.println("Location already entered");
					System.out.println("Please enter another choice:");
					cardTwo = getChoice();

				}

				flipChoice(cardTwo, side);
				displayBoard(cards, side);

			}

			// checks if the value of cardOne matches the value of cardTwo
			if (isMatch(cardOne, cardTwo, cards)) {

				System.out.println("Match found!");

			}

			// the 2 chosen cards do not match and are flipped back to numbered side
			else {

				System.out.println("Not a match");
				flipChoice(cardOne, side);
				flipChoice(cardTwo, side);

			}

			// checks if all the sides have been flipped indicating all have been matched
			for (int i = 0; i < side.length; i++) {

				allMatch = true;

				for (int j = 0; j < side[0].length; j++) {

					// if any card is not flipped, it has not been matched yet, and not all cards
					// have been matched
					if (side[i][j] == false) {

						allMatch = false;
						break;

					}

				}

			}

			// if all cards have been matched, will check if user wants to play again,
			// restarting the whole game
			if (allMatch) {

				System.out.println("All matches have been made");
				System.out.println();
				System.out.println("1. Play Again.");
				System.out.println("2. Quit.");

				int playAgain = CheckInput.getIntRange(1, 2);

				// user wants to play again...reset the game
				if (playAgain == 1) {

					allMatch = false;
					readFile(cards, getFileChoice());
					shuffle(cards);

					// flip all cards back to numbered side
					for (int i = 0; i < side.length; i++) {

						for (int k = 0; k < side[0].length; k++) {

							side[i][k] = false;

						}

					}

					displayBoard(cards, side);

				}

			}

		}

	}

	/**
	 * Prints the menu for possible card values and gets the user's preference
	 * 
	 * @return the userChoice of what topic they want their card values to be
	 */
	public static int getFileChoice() {

		System.out.println("1. Letters");
		System.out.println("2. Numbers");
		System.out.println("3. Animals");
		System.out.println("4. Objects");
		System.out.println("Enter Choice:");

		int userChoice = CheckInput.getIntRange(1, 4);

		return userChoice;
	}

	/**
	 * Reads in the file based on the user's choice of topic for the cards and
	 * inserts them into a 4x4 array type string
	 * 
	 * @param cards An 4x4 Array of type string
	 * @param userChoice the file that contains the topic the user prefers
	 */
	public static void readFile(String[][] cards, int userChoice) {

		
			try {

				Scanner read = new Scanner(new File("letters.txt"));
				
				// wants topic to be letters
				if (userChoice == 1)
				{
					
					// reads file "letters.txt"
					read = new Scanner(new File("letters.txt"));
					
				}
				
				//wants topic to be numbers
				else if (userChoice == 2)
				{
					
					// reads file "numbers.txt"
					read = new Scanner(new File("numbers.txt"));
					
				}
				
				//wants topic to be animals
				else if(userChoice == 3)
				{
					
					//reads file "animals.txt"
					read = new Scanner(new File("animals.txt"));
					
				}
				
				// wants topic to be objects
				else if (userChoice == 4)
				{
					
					//reads file "objects.txt"
					read = new Scanner(new File("objects.txt"));
					
					
				}

				while (read.hasNext()) {

					// the row values for the 4x4 array
					for (int i = 0; i < cards.length; i++) {

						// the column values for the 4x4 array, increments by two to insert all the
						// values in doubles
						for (int j = 0; j < cards[0].length; j += 2) {

							String singleCard = read.nextLine();
							cards[i][j] = singleCard;

							// same value placed in doubles
							cards[i][j + 1] = singleCard;

						}

					}

				}
				read.close();

				/*
				 * for (int i = 0; i < cards.length; i++) { for (int k = 0; k < cards[0].length;
				 * k++) { System.out.print(cards[i][k]); } }
				 */

			} catch (FileNotFoundException fnf) {

				System.out.println("File Not found");

			}

	}

	/**
	 * Swaps the location of values by randomly selecting 2 indexes 100 times
	 * 
	 * @param cards An 4x4 Array of type string containing the values of the cards
	 */
	public static void shuffle(String[][] cards) {

		// shuffle 100 times by choosing 2 random indexes each time and swapping
		for (int i = 0; i < 100; i++) {

			int rowRandomOne = (int) (Math.random() * 4);
			int colRandomOne = (int) (Math.random() * 4);

			int rowRandomTwo = (int) (Math.random() * 4);
			int colRandomTwo = (int) (Math.random() * 4);

			// swap value at randomIndexOne with the value at randomIndexTwo
			String swap = cards[rowRandomOne][colRandomOne];
			cards[rowRandomOne][colRandomOne] = cards[rowRandomTwo][colRandomTwo];
			cards[rowRandomTwo][colRandomTwo] = swap;

		}

		/*
		 * System.out.println(); for (int i = 0; i < cards.length; i++) { for (int k =
		 * 0; k < cards[0].length; k++) { System.out.print(cards[i][k]); }
		 * System.out.println(); }
		 */

	}

	/**
	 * Displays the board, depending on the side, it will either show the cards
	 * value or its numbered position
	 * 
	 * @param cards An 4x4 Array of type string containing the values of the cards
	 * @param side  An 4x4 Array of type boolean indicating which side is shown
	 */
	public static void displayBoard(String[][] cards, boolean[][] side) {

		// iterates through the cards array
		for (int i = 0; i < cards.length; i++) {

			// prints the top half of the cards
			System.out.print("+----+");
			System.out.print("+----+");
			System.out.print("+----+");
			System.out.println("+----+");

			System.out.print("|    |");
			System.out.print("|    |");
			System.out.print("|    |");
			System.out.println("|    |");

			for (int k = 0; k < cards[0].length; k++) {

				// if the card is side up, the cards' value is displayed
				if (side[i][k] == true) {

					System.out.print("|" + cards[i][k] + "|");

				}

				// the card is down and shows its numbered position
				else {

					// convert the rows and columns from the loops to each numbered position to be
					// displayed
					int row = (i * 4);
					int column = ((k % 4) + 1);

					// add a space if position value is less than 10
					if (row + column < 10) {

						System.out.print("|  " + (row + column) + " |");

					}

					// removes a space if position value is greater than or equal to 10
					else {

						System.out.print("| " + (row + column) + " |");

					}

				}

			}

			// complete the rest of the card boxes
			System.out.println();
			System.out.print("|    |");
			System.out.print("|    |");
			System.out.print("|    |");
			System.out.println("|    |");

			System.out.print("+----+");
			System.out.print("+----+");
			System.out.print("+----+");
			System.out.println("+----+");

			System.out.println();
		}

	}

	/**
	 * Checks that user input is within the appropriate range and type
	 * 
	 * @return the user input of an int within the range of (1-16)
	 */
	public static int getChoice() {
		int userChoice = CheckInput.getIntRange(1, 16);

		return userChoice;
	}

	/**
	 * Flips the card to the opposite side of its current status
	 * 
	 * @param userChoice the card the user has choosen to flip
	 * @param cardSide   An 4x4 Array of type boolean indicating which side is shown
	 */
	public static void flipChoice(int userChoice, boolean[][] cardSide) {

		// converts the userChoice from its numbered position to its row value
		int row = (userChoice / 4);

		if (userChoice % 4 == 0) {

			row = ((userChoice / 4) - 1);

		}

		// converts the userChoice from its numbered position to its column value
		int column = (userChoice % 4);

		// cards' positional value is in the 3rd column
		if (column == 0) {

			column = 3;

		}

		// cards' column value is the positional value mod 4 minus one
		else {

			column -= 1;

		}

		// flip to card's numbered position side
		if (cardSide[row][column] == true) {

			cardSide[row][column] = false;

		}

		// flip to card's value side
		else {

			cardSide[row][column] = true;

		}

	}

	/**
	 * Compares the values of two cards to see if the cards match
	 * 
	 * @param cardOne the position of cardOne
	 * @param cardTwo the position of cardTwo
	 * @param cards An 4x4 Array of type string containing the values of the cards
	 * @return whether or not the cards match
	 */
	public static boolean isMatch(int cardOne, int cardTwo, String[][] cards) {

		boolean match = false;

		// converts cardOne from its numbered position to its row value
		int rowOne = (cardOne / 4);

		if (cardOne % 4 == 0) {

			rowOne = ((cardOne / 4) - 1);

		}

		// converts cardOne from its numbered position to its column value
		int columnOne = (cardOne % 4);

		// card's positional value is in the 3rd column
		if (columnOne == 0) {

			columnOne = 3;

		}

		// cards' column value is the positional value mod 4 minus one
		else {

			columnOne -= 1;

		}

		// converts cardTwo from its numbered position to its row value
		int rowTwo = (cardTwo / 4);

		if (cardTwo % 4 == 0) {

			rowTwo = ((cardTwo / 4) - 1);

		}

		// converts cardTwo from its numbered position to its column value
		int columnTwo = (cardTwo % 4);

		// cards' positional value is in the 3rd column
		if (columnTwo == 0) {

			columnTwo = 3;

		}

		// cards' column value is the positional value mod 4 minus one
		else {

			columnTwo -= 1;

		}

		// if the values of cardOne and cardTwo match
		if (cards[rowOne][columnOne] == cards[rowTwo][columnTwo]) {

			match = true;

		}

		return match;

	}

	/**
	 * Returns if the card has been flipped to show its value yet
	 * 
	 * @param userCard the position of the card the user has choosen
	 * @param cardSide An 4x4 Array of type boolean indicating which side is shown
	 * @return the boolean value of the cards' side that it is currently on
	 */
	public static boolean checkFlipped(int userCard, boolean[][] cardSide) {

		// converts userCard from its numbered position to its row value
		int row = (userCard / 4);

		if (userCard % 4 == 0) {

			row = ((userCard / 4) - 1);

		}

		// converts the userCard from its numbered position to its column value
		int column = (userCard % 4);

		// cards' positional value is in the 3rd column
		if (column == 0) {

			column = 3;

		}

		// cards' column value is the positional value mod 4 minus one
		else {

			column -= 1;

		}

		return (cardSide[row][column]);

	}
}
