import java.util.ArrayList;

/**
 * @author michaelching
 *
 *         Linked List to hold all the songs and possible functions to use on
 *         the list of songs
 */
public class LinkedList {

	/**
	 * 
	 * @author michaelching 4/20/2020
	 * 
	 *         A node to hold each song and their values and possibly the next
	 *         location of a Node
	 *
	 */
	private static class Node {

		private Song s;

		// possible next Node location value
		private Node next;

		/**
		 * Constructor
		 * 
		 * @param s A passed in song to hold values of
		 */
		public Node(Song s) {

			// set Node song to passed in song, added at end of list
			this.s = s;
			next = null;

		}

		/**
		 * Returns the values of the song it is holding
		 */
		@Override
		public String toString() {

			// uses the song toString()
			return (s.toString());

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
	 * Adds a song to the linked list
	 * 
	 * @param s A song with values
	 */
	public void add(Song s) {

		// if there are no songs in the list
		if (first == null) {

			// set first Node to song passed in and last node is current
			first = new Node(s);
			last = first;

		}

		// there are other songs in list
		else {

			// create a new Node for song passed in and set it as last
			Node n = new Node(s);
			last.next = n;
			last = n;

		}

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
	 * Remove song at the top of the list
	 * 
	 * @return The top song of the list
	 */
	public String remove() {

		Node n = first;

		// no Nodes in linked list
		if (first == null) {

			throw new IndexOutOfBoundsException();

		} else {

			// set next Node as first
			first = first.next;

			// checks if only Node in linked list
			if (first == null) {
				last = null;

			}

		}

		return n.toString();

	}

	/**
	 * Returns the song that matches the desired data correctly
	 * 
	 * @param title  Desired Title of the song
	 * @param artist Desired Artist of the song
	 * @return the song info of the desired song
	 */
	public Song searchSong(String title, String artist) {

		Node n = first;

		// As long as current node exists
		while (n != null) {

			// temp song to hold song values
			Song tempSong = new Song(title, artist);

			// checks to see if title and artist match
			if (n.s.equals(tempSong)) {

				return n.s;

			}

			// Iterates to next node
			n = n.next;

		}

		// does not exist in list
		return null;

	}

	/**
	 * Finds and creates a list with songs all from the same artist
	 * 
	 * @param artist Desired artist of the song
	 * @return List of all songs under the desired artist
	 */
	public ArrayList<Song> searchArtist(String artist) {

		ArrayList<Song> sameArtist = new ArrayList<Song>();

		Node n = first;

		// As long as current node exists
		while (n != null) {

			//same artist
			if (n.s.getArtist().equals(artist)) {

				sameArtist.add(n.s);

			}
			
			//iterate to next node
			n = n.next;

		}

		return sameArtist;

	}

	/**
	 * Finds and creates a list with all songs in the correct decade
	 * 
	 * @param decade Decade of the song release in format (Ex. 1980)
	 * @return List of all songs under the desired decade
	 */
	public ArrayList<Song> searchDecade(int decade) {

		ArrayList<Song> sameDecade = new ArrayList<Song>();

		Node n = first;

		// As long as current node exists
		while (n != null) {

			//within start of decade to 9 years from then
			if (n.s.getYear() >= decade && n.s.getYear() < decade + 9) {

				sameDecade.add(n.s);

			}
			
			//iterate to next node
			n = n.next;

		}

		return sameDecade;

	}

	/**
	 * Bubble Sorts the list by comparing the rating, then artist,then title of the songs
	 * with highest rating on top
	 */
	public void sort() {

		// initial swap to false
		boolean swapped = false;

		// check once first
		do {

			// keep tracks of first Node
			Node n = first;
			swapped = false;

			// loop till reached last appropriate Node to compare with
			while (n.next != null) {

				// if negative, explicit song values are higher
				if (n.s.compareTo(n.next.s) < 0) {

					// temp song to hold Song
					Song swap = n.s;

					// swap current Song with next Song
					n.s = n.next.s;

					// set next Node to song that was swapped
					n.next.s = swap;

					// continue to sort
					swapped = true;

				}

				// iterates to next Node
				n = n.next;

			}

			// loop until nothing has been swapped
		} while (swapped);

	}

	/**
	 * Displays the items in the passed in list
	 * 
	 * @param list A ArrayList that holds song info
	 */
	public void display(ArrayList<Song> list) {

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));

		}

	}

	/**
	 * Writes all the songs in the format it was passed in from
	 * 
	 * @return All the songs info in the proper format using song toString() format
	 */
	public String toString() {

		String str = "";
		Node n = first;

		// As long as current node exists
		while (n != null) {

			// prints using format of the circle toString
			str = str + n.s.toString();
			str = str + "\n";

			// iterates to next Node
			n = n.next;

		}

		return str;

	}

}
