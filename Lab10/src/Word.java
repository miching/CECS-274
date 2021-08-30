/**
 * 
 */

/**
 * @author michaelching 5/3/2020 Class to imitate a Word holding the word and
 *         its frequency
 */
public class Word {

	// word it is storing
	private String word;

	// number of times the same word appears
	private int freq;

	/**
	 * Default Constructor
	 * 
	 * @param word A String word to store
	 */
	public Word(String word) {

		this.word = word;
		freq = 1;

	}

	/**
	 * Compares alphabetically implicit with explicit
	 * 
	 * @param word A word of type Word
	 * @return the difference in the alphabet
	 */
	public int compareTo(Word word) {

		// negative if implicit before, positive if implicit after, zero if same
		return this.word.compareTo(word.word);

	}

	/**
	 * Return the word in the format (word : freq)
	 * 
	 * @return the specific format
	 */
	@Override
	public String toString() {

		return (word + ": " + freq);

	}

	/**
	 * Increments the frequency of the word
	 */
	public void increment() {

		freq += 1;

	}

}
