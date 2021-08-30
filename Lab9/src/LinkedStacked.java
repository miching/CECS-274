
/**
 * 
 */
import java.awt.Point;

/**
 * @author michaelching
 *Data structure to hold point values in a form of a stack
 *
 */
public class LinkedStacked {

	/**
	 * 
	 * @author michaelching
	 *	A node to hold each Point values and
	 *  and possibly the next location of a Node
	 *
	 */
	private static class Node {

		// point values (x,y)
		private Point point;

		// next location of node
		private Node next;

		/**
		 * Constructor
		 * 
		 * @param p Point with x and y values
		 * @param n next location of node
		 */
		public Node(Point p, Node n) {

			this.point = p;
			this.next = n;

		}

		/**
		 * Returns the point values
		 * 
		 * @return Uses the point.toString()
		 */
		@Override
		public String toString() {

			return point.toString();

		}

	}

	// top location of the stack
	private Node top;

	/**
	 * Constructor
	 */
	public LinkedStacked() {

		// no item on top
		top = null;

	}

	/**
	 * Checks to see if stack is empty
	 * 
	 * @return boolean value of if stack is empty
	 */
	public boolean isEmpty() {

		return top == null;

	}

	/**
	 * Adds item to the top of the stack
	 * 
	 * @param p Point with x and y values
	 */
	public void push(Point p) {

		top = new Node(p, top);

	}

	/**
	 * Removes and returns the item at the top of the stack
	 * 
	 * @return String value at the top of the stack
	 */
	public String pop() {

		String retVal = "";

		// checks to see that stack has items
		if (!isEmpty()) {

			retVal = top.point.toString();

			// set next location as top since current is removed
			top = top.next;

		}

		return retVal;

	}

	/**
	 * Returns the item at the top of the stack
	 * 
	 * @return String value at the top of the stack
	 */
	public String peek() {

		String retVal = "";

		// checks to see stack has items
		if (!isEmpty()) {

			retVal = top.point.toString();

		}

		return retVal;

	}

	/**
	 * Returns the values of the stack from top to bottom
	 * 
	 * @return String values of the stack from top to bottom
	 */
	@Override
	public String toString() {

		String s = "";

		// start from top
		Node n = top;

		// Node exists
		while (n != null) {

			s = s + n.point.toString() + " ";

			// goes to next Node in the stack
			n = n.next;

		}
		return s;

	}

	/**
	 * Returns the number of items in the stack
	 * 
	 * @return Int value of number of items in stack
	 */
	public int size() {
		// no items
		int count = 0;

		// start from top
		Node n = top;

		// Node exists
		while (n != null) {

			count++;

			// goes to next Node in stack
			n = n.next;

		}

		return count;

	}
}
