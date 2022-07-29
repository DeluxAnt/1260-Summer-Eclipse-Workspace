/**
 * ---------------------------------------------------------------------------
 * File name: MP3.java
 * Project name: MP3 - Project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 22, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;


/**
 * Creates Default and Parameterized Constructor, with proper attributes,
 * getters and setters, as well as formatted toString
 *
 * <hr>
 * Date created: Jun 22, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3
{
	private String songTitle;
	private String artist;
	private String releaseDate;
	private double playbackTime;
	private Genre genre;
	private double cost;
	private double fileSize;
	private String albumCover;
	
	
	/**
	 * 
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jun 22, 2021 
	 *
	 *
	 */
	public MP3() {
		songTitle = "";
		artist = "";
		releaseDate = "";
		playbackTime = 0;
		genre = null;
		cost = 0;
		fileSize = 0;
		albumCover = "";
	}
	
	/**
	 * 
	 * Parameratized Constructor        
	 *
	 * <hr>
	 * Date created: Jun 22, 2021 
	 *
	 * 
	 * @param songTitle
	 * @param artist
	 * @param releaseDate
	 * @param playbackTime
	 * @param genre
	 * @param cost
	 * @param fileSize
	 * @param albumCover
	 */
	public MP3(String songTitle, String artist, String releaseDate, double playbackTime,
	           Genre genre, double cost, double fileSize, String albumCover) {
		this.songTitle = songTitle;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.playbackTime = playbackTime;
		this.genre = genre;
		this.cost = cost;
		this.fileSize = fileSize;
		this.albumCover = albumCover;
		
		
	}

	

	
	/**
	 * @return songTitle
	 */
	public String getSongTitle ( )
	{
		return songTitle;
	}

	
	/**
	 * @param songTitle the songTitle to set
	 */
	public void setSongTitle (String songTitle)
	{
		this.songTitle = songTitle;
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
	 * @return releaseDate
	 */
	public String getReleaseDate ( )
	{
		return releaseDate;
	}

	
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate (String releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	
	/**
	 * @return playbackTime
	 */
	public double getPlaybackTime ( )
	{
		return playbackTime;
	}

	
	/**
	 * @param playbackTime the playbackTime to set
	 */
	public void setPlaybackTime (double playbackTime)
	{
		this.playbackTime = playbackTime;
	}

	
	/**
	 * @return genre
	 */
	public Genre getGenre ( )
	{
		return genre;
	}

	
	/**
	 * @param genre the genre to set
	 */
	public void setGenre (Genre genre)
	{
		this.genre = genre;
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
	 * @return fileSize
	 */
	public double getFileSize ( )
	{
		return fileSize;
	}

	
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize (double fileSize)
	{
		this.fileSize = fileSize;
	}

	
	/**
	 * @return albumCover
	 */
	public String getAlbumCover ( )
	{
		return albumCover;
	}

	
	/**
	 * @param albumCover the albumCover to set
	 */
	public void setAlbumCover (String albumCover)
	{
		this.albumCover = albumCover;
	}
	
	/**
	 * Format object of type MP3 as a String for
	 * possible display by another class
	 *
	 * Date created: Jun 22, 2021
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String resultOut = "MP3 Title: " + songTitle +
						   "\nArtist: " + artist +
						   "\nRelease Date: " + releaseDate + "     " + "Genre: " + genre +
						   "\nDownload Cost: " + cost + "     " + "File Size: " + fileSize +
						   "\nSong Playtime: " + playbackTime + "     " + "Album Photo: " + albumCover + "\n";

		return resultOut;
	} // end toString

	

}
