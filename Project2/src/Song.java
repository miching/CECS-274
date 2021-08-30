/**
 * 
 */

/**
 * @author michaelching 4/20/2020
 *  Object Song that can hold details about itself
 *  (title, artist, year, and rating)
 */
public class Song {

	private String title;
	private String artist;
	private int year;
	private int rating;

	/**
	 * Constructor
	 * 
	 * @param title  The title of the song
	 * @param artist The artist of the song
	 */
	public Song(String title, String artist) {

		this.title = title;
		this.artist = artist;

		// set year and rating to zero
		this.year = 0;
		this.rating = 0;

	}

	/**
	 * Overload Constructor
	 * 
	 * @param title  The title of the song
	 * @param artist The artist of the song
	 * @param year   The release year of song
	 * @param rating The rating of the song
	 */
	public Song(String title, String artist, int year, int rating) {

		this.title = title;
		this.artist = artist;
		this.year = year;
		this.rating = rating;

	}

	/**
	 * Returns the title of the song
	 * 
	 * @return String value of title
	 */
	public String getTitle() {

		return title;

	}

	/**
	 * Returns the artist of the song
	 * 
	 * @return String value of the artist
	 */
	public String getArtist() {

		return artist;

	}

	/**
	 * Returns the release year of the song
	 * 
	 * @return integer value of release year
	 */
	public int getYear() {

		return year;

	}

	/**
	 * Returns the rating of the song
	 * 
	 * @return integer value of the rating from (1-5)
	 */
	public int getRating() {

		return rating;

	}

	/**
	 * Printing out the song info in specific format
	 * 
	 * @return Return song info in format (title, artist, year, rating)
	 */
	@Override
	public String toString() {

		return (title + "," + artist + "," + year + "," + rating);

	}

	/**
	 * 
	 * Compares 2 songs by their title and artist to see if they match
	 * 
	 * @param o An object passed in
	 * @return boolean value of whether or not songs match by title/artist
	 */
	@Override
	public boolean equals(Object o) {

		// checks to confirm object passed in is a Song
		if (o instanceof Song) {

			// convert object to type Song
			Song s = (Song) o;

			// song have matching title and artist
			if ((this.title.compareTo(s.getTitle()) == 0) && (this.artist.compareTo(s.getArtist()) == 0)) {

				return true;

			}

			// song have different title or artist
			else {

				return false;

			}
		}

		// object passed in not a song
		else {

			return false;

		}

	}

	/**
	 * Find the difference between 2 songs
	 * 
	 * @param s A song with information
	 * @return integer value of the difference between the information from 2 songs
	 */
	public int compareTo(Song s) {

		// rating is not the same
		if (this.rating != s.rating) {

			return (this.rating - s.rating);

		}

		// artist are not the same
		else if (!this.artist.equals(s.artist)) {

			// negative value if explicit song artist comes before implicit song artist
			return (s.artist.compareTo(this.artist));

		}

		// compare the title
		else {

			// negative value if explicit song title comes before implicit song title
			return (s.title.compareTo(this.title));

		}
	}

}
