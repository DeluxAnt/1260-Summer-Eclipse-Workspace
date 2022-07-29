/**
 * ---------------------------------------------------------------------------
 * File name: MP3Tracker.java
 * Project name: MP3 - Project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 30, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Jun 30, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3Tracker
{
	
	private ArrayList<MP3> collection = new ArrayList();
	private String collectionName;
	private String firstName;
	private String lastName;
	private String creationDate;
	
	/**
	 * 
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jul 8, 2021 
	 *
	 *
	 */
	public MP3Tracker() {
		collection = new ArrayList<>();
		collectionName = null;
		firstName = null;
		lastName = null;
		creationDate = null;
	}
	
	/**
	 * 
	 * Paramarterized Constructor        
	 *
	 * <hr>
	 * Date created: Jul 8, 2021 
	 *
	 * 
	 * @param collectionName
	 * @param firstName
	 * @param lastName
	 * @param creationDate
	 */
	public MP3Tracker(String collectionName, String firstName, String lastName, String creationDate) {
		collection = new ArrayList<>();
		this.collectionName = collectionName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = creationDate;
	}
	
	/**
	 * 
	 * Adds song to collection array        
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param mp3
	 */
	public void addSong(MP3 mp3) {
		collection.add (mp3);
	}
	
	/**
	 * 
	 * Allows user to write song data         
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param index
	 * @param mp3
	 */
	public void editSong (int index, MP3 mp3) {
		collection.set (index, mp3);
	}
	
	/**
	 * 
	 * Romoves song from collection         
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param index
	 */
	public void rvmSong(int index) {
		collection.remove (index);
	}
	
	/**
	 * 
	 * returns song data from index entered by user       
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param index
	 * @return
	 */
	public MP3 getMP3(int index) {
		return collection.get(index);
	}
	
	/**
	 * 
	 * Finds the max value and orders the array        
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	public int sortTitle (int size) {
		int max = 0;
		for(int n=1; n < size; n++) //compares titles to get the greatest value
			if (collection.get(n).getSongTitle().compareTo(collection.get(max).getSongTitle())> 0) {
				max = n;
			}
		return max;
	}
	
	/**
	 * 
	 * Orders the array based on alphabetical values and then displays         
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 */
	public void sortTitleDis() {
		for (int i = collection.size(); i > 1; i--) {
			int m = sortTitle(i);
			if(m != i-1) {
				MP3 temp = collection.get(m); //swaps values to sort greater to the top
				collection.set(m, collection.get(i-1));
				collection.set(i-1, temp);
			}
		}
		System.out.println(collection + "\n"); //prints sorted array
	}
	
	/**
	 * 
	 * Finds the title that matches the user input       
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param title
	 */
	public void findTitle(String title) {
		for(MP3 mp3 : collection) {
			if(mp3.getSongTitle() != null && mp3.getSongTitle ( ).contains (title)) {
				System.out.println(mp3.toString ( ));
			}
		}
	}
	
	/**
	 * 
	 * Finds the Artist that matched user input       
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param artist
	 */
	public void findArtist(String artist) {
		for(MP3 mp3 : collection) {
			if(mp3.getArtist ( ) != null && mp3.getArtist ( ).contains (artist)) {
				System.out.println(mp3.toString ( ));
			}
		}
	}
	
	/**
	 * 
	 * Sorts and displays by song genre         
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param genre
	 * @return
	 */
	public String genreType(Genre genre) {
		String n = "";
		for(MP3 mp3 : collection) {
			if(mp3.getGenre ( ) == genre) {
				n += mp3.toString ( ) + "\n\n";
			}
		}
		return n;
	}
	
	public int collectionSize() {
		return collection.size ( );
	}
	
	/**
	 * sorts all songs by the playback length
	 *   
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	public void maxLength() {
		for(int i = 0; i < collection.size()-1; i++) {
			int n = i;
			for(int j = i + 1; j < collection.size(); j++) {
				if(collection.get (n).getPlaybackTime ( ) > collection.get (j).getPlaybackTime ( )) {
					n = j;
				}
			}
			MP3 tmp = collection.get (i);
			collection.set (i, collection.get (n));
			collection.set(n, tmp);
		}
		
			
	}

	
	
	
	/**
	 * @return collection
	 */
	public ArrayList <MP3> getCollection ( )
	{
		return collection;
	}

	
	/**
	 * @param collection the collection to set
	 */
	public void setCollection (ArrayList <MP3> collection)
	{
		this.collection = collection;
	}

	
	/**
	 * @return collectionName
	 */
	public String getCollectionName ( )
	{
		return collectionName;
	}

	
	/**
	 * @param collectionName the collectionName to set
	 */
	public void setCollectionName (String collectionName)
	{
		this.collectionName = collectionName;
	}

	
	/**
	 * @return firstName
	 */
	public String getFirstName ( )
	{
		return firstName;
	}

	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}

	
	/**
	 * @return lastName
	 */
	public String getLastName ( )
	{
		return lastName;
	}

	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}

	
	/**
	 * @return creationDate
	 */
	public String getCreationDate ( )
	{
		return creationDate;
	}

	
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate (String creationDate)
	{
		this.creationDate = creationDate;
	}
	
	/**
	 * Format object of type MP3Tracker as a String for
	 * possible display by another class
	 *
	 * Date created: Jun 30, 2021
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		StringBuilder s = new StringBuilder("\n"); //StringBuilder used to be more efficient
		s.append("Collection Name: ").append(collectionName).append("\n");
		s.append("Collection Creator First Name: ").append(firstName).append("\n");
		s.append("Collection Creator Last Name: ").append(lastName).append("\n");
		s.append("Creation Date: ").append(creationDate).append("\n\n");
		s.append("Song: \n");
		
		if (collection.size() != 0) {
			for (int i = 0; i < collection.size(); i++) {
				s.append(i + 1).append(" ");
				s.append(collection.get(i)).append("\n");
			} 
		}
		else {
			s.append("No songs yet\n\n");
		}
		return s.toString();
	 // end toString
	}

	
	
	
	
}

	


	
	
	
	


