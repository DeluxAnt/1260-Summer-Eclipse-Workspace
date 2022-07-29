/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 25, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;

import java.util.Random;

/**
 * Creates a dungeon which is an array full of rooms.
 *
 * <hr>
 * Date created: Jul 25, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Dungeon
{
	private Room[] dungeonRooms;
	private Random rand = new Random();
	
	/**
	 * 
	 * Constructor creates the array of a random amount of rooms to create the dungeon.   
	 *
	 * <hr>
	 * Date created: Jul 26, 2021 
	 *
	 *
	 */
	public Dungeon()
	{
		dungeonRooms = new Room[rand.nextInt(6) + 5]; // generate an array of rooms sized randomly from 5 to 10
		for(int i = 0; i < dungeonRooms.length; i++)
		{
			dungeonRooms[i] = new Room();
		}
		dungeonRooms[0].setHasWestDoor(false);
		
		// Randomly place a monster in one of the rooms except for the starting room
		{
			for(int i = 1; i < dungeonRooms.length; i++)
			{
				dungeonRooms[i].monsterAdder(); // 50% chance to add a monster to room at index i

			}
		}
		
		// Randomly place a sword in one of the rooms
		int swordCheck = 0;
		while(swordCheck == 0)
		{
			for(int i = 0; i < dungeonRooms.length; i++)
			{
				if(swordCheck == 1) // if a sword exists in the dungeonRooms array, exit the loop
				{
					break;
				}
				dungeonRooms[i].weaponAdder(); // 75% chance to add a sword to room at index i
				if(dungeonRooms[i].getWeapon() != null)
				{
					swordCheck = 1;
				}
			}
		}
	} // end Dungeon()
	
	
	/**
	 * 
	 * get the dungeonRooms array       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return dungeonRooms
	 */
	public Room[] getDungeonRooms()
	{
		return dungeonRooms;
	}
	
	/**
	 * 
	 * get a specific dungeon room      
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param i
	 * @return dungeonRooms[i]
	 */
	public Room getSpecificRoom(int i)
	{
		return dungeonRooms[i];
	}
	

	
	/**
	 * 
	 * Sets the player to the start of the dungeon      
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param player
	 */
	public void setPlayerToStart(Player player)
	{
		dungeonRooms[0].setPlayer(player);
	}
			

	
	/**
	 * 
	 * Dungeon toString returns all the rooms in the dungeon array
	 * to display them.        
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return tempString
	 */
	public String toString()
	{
		String tempString = "";
		for(Room room : dungeonRooms)
		{
			tempString += room.toString();
		}
		return tempString;
	}
	
	/**
	 * 
	 * Gets the monster in the player's room.         
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param player
	 * @return dungeonRooms[player.getPlayerRoomNumber()].getMonster()
	 */
	public Monster getMonsterInPlayerRoom(Player player)
	{
		return dungeonRooms[player.getPlayerRoomNumber()].getMonster();
	}
}
