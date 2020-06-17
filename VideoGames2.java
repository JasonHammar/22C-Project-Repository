import java.io.PrintWriter;

public class VideoGames2 extends VideoGames implements Comparable<VideoGames2> {
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

}
