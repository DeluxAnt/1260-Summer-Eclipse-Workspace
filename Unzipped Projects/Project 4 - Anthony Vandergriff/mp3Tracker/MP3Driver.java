/**
 * ---------------------------------------------------------------------------
 * File name: MP3Driver.java
 * Project name: MP3 - Project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 22, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.Menu; //used to create menu

/**
 * Demonstrates the creation a menu (using util), adds songs based on
 * user input, displays songs, and terminates program, all handled through switch statement
 *
 * <hr>
 * Date created: Jun 22, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3Driver
{
	//creates MP3 object from MP3 class 
	public static MP3 mp3 = new MP3();
	
	//creates MP3Tracker object from MP3Tracker class
	public static MP3Tracker collection = null;
	
	//creates a keyboard scanner for user inputs
	private static Scanner kb = new Scanner(System.in);
	
	static int index;
	static String strInput;

	/**
	 * Runs the menu, adds songs, displays songs, displays
	 * welcome and goodbye windows        
	 *
	 * <hr>
	 * Date created: Jun 22, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		ArrayList<MP3> collecionAlb = new ArrayList<>();
		
		//creates a menu using imported util
		Menu menu = new Menu("Menu for Project 1 - MP3");
		
		JOptionPane.showMessageDialog (null, "Welcome to Project 3 Demo of my MP3 player!" + 
										"\n This program will demonstrate the functionallity of the MP3 class.");
		
		String user = JOptionPane.showInputDialog(null, "Welcome to the MP3 Player." + "\n What is your name?");

		menu.addChoice ("Create a new MP3 Collection");
		menu.addChoice ("Create a new MP3 File");
		menu.addChoice ("Edit an exisiting MP3 File");
		menu.addChoice ("Delete an exisiting MP3 File");
		menu.addChoice ("Display all MP3s in the collection");
		menu.addChoice ("Find and display an MP3 by title");
		menu.addChoice ("Find and display an MP3 by artist");
		menu.addChoice ("Find and display an MP3 by genre");
		menu.addChoice ("Sort all MP3s by title");
		menu.addChoice ("Save File");
		menu.addChoice ("Read File");
		menu.addChoice ("Sort all MP3s by shortest playback time");
		menu.addChoice ("End the Program");
		
		int choice;
		while ((choice = menu.getChoice ( )) != 14) {
			
			switch(choice) {
				
				case 1:
					createCollection();
					break;
					
				case 2:
					createSong();
					collection.addSong (mp3);
					break;
				case 3:
					edit();
					break;
					
				case 4:
					delete();
					break;
					
				case 5:
					display();
					break;
					
				case 6:
					title();		
					break;
					
				case 7:
					artist();
					break;
					
				case 8:
					genre();
					break;
					
				case 9:
					titleSort();
					break;
				case 10:
					save();
					break;
				
				case 11:
					read();
					break;
				
				case 12:
					collection.maxLength ( );
					break;
					
				default:	
					 //closes the program and thanks the user
		            //check for dirty flag to be set

		            //if dirty, ask if user wants to save and exit after save or exit with no save
		            if(MP3Tracker.isSaveNeeded())
		            {
		            	//promts the user that file needs to be saved and asks if they would like to
		                int reply = JOptionPane.showConfirmDialog(null, "You have changed some data and have not saved, would you like to save?", "Save?", JOptionPane.YES_NO_OPTION);
		                if (reply == JOptionPane.YES_OPTION) {
		                    try {
		                    	MP3Tracker.saveToFile("", ""); //calls saveToFile method from club class
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());  //displays error message to console
							}
		                }
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(null, "Thank you, " + user + ", for using the Club Roster.");
		            }
		         //   System.out.println(MP3Tracker.toString()); //prints all members
		            System.exit(0);
					break;
			}
		}

	}
	
	/**
	 * 
	 * Prompts the user to create a collection using the MP3Tracker Constructor        
	 *
	 * <hr>
	 * Date created: Jul 8, 2021
	 *
	 * <hr>
	 */
	private static void createCollection() {
		System.out.println("Enter the name of the collection:");
		String collectionName = kb.nextLine ( );
		
		System.out.println("Enter your first name: ");
		String firstName = kb.nextLine ( );
		
		System.out.println("Enter your last name: ");
		String lastName = kb.nextLine ( );
		
		System.out.println("Enter the date: ");
		String creationDate = kb.nextLine ( );
		
		collection = new MP3Tracker(collectionName,firstName,lastName,creationDate );

	}
	
	/**
	 * 
	 * Prompts user to enter all parameters of their song
	 * through the console and assigns it to a MP3 object    
	 *
	 * <hr>
	 * Date created: Jun 22, 2021
	 *
	 * <hr>
	 */
	private static void createSong() {
		System.out.println("Enter the Title of the song:");
		String title = kb.nextLine();
		System.out.println ("Enter the artist: " );
		String artist = kb.nextLine ( );
		System.out.println("Enter the Release Date of the song:");
		String releaseDate = kb.nextLine ( );
		System.out.println("Enter the Playback time of the song in minutes (3.15):");
		double playbackTime = kb.nextDouble ( );
		kb.nextLine ( );
		
		System.out.println("Enter the Genre of the song:");
		String songGenre = kb.nextLine ( ).toUpperCase ( );
		Genre genre = Genre.valueOf (songGenre);
		
		System.out.println("Enter the cost of the song(EX: 1.99):");
		double cost = kb.nextDouble ( );
		System.out.println("Enter the File Size of the song in Megabytes (4.89):");
		double filesize = kb.nextDouble ( );
		kb.nextLine ( );
		System.out.println("Enter the file name of the Album photo (EX:album.jpg):");
		String albumCover = kb.nextLine ( );
		
		//assigns entered data to a new MP3 object
		mp3 = new MP3(title, artist, releaseDate, playbackTime, genre, cost, filesize, albumCover);
		
		//prints the new song details
		System.out.println("=================================================");
		System.out.print(mp3.toString());
		System.out.println("=================================================");
	}
	
	/**
	 * 
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void edit() {
		
		if (collection != null)
		{
			System.out.println(collection.toString ( ));
			System.out.println ("Please enter the number of the song that you want to change:"); //promps the user to pick the array
			index = kb.nextInt ( );
			kb.nextLine ( );
			createSong ( );
			collection.editSong (index, mp3);
		}else {
			System.out.println("\nThere are no songs stored. Please Create add a song. \n");

		}
	}
	
	/**
	 * 
	 * Switch case to delete song from collection        
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void delete() {
		if (collection != null)
		{
			System.out.println (collection.toString ( ));
			System.out.println ("Please enter the number of the song that you want to remove:"); //using input removes the song
			index = kb.nextInt ( );
			collection.rvmSong (index);
			System.out.println ("Removal complete, Here is an updated list of all songs:");
			System.out.println (collection.toString ( )); //prints club toString
		}else {
			System.out.println("\nThere are no songs stored. Please Create add a song. \n");
		}
	}
	
	/**
	 * 
	 * Switch case for displaying songs in collection
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void display() {
		if(collection != null) {
			System.out.println("=================================================");
			System.out.print(collection.toString());
			System.out.println("=================================================");
		}else {
			System.out.println("\nThere are no songs stored. Please Create add a song. \n");
		}
	}
	
	/**
	 * 
	 * Switch case for searching titles     
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void title() {
		System.out.println("Enter the title of the song that you are searching for. " 
						+ "\n(Case sensitive)");
				strInput = kb.nextLine();
				collection.findTitle(strInput); //calls findName method from club class
	}
	
	/**
	 * 
	 * Switch case for searching artists       
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void artist() {
		System.out.println("Enter the artist of the song that you are searching for. " 
						+ "\n(Case sensitive)");
				strInput = kb.nextLine();
				collection.findArtist(strInput); //calls findArtist method from club class
	}
	
	/**
	 * 
	 * Switch method for searching genres
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void genre() {
		Genre search = null;
		System.out.println("Which type would you like to sort by: ROCK, POP, JAZZ, COUNTRY, CLASSICAL, OTHER");
		String answer = kb.nextLine ( ).toUpperCase ( );
		search = Genre.valueOf (answer);
		System.out.println(collection.genreType (search));
	}
	
	/**
	 * 
	 * Switch case for sorting by title
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void titleSort() {
		collection.sortTitle (collection.collectionSize ( ));
		System.out.println("Here is all songs ordered alphabetically:\n");
		collection.sortTitleDis ( );
	}
	
	/**
	 * 
	 * Switch case for saving to file
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void save() {
		try {
			MP3Tracker.saveToFile("", ""); //calls saveToFile method from club class
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage()); //displays error message to console
		}
	}
	
	/**
	 * 
	 * Switch case for reading from file
	 *
	 * <hr>
	 * Date created: Aug 1, 2021
	 *
	 * <hr>
	 */
	private static void read() {
		try {
			MP3Tracker.fillFromFile(); //calls fillFromFile method from club class
			//MP3Tracker.toString(); //Calls toString method from club class to display output
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage()); //displays error message to console
		}
	}
}
