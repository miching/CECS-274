import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 * 
 */

/**
 * @author michaelching 4/20/2020 Imitates the functions of a jukebox
 */
public class Jukebox {

	/**
	 * Main Class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// LinkedList to hold all songs
		LinkedList songs = new LinkedList();

		// writes in file and sorts by rating
		songs = writeInFile(songs);

		// user choice of the menu
		int userChoice = 0;

		// user does not want to quit
		while (userChoice != 5) {

			// displays menu options
			getMenu();

			userChoice = CheckInput.getIntRange(1, 5);

			// user wants to add song
			if (userChoice == 1) {

				// adds song and resorts list
				songs = addSong(songs);

			}

			// user wants to play song
			if (userChoice == 2) {

				// plays top rated song and removes it
				songs = playSong(songs);

			}

			// user wants to search for a specific song
			if (userChoice == 3) {

				// prints details of desired song
				searchSong(songs);

			}

			// user wants to display the songs
			if (userChoice == 4) {

				// display size and songs in the list
				display(songs);

			}

			// user wants to quit
			if (userChoice == 5) {

				// escape loop
				break;

			}

		}

		// write LinkedList back into songs.txt
		quit(songs);

	}

	/**
	 * Read in the songs from "song.txt" file and sort
	 * 
	 * @param songs empty LinkedList of songs
	 * @return LinkedList of songs from text file and sorted
	 */
	public static LinkedList writeInFile(LinkedList songs) {

		try {

			Scanner read = new Scanner(new File("songs.txt"));

			// As long as there is more content to read in
			while (read.hasNext()) {

				String info = read.nextLine();

				// split up each piece of song info separated by ','
				String[] tokens = info.split(",");

				// first data is title
				String title = tokens[0];

				// second data is artist
				String artist = tokens[1];

				// third data is year which is converted to int
				int year = Integer.parseInt(tokens[2]);

				// fourth data is rating which is converted to int
				int rating = Integer.parseInt(tokens[3]);

				/*
				 * for(int i = 0; i<tokens.length;i++) { System.out.println(tokens[i]);
				 * System.out.println("test"); }
				 */

				// create a new song with all proper info
				Song s = new Song(title, artist, year, rating);

				// add song to LinkedList
				songs.add(s);

			}

			read.close();

			// file is not found
		} catch (FileNotFoundException fnf) {

			System.out.println("File Not found");

		}

		// checks if list is not empty
		if (!songs.isEmpty()) {

			// sort list after writing in
			songs.sort();

		}

		// linkedlist of songs
		return songs;

	}

	/**
	 * Prints menu for user to see
	 */
	public static void getMenu() {

		System.out.println("1. Add Song");
		System.out.println("2. Play Song");
		System.out.println("3. Search Song");
		System.out.println("4. Display Songs");
		System.out.println("5. Quit");

	}

	/**
	 * Adds song to linked list and resorts in order
	 * 
	 * @param songs LinkedList of songs
	 * @return LinkedList of songs plus added song and resorted by rating
	 */
	public static LinkedList addSong(LinkedList songs) {

		System.out.println("Enter title of song:");
		String title = CheckInput.getString();

		System.out.println("Enter artist of song:");
		String artist = CheckInput.getString();

		System.out.println("Enter release year of song:");

		// song year has to be between (1500,2020)
		int year = CheckInput.getIntRange(1500, 2020);

		System.out.println("Enter rating of song:");

		// song rating is between (1-5)
		int rating = CheckInput.getIntRange(1, 5);

		// create song with proper info
		Song song = new Song(title, artist, year, rating);

		// add song to LinkedList
		songs.add(song);

		// resort the LinkedList
		songs.sort();

		// linkedlist of songs
		return songs;

	}

	/**
	 * Displays the top rated song in LinkedList and removes it
	 * 
	 * @param songs LinkedList of songs
	 * @return LinkedList of songs with previous top song removed
	 */
	public static LinkedList playSong(LinkedList songs) {

		// checks to see if LinkedList is empty
		if (songs.isEmpty()) {
			System.out.println("No songs left in list!");

		} else {

			// removes and prints top rated song
			System.out.println("Playing: " + songs.remove());

		}

		// linkedlist of songs
		return songs;

	}

	/**
	 * Search for a song by a certain criteria and prints out details
	 * 
	 * @param songs Linkedlist of songs
	 */
	public static void searchSong(LinkedList songs) {

		System.out.println("1. By title and Artist");
		System.out.println("2. By Artist");
		System.out.println("3. By Decade");

		int choice = CheckInput.getIntRange(1, 3);

		// user wants to search by title and artist
		if (choice == 1) {

			System.out.println("Enter title:");
			String title = CheckInput.getString();

			System.out.println("Enter Artist:");
			String artist = CheckInput.getString();

			// song exists
			if (songs.searchSong(title, artist) != null) {

				// prints first matching song
				System.out.println(songs.searchSong(title, artist));

			}

			// song does not exist
			else {

				System.out.println("Not Found");

			}
		}

		// user wants to search by artist
		if (choice == 2) {

			System.out.println("Enter Artist:");
			String artist = CheckInput.getString();

			// no matching artist songs in the list
			if (songs.searchArtist(artist).isEmpty()) {

				System.out.println("Not Found");

			}

			// there are songs matching the artist
			else {

				// list of songs with matching artist
				songs.display(songs.searchArtist(artist));

			}

		}

		// user wants to search by decade
		if (choice == 3) {

			System.out.println("Enter decade (in format xxxx) :");

			// decade has to be between (1500,2020)
			int decade = CheckInput.getIntRange(1500, 2020);

			// no songs in appropriate decade
			if (songs.searchDecade(decade).isEmpty()) {

				System.out.println("Not Found");

			}

			// there are songs in the requested decade
			else {

				// list of songs in requested decade
				songs.display(songs.searchDecade(decade));

			}
		}

	}

	/**
	 * Displays the songs in the list
	 * 
	 * @param songs LinkedList of songs
	 */
	public static void display(LinkedList songs) {

		// displays the size of list
		System.out.println("Size: " + songs.size());

		// displays sorted songs info
		System.out.println(songs);

	}

	/**
	 * Writes songs back into "song.txt" file in proper format
	 * 
	 * @param songs LinkedList of songs
	 */
	public static void quit(LinkedList songs) {

		try {
			PrintWriter writer = new PrintWriter("songs.txt");

			// uses proper format (title, artist, year, rating)
			writer.print(songs.toString());

			writer.close();

			// file was not found
		} catch (FileNotFoundException fnf) {

			System.out.println("File was not found");

		}

	}
}
