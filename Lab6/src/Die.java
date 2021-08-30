/**
 * 
 */

/**
 * Class to represent a die
 * 
 * @author michaelching
 *
 */

public class Die {

	private int sides;
	private int dieVal;

	/**
	 * Constructor
	 * 
	 * @param s the number of sides
	 */
	public Die(int s) {

		sides = s;
		dieVal = roll();

	}

	/**
	 * Rolls the dice based on given number of sides
	 * 
	 * @return the dice value after rolled
	 */
	public int roll() {

		dieVal = (int) (Math.random() * sides) + 1;
		return dieVal;

	}

	/**
	 * A getter method to get the Die's value
	 * 
	 * @return the Die's value
	 */
	public int getDieVal() {

		return dieVal;

	}

	/**
	 * Sets the dice to a specific value
	 * 
	 * @param value the specific value to set the dice to
	 * @return if the specific value is appropriate for the dice and its attributes
	 */
	public boolean setDiceVal(int value) {

		// value is greater than zero but less than number of sides
		if (value > 0 && value <= sides) {

			dieVal = value;
			return true;

		}

		return false;
	}

	/**
	 * Compares the values of two dices to see if they equal
	 * 
	 * @param dice A object
	 */
	@Override
	public boolean equals(Object dice) {

		// the passed object is a Die
		if (dice instanceof Die) {

			Die d = (Die) dice;
			return this.dieVal == d.dieVal;

		}

		return false;

	}

	/**
	 * Compares the values of the dies
	 * 
	 * @param dice An object of type Die
	 * @return the value of the current die minus the value of the passed in die
	 */
	public int compareTo(Die dice) {

		// System.out.println(this.dieVal - dice.getDieVal());

		return this.dieVal - dice.dieVal;

	}

}
