import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author michaelching Word Class to read in a file, make a type Word for each
 *         word and sort alphabetically with frequency
 */
public class WordClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// binary search tree
		BST tree = new BST();

		try {

			// read in from words.txt
			Scanner read = new Scanner(new File("words.txt"));

			// As long as there is more content to read in
			while (read.hasNext()) {

				String info = read.nextLine();

				// create a Word with each word from file
				Word word = new Word(info);

				// add Word to tree
				tree.add(word);

			}

			read.close();

			// file is not found
		} catch (FileNotFoundException fnf) {

			System.out.println("File Not found");

		}

		// menu options for user
		System.out.println("1. Display list in alphabetical order with frequency");
		System.out.println("2. Search for a word");
		System.out.println("3. Quit");

		// get user choice
		int userChoice = CheckInput.getIntRange(1, 3);

		// user wants to continue
		while (userChoice != 3) {

			// user wants to display list in order with freq
			if (userChoice == 1) {

				System.out.println(tree.toSortedString());

			}

			// user wants to search for a word
			else if (userChoice == 2) {

				System.out.println("Enter word to be searched: ");

				// create a Word for the desired search word
				Word w = new Word(CheckInput.getString());

				// word is found in tree
				if (tree.contains(w) != null) {

					// prints the desired word and its frequency
					System.out.println(tree.contains(w));

				}

				// word was not found
				else {

					// freq is zero
					System.out.println("Freq: 0");

				}

			}

			// Menu choices
			System.out.println("1. Display list in alphabetical order with frequency");
			System.out.println("2. Search for a word");
			System.out.println("3. Quit");
			userChoice = CheckInput.getIntRange(1, 3);

		}

		System.out.println("Program ended.");

	}

}
