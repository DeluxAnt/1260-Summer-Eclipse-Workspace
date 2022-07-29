/**
 * ---------------------------------------------------------------------------
 * File name: Stick.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 28, 2021
 * ---------------------------------------------------------------------------
 */
package zorkGame;


/**
 * Sitck class inherits values from the weapon class to create
 * stick method for the player to interact with
 * 
 * Date Created: Jul 28, 2021
 * @author Anthony Vandergriff
 *
 */
public class Stick extends Weapon{
	
	/**
	 * Default constructor for the stick applying its 
	 * default damage values by inheriting from weapon class
	 * 
	 * Date Created: Jul 28, 2021
	 */
	public Stick() 
	{
		super(1);
	}

}
