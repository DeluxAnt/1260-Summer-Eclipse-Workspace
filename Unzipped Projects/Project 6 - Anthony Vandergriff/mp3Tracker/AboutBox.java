/**
 * ---------------------------------------------------------------------------
 * File name: AboutBox.java
 * Project name: MP3 - Project 6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Aug 10, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Aug 10, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class AboutBox extends JDialog
{
	private JLabel titleLabel, classLabel, 
					imageLable, namelabel;
	private JButton button;

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Aug 10, 2021 
	 *
	 * 
	 */
	public AboutBox (JFrame parent )
	{
		super(parent, "About MP3 Tracker...", true);
		this.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		button = new JButton("OK");
		titleLabel = new JLabel("MP3 Tracker");
		titleLabel.setForeground (Color.BLUE);
		
		imageLable = new JLabel();
		imageLable.setIcon (new ImageIcon("Pictures/mp3-logo.png"));
		
		classLabel = new JLabel("Created for 1260, Project 6");
		namelabel = new JLabel("Anthony Vandergiff, August, 2021");
		
		button.addActionListener (new Listener());
		
		add(titleLabel);
		add(imageLable);
		add(classLabel);
		add(namelabel);
		add(button);
		
		setSize(300,300);
		setVisible(true);
		
		
		
		
	}

	private class Listener implements ActionListener
	{

		@Override
		public void actionPerformed (ActionEvent e)
		{
			// Appropriate method calculates the results
			AboutBox.super.setVisible (false);
		}

	}

}
