/**
 * ---------------------------------------------------------------------------
 * File name: MP3Collection.java
 * Project name: MP3 Tracker - Project 3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Erin L Cook, cookel@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 10, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Model an MP3 Tracker with a name, owner first and last name,
 * date created, and an MP3 collection
 *
 * <hr>
 * Date created: Jun 10, 2021
 * <hr>
 * @author Erin L Cook
 */
public class MP3Collection
{
	private ArrayList<MP3> 		collection;
	private String 				collectionName;
	private String 				firstName;
	private String 				lastName;
	private String 				creationDate;
	private boolean				saveNeeded	= false;
	
	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021 
	 *
	 * 
	 */
	public MP3Collection ( )
	{
		collection = new ArrayList<>();
		collectionName = "No Collection Name";
		firstName = "No First Name";
		lastName = "No Last Name";
		creationDate = "00/00/0000";
		saveNeeded = true;
	}

	
	/**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021 
	 *
	 * 
	 * @param collection
	 * @param collectionName
	 * @param firstName
	 * @param lastName
	 * @param creationDate
	 */
	public MP3Collection (String collectionName, String firstName, String lastName,
							String creationDate)
	{
		collection = new ArrayList<>();
		this.collectionName = collectionName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = creationDate;
		saveNeeded = true;
	}
	
	/**
	 * 
	 * Copy Constructor        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * 
	 * @param existingMP3Collection
	 */
	public MP3Collection(MP3Collection existingMP3Collection)
	{
		collectionName = existingMP3Collection.collectionName;
		firstName = existingMP3Collection.firstName;
		lastName = existingMP3Collection.lastName;
		creationDate = existingMP3Collection.creationDate;
		collection = new ArrayList <> (existingMP3Collection.collection);
		saveNeeded = true;
	}


