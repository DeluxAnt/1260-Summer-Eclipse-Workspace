/**
 * ---------------------------------------------------------------------------
 * File name: BowlingAverageDriver.java
 * Project name: Classwork - Exception Handling - Bowling
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 7, 2021
 * ---------------------------------------------------------------------------
 */

package bowling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Demonstrates the functionality of the BowlingAverage class as well
 * as the functionality of the try-catch exception handling
 *
 * <hr>
 * Date created: Jul 7, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class BowlingAverageDriver
{

	
	private static Scanner kb = new Scanner(System.in); 				
	private static BowlingAverage defAve = new BowlingAverage();		//Creates new average object from the BowlingAverage constructors
	private static BowlingAverage uAve = new BowlingAverage();	    //Creates new average object from parameterized constructor
	
	
	
	/**
	 * Runs objects and methods created from the BowlingAverage 
	 * and BowlingException classes         
	 *
	 * <hr>
	 * Date created: Jul 7, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		int numGames = 0;
		Scanner sc = new Scanner(System.in);
		String flag = null;
		
		
		System.out.println("Default Bowiling Average: " + defAve.toString ( ));
		System.out.println("-------------------------------------------------------");

		do {
			input();
			
			System.out.println ("Do you want to average more scores? (yes or no)");
			
			flag = sc.next ( );
		}while(flag.equalsIgnoreCase ("yes"));
		
		System.out.println("Goodbye. Thank you for using this program.");  //thanks the user for using the program
		kb.close();			//stops scanning keyboard for inputs
		System.exit(0);		//Closes the program

	}



	/**
	 * This is where the user will input all prompts.
	 * Also try-catch handles all exceptions that could be produced         
	 *
	 * <hr>
	 * Date created: Jul 7, 2021
	 *
	 * <hr>
	 */
	private static void input ( )
	{
		boolean ok = false;
		
		while(!ok) {
			try {
				System.out.println("How many games were played?"); //sets array size with user set integer
				int numGames = kb.nextInt ( );
				int[] scores = new int[numGames];
				
				for(int i = 0; i < scores.length; i++) {
					System.out.println("Enter the score for game " + (i+1) + ":");
					scores[i] = kb.nextInt ( );
				}
				
				uAve = new BowlingAverage(scores, numGames);
				ok = true;	
				
			} catch(BowlingException e) {
				System.out.println(e.getMessage());
				
			} catch (InputMismatchException e) {		//InputMismatchException will catch invalid user inputs regarding integers
				System.out.println("Invalid integer input.");
				kb.nextLine();
				
			} catch (NegativeArraySizeException e) {	//NegativeArraySizeException will catch invalid responses regarding games played
				System.out.println("Invalid amount of games played.");
				kb.nextLine();
			}
		}
		
		System.out.println(uAve.toString ( ));
		
	}

}
