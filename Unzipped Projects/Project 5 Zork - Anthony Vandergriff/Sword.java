/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 28, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;


/**
 * Sword class inherits values from the weapon class to create
 * sword method for the player to interact with
 *
 * <hr>
 * Date created: Jul 28, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Sword extends Weapon
{
	/**
	 * Default constructor for the sword applying its 
	 * damage values by inheriting from weapon class
	 * 
	 * Date Created: Jul 28, 2021
	 */
	public Sword()
	{
		super(3);
	}
}
