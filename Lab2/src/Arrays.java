/**
 * 
 */

/**
 * @author Michael Ching 
 * Date: 2/3/2020 
 * Description: Ask user to input values
 *  	   	  	into an array of size 10. Display a menu that give options to
 *     		    manipulate the array, such as display values, add all the values,
 *     		    etc.
 *
 */

//import java.util.Scanner;

public class Arrays {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create an array of size 10
		int[] values = new int[10];

		// ask user to enter 10 integers into the array
		populateArray(values);

		int menuChoice = 0;

		// while user does not want to quit program
		while (menuChoice != 8) {

			displayMenu();

			menuChoice = CheckInput.getIntRange(1, 8);

			// if user wants to display values
			if (menuChoice == 1) {

				displayValues(values);

			}

			// if user wants to display values reversed
			if (menuChoice == 2) {

				displayReversed(values);

			}

			// if user wants to find sum of all integers in the array
			if (menuChoice == 3) {

				System.out.println("Sum: " + computeSum(values));

			}

			// if user wants to find largest value
			if (menuChoice == 4) {

				System.out.println("Max Value: " + maxValue(values));

			}

			// if user wants to search for a value
			if (menuChoice == 5) {

				System.out.println("Enter a value to be searched for.");

				int userValue = CheckInput.getInt();

				// returns the index of userValue in the array values
				int where = searchValue(values, userValue);

				// if value does not exist in array
				if (where == -1) {

					System.out.println("Does not exist in the array.");

				}

				else {

					// add one to index to convert to one-based index for user experience
					System.out.println("The index of the desired number is: " + (where + 1));
					System.out.println("This is one-based indexing.");

				}
			}

			// if user wants to insert a value at a certain location
			if (menuChoice == 6) {

				System.out.println("Enter an one-based index for where the value will be inserted.");

				// ask for user index based on one-based index
				int userIndex = CheckInput.getIntRange(1, values.length);

				System.out.println("Enter a value to be inserted.");

				int userValue = CheckInput.getInt();

				// sets userValue at userIndex for the array values
				insertValue(values, userIndex, userValue);

			}

			// if user wants to reset and enter 10 new values
			if (menuChoice == 7) {

				populateArray(values);

			}

		}

	}

	/**
	 * Displays the menu options for user to see
	 * 
	 * @param
	 */

	public static void displayMenu() {

		System.out.println("1: Display Values");
		System.out.println("2: Display Reversed");
		System.out.println("3: Display Sum");
		System.out.println("4: Display Max");
		System.out.println("5: Search for value");
		System.out.println("6: Insert new value");
		System.out.println("7: Reset value");
		System.out.println("8: Quit");

	}

	/**
	 * Allows user to enter 10 values into array
	 * 
	 * @param values An array of size 10
	 * @return  Returns the array after user enters 10 values
	 */

	public static int[] populateArray(int[] values) {
		System.out.println("Please enter in 10 integers.");

		for (int i = 0; i < values.length; i++) {

			values[i] = CheckInput.getInt();

		}

		return values;

	}

	/**
	 * Displays the values in order of which the user entered
	 * 
	 * @param values An array consisting of 10 values
	 */

	public static void displayValues(int[] values) {

		for (int i = 0; i < values.length; i++) {

			System.out.print(values[i] + ", ");

		}

		System.out.println("");
	}

	/**
	 * Displays the values in reversed from which they were entered
	 * 
	 * @param values An array consisting of 10 values
	 */

	public static void displayReversed(int[] values) {

		// start from end of array and move down to first index
		for (int i = (values.length - 1); i >= 0; i--) {

			System.out.print(values[i] + ", ");

		}

		System.out.println("");

	}

	/**
	 * Adds all the values in the array together
	 * 
	 * @param values An array consisting of 10 values
	 * @return sum of all the numbers added together
	 */

	public static int computeSum(int[] values) {

		int sum = 0;

		for (int i = 0; i < values.length; i++) {

			sum += values[i];

		}

		return sum;

	}

	/**
	 * Finds the max value in the array
	 * 
	 * @param values An array consisting of 10 values
	 * @return the largest value in the array
	 */

	public static int maxValue(int[] values) {

		// start at lowest possible value in java
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < values.length; i++) {

			// checks if the current largest is smaller than current value at index i
			if (max < values[i]) {

				max = values[i];

			}

		}

		return max;
	}

	/**
	 * Searches for a value for which the user has asked for
	 * 
	 * @param values    An array consisting of 10 values
	 * @param userValue The value the user wants to search for
	 * @return the index location of the first occurrence of desired value
	 */

	public static int searchValue(int[] values, int userValue) {

		// if value does not exist
		int where = -1;

		for (int i = 0; i < values.length; i++) {
			if (userValue == values[i]) {

				where = i;

				// first instance of the desired value
				break;
			}

		}

		return where;

	}

	/**
	 * Inserts a value into the array at a certain location
	 * 
	 * @param values    An array consisting of 10 values
	 * @param userIndex The desired location of value to be placed in a one-based
	 *                  index
	 * @param userValue The desired value to be placed into the array
	 */

	public static void insertValue(int[] values, int userIndex, int userValue) {

		// convert userIndex one-based index back to zero-based index
		values[(userIndex - 1)] = userValue;

	}
}
