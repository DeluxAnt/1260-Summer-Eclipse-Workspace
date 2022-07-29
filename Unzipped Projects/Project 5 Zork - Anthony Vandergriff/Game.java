/**
 * ---------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, vandergriff@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 26, 2021
 * ---------------------------------------------------------------------------
 */

package zorkGame;

import java.util.Random;

/**
 * Creates the game which coordinates the player, monster, and dungeon classes.
 *
 * <hr>
 * Date created: Jul 26, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Game
{
    private Player player;
    private Dungeon dungeon;

    /**
     * 
     * Constructor initializes a new player, dungeon, and 
     * calls the setPlayerToStart method using the player 
     * for its parameter       
     *
     * Date created: Jul 26, 2021 
     *
     *
     */
    public Game()
    {
        player = new Player();
        dungeon = new Dungeon();
        dungeon.setPlayerToStart(player);
    }
    
    /**
     * 
     * Gets Dungeon        
     *
     * Date created: Jul 26, 2021
     *
     * @return Dungeon
     */
    public Dungeon getDungeon()
    {
    	return dungeon;
    }
    
    /**
     * 
     * gets Player      
     *
     * Date created: Jul 26, 2021
     *
     * @return Player
     */
    public Player getPlayer()
    {
    	return player;
    }
    
    /**
     * playerMoveWest allows the player to move to the left
     * if there is a room left of the player using a boolean object to validate.
     * 
     * 
     * Date created: Jul 26, 2021
     */
    public void playerMoveWest()
    {
        	dungeon.getDungeonRooms()[player.getPlayerRoomNumber()].setPlayer(null); // set player field to null for room player is currently in
			dungeon.getDungeonRooms()[player.getPlayerRoomNumber() - 1].setPlayer(player); // set the player field to contain player parameter at next room to the east
			player.setPlayerRoomNumber(player.getPlayerRoomNumber() - 1);
    }
    
    /**
     * playerMoveEast allows the player to move to the right
     * if there is a room right of the player 
     * 
     * Date Created: Jul 26, 2021
     */
    public void playerMoveEast()
    {
        	dungeon.getDungeonRooms()[player.getPlayerRoomNumber()].setPlayer(null); // set player field to null for room player is currently in
			dungeon.getDungeonRooms()[player.getPlayerRoomNumber() + 1].setPlayer(player); // set the player field to contain player parameter at next room to the east
            player.setPlayerRoomNumber(player.getPlayerRoomNumber() + 1);
    }
    
    /**
     * Calculates hit chance and miss chances with respective outputs 
     * based on random number generation with health calculations for the monster
     * 
     * Date Created: Jul 26, 2021
     */
    public String monsterAttack() 
    {
    	String monsterHit = "";
		Random rand = new Random();
		if(rand.nextInt(5) == 0) 
		{
			monsterHit = "The monster missed you!";
			return monsterHit;
		}
		else 
		{
			player.setHealthPoints(player.getHealthPoints() - dungeon.getMonsterInPlayerRoom(player).getDamage());
			monsterHit = "You are hit by the monster! Player Health: " + player.getHealthPoints ( );
			return monsterHit;
		}
	}

    /**
     * Calculates hit chance and miss chances with respective outputs 
     * based on random number generation with health calculations for the player
     * 
     * Date Created: Jul 26, 2021
     * 
     */
    public String playerAttack() 
    {
    	String playerHit = "";
		Random rand = new Random();
		if(rand.nextInt(10) == 0) 
		{
			playerHit = "You miss the monster!";
			return playerHit;
		}
		else 
		{
			dungeon.getMonsterInPlayerRoom(player).setHealthPoints(dungeon.getMonsterInPlayerRoom(player).getHealthPoints() - player.getDamage ( ));
			playerHit = "You get a hit on the monster! Monster Health: " + dungeon.getMonsterInPlayerRoom(player).getHealthPoints();
			return playerHit;
		}
    }

    /**
     *  Method checks for monsters and if true then the playerAttack 
     *  and mosterAttack methods will loop until either the player 
     *  or monster's health is depleted
     *  
     *  Date created: Jul 26, 2021
     */
    public String attackSequence()
    {
    	String attackSequence = "";
        if(dungeon.getMonsterInPlayerRoom(player) != null)
        {
        	attackSequence += "\nA " + dungeon.getSpecificRoom(player.getPlayerRoomNumber()).getMonsterName() + "!\n"
        					+ "You start to attack.\n\n";
            do
            {
               attackSequence += playerAttack() + "\n";
               attackSequence += monsterAttack() + "\n";
            }while(player.getHealthPoints() > 0 && dungeon.getMonsterInPlayerRoom(player).getHealthPoints() > 0);
            
            if(dungeon.getMonsterInPlayerRoom(player).getHealthPoints() <= 0)
            {
            	dungeon.getDungeonRooms()[player.getPlayerRoomNumber()].setMonster(null);
            }
            return attackSequence;
        }
        else
        {
        	attackSequence = "No monsters in here...";
        	return attackSequence;
        }
    }
}
