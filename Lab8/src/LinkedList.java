/**
 * 
 */

/**
 * @author michaelching 04/12/2020 
 * 			Linked List class to hold all the different
 *          values of circles that were created
 *
 */
public class LinkedList {

	/**
	 * 
	 * @author michaelching 04/12/2020 
	 * 			A node to hold each circle and their values
	 *          and possibly the next location of a Node
	 *
	 */
	private static class Node {

		// contains a circle
		private Circle c;

		// possible next Node location value
		private Node next;

		/**
		 * Constructor
		 * 
		 * @param c A passed in Circle to hold values of
		 */
		public Node(Circle c) {

			// set Node circle to passed in circle, added at end of list
			this.c = c;
			next = null;

		}

		/**
		 * Overload Constructor
		 * 
		 * @param c A passed in Circle to hold values of
		 * @param n A certain Node location to add at
		 */
		public Node(Circle c, Node n) {

			//set Node circle to passed in circle, at Node n
			this.c = c;
			next = n;

		}

		/**
		 * Returns the values of the circle it is holding
		 */
		@Override
		public String toString() {

			// uses the circle toString()
			return (c.toString());

		}

	}

	// location of first Node
	private Node first;

	// location of last Node
	private Node last;

	/**
	 * Constructor
	 */
	public LinkedList() {

		// first and last Node don't exist
		first = null;
		last = null;

	}

	/**
	 * Checks to see if linked list is empty
	 * 
	 * @return boolean value of whether or not list is empty
	 */
	public boolean isEmpty() {

		// if first Node doesn't exist
		return (first == null);

	}

	/**
	 * Adds a circle to the linked list
	 * 
	 * @param c A circle with values
	 */
	public void add(Circle c) {

		// if there are no circles in the list
		if (first == null) {

			// set first Node to circle passed in/last node is current
			first = new Node(c);
			last = first;

		}

		// there are other circles in list
		else {

			// create a new Node for circle passed in and set it as last
			Node n = new Node(c);
			last.next = n;
			last = n;

		}

	}

	/**
	 * Add a circle at at certain location
	 * 
	 * @param i Location to be added
	 * @param c A circle with values
	 */
	public void add(int i, Circle c) {

		// location invalid
		if (i < 0) {

			throw new IndexOutOfBoundsException();

		}

		// location is first
		if (i == 0) {

			first = new Node(c, first);

			// is the only Node in linked list
			if (last == null) {

				last = first;

			}

		}

		// location is elsewhere in linked list
		else {

			Node n = first;

			// first Node doesn't exist
			if (n == null) {

				throw new IndexOutOfBoundsException();

			}

			// iterates till reached desired location -1
			for (int j = 1; j < i; j++) {

				n = n.next;

				// location before desired location is out of bounds
				if (n == null) {

					throw new IndexOutOfBoundsException();

				}

			}

			// insert new Node at desired location
			n.next = new Node(c, n.next);

			// the Node after newly create Node does not exist
			if (n.next.next == null) {

				// last node is current node
				last = n.next;

			}

		}

	}

	/**
	 * Remove a Node at desired location
	 * 
	 * @param i location of Node to be removed
	 * @return the value of the removed Node
	 */
	public Circle remove(int i) {

		// Initialize circle
		Circle removeC = new Circle(0, 0, 0);

		// no Nodes in linked list
		if (first == null || i < 0) {

			throw new IndexOutOfBoundsException();

		}

		// first item in linked list
		if (i == 0) {
			removeC = first.c;

			// set next Node as first
			first = first.next;

			// checks if only Node in linked list
			if (first == null) {
				last = null;

			}

		}

		// Location elsewhere in linked list
		else {

			Node n = first;

			// iterates to desired location -1
			for (int j = 1; j < i; j++) {

				n = n.next;

				// location before desired location does not exist
				if (n == null) {

					throw new IndexOutOfBoundsException();

				}

				// Node at desired location does not exist
				if (n.next == null) {

					throw new IndexOutOfBoundsException();

				}

				// sets removeC to the desired removed Node
				removeC = n.next.c;

				// changes the linking to the Node after the removed Node
				n.next = n.next.next;

				// if the Node after the removed Node doesn't exist
				if (n.next == null) {

					last = n;

				}

			}

		}

		return removeC;

	}

	/**
	 * Removes a circle in a node if it matches with the circle passed in
	 * 
	 * @param c A circle with values
	 * @return Whether or not the circle matches and is removed\
	 */
	public boolean remove(Circle c) {

		// checks to see there are Circles in the linked list
		if (first != null) {

			// checks if desired circle matches with first circle
			if (c.equals(first.c)) {

				// changes First Node linking from current to the one after
				first = first.next;

				// there is only one Circle in linked list
				if (first == null) {

					last = null;

				}

				// found and removed
				return true;
			}

			// desired circle is elsewhere in linked list
			else {

				Node n = first;

				// Iterates through linked list as long as desired circle is not found and next
				// Node exists
				while (n.next != null && !n.next.c.equals(c)) {

					n = n.next;

				}

				// Checks if next Node exists/found matched circle
				if (n.next != null) {

					// set next connected Node to the Node after the removed Node
					n.next = n.next.next;

					// if the node after the removed Node does not exist/current is last
					if (n.next == null) {

						last = n;

					}
					// found and removed
					return true;
				}

			}
		}
		// does not exist in linked list
		return false;
	}

	/**
	 * Returns the circle values at a desired Node
	 * 
	 * @param i Location of node
	 * @return the values of the circle
	 */
	public Circle get(int i) {

		// linked list does not exist or location out of bounds
		if ((first == null) || (i < 0)) {

			throw new IndexOutOfBoundsException();

		}

		Node n = first;

		// iterate to the desired location
		for (int j = 0; j < i; j++) {

			n = n.next;

			// Node does not exist/location is out of bounds
			if (n == null) {

				throw new IndexOutOfBoundsException();

			}

		}

		return n.c;

	}

	/**
	 * Changes the circle values at Node i, to the Circle passed in
	 * 
	 * @param i location of Node
	 * @param c A circle with values
	 */
	public void set(int i, Circle c) {

		// linked list does not exist or location out of bounds
		if ((first == null) || (i < 0)) {

			throw new IndexOutOfBoundsException();

		}

		Node n = first;

		// iterates to desired location
		for (int j = 0; j < i; j++) {

			n = n.next;

			// Node does not exist
			if (n == null) {

				throw new IndexOutOfBoundsException();

			}

		}

		// sets the Node to new circle values
		n.c = c;

	}

	/**
	 * Iterates through the Nodes to find the size of linked list
	 * 
	 * @return the size of the linked list
	 */
	public int size() {

		int count = 0;
		Node n = first;

		// As long as current Node exists
		while (n != null) {

			count++;

			// iterates to next Node
			n = n.next;

		}

		return count;

	}

	/**
	 * Returns the values of the circles using the Circles toString() with a line
	 * spacing between each circle
	 */
	@Override
	public String toString() {

		String str = "";
		Node n = first;

		// As long as current node exists
		while (n != null) {

			// prints using format of the circle toString
			str = str + n.c.toString();
			str = str + "\n";

			// iterates to next Node
			n = n.next;

		}

		return str;

	}

}
