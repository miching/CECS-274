/**
 * 
 */

/**
 * @author michaelching 5/3/2020 Binary Search Tree to store in order and search
 *         for specific words
 */
public class BST {

	/**
	 * 
	 * @author michaelching Node class for BST
	 */
	private static class Node {

		// word to hold
		private Word word;

		// node to the left
		private Node left;

		// node to the right
		private Node right;

		/**
		 * Default Constructor
		 * 
		 * @param word A word of type Word
		 */
		public Node(Word word) {

			this.word = word;
			left = null;
			right = null;

		}

		/**
		 * Returns the desired word using word toString format
		 * 
		 * @return the word in Node
		 */
		@Override
		public String toString() {

			return "" + word;

		}
	}

	// first Node inserted
	private Node root;

	/**
	 * Default constructor
	 */
	public BST() {
		// nothing in tree
		root = null;

	}

	/**
	 * Determines whether bst is empty or not
	 * 
	 * @return boolean if empty or not
	 */
	public boolean isEmpty() {

		// null means empty
		return root == null;

	}

	/**
	 * Adds a word to the tree
	 * 
	 * @param w A word of type Word
	 */
	public void add(Word w) {

		// calls private add
		root = add(w, root);

	}

	/**
	 * Adds a word to the tree at the correct location
	 * 
	 * @param w A word of type Word
	 * @param n A specific Node in the tree
	 * @return The correct Node location for the word
	 */
	private Node add(Word w, Node n) {

		// reached end so create new Node
		if (n == null) {

			return new Node(w);

		}

		else {
			// less than value so go left
			if (w.compareTo(n.word) < 0) {

				n.left = add(w, n.left);

			}

			// greater than value so go right
			else if (w.compareTo(n.word) > 0) {

				n.right = add(w, n.right);

			}

			// same word
			else {

				// increments the freq
				n.word.increment();

			}

			return n;

		}

	}

	/**
	 * Search the tree for a certain value
	 * 
	 * @param w A desired word of type Word
	 * @return the Word whether its found or null if not found
	 */
	public Word contains(Word w) {

		// tree is empty
		if (root == null) {

			return null;

		}

		else {

			// calls private contains
			return contains(w, root);

		}

	}

	/**
	 * Search the tree for a specific value
	 * 
	 * @param w A desired word of type Word
	 * @param n The next node to examine and compare values with
	 * @return the word if found, else null if not
	 */
	private Word contains(Word w, Node n) {

		// words match
		if (w.compareTo(n.word) == 0) {

			return n.word;

		}

		// searched word comes before, go left
		if (w.compareTo(n.word) < 0) {

			// word does not exist
			if (n.left == null) {

				return null;

			}

			// continue searching left
			else {

				return contains(w, n.left);

			}

		}

		// search word comes after, go right
		else {

			// word does not exist
			if (n.right == null) {

				return null;

			}

			// continue searching right
			else {

				return contains(w, n.right);

			}
		}

	}

	/**
	 * Traverse through the tree in order
	 * 
	 * @return the string value of all the words together
	 */
	public String toSortedString() {

		// calls private toSortedString
		return toSortedString(root);

	}

	/**
	 * Traverse through the tree in order
	 * 
	 * @param n Next node to go through
	 * @return The string value of all the nodes in order and in format
	 */
	private String toSortedString(Node n) {

		String s = "";

		// node exist
		if (n != null) {

			// move left, access, move right
			s += toSortedString(n.left);
			s += n.word + ", ";
			s += toSortedString(n.right);

		}

		// string sorted alphabetically
		return s;

	}
}
