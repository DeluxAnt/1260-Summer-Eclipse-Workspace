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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * Creates the ability to store MP3 objects, create collections, 
 * sort by artist, title, genre, order by playtime, title, edit and remove
 * MP3 in collection, save and read files 
 *
 * <hr>
 * Date created: Jun 30, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3Tracker
{
	
	private static ArrayList<MP3> collection;
	private static String collectionName;
	private static String firstName;
	private static String lastName;
	private static String creationDate;
	private static boolean saveNeeded;  //used to check if user needs to save file

	
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
		collectionName = "Default Playlist";
		firstName = "John";
		lastName = "Doe";
		creationDate = "MM/DD/YYYY";
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
		saveNeeded = true;
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
		saveNeeded = true;
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
		saveNeeded = true;
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
	 * 
	 * Reads file and populates the music collection         
	 *
	 * <hr>
	 * Date created: Jul 23, 2021
	 *
	 * <hr>
	 */
	public static void fillFromFile() {
		
		JFileChooser chooser = new JFileChooser("./MP3TrackerData/"); //prompts user to pick a file
		int result = chooser.showSaveDialog(null);
		
		//ask how to read first line correctly
		
		File fileIn = chooser.getSelectedFile ( );
		Scanner file = null;
		
		if (result != JFileChooser.APPROVE_OPTION) {
			System.out.println("No file Selected - TERMINATED");
			System.exit(0);
		}
		
		try {
			file = new Scanner(fileIn);
		}
		catch(Exception e1){
			System.out.println (e1.getMessage ( ) );
			
		}
		
		while (file.hasNextLine ( )) {
			String line = file.nextLine ( );
			String[] split = line.split ("\\|");
			try {
				MP3 m = new MP3(split[0], split[1], split[2], Double.parseDouble (split[3]), null, Double.parseDouble (split[5]), Double.parseDouble (split[6]), split[7]);
				collection.add (m);
			}
			catch (NumberFormatException e)
			{
				System.out.println(e);
				return;
			}
			catch (Exception e)
			{
				System.out.println(e);
				return;
			}
		}
	}
	
	
	/**
	 * 
	 * Writes all user entered music to a file to save        
	 *
	 * <hr>
	 * Date created: Jul 23, 2021
	 *
	 * <hr>
	 * @param fileName
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(String fileName, String filePath) throws FileNotFoundException{
		
		JFileChooser chooser = new JFileChooser("./MP3TrackerData/"); //prompts user to pick a file
		int result = chooser.showSaveDialog(null);
		
		if (result != JFileChooser.APPROVE_OPTION) {
			System.out.println("No file Selected - TERMINATED");
			System.exit(0);
		}
		fileName = chooser.getSelectedFile().getPath();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
			
			//write header line
			writer.println(collectionName + "|" + firstName + "|" + lastName + "|" + creationDate);
			
			//write member details
			for(int n =0; n < collection.size(); n++) { //adds members to file based on how many members are created
				MP3 m = collection.get(n);
				writer.println(m.getSongTitle ( ) + "|" + m.getArtist ( ) + "|" + m.getReleaseDate ( ) + "|" + m.getPlaybackTime ( ) + "|" + m.getGenre ( )
				+ "|" + m.getCost ( ) + "|" + m.getFileSize ( ) + "|" + m.getAlbumCover ( ));
				saveNeeded = false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("File not saved: " + e.getMessage()); //prints error message if file not found
		} finally{
			if (writer != null)
				writer.close();
		}
	}
	
	
	
	
	
	
	/**
	 * @return saveNeeded
	 */
	public static boolean isSaveNeeded ( )
	{
		return saveNeeded;
	}

	
	/**
	 * @param saveNeeded the saveNeeded to set
	 */
	public void setSaveNeeded (boolean saveNeeded)
	{
		this.saveNeeded = saveNeeded;
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

	


	
	
	
	


