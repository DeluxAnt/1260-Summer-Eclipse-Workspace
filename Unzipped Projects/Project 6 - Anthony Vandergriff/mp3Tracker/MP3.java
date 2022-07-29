package mp3Tracker;
/**
 * ---------------------------------------------------------------------------
 * File name: MP3.java
 * Project name: MP3 - Project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Erin L Cook, cookel@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 10, 2021
 * ---------------------------------------------------------------------------
 */



/**
 * Representation of a MP3 file
 *
 * <hr>
 * Date created: Jun 10, 2021
 * <hr>
 * @author Erin L Cook
 */
public class MP3
{
	private String title;
	private String artist;
	private String date;
	private double length;
	private double cost;
	private double size;
	private String photo;
	private Genre songGenre;
	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021 
	 *
	 * 
	 */
	public MP3 ( )
	{
		title = "";
		artist = "";
		length = 0.0;
		cost = 0.0;
		size = 0.0;
		songGenre = Genre.OTHER;
		photo = "none.jpg";
		
	}
	
	
	/**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021 
	 *
	 * 
	 * @param title
	 * @param artist
	 * @param length
	 * @param cost
	 * @param size
	 * @param photo
	 * @param date
	 * @param songGenre
	 */	
	public MP3 (String title, String artist, double length, double cost, double size, String photo, String date,
				Genre songGenre)
	{
		this.title = title;
		this.artist = artist;
		this.length = length;
		this.cost = cost;
		this.size = size;
		this.photo = photo;
		this.date = date;
		this.songGenre = songGenre;
	}


	
	/**
	 * @return date
	 */
	public String getDate ( )
	{
		return date;
	}

	
	/**
	 * @param date the date to set
	 */
	public void setDate (String date)
	{
		this.date = date;
	}





	/**
	 * @return title
	 */
	public String getTitle ( )
	{
		return title;
	}


	
	/**
	 * @param title the title to set
	 */
	public void setTitle (String title)
	{
		this.title = title;
	}


	
	/**
	 * @return artist
	 */
	public String getArtist ( )
	{
		return artist;
	}


	
	/**
	 * @param artist the artist to set
	 */
	public void setArtist (String artist)
	{
		this.artist = artist;
	}


	
	/**
	 * @return length
	 */
	public double getLength ( )
	{
		return length;
	}


	
	/**
	 * @param length the length to set
	 */
	public void setLength (double length)
	{
		this.length = length;
	}


	
	/**
	 * @return cost
	 */
	public double getCost ( )
	{
		return cost;
	}


	
	/**
	 * @param cost the cost to set
	 */
	public void setCost (double cost)
	{
		this.cost = cost;
	}


	
	/**
	 * @return size
	 */
	public double getSize ( )
	{
		return size;
	}


	
	/**
	 * @param size the size to set
	 */
	public void setSize (double size)
	{
		this.size = size;
	}


	
	/**
	 * @return photo
	 */
	public String getPhoto ( )
	{
		return photo;
	}


	
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto (String photo)
	{
		this.photo = photo;
	}


	
	/**
	 * @return songGenre
	 */
	public Genre getSongGenre ( )
	{
		return songGenre;
	}


	
	/**
	 * @param songGenre the songGenre to set
	 */
	public void setSongGenre (Genre songGenre)
	{
		this.songGenre = songGenre;
	}

	/**
	 * Format object of type MP3 as a String for
	 * possible display by another class
	 *
	 * Date created: Jun 10, 2021
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String resultOut = "";
		
		resultOut = "\nMP3 Title:\t" + title + "\n";
		resultOut += "Artist:\t\t" + artist + "\n";
		resultOut += "Release Date:\t" + date + "\tGenre:\t" + songGenre + "\n";
		resultOut += "Download Cost:\t$" + cost + "\t\tFile Size: \t" + size + " MBs\n";
		resultOut += "Song Playtime:\t" + length + " minutes\tAlbum Photo: " + photo;

		return resultOut;
	} // end toString

	
	
	
}
