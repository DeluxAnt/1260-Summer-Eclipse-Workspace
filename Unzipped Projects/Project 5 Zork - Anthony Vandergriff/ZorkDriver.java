/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 26, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;

import java.util.Random;
import java.util.*;

/**
 * Driver class containing main method
 *
 * <hr>
 * Date created: Jul 26, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class ZorkDriver
{
	private static Game zork;
	
	/**
	 * 
	 * Main method initiates the game and menu to take player input 
	 * to coordinate different actions in the game.       
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random rand = new Random();
		Scanner kb = new Scanner(System.in);
		zork = new Game();

		System.out.println("Welcome to Zork! In this game, you must make your way through a perilous dungeon filled with monsters.\n" +
						   "Each room may have a monster and/or a weapon in it. You may pick up the weapon to help defeat your foes!\n" +
						   "Make it to the end alive, and you win!\n\n");
		
		System.out.println(zork.getDungeon());
		addWeaponToInventory(kb);
		System.out.println("Player Hit Points left: " + zork.getPlayer().getHealthPoints());
		int choice = 0;
		do
		{
			try
			{
				choice = menu(kb);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Congratulations, you have beaten the Dungeon!");
				choice = 3;
			}
		}while(choice != 3 && zork.getPlayer().getHealthPoints() > 0);
		
		if(zork.getPlayer().getHealthPoints ( ) <= 0)
		{
			System.out.println("Game Over. You died.");
		}
		
		kb.close();
		System.exit(0);
	}
	
	/**
	 * 
	 * Menu class displays a menu and takes player input on a choice.
	 * Returns an action based on the player choice.
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param kb
	 * @return int
	 */
	public static int menu(Scanner kb)
	{
		String menu = 		"Please Enter Your Choice Below. You May Go East, Go West, Or Give Up.\n";
		
		System.out.println(menu);
		String choice = kb.nextLine();
		int choiceReturn = 0;
		
		switch(choice.trim().toLowerCase())
		{
			case "go west":
				choiceReturn = 1;
				if(!zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getHasWestDoor()) // if the room the player i currently in doesn't have a west door
				{
					System.out.println("Sorry, I can't go that way.");
				}
				else
				{
					zork.playerMoveWest();
					addWeaponToInventory(kb);
				}
				System.out.println(zork.attackSequence());
				System.out.println("Player Hit Points left: " + zork.getPlayer().getHealthPoints());
				System.out.println(zork.getDungeon());
			break;
			
			case "go east":
				choiceReturn = 2;
				if(!zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getHasEastDoor()) // if the room the player is currently in doesn't have an east door
				{
					System.out.println("Sorry, I can't go that way.");
				}
				else
				{
					zork.playerMoveEast();
					addWeaponToInventory(kb);
				}
				System.out.println(zork.attackSequence());
				System.out.println("Player Hit Points left: " + zork.getPlayer().getHealthPoints());
				System.out.println(zork.getDungeon());
			break;
				
			case "give up":
				choiceReturn = 3;
				System.out.println("Goodbye, and thanks for playing.");
			break;
			
			default:
				System.out.println("I do not know what you mean.");
				System.out.println(zork.getDungeon());
			break;
		}
		return choiceReturn; 
	}
	
	/**
	 * 
	 * Prompt a player to add a weapon to their inventory      
	 *
	 * <hr>
	 * Date created: Jul 26, 2021
	 *
	 * <hr>
	 * @param kb
	 */
	public static void addWeaponToInventory(Scanner kb)
	{
		int largeLoopControl = 1;
		while(largeLoopControl == 1)
		{
			if(zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getWeapon() != null) // if the room the player is currently in has a weapon
			{
				System.out.println("There is a " + zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getWeaponName() + 
								   " in this room. Would you like to pick it up? (yes/no)");
				
				String userPickUpString = "";
				userPickUpString = kb.nextLine();
				int loopControl = 1;
				while(loopControl == 1)
				{
					switch(userPickUpString.trim().toLowerCase())
					{
						case "yes":
						// add the weapon from the room the player is currently in to the player's inventory (below)
						zork.getPlayer().getInventory().add(zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getWeapon());
						zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).setWeapon(null); // set the weapon field for room player is currently in to null
						System.out.println("Picked up " + zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getWeaponName() + "!");
						loopControl = 0;
						largeLoopControl = 0;
						break;
						
						case "no":
						System.out.println("Left the " + zork.getDungeon().getSpecificRoom(zork.getPlayer().getPlayerRoomNumber()).getWeaponName() + " on the ground");
						loopControl = 0;
						largeLoopControl = 0;
						break;
						
						default:
						System.out.println("I don't know what you mean");
						largeLoopControl = 1;
						loopControl = 0;
						break;
					}
				}
			}else
			{
				break;
			}
		} // end while(largeControlLoop == 1)
	} // end addWeaponToInvetory()
}
