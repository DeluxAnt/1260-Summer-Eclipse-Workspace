/**
 * ---------------------------------------------------------------------------
 * File name: CardsDriver.java
 * Project name: Classwork-Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 16, 2021
 * ---------------------------------------------------------------------------
 */

package cards;

import java.util.Scanner;

/**
 * Used to run and demonstrate the Card, Deck, and Hand classes
 *
 * <hr>
 * Date created: Jun 16, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class CardsDriver
{

	static Scanner sc = new Scanner(System.in);


	/**
	 * Runs objects and methods from the Card, Deck, and hand
	 * for the user to interact with
	 *
	 * <hr>
	 * Date created: Jun 16, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		// TODO Auto-generated method stub
		
		Deck deck = new Deck();
		Card defaultCard = new Card();
		System.out.println("The default card is " + defaultCard);
		
		System.out.println ("The Default Deck: \n" + "\n" + deck );
		
		//Shuffles original deck
		deck.shuffle();
		
		//Copied deck of 'deck'
		Deck existingDeck = new Deck(deck);

		//Displays the shuffled copied deck
		System.out.println("Shuffled deck: \n" + "\n" + existingDeck );
				
		//Simulates player 1's hand with 7 cards from the copied deck
		System.out.println("Player 1: \n" + existingDeck.dealAHand(7)  + "\n");
				
		//Simulates player 2's hand with 7 cards from the copied deck
		System.out.println("Player 2: \n" + existingDeck.dealAHand(7) + "\n");
				
		int handSize;
		int player;
		
		//Prompts the user to input amount of cards per hand
		System.out.println("How many cards would you like in a hand?");
		handSize = sc.nextInt();
			
		//Prompts the user to input amount of players (hands)
		System.out.println("How many players are playing?");
		player = sc.nextInt();
			
		/**
		 * loop logic will see if user entered parameters will be more than 52,
		 * if it is over then the user will be prompted to enter their values again
		 * until entered correctly
		 */
		while(handSize * player > 52) {
			System.out.println("There are not enough cards in the deck to deal " + player + " hands of " + handSize + " cards. Try Again.");
				
			System.out.println("How many cards would you like in a hand?");
			handSize = sc.nextInt();
				
			System.out.println("How many players are playing? \n");
			player = sc.nextInt();
		}
			
		
			
		/**
		 * For loop creates Hands based on user input and displays
		 * said hands, as well as, player numbers
		 */
		
		for(int i = 0; i < player; i++)	{
				
			System.out.println("Player " + i +  
					"\n" + deck.dealAHand(handSize) );
			
			}
			

	}
	


}
