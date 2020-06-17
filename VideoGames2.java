import java.io.PrintWriter;

public class VideoGames2 implements Comparable<VideoGames2> {
	private String serialNumber;
	private String title;
	private Integer year;
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
	public VideoGames2(String serialNumber, String title, int year, String studio, String rating) {
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
	 * Access publisher's name who published the game
	 *
	 * @return the Video Game's publisher
	 */
	public String getPublisher() {
		return this.publisher;
	}
	
	/**
	 * Access the rating of the video game
	 *
	 * @return the Video Game's rating
	 */
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
	 * Sets the serial number of the Video Game
	 *
	 * @param serial number the Video Game's serial number
	 */
	public void setSerialNumber(String serialNumber) {
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
	 * Sets the Studio or Publisher who made the video game
	 *
	 * @param Studio or publisher who made the video game
	 */
	public void setStudioOrPublisher(String studio) {
		this.publisher = studio;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Creates a String of the Video Game information the following format: Serial Number:
	 * <serialNumber> Title: <title> Year: <year> Publisher: <publisher> Rating: <rating>
	 * Note that there should be no <> in the resulting String.
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Serial Number: " + serialNumber + "\nTitle: " + title + "\nYear: " + year + "\nPublisher: "
				+ publisher + "\nRating: " + rating + "\n\n";
		return result;
	}

	/**
	 * Determines whether two Video Game objects are equal by comparing serialNumber
	 * and Title.
	 *
	 * @param otherVideo Game the second Video Game object
	 * @return whether the Video Games are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof VideoGames2)) {
			return false;
		} else {
			VideoGames2 p = (VideoGames2) o;
			return serialNumber.equals(p.serialNumber) && title.equals(p.title);
		}

	}

	/**
	 * Compares two Video Game objects to determine ordering Returns 0 if the two
	 * items are equal Return -1 if this Video Game's serial number comes alphabetically
	 * before the other Video Game's serial number. Returns 1 if the other Video Game's
	 * serial number comes alphabetically before this Video Game's serial number If the two Video
	 * Game's serial number are the same, will differentiate by title's name
	 * (alphabetical comparison)
	 *
	 * @param the other Video Game object to compare to this
	 * @return 0 (same Video Game), -1 (this Video Game ordered first) or 1 (the
	 *         other Video Game ordered first)
	 */
	// @Override
	public int compareTo(VideoGames2 otherVideoGame) {
		int compare = this.title.compareTo(otherVideoGame.getTitle());
    	
    	if(compare == 0) {
        	compare = this.year.compareTo(otherVideoGame.getYear());
        	if (compare == 0) {
        		return 0;
        	}
        	else if(compare < 0) {
        		return -1;
        	}
        	else {
        		return 1;
        	}
        }
        else if(compare < 0) {
        	return -1;
        }
        else  {
        	return 1;
        }
 
	}

	/**
	 * Returns a consistent hash code for each Video Game by summing the Unicode
	 * values of each character in the key Key = serialNumber + title
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
				+ publisher + "\n" + year + "\n" + rating + "\n");
	}

}