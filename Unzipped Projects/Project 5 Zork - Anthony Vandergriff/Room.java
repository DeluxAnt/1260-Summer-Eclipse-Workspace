/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
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
 * Creates a room that can contain a monster and weapon.
 * A player can also be in room. 
 *
 * <hr>
 * Date created: Jul 25, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Room
{
	private boolean hasWestDoor,
					hasEastDoor;
	private Player 	player;
	private Monster monster;
	private Weapon	weapon;
	private String	weaponType,
					monsterType,
					weaponName,
					monsterName;
	
	/**
	 * 
	 * Constructor creates a room with an east and west door.
	 * Establishes monster and player values.
	 *
	 * <hr>
	 * Date created: Jul 26, 2021 
	 *
	 *
	 */
	public Room()
	{
		hasWestDoor = true;
		hasEastDoor = true;
		player = null;
		monster = null;
	}
	

	
	/**
	 * 
	 * Returns true if a room has a west door.    
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return hasWestDoor
	 */
	public boolean getHasWestDoor()
	{
		return hasWestDoor;
	}
	
	/**
	 * 
	 * Returns true if a room has an east door.
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return hasEastDoor
	 */
	public boolean getHasEastDoor()
	{
		return hasEastDoor;
	}
	
	/**
	 * 
	 * Gets the player.    
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return player
	 */
	public Player getPlayer()
	{
		return player;
	}
	
	/**
	 * 
	 * Gets the monster.       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return monster
	 */
	public Monster getMonster()
	{
		return monster;
	}
	
	/**
	 * 
	 * Gets the weapon in the room    
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	/**
	 * 
	 * Gets the name of the weapon in the room       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return weaponName
	 */
	public String getWeaponName()
	{
		return weaponName;
	}
	
	/**
	 * 
	 * Gets the name of the monster in the room       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @return monsterName
	 */
	public String getMonsterName()
	{
		return monsterName;
	}
	

	
	/**
	 * 
	 * Sets if a room has a west door        
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param hasWestDoor
	 */
	public void setHasWestDoor(boolean hasWestDoor)
	{
		this.hasWestDoor = hasWestDoor;
	}
	
	/**
	 * 
	 * Sets if a room has an east door      
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param hasEastDoor
	 */
	public void setHasEastDoor(boolean hasEastDoor)
	{
		this.hasEastDoor = hasEastDoor;
	}
	
	/**
	 * 
	 * Sets a room's player   
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	/**
	 * 
	 * Sets a room's monster        
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param monster
	 */
	public void setMonster(Monster monster)
	{
		this.monster = monster;
	}
	
	/**
	 * 
	 * Sets a room's weapon    
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param weapon
	 */
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}
	


	/**
	 * 
	 * Has a chance of adding a monster to the room.
	 * Randomly chooses a type of monster.        
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 */
	public void monsterAdder()
	{
		Random rand = new Random();
		if(rand.nextInt(10000) < 5000) // 50% chance
		{
			int monsterProbability;
			monsterProbability = rand.nextInt(10000);
			
			if(monsterProbability < 3333 && monsterProbability > 0)
			{
				monster = new GiantMosquito();
				monsterType = "GM";
				monsterName = "Giant Mosquito";
			}
			else if(monsterProbability < 6666 && monsterProbability > 3333)
			{
				monster = new Goblin();
				monsterType = "GB";
				monsterName = "goblin";
			}
			else if(monsterProbability < 10000 && monsterProbability > 6666)
			{
				monster = new Minotaur();
				monsterType = "MT";
				monsterName = "Minotaur";
			}
		}
	}
	
	
	/**
	 * 
	 * Randomly adds a type of weapon to the room         
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 */
	public void weaponAdder()
	{
		Random rand = new Random();
		if(rand.nextInt(10000) < 5000) // 50% chance.
		{
			int weaponProbability;
			weaponProbability = rand.nextInt(10000);
			
			if(weaponProbability < 2000 && weaponProbability > 0)
			{
				weapon = new Sword();
				weaponType = "SW";
				weaponName = "sword";
			}
			else if(weaponProbability < 4000 && weaponProbability > 2000)
			{
				weapon = new Stick();
				weaponType = "SK";
				weaponName = "stick";
			}
			else if(weaponProbability < 6000 && weaponProbability > 4000)
			{
				weapon = new Mace();
				weaponType = "MC";
				weaponName = "mace";
			}
			else if(weaponProbability < 8000 && weaponProbability > 6000)
			{
				weapon = new Flail();
				weaponType = "FL";
				weaponName = "flail";
			}
			else if(weaponProbability < 10000 && weaponProbability > 8000)
			{
				weapon = new Gorilla();
				weaponType = "GA";
				weaponName = "gorilla";
			}
		}
	} // end weaponAdder()
	
	/**
	 * 
	 * Room toString prints out the visual appearance of the room.    
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
		
		tempString += "|";
		if(player != null)
		{
			tempString += "P";
		}
		else
		{
			tempString += "_";
		}

		if(monster != null)
		{
			tempString += monsterType;
		}
		else
		{
			tempString += "_";
		}

		if(weapon != null)
		{
			tempString += weaponType;
		}
		else
		{
			tempString += "__";
		}
	
		tempString += "|";
		return tempString;
	}
}
