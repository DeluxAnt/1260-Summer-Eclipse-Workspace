/**
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: Classwork-Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jun 30, 2021
 * ---------------------------------------------------------------------------
 */

package cards;


import java.util.Random;


/**
 * Creates the ability to store cards into a deck
 * with the options to populate, copy, display, 
 * deal a singular card, shuffle, and deal a hand
 *
 * <hr>
 * Date created: Jun 30, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Deck
{
	private int nextCard = 0;
	private  Card[] deck = new Card[52];
	
	/**
	 * Initializes the default deck of cards using an array
	 * and a for loop to fill the deck with cards
	 */
	public Deck(){
		for(int i = 0; i < deck.length; i++)
    		deck[i] = new Card(i);
    	}
	
	/**
	 * Copies the values from the default deck to
	 * create a deep copy so there is no interference 
	 * @param exisitingDeck - copied deck name field value
	 */
    public Deck(Deck exisitingDeck) {
    	
    	for(int i = 0; i < deck.length; i++)
    		deck[i] = exisitingDeck.deck[i];
    	}
    
    /**
     * Prints out all cards within a deck 
     * using a for loop to print all 52 cards
     * @return
     */
    public String toString() {
    	String s = "";
    	for(int i = 1; i <52; i++) {
    		s += deck[i] + "\n";
    	}
		return s;
    }
    
    /**
     * Pulls cards using their array value and
     * Iterates through the whole deck when called
     * 
     * @return
     */
    public Card dealACard() {
    	
    	return deck[nextCard++];
    }
    
    /**
     * Shuffles whole deck 1000 times and creates a new random object each
     * time it is called so java calls a new seed to truly randomize
     */
    public void shuffle() {
    	Random rand = new Random();
    	for(int i = 1; i < 1000; i++) {
    		int rcard = rand.nextInt(52);
    		int ncard = rand.nextInt(52);
    		Card temp = deck[rcard];
    		deck[rcard] = deck[ncard];
    		deck[ncard] = temp;
    	}
    }
    
    /**
     * Deals a hand to player(s) based on what the user
     * has entered to be the hand size
     * 
     * @param handSize - user entered integer
     * @return
     * 
     */
    public Hand dealAHand(int handSize) {
    	Hand nHand = new Hand(handSize);
		for(int i = 0; i < handSize; i++) {
			nHand.addCard(dealACard());//the idea is that the loop should add x amount of cards to the hand
		}
    	return nHand;
    }
	
	
}
