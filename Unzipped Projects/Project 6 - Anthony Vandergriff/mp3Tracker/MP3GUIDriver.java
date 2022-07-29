/**
 * ---------------------------------------------------------------------------
 * File name: MP3GUIDriver.java
 * Project name: MP3 - Project 6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Aug 9, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import javax.swing.SwingUtilities;

/**
 * Runs GUI created from aboutbox and mp3trackergui classes
 *
 * <hr>
 * Date created: Aug 9, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3GUIDriver
{

	/**
	 * main executes GUI         
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		AboutBox window = new AboutBox(null);
		
		
		SwingUtilities.invokeLater (new Runnable ( )
		{
			@Override
			public void run ( )
			{
				new MP3TrackerGUI ( );
			}
		});

	}

}
