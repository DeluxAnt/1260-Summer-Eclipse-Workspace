/**
 * ---------------------------------------------------------------------------
 * File name: Hand.java
 * Project name: Classwork-Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 30, 2021
 * ---------------------------------------------------------------------------
 */

package cards;


/**
 * Allows the creation of a hand of cards
 * using methods to create constructors, population,
 * and display
 *
 * <hr>
 * Date created: Jun 30, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Hand
{

	private int handSize = 5;
	private int cardsInHand;
	private Card[] hand;
	
	/**
	 * Default constructor sets the default
	 * hand size to 5
	 */
	public Hand() {
	//add attributes
		this.handSize = 5;
		this.cardsInHand = 0;
		
	}
	
	/**
	 * Using user input to change the size of 
	 * the given hand
	 * 
	 * @param handSize - integer that user inputs
	 */
	public Hand(int handSize) {
		this.handSize = handSize;
	    cardsInHand = 0;
	    this.hand = new Card[handSize];
	}
	
	/**
	 * Copy constructor for Hand class
	 * @param handIn
	 */
	public Hand(Hand handIn) {
		this.handSize = handIn.handSize;
		this.cardsInHand = handIn.cardsInHand;
		for(int i = 0; i < handIn.hand.length; i++) {
	    		handSize = handIn.cardsInHand;
	    		
	    	}
		}
    	
	
	
	/**
	 * Adds card to hand one at a time
	 * @param card
	 */
	public void addCard(Card card) {
		
		hand[cardsInHand] = card;
		 cardsInHand++;
	}
	
	/**
	 * Displays the hand to the user
	 * 
	 */
	public  String toString() {
		String s = "";
		for(int i = 0; i < handSize; i++) {
			s += hand[i] + "\n";
		}
		//add and retrieve indexes to string
		
		return s;
	}

	
}
