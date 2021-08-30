/**
 * 
 */

/**
 * Class to represent a player
 * 
 * @author michaelching
 *
 */
public class Player {

	// player points
	private int points;

	// an array of 3 dices
	private Die[] myDice = new Die[3];

	/**
	 * Constructor
	 */
	public Player() {

		for (int i = 0; i < 3; i++) {

			myDice[i] = new Die(6);

		}

	}

	/**
	 * Sorts the dices by their values using bubble sort
	 */
	public void sort() {

		/*
		 * for(int i = 0; i < myDice.length; i++) {
		 * 
		 * int lowest = i;
		 * 
		 * for(int j = i+1; j < myDice.length; j++) {
		 * 
		 * if(myDice[i].compareTo( myDice[j] ) > 0) {
		 * 
		 * lowest = j;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * Die d = myDice[i]; myDice[i] = myDice[lowest]; myDice[lowest] = d;
		 * 
		 * }
		 * 
		 * 
		 */

		// no object swaps
		boolean swapped = false;

		do {

			swapped = false;

			for (int i = 0; i < myDice.length - 1; i++) {

				// the current dice is of a larger value than the dice ahead in the array
				if (myDice[i].compareTo(myDice[i + 1]) > 0) {

					// swaps the dices
					Die d = myDice[i];
					myDice[i] = myDice[i + 1];
					myDice[i + 1] = d;
					swapped = true;

				}

			}
		}
		// if there was a value swapped, continue
		while (swapped);

	}

	/**
	 * Checks if there are pairs in the array of dices
	 * 
	 * @return a boolean of whether or not there are pairs in the array
	 */
	public boolean pairs() {

		// no pairs
		boolean pairs = false;

		for (int i = 0; i < myDice.length; i++) {

			for (int j = i + 1; j < myDice.length; j++) {

				// if the values of two dices match
				if (myDice[i].equals(myDice[j])) {

					pairs = true;

				}

			}

		}

		return pairs;
	}

	/**
	 * Checks if there are triples in the array of dices
	 * 
	 * @return a boolean of whether there are triples in the array
	 */
	public boolean triples() {

		boolean triple = false;

		// if all 3 dices match
		if ((myDice[0].equals(myDice[1])) && (myDice[0].equals(myDice[2]))) {

			triple = true;

		}

		return triple;
	}

	/**
	 * Checks if the dices are in series
	 * 
	 * @return a boolean of whether or not the dices are in series
	 */
	public boolean series() {

		boolean series = false;
		int d1 = myDice[0].getDieVal();
		int d2 = myDice[1].getDieVal();
		int d3 = myDice[2].getDieVal();

		// if the lowest value plus one equals the middle value, and the middle value
		// plus one equals the largest value
		if ((d1 + 1 == d2) && (d2 + 1 == d3)) {

			series = true;

		}

		return series;
	}

	/**
	 * String representation of the dice values
	 * 
	 * @return String representation of the dice values
	 */
	@Override
	public String toString() {

		return ("D1: " + myDice[0].getDieVal() + ", D2: " + myDice[1].getDieVal() + ", D3: " + myDice[2].getDieVal());

	}

	/**
	 * A getter method to return the player points
	 * 
	 * @return the players points
	 */
	public int getPoints() {

		return points;

	}

	/**
	 * Rolls the dice and checks if the dices meet any winning condition to awards
	 * player their points
	 */
	public void takeTurn() {

		// rolls each dice
		for (int i = 0; i < myDice.length; i++) {

			myDice[i].roll();

		}

		this.sort();

		System.out.println(this);

		// if there are pairs only
		if (this.pairs() && !(this.triples())) {

			points += 1;
			System.out.println("You got pairs!");

		}

		// there are triples in the dices
		else if (this.triples()) {

			points += 3;
			System.out.println("You got 3 of a kind!");

		}

		// the dices are in a series of 3
		else if (this.series()) {

			points += 2;
			System.out.println("You got a series of 3");

		}

		// player did not meet any winning condition
		else {

			System.out.println("Aw. Too bad!");

		}

		System.out.println("Score: " + this.getPoints());
	}

}
