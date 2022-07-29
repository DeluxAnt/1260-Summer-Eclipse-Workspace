/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 26, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;

import java.util.ArrayList;

/**
 * Player class inherits values from the participant class to 
 * create the player
 *
 * <hr>
 * Date created: Jul 26, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Player extends Participant
{
	private ArrayList<Weapon> inventory;
	private int playerRoomNumber;
	
	/**
	 * Creates default values for the player by inheriting attributes from 
	 * the participant constructor as well creating a inventory and setting the default room
	 * 
	 * created: Jul 26, 2021
	 */
	public Player()
	{
		super(100, 5);
		inventory = new ArrayList<Weapon>();
		playerRoomNumber = 0;
	}
	
	/**
	 * @return playerRoom number
	 * 
	 * created: Jul 26, 2021
	 */
	public int getPlayerRoomNumber()
	{
		return playerRoomNumber;
	}
	
	/**
	 * 
	 * Gets the player inventory       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return inventory
	 */
	public ArrayList<Weapon> getInventory()
	{
		return inventory;
	}
	
	/**
	 * @param playerRoomNumber - sets playerRoomNumber
	 * 
	 * created: Jul 26, 2021
	 */
	public void setPlayerRoomNumber(int playerRoomNumber)
	{
		this.playerRoomNumber = playerRoomNumber;
	}
	
}
