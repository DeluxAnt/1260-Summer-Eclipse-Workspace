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
		//creates a menu using imported util
		Menu menu = new Menu("Menu for Project 1 - MP3");
		
		JOptionPane.showMessageDialog (null, "Welcome to MP3 player!" + 
										"\n Here you can enter and display songs.");
		
		String user = JOptionPane.showInputDialog(null, "Welcome to MP3 Player." + "\n What is your name?");

		menu.addChoice ("Create a new MP3 File");
		menu.addChoice ("Display an MP3 File");
		menu.addChoice ("End the Program");
		
		int choice;
		while ((choice = menu.getChoice ( )) != 4) {
			
			switch(choice) {
				
				case 1:
					createSong();
					break;
					
				case 2:
					//displays song
					if(mp3 != null) {
						System.out.println("=================================================");
						System.out.print(mp3.toString());
						System.out.println("=================================================");
						
						
					}else 
					{			//if there is no song then it will display an error message

					System.out.println("\nThere are no songs stored. Please add a new song. \n");

					}
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
