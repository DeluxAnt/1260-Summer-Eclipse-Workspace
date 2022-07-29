/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date:Jul 26, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;

/**
 * The Participant class is used to pass attributes, parameters, and constructors
 * to all created Participants of the game. 
 * Example: Player and Monsters
 *
 * <hr>
 * Date created: Jul 26, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Participant
{
	private int healthPoints;
	private int damage;
	
	
	/**
	 * Default contructor sets default values of the 
	 * participants health and damage 
	 *
	 * created: Jul 26,2021
	 */
	public Participant()
	{
		healthPoints = 0;
		damage = 0;
	}
	
	/**
	 * Constructor allows for healthPoints and damage to be changed 
	 * using an int value, Used to change health and damage on the
	 * player and monsters
	 * 
	 * @param healthPoints
	 * @param damage
	 * 
	 * Created: Jul 26, 2021
	 */
	public Participant(int healthPoints, int damage)
	{
		this.healthPoints = healthPoints;
		this.damage = damage;
	}
	
	/**
	 * 
	 * @returns healthpoints
	 * 
	 * created: Jul 26, 2021
	 */
	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	/**
	 * 
	 * @returns damage
	 * 
	 * created: Jul 26, 2021
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**
	 * @param healthPoints - sets the healthPoints
	 * 
	 * created: Jul 26, 2021
	 */
	public void setHealthPoints(int healthPoints)
	{
		this.healthPoints = healthPoints;
	}
	
	/**
	 * @param damage - sets the damage
	 * 
	 * created: Jul 26,2021
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
}
