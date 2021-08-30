
/**
 *
 * 
 */
import java.awt.Point;
import java.util.Stack;

/**
 * @author michaelching 4/19/2020
 *  Uses points to place on a 2D array using stacks to keep track of each point
 */
public class Stacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// stack points
		Stack<Point> stack = new Stack<Point>();

		// 2D char array size 5x5
		char[][] array = new char[5][5];

		// Initialize 2D array to all '.'
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				array[i][j] = '.';

			}

		}

		System.out.println("Enter 5 locations (0-4) : ");

		// get 5 appropriate points to enter into the stack
		for (int i = 0; i < 5; i++) {
			System.out.println("Location " + (i + 1) + " row value: ");
			int x = CheckInput.getIntRange(0, 4);

			System.out.println("Location " + (i + 1) + " column value: ");
			int y = CheckInput.getIntRange(0, 4);

			Point p = new Point(x, y);

			// add point to top of stack
			stack.push(p);

		}

		// ascii value of character '5'
		int count = 53;

		// remove points from stack and place char value at the location and its
		// neighboring location
		for (int i = 0; i < 5; i++) {

			// remove top value
			Point p = stack.pop();

			// row value of point
			int row = p.x;

			// column value of point
			int column = p.y;

			// set location of point to its place in stack
			array[row][column] = (char) count;

			// checks if location below is in bounds
			if ((row + 1) < 5) {

				array[row + 1][column] = (char) count;

			}

			// checks if location above is in bounds
			if ((row - 1) > -1) {

				array[row - 1][column] = (char) count;

			}

			// checks if location right is in bounds
			if ((column + 1) < 5) {

				array[row][column + 1] = (char) count;

			}

			// checks if location left is in bounds
			if ((column - 1) > -1) {

				array[row][column - 1] = (char) count;

			}

			// decrease to next appropriate ascii value for char
			count--;

		}

		// print out the 2D array
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				System.out.print(array[i][j]);

			}

			System.out.println();

		}

	}

}
