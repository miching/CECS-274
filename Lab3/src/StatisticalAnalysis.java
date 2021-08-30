
/**
 * 
 */

/**
 * Description: Read in a text file and input into an arrayList to be sorted, and then manipulated based off user choices
 * @author Michael Ching
 *Date: 2/10/2020
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class StatisticalAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ArrayList of type Integer with values being read in by populateArray
		// method
		ArrayList<Integer> grades = populateArray();

		// sorts list using bubble sort
		sortList(grades);

		displayMenu();

		int menuChoice = CheckInput.getIntRange(1, 6);

		// while user does not want to quit
		while (menuChoice != 6) {

			// user wants to display sorted grades in rows of 10
			if (menuChoice == 1) {

				displayGrades(grades);

			}

			// user wants to display avg grade to one decimal point
			if (menuChoice == 2) {
				DecimalFormat df = new DecimalFormat("0.0");
				System.out.println(
						"The sum of all the grades is: " + df.format((sumGrades(grades) / (1.0 * grades.size()))));

			}

			// user wants to display max value
			if (menuChoice == 3) {

				System.out.println("The highest grade value is: " + grades.get(grades.size() - 1));

			}

			// user wants to display minimum value
			if (menuChoice == 4) {

				System.out.println("The lowest grade value is: " + grades.get(0));

			}

			// user wants to display value at the middle of the sorted list
			if (menuChoice == 5) {
				DecimalFormat df = new DecimalFormat("0.0");
				System.out.println("The median grade value is: " + df.format(findMedian(grades)));

			}

			displayMenu();
			menuChoice = CheckInput.getIntRange(1, 6);
		}

	}

	/**
	 * Reads in the values from a text file and inputs them into an ArrayList
	 * 
	 * @return A ArrayList containing all of the grades from the text file
	 */

	public static ArrayList<Integer> populateArray() {

		ArrayList<Integer> grades = new ArrayList<Integer>();

		try {

			// reads in values from text file "grades"
			Scanner read = new Scanner(new File("grades.txt"));

			while (read.hasNext()) {

				int studentGrade = read.nextInt();
				grades.add(studentGrade);

			}

			read.close();
		}

		// if file cannot be found
		catch (FileNotFoundException fnf) {

			System.out.println("File was not found");

		}

		return grades;

	}

	/**
	 * Displays all the grade sorted from the list
	 * 
	 * @param grades A sorted ArrayList containing list of grades
	 */

	public static void displayGrades(ArrayList<Integer> grades) {

		for (int i = 0; i < grades.size(); i++) {

			System.out.print(grades.get(i));

			// every element that is not the tenth
			if ((i + 1) % 10 != 0) {

				System.out.print(", ");

			}

			// every tenth element
			if ((i + 1) % 10 == 0) {

				System.out.println();

			}

		}
		System.out.println();
	}

	/**
	 * Sorts the ArrayList using bubble-sort
	 * 
	 * @param grades An ArrayList containing list of grades
	 */

	public static void sortList(ArrayList<Integer> grades) {

		// false means it has not been swapped
		boolean swapped = false;
		do {

			swapped = false;
			for (int i = 0; i < grades.size() - 1; i++) {

				// if the current value is larger than the next value in place
				if (grades.get(i) > grades.get(i + 1)) {

					int swap = grades.get(i);
					grades.set(i, grades.get(i + 1));
					grades.set(i + 1, swap);
					swapped = true;

				}

			}
			// while there was an item swapped meaning an element was out of order
		} while (swapped);

	}

	/**
	 * Adds all the grades together from the list
	 * 
	 * @param grades A sorted ArrayList containing list of grades
	 * @return the sum of all the grades from the list
	 */

	public static int sumGrades(ArrayList<Integer> grades) {

		int sum = 0;
		for (int i = 0; i < grades.size(); i++) {

			sum += grades.get(i);

		}

		return sum;

	}

	/**
	 * Finds the middle value in the list (location-wise)
	 * 
	 * @param grades A sorted ArrayList containing list of grades
	 * @return the double value of the grade at the middle location of the list
	 */

	public static double findMedian(ArrayList<Integer> grades) {

		double middleGrade = 0;

		// if the list had an even amount of elements
		if (grades.size() % 2 == 0) {

			int lowerValue = ((grades.size() / 2) - 1);
			int higherValue = (grades.size() / 2);

			// add the two values in the middle and divide by 2
			middleGrade = ((grades.get(lowerValue) + grades.get(higherValue)) / 2.0);

		}

		// if the list had an odd amount of elements
		else {

			middleGrade = grades.get((grades.size() - 1) / 2);

		}

		return middleGrade;

	}

	/**
	 * Displays the list of options for user to choose
	 */

	public static void displayMenu() {

		System.out.println("1. Display sorted grades");
		System.out.println("2. Display average grade");
		System.out.println("3. Display maximum grade");
		System.out.println("4. Display minimum grade");
		System.out.println("5. Display median grade");
		System.out.println("6. Quit");

	}
}