	/**
	 * 
	 * Open the specified text file and populate the MP3Collection 
	 * object from it        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @param filePath - text file name and path to be opened
	 * @throws Exception
	 */
	public void fillFromFile (String filePath) throws Exception
	{
		Scanner file = null;
		String line;
		try
		{
			file = new Scanner (new File (filePath));
			line = file.nextLine ( );
			String [ ] musicData = line.split ("\\|");
			if (musicData.length != 4)
				throw new Exception (
								"\nInvalid collection data in the input file.\nRest of file skipped");
			this.setCollectionName (musicData [0]);
			this.setFirstName (musicData [1]);
			this.setLastName (musicData [2]);
			this.setCreationDate (musicData [3]);
			

			while (file.hasNext ( ))
			{
				line = file.nextLine ( );
				String [ ] fields = line.split ("\\|");
				if (fields.length != 8)
					throw new Exception ("Invalid MP3 data in the input file on the line: '" +
									line + "'\nRest of input file was skipped.");
				MP3 m = new MP3 (fields [0], fields [1], Double.valueOf (fields [4]), Double.valueOf(fields [5]), Double.valueOf (fields [6]),
					fields [7], fields [2], Genre.valueOf (fields [3].toUpperCase ( )));
				collection.add (m);
			}
		}
		finally
		{
			if (file != null)
				file.close ( );
			saveNeeded = false;
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
		saveNeeded = true;
	}


	
	/**
	 * @return collectionName
	 */
	public String getCollectionName ( )
	{
		return collectionName;
	}


	/**
	 * 
	 * Getter for saveNeeded flag     
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @return
	 */
	public boolean isSaveNeeded ( )
	{
		return saveNeeded;
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
		saveNeeded = true;
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
		saveNeeded = true;
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
		saveNeeded = true;
	}
	
	/**
	 * 
	 * Return last name comma first name        
	 *
	 * <hr>
	 * Date created:Jun 10, 2021
	 *
	 * <hr>
	 * @return the whole name, last name first
	 */
	public String getName()
	{
		return lastName + ", " + firstName;
	}
	
	/**
	 * 
	 * Add an mp3 to the MP3Collection        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @param track
	 */
	public void addMP3(MP3 track)
	{
		collection.add (track);
		saveNeeded = true;
	}
	
	/**
	 * 
	 * Return a member with the given name; return null if no such member        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param artist
	 * @return 
	 */
	public MP3 returnMP3(String title)
	{
		if(searchMP3(title) == -1)
			return null;
		else
			return collection.get (searchMP3(title));	
	}	
	
	
	
	/**
	 * 
	 * Replace the existing mp3 of a subscript with a new mp3; 
	 * can be used to edit an mp3 by replacing the 
	 * existing mp3 with the edited mp3       
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param track
	 * @param value
	 */
	public void editMP3(MP3 track, int value)
	{
		collection.set (value, track);		
		
		System.out.println(track.toString ( ));	// testing
		saveNeeded = true;
	}
	
	/**
	 * 
	 * Remove an mp3 with the specified title from the 
	 * collection if there is such an mp3; otherwise 
	 * do nothing        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param title
	 */
	public void dropMP3(String title)
	{
		if(searchMP3(title) == -1)
			System.out.println("MP3 with the title of " + title
						+ " was not found.");
		else
		{
			collection.remove (searchMP3(title));	
			saveNeeded = true;
		}	
		
	}
	
	/**
	 * 
	 * Return index position with the given title; return -1 if no such mp3       
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param title
	 * @return int
	 */
	public int searchMP3(String title)
	{
		int index = 0;
		int element = -1;
		boolean found = false;
		
		while(!found && index < collection.size ( ))
		{
			if(collection.get (index).getTitle ( ).equalsIgnoreCase (title))
			{
				found = true;
				element = index;
			}
			
			index++;
		}
		
		return element;
	}
	
	/**
	 * 
	 * Returns the number of MP3s 
	 * in the collection       
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getCollectionSize()
	{
		return collection.size ( );
	}
	
	/**
	 * 	
	 * Return all mp3s with the given title; return -1 if no such mp3        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param artist
	 * @return mp3 collection
	 */
	public ArrayList<MP3> findByArtist(String artist)
	{
		ArrayList <MP3> list = new ArrayList <MP3> ( );
		for (MP3 m : collection)
			if (m.getArtist ( ).equalsIgnoreCase (artist))
				list.add (m);

		return list;
	}
	
	
	/**
	 * 
	 * Return an ArrayList<MP3> all of whom are of the specified Genre        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param genre
	 * @return
	 */
	public ArrayList <MP3> findByGenre (Genre genre)
	{
		ArrayList <MP3> list = new ArrayList <MP3> ( );
		for (MP3 m : collection)
			if (m.getSongGenre ( ).equals (genre))
				list.add (m);

		return list;
	}
	
	/**
	 * 
	 * Find the title alphabetically in the first size positions in the
	 * collection and return its index        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	private int findMaxTitle (int size)
	{
		int max = 0;
		for (int n = 1; n < size; n++ )
		{
			if (collection.get (max).getTitle ( ).compareTo (collection.get (n).getTitle ( )) < 0)
				max = n;
		}
		return max;
	}
	
	/**
	 * 
	 * Sort the collection alphabetically by title     
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public void sortByTitle ( )
	{
		MP3 temp;
		int max;
		for (int n = collection.size ( ); n > 1; n-- )
		{
			max = findMaxTitle (n);
			if (max != n - 1)
			{
				temp = collection.get (max);
				collection.set (max, collection.get (n - 1));
				collection.set (n - 1, temp);
				saveNeeded = true;
				
			}
		}
	}
	
	/**
	 * 
	 * Find the title numerically in the first size positions in the
	 * collection and return its index       
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 * @param size
	 * @return
	 */
	private int findMinTime(int size)
	{
		int max = 0;
		for (int n = 1; n < size; n++ )
		{
			if (collection.get (max).getLength ( ) < collection.get (n).getLength( ))
				max = n;
		}
		return max;
	}
	
	/**
	 * 
	 * Sort the collection numerically by time         
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public void sortByTime ( )
	{
		MP3 temp;
		int max;
		for (int n = collection.size ( ); n > 1; n-- )
		{
			max = findMinTime (n);
			if (max != n - 1)
			{
				temp = collection.get (max);
				collection.set (max, collection.get (n - 1));
				collection.set (n - 1, temp);
				saveNeeded = true;
				
			}
		}
	}
	
	/**
	 * 
	 * Return the mp3 from the selectedIndex position in
	 * the collection       
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @param selectedIndex
	 * @return
	 */
	public MP3 getMP3( int selectedIndex)
	{
		if (selectedIndex >= 0 && selectedIndex < getCollectionSize ( ))
			return collection.get (selectedIndex);
		return null;
	}
	
	/**
	 * 
	 * Save all MP3Tracker data to the specified text file        
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 * @param path
	 * @throws Exception
	 */
	public void saveFile (String path) throws Exception
	{
		PrintWriter pw = new PrintWriter (path);
		String line = collectionName + "|" + firstName + 
						"|" + lastName + "|" + creationDate;
		pw.println (line);
		for (MP3 m : collection)
		{
			line = m.getTitle ( ) + "|";
			line += m.getArtist ( ) + "|";
			line += m.getDate ( ) + "|";
			line += m.getSongGenre ( ) + "|";
			line += m.getLength ( ) + "|";
			line += m.getCost ( ) + "|";
			line += m.getSize ( ) + "|";
			line += m.getPhoto ( );
			pw.println (line);
		}
		pw.close ( );
		this.saveNeeded = false;
	}
	
	/**
	 * Format object of type MP3Collection as a String for
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
		
		resultOut += "\nCollection Name: " + collectionName;
		resultOut += "\nOwner: " + getName();
		resultOut += "\nCreation Date: " + creationDate + "\n";	
		
		for(MP3 m : collection)
			resultOut += "\n" + m.toString ( );

		return resultOut;
	} // end toString

	
	
}
