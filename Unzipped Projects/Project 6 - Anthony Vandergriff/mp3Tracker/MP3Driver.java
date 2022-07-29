/**
 * ---------------------------------------------------------------------------
 * File name: MP3Driver.java
 * Project name: Project 4 - MP3 Tracker
 * ---------------------------------------------------------------------------
 * Creator's name and email: Erin L Cook, cookel@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 10, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Menu;

/**
 * Driver - manages user interaction with the program
 *
 * <hr>
 * Date created: Jun 10, 2021
 * <hr>
 * @author Erin L Cook
 */
public class MP3Driver
{

	private static String			userName	= null;
	private static String			fileName;
	private static Menu				mainMenu;
	private static MP3				mp3			= null;
	private static MP3Collection 	collection	= null;
	private static Scanner kb = new Scanner (System.in);

	/**
	 * Entry point of program; demos use of MP3 object        
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 * @param args
	 */
//	public static void main (String [ ] args)
//	{
//		setup ( );
//		processMP3 ( );
//		sayGoodbye ( );
//
//	}
	
	/**
	 * Display a welcome message, get the user's name, and setup the main menu
	 * for the program.
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	private static void setup ( )
	{
		DateFormat date = DateFormat.getDateInstance (DateFormat.FULL);
		String msg = "Welcome to Project 4 Demonstration by Erin L Cook on " +
						date.format (new Date ( )) + ".\n";
		msg += "\nThis program demonstrates the functionality of the MP3 class.  I hope you enjoy using it.\n\n";
		JOptionPane.showMessageDialog (null, msg, "Welcome to Project 3 by Erin L Cook",
			JOptionPane.INFORMATION_MESSAGE);
		userName = JOptionPane.showInputDialog (null, "Please tell me your name.", "Erin L Cook");
		
		mainMenu = new Menu ("Menu for Project 4 - MP3 Tracker");
		
		mainMenu.addChoice ("Create a new MP3 Collection");
		mainMenu.addChoice ("Open an Existing MP3 Collection from a Text File");
		mainMenu.addChoice ("Create a new MP3 file");
		mainMenu.addChoice ("Edit an existing MP3 file");
		mainMenu.addChoice ("Delete an existing MP3 file");
		mainMenu.addChoice ("Display all MP3s in the collection");
		mainMenu.addChoice ("Find and display an MP3 by title");
		mainMenu.addChoice ("Find and display an MP3 by artist");
		mainMenu.addChoice ("Display all MP3s by a given genre");
		mainMenu.addChoice ("Sort all MP3s by title");
		mainMenu.addChoice ("Sort all MP3s by shortest playback time");
		mainMenu.addChoice ("Save the Collection to a File");
		mainMenu.addChoice ("End the Program");
	}

	/**
	 * Display main menu and process user's choices
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	private static void processMP3 ( )
	{
		int choice;
		while ( (choice = mainMenu.getChoice ( )) != 13)
		{
			switch (choice)
			{
				case 1: // Create new MP3 collection
					createMP3Collection ( );
					break;
				case 2:	// Fill from text file
					openCollection();
					break;
				case 3: // Add MP3
					createMP3();					
					break;
				case 4: // Edit existing MP3					
					editMP3();				
					break;
				case 5: // Drop a MP3 from the Club			
					dropMP3();			
					break;
				case 6: // Display all MP3s					
					showMP3s();		
					break;
				case 7: // Find and display an MP3 by Title				
					pickMP3Title();		
					break;
				case 8: // Find and display an MP3 by Artist
					pickMP3Artist();
					break;
				case 9: // Display all MP3s of a genre					
					pickGenre();								
					break;
				case 10: // Sort MP3s by title					
					sortTitle();
					System.out.println("\nCollection sorted by Title");				
					break;
				case 11:  // Save to file
					saveFile ( );
					break;
				default: // Sort MP3s by shortest playback time					
					sortTime();					
					System.out.println("\nCollection sorted by shortest playback time");	
					break;			
			}
		}
	}
	
	/**
	 * 
	 * Input data necessary to instantiate an MP3 collection and then instantiate
	 * the MP3 collection    
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void createMP3Collection()
	{
		if (collection!= null && collection.isSaveNeeded ( ))
			saveFile ( );
		
		System.out.print ("\n\nPlease enter the collection name. ");
		String collectionName = kb.nextLine ( );
		System.out.print ("Please enter the first name of the collection owner ");
		String firstName = kb.nextLine ( );
		System.out.print ("Please enter the last name of the collection owner ");
		String lastName = kb.nextLine ( );
		System.out.print ("Please enter the creation date of " + collectionName + " ");
		String date = kb.nextLine ( );

		collection = new MP3Collection(collectionName, firstName, lastName, date);
	}

	/**
	 * Input data necessary to instantiate an MP3 object and then instantiate
	 * the MP3 file
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	@SuppressWarnings ("resource")
	private static void createMP3 ( )
	{
		
		if (collection == null)
			return;
		
		Scanner kb = new Scanner (System.in);
		System.out.print ("\n\nPlease enter the song title. ");
		String title = kb.nextLine ( );
		System.out.print ("Please enter name of the artist. ");
		String artist = kb.nextLine ( );
		System.out.print ("Please enter the song release date in the form mm/dd/yyyy. ");
		String date = kb.nextLine ( );
		System.out.print ("Please enter playback time in minutes. ");
		double length = kb.nextDouble();
		kb.nextLine();
		System.out.print ("Please enter the music genre.  It must be one of these: \n" +
						"\t Rock, Pop, Jazz, Country, Classical, Other ");
		Genre genre = Genre.valueOf (kb.nextLine ( ).toUpperCase ( ));
		System.out.print ("Please enter the cost to download. ");
		double cost = kb.nextDouble ( );
		System.out.print ("Please enter the size of the file in megabytes. ");
		double size = kb.nextDouble ( );
		kb.nextLine();
		System.out.print ("Please enter the name of the .jpg file containing the album cover photo. ");
		String photo = kb.nextLine ( );
		mp3 = new MP3 (title, artist, length, cost, size, photo, date, genre);
		
		collection.addMP3 (mp3);
		return;
	}
	
	/**
	 * 
	 * Input data necessary to drop an MP3 object from 
	 * the collection
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public static void dropMP3()
	{
		if (collection == null)
			return;
		
		System.out.print ("Please enter the title of the MP3 you want to drop. ");
		String title = kb.nextLine ( );
		
		collection.dropMP3 (title);
		System.out.print ("\nThe MP3 titled, " + title + ", was removed from the collection.\n");
	}
	
	/**
	 * 
	 * Input data necessary to search the collection
	 * for an MP3 object by title then prompt user
	 * to input updated MP3 attribute values        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public static void editMP3()
	{
		if (collection == null)
			return;
		
		System.out.print ("Please enter the title of the MP3 you want to edit. ");
		String title = kb.nextLine ( );
		
		int value = collection.searchMP3(title);
		
		if(value == -1)
		{
			System.out.println("MP3 with the title of " + title
				+ " was not found.");
		}			
		else
		{
			System.out.println("MP3 with the title of " + title + " was found.");
			Scanner kb = new Scanner (System.in);
			System.out.print ("\n\nPlease enter the updated song title. ");
			String newTitle = kb.nextLine ( );
			System.out.print ("Please enter name of the artist. ");
			String artist = kb.nextLine ( );
			System.out.print ("Please enter the song release date in the form mm/dd/yyyy. ");
			String date = kb.nextLine ( );
			System.out.print ("Please enter playback time in seconds. ");
			double length = kb.nextDouble();
			kb.nextLine();
			System.out.print ("Please enter the music genre.  It must be one of these: \n" +
							"\t Rock, Pop, Jazz, Country, Classical, Other ");
			Genre genre = Genre.valueOf (kb.nextLine ( ).toUpperCase ( ));
			System.out.print ("Please enter the cost to download. ");
			double cost = kb.nextDouble ( );
			System.out.print ("Please enter the size of the file in megabytes. ");
			double size = kb.nextDouble ( );
			kb.nextLine();
			System.out.print ("Please enter the name of the .jpg file containing the album cover photo. ");
			String photo = kb.nextLine ( );
			mp3 = new MP3 (newTitle, artist, length, cost, size, photo, date, genre);	
			
			collection.editMP3(mp3, value);
		}		
		
			
	}
	
	/**
	 * 
	 * Display all MP3s in the collection if 
	 * a collection is present       
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void showMP3s()
	{
		if (collection == null)
			return;
		
		System.out.println (collection);
		return;
	}
	
	/**
	 * 
	 * Input artist name to search collection
	 * for matching MP3 artist then display
	 * the MP3        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void pickMP3Artist ( )
	{
		if (collection == null)
			return;
		
		System.out.print ("Please enter the artist. ");
		String artist = kb.nextLine ( );
		
		ArrayList<MP3> music = collection.findByArtist(artist);
		
		if(music == null)
		{
			System.out.println("MP3(s) with the artist of " + artist
				+ " not found.");
		}			
		else
		{
			for(MP3 a : music)
				System.out.println(a);
		}
		return;
	}
	
	/**
	 * 
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void pickMP3Title()
	{
		if (collection == null)
			return;
		
		System.out.print ("Please enter the title. ");
		String title = kb.nextLine ( );
		
		MP3 m = collection.returnMP3(title);
		
		if(m == null)
		{
			System.out.println("Title of " + title + " not found");
		}			
		else
		{
			System.out.println(m);
		}
		return;
	}
	
	/**
	 * 
	 * Input genre from selection and display
	 * MP3 objects from collection with matching
	 * genre value       
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void pickGenre ( )
	{
		if (collection == null)
			return;
		
		System.out.println ("\nWhat genre do you want to display? Possibilities are");
		for (Genre t : Genre.values ( ))
			System.out.println ("\t" + t);
		String strType = kb.nextLine ( ).toUpperCase ( );
		ArrayList <MP3> list = collection.findByGenre (Genre.valueOf (strType));
		
		// display list if any matches
		if(list.size() < 1)
		{
			System.out.println("\nNo MP3s found in the " + strType + " genre");
		}			
		else	
		{
			System.out.println("\nDisplaying " + strType + " genre");
			for (MP3 m : list)
				System.out.println (m + "\n");
		}
		
		return;
	}
	
	/**
	 * 
	 * Sort collection by MP3 title        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void sortTitle ( )
	{
		if (collection == null)
			return;
		collection.sortByTitle ( );
		
		return;

	}
	
	/**
	 * 
	 * Sort collection by shortest playback time        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void sortTime ( )
	{
		if (collection == null)
			return;
		collection.sortByTime ( );
		
		return;
	}

	/**
	 * Display a goodbye message
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	private static void sayGoodbye ( )
	{
		if (collection!= null && collection.isSaveNeeded ( ))
			saveFile ( );
		
		JOptionPane.showMessageDialog (null, "Goodbye, " + userName + "." +
						" Thank you for using this demonstration of the MP3 class.\n",
			"Thank you and Goodbye", JOptionPane.INFORMATION_MESSAGE);
		
		kb.close ( );
	}
	
	/**
	 * 
	 * Open an MP3 Tracker file and populate the tracker      
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 */
	private static void openCollection()
	{
		if (collection != null && collection.isSaveNeeded ( ))
		{
			saveFile ( );
		}
		collection = new MP3Collection ( );
		JFileChooser dlg = new JFileChooser ("MP3TrackerData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the Collection Data File You Wish to Open");
		int button = dlg.showOpenDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Opened",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			fileName = dlg.getSelectedFile ( ).getPath ( );
			collection.fillFromFile (fileName);
							
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null,
				"There was an error processing the file - operation terminated. \n" +
								e.getMessage ( ),
				"Error Reading from File", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * Save all MP3 Tracker data to the specified text file       
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 */
	private static void saveFile ( )
	{
		if (collection == null)
		{
			JOptionPane.showMessageDialog (null, "There is no collection to save", "Save Failed",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		JFileChooser dlg = new JFileChooser ("MP3TrackerData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the MP3 Collection Data File You Wish to Save");
		int button = dlg.showSaveDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			collection.saveFile (dlg.getSelectedFile ( ).getPath ( ));
			JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog (null, "File not found - " + e.getMessage ( ),
				"File Not Found", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null, "File not saved - " + e.getMessage ( ),
				"Error During File Save", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
	}

}
