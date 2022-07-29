/**
 * ================================================================
 * File Name: Card.java
 * Project Name: Classwork-Cards
 * ================================================================
 * Creator's Name/Email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course: CSCI 1260
 * Created: 6/16/2021
 */
package cards;

/**
 * Creates default, copy, and Parameterized constructors 
 * as well as a formatted toString to be used by other classes
 * 
 * @author Anthony Vandergriff
 *
 */
public class Card {
	
	private Face face;
	private Suit suit;
	
	/**
	 * 
	 * Default Constructor
	 *
	 * <hr>
	 * Date created: Jun 16, 2021 
	 *
	 *
	 */
	public Card() {
		this.face = face.ACE;
		this.suit = suit.HEARTS;
	}
	
	/**
	 * 
	 * Copy Constructor        
	 *
	 * <hr>
	 * Date created: Jun 16, 2021 
	 *
	 * 
	 * @param exisitingCard
	 */
	public Card(Card exisitingCard) {
		this.face = exisitingCard.face;
		this.suit = exisitingCard.suit;
	}
	/**
	 * 
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Jun 16, 2021 
	 *
	 * 
	 * @param n
	 */
	public Card(int n) {
		face = Face.values()[n%13];
		suit = Suit.values()[n%4];
	}
	
	/**
	 * Format object of type Card as a String for
	 * possible display by another class
	 *
	 * Date created: Jun 16, 2021
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String resultOut = "The " + face + " of " + suit + "\n";

		return resultOut;
	} // end toString

	

}
