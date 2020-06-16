import java.io.PrintWriter;

public class VideoGames implements Comparable<VideoGames> {
	private String serialNumber;
	private String title;
	private int year;
	private String publisher;
	private String rating;

	/**
	 * Constructor for the Video Game class
	 *
	 * @param title    the Video Game's title
	 * @param director the Video Game's director
	 * @param year     the year the Video Game was released
	 * @param gross    the amount grossed over the lifetime of the Video Game, given
	 *                 in Millions of dollars
	 */
	public VideoGames(String serialNumber, String title, int year, String studio, String rating) {
		this.serialNumber = serialNumber;
		this.title = title;
		this.year = year;
		this.publisher = studio;
		this.rating = rating;
	}

	/**
	 * Accesses the title of the Video Game
	 *
	 * @return the Video Game's title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Accesses the director of the Video Game
	 *
	 * @return the Video Game's director
	 */
	public String getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * Access the year the Video Game was released in theaters
	 *
	 * @return the year the Video Game was released
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Access the gross amount earned by the Video Game in Millions of dollars
	 *
	 * @return the Video Game's gross in Millions
	 */
	public String getPublisher() {
		return this.publisher;
	}

	public String getRating() {
		return this.rating;
	}

	/**
	 * Sets the title of the Video Game
	 *
	 * @param title the Video Game's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the director of the Video Game
	 *
	 * @param director the Video Game's director
	 */
	public void setisbn(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Sets the year the Video Game was released
	 *
	 * @param year the year the Video Game was released
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Sets the gross amount earned by the Video Game in Millions of dolalrs
	 *
	 * @param gross the gross amount in Millions of dollars
	 */
	public void setStudioOrPublisher(String studio) {
		this.publisher = studio;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Creates a String of the Video Game information the following format: Title:
	 * <title> Director: <director> Year: <year> Gross in Millions: $<grossMillions>
	 * Note that there should be no <> in the resulting String Also the
	 * grossMillions should be displayed as follows: XXX,XXX.XX
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Serial Number: " + serialNumber + "\nTitle: " + title + "\nYear: " + year + "\nPublisher: "
				+ publisher + "\nRating: " + rating + "\n\n";
		return result;
	}

	/**
	 * Determines whether two Video Game objects are equal by comparing titles and
	 * directors
	 *
	 * @param otherVideo Game the second Video Game object
	 * @return whether the Video Games are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof VideoGames)) {
			return false;
		} else {
			VideoGames p = (VideoGames) o;
			return serialNumber.equals(p.serialNumber) && title.equals(p.title);
		}

	}

	/**
	 * Compares two Video Game objects to determine ordering Returns 0 if the two
	 * items are equal Return -1 if this Video Game's title comes alphabetically
	 * before the other Video Game's title. Returns 1 if the other Video Game's
	 * title comes alphabetically before this Video Game's title If the two Video
	 * Game's titles are the same, will differentiate by director's name
	 * (alphabetical comparison)
	 *
	 * @param the other Video Game object to compare to this
	 * @return 0 (same Video Game), -1 (this Video Game ordered first) or 1 (the
	 *         other Video Game ordered first)
	 */
	// @Override
	public int compareTo(VideoGames otherVideoGame) {
		if (this.equals(otherVideoGame)) {
			return 0;
		} else if (serialNumber.compareTo(otherVideoGame.serialNumber) < 0) {
			return -1;
		} else if (serialNumber.compareTo(otherVideoGame.serialNumber) > 0) {
			return 1;
		}
		if (title.compareTo(otherVideoGame.title) < 0) {
			return -1;
		} else if (title.compareTo(otherVideoGame.title) > 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * Returns a consistent hash code for each Video Game by summing the Unicode
	 * values of each character in the key Key = title + director
	 *
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		String key = serialNumber + title;
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}
	/**
	 * Prints all the games that are stored in hash table in original format
	 */
	public void printGameToFile(PrintWriter output) {
		output.println(serialNumber + "\n" + title + "\n" 
				+ year + "\n" + publisher + "\n" + rating + "\n");
	}

}
