/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 27, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;


/**
 * The weapon class is used to pass attributes, parameters, and constructors
 * to all created weapons.
 *
 * <hr>
 * Date created: Jul 27, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Weapon
{
	int damageBoost;
	
	/**
	 * Default constructor sets default values
	 * to damageboost
	 * 
	 * created: Jul 27, 2021
	 */
	public Weapon()
	{
		damageBoost = 0;
	}
	
	/**
	 * Constructor allows for damageBoost to be changed 
	 * using an int value, Used to change damage on weapons
	 * 
	 * @param damageBoost
	 * 
	 * created: Jul 27, 2021
	 */
	public Weapon(int damageBoost)
	{
		this.damageBoost = damageBoost;
	}
	
	/**
	 * @return the damageBoost
	 * 
	 * created: Jul 27, 2021
	 */
	public int getDamageBoost()
	{
		return damageBoost;
	}
	
	/**
	 * @param damageBoost - set the damageBoost
	 * 
	 * created: Jul 27,2021
	 */
	public void setDamageBoost(int damageBoost)
	{
		this.damageBoost = damageBoost;
	}
}
