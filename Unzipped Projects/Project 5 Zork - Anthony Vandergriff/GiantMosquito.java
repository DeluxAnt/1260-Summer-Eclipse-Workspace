/**
 * ---------------------------------------------------------------------------
 * File name: GiantMosquito.java
 * Project name: Zork - Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Aug 1, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;


/**
 * Extends the Monster class to add variety
 *
 * <hr>
 * Date created: Aug 1, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class GiantMosquito extends Monster
{

	/**
	 * Default Constructor to set damage and health        
	 *
	 * <hr>
	 * Date created: Aug 1, 2021 
	 *
	 * 
	 */
	public GiantMosquito ( )
	{
		super();
		setHealthPoints(35);
		setDamage(10);
	}

}
