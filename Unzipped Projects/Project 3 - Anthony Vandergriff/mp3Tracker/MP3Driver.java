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
		menu.addChoice ("Sort all MP3s by shortest playback time");
		menu.addChoice ("End the Program");
		
		int choice;
		String strInput;
		while ((choice = menu.getChoice ( )) != 12) {
			
			switch(choice) {
				
				case 1:
					createCollection();
					break;
					
				case 2:
					createSong();
					collection.addSong (mp3);
					break;
				case 3:
					int index;
					
					if (collection != null)
					{
						System.out.println ("Please enter the number of the member that you want to change:"); //promps the user to pick the array
						index = kb.nextInt ( );
						kb.nextLine ( );
						createSong ( );
						collection.editSong (index, mp3);
					}else {
						System.out.println("\nThere are no songs stored. Please Create add a song. \n");

					}
					break;
					
				case 4:
					if (collection != null)
					{
						System.out.println (collection.toString ( ));
						System.out.println ("Please enter the number of the song that you want to remove:"); //using input removes the song
						index = kb.nextInt ( );
						System.out.println ("Removal complete, Here is an updated list of all songs:");
						System.out.println (collection.toString ( )); //prints club toString
					}else {
						System.out.println("\nThere are no songs stored. Please Create add a song. \n");
					}
					break;
					
				case 5:
					if(collection != null) {
						System.out.println("=================================================");
						System.out.print(collection.toString());
						System.out.println("=================================================");
					}else {
						System.out.println("\nThere are no songs stored. Please Create add a song. \n");
					}
					break;
					
				case 6:
					
					System.out.println("Enter the title of the song that you are searching for. " 
									+ "\n(Case sensitive)");
							strInput = kb.nextLine();
							collection.findTitle(strInput); //calls findName method from club class
								
					break;
					
				case 7:

					System.out.println("Enter the artist of the song that you are searching for. " 
									+ "\n(Case sensitive)");
							strInput = kb.nextLine();
							collection.findArtist(strInput); //calls findArtist method from club class
					break;
					
				case 8:
					Genre search = null;
					System.out.println("Which type would you like to sort by: ROCK, POP, JAZZ, COUNTRY, CLASSICAL, OTHER");
					String answer = kb.nextLine ( ).toUpperCase ( );
					search = Genre.valueOf (answer);
					System.out.println(collection.genreType (search));
					break;
					
				case 9:
					collection.sortTitle (collection.collectionSize ( ));
					System.out.println("Here is all songs ordered alphabetically:\n");
					collection.sortTitleDis ( );
					break;
				
				case 10:
					Collections.sort (collecionAlb);
					break;
					
				default:	
					JOptionPane.showMessageDialog(null, "Thank you " + user + " for using MP3 player!");
					
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
		System.out.println("Enter the Playback time of the song:");
		double playbackTime = kb.nextDouble ( );
		kb.nextLine ( );
		
		System.out.println("Enter the Genre of the song:");
		String songGenre = kb.nextLine ( ).toUpperCase ( );
		Genre genre = Genre.valueOf (songGenre);
		
		System.out.println("Enter the cost of the song:");
		double cost = kb.nextDouble ( );
		System.out.println("Enter the File Size of the song:");
		double filesize = kb.nextDouble ( );
		kb.nextLine ( );
		System.out.println("Enter the file name of the Album photo:");
		String albumCover = kb.nextLine ( );
		
		//assigns entered data to a new MP3 object
		mp3 = new MP3(title, artist, releaseDate, playbackTime, genre, cost, filesize, albumCover);
		
		//prints the new song details
		System.out.println("=================================================");
		System.out.print(mp3.toString());
		System.out.println("=================================================");

						


	}
	
	

}
