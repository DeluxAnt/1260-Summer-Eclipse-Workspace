/**
 * ---------------------------------------------------------------------------
 * File name: MP3TrackerGUI.java
 * Project name: MP3 - Project 6
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Aug 9, 2021
 * ---------------------------------------------------------------------------
 */

package mp3Tracker;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Creates the GUI for MP3 tracker
 *
 * <hr>
 * Date created: Aug 9, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class MP3TrackerGUI extends JFrame
{
	
	private static MP3Collection mP3Collection = null;
	private static Scanner kb = new Scanner (System.in);
	private static MP3				mp3			= null;
	private static String			userName	= null;
	private static String			fileName;
	

	private static final long	serialVersionUID	= 1L;
	private JPanel songPanel, infoPanel, albumPhotoPanel;
	private JLabel collectionNameLabel, firstNameLabel, 
					lastNameLabel, dateCreatedLabel;
	private JLabel titleLabel, artistLabel, releaseDateLabel, 
					sizeLabel, genreLabel, costLabel, playbackLabel, albumphotoLabel;
	private JComboBox genreComboBox;
	private static JTextField collectionNameField, firstNameField, 
	lastNameField, dateCreatedField;
	private static JTextField titleField;
	private static JTextField artistField;
	private static JTextField releaseDateField;
	private static JTextField sizeField;
	private static JTextField costField;
	private static JTextField playbackField;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, helpMenu;
	private JMenuItem createCollectionItem, openCollectionItem, 
						saveCollectionItem, exitAppItem, addMP3Item,
						editMP3Item, removeMP3Item, aboutItem;
	public ImageIcon ImageIcon;
	
	private static JList <String> mp3List;
	private static JScrollPane scrollPane;
	private static String[] titleArray;
	
	
	
	
	
	/**
	 * 
	 * GUI Constructor        
	 *
	 * <hr>
	 * Date created: Aug 9, 2021 
	 *
	 *
	 */
	public MP3TrackerGUI () {
		
		super("MP3Tracker - GUI - AVandergriff");
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout (new BorderLayout (2, 1));

		declComponets();
		
		this.setJMenuBar(menuBar);

		
		declSongPanel();
		add(songPanel, BorderLayout.WEST);
		
		declInfoPanel();
		add(infoPanel, BorderLayout.EAST);
		
		declAlbumPhotoPanel();
		add(albumPhotoPanel, BorderLayout.SOUTH);
		
		try
		{
			UIManager.setLookAndFeel(
				"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //sets ui to look and feel like windows
			SwingUtilities.updateComponentTreeUI (this);
			}catch (Exception e)
		{JOptionPane.showMessageDialog(null,
			"Error setting the look and feel.");
		System.exit(0);
		}
		
		
		addListeners();
		
		setWindowIcon ();
		

		this.setLocationRelativeTo (null);
		this.setVisible (true);
	}
	
	
	/**
	 * 
	 * Set non-default icon for the main window         
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void setWindowIcon () {
		try
		// change the icon for the application
		{
			File file = new File ("Pictures/disc.png");
			BufferedImage icon = ImageIO.read (file);
			setIconImage (icon);
		}
		catch (Exception e)
		{
			// ignore if we fail to load icon
		}
	}
	
	
	/**
	 * 
	 * Adds listeners to components
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void addListeners() {
		
		createCollectionItem.addActionListener (new menuListener());
		openCollectionItem.addActionListener (new menuListener());
		saveCollectionItem.addActionListener (new menuListener());
		exitAppItem.addActionListener (new menuListener());
		addMP3Item.addActionListener (new menuListener());
		editMP3Item.addActionListener (new menuListener());
		removeMP3Item.addActionListener (new menuListener());
		aboutItem.addActionListener (new menuListener());
		
		mp3List.addListSelectionListener (new listListener());
		
	}
	
	/**
	 * 
	 * Builds Song Panel
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void declSongPanel() {
		songPanel = new JPanel();
		
		songPanel.add (mp3List);
		songPanel.add (scrollPane);
		
	}
	
	/**
	 * 
	 * builds panel for album pictures
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void declAlbumPhotoPanel() {
		albumPhotoPanel = new JPanel();
		
		albumPhotoPanel.add (albumphotoLabel);
	}
	
	/**
	 * 
	 * builds panel for the details of mp3 file
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void declInfoPanel() {
		infoPanel = new JPanel (new GridLayout (11,2));
		infoPanel.add (collectionNameLabel);
		infoPanel.add (collectionNameField);
		
		infoPanel.add (firstNameLabel);
		infoPanel.add (firstNameField);
		
		infoPanel.add (lastNameLabel);
		infoPanel.add (lastNameField);
		
		infoPanel.add (dateCreatedLabel);
		infoPanel.add (dateCreatedField);
		
		infoPanel.add (titleLabel);
		infoPanel.add (titleField);
		
		infoPanel.add (artistLabel);
		infoPanel.add (artistField);
		
		infoPanel.add (releaseDateLabel);
		infoPanel.add (releaseDateField);
		
		infoPanel.add (sizeLabel);
		infoPanel.add (sizeField);
		
		infoPanel.add (genreLabel);
		infoPanel.add (genreComboBox);
		
		infoPanel.add (costLabel);
		infoPanel.add (costField);
		
		infoPanel.add (playbackLabel);
		infoPanel.add (playbackField);
		
		
	}
	
	/**
	 * 
	 * Declares components to be used 
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 */
	private void declComponets() {
		collectionNameLabel = new JLabel("Collection Name");
		collectionNameField = new JTextField();
		
		firstNameLabel = new JLabel("First Name");
		firstNameField = new JTextField();
		
		lastNameLabel = new JLabel("Last Name");
		lastNameField = new JTextField();
		
		dateCreatedLabel = new JLabel("Date Created");
		dateCreatedField = new JTextField();
		
		titleLabel = new JLabel("MP3 Title");
		titleField = new JTextField();
		
		artistLabel = new JLabel("MP3 Artist");
		artistField = new JTextField();
		
		releaseDateLabel = new JLabel("MP3 Release Date");
		releaseDateField = new JTextField();
		
		sizeLabel = new JLabel("File size (MBs)");
		sizeField = new JTextField();
		
		genreLabel = new JLabel("Genre");
		genreComboBox = new JComboBox();
		genreComboBox.addItem ("ROCK");
		genreComboBox.addItem ("POP");
		genreComboBox.addItem ("JAZZ");
		genreComboBox.addItem ("COUNTRY");
		genreComboBox.addItem ("CLASSICAL");
		genreComboBox.addItem ("OTHER");
		
		costLabel = new JLabel("Download Cost");
		costField = new JTextField();
		
		playbackLabel = new JLabel("Playback Time");
		playbackField = new JTextField();
		
		
		scrollPane = new JScrollPane (mp3List);
		
		albumphotoLabel = new JLabel();
		
		mp3List = new JList<>();
		
		menuBar = new JMenuBar();
		
		//////FILE MENU\\\\\\\
		fileMenu = new JMenu("File");
		createCollectionItem = new JMenuItem("Create New MP3 Tracker");
		openCollectionItem = new JMenuItem("Open an MP3 Tracker");
		saveCollectionItem = new JMenuItem("Save Current MP3 Tracker");
		exitAppItem = new JMenuItem("Exit MP3 Tracker");
		fileMenu.add (createCollectionItem);	//Adds items to menu
		fileMenu.add (openCollectionItem);
		fileMenu.add (saveCollectionItem);
		fileMenu.add (exitAppItem);
		ImageIcon create = new ImageIcon("Pictures/playlist.png");
		ImageIcon open = new ImageIcon("Pictures/open.png");
		ImageIcon save = new ImageIcon("Pictures/save-file.png");
		ImageIcon exit = new ImageIcon("Pictures/exit.png");
		createCollectionItem.setIcon (create);	//adds Icons to menuItems
		openCollectionItem.setIcon (open);
		saveCollectionItem.setIcon (save);
		exitAppItem.setIcon (exit);

		
		
		//////EDIT MENU\\\\\\\
		editMenu = new JMenu("Edit");
		addMP3Item = new JMenuItem("Add a MP3 to the Collection");
		editMP3Item = new JMenuItem("Modify MP3 Data");
		removeMP3Item = new JMenuItem("Drop a MP3 From the Collection");
		editMenu.add (addMP3Item); 		//Adds items to menu
		editMenu.add (editMP3Item);
		editMenu.add (removeMP3Item);
		ImageIcon add = new ImageIcon("Pictures/add-song.png");	
		ImageIcon edit = new ImageIcon("Pictures/edit.png");
		ImageIcon remove = new ImageIcon("Pictures/remove.png");
		addMP3Item.setIcon (add);	//adds Icons to menuItems
		editMP3Item.setIcon (edit);
		removeMP3Item.setIcon (remove);
		
		//////HELP MENU\\\\\\\
		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About...");
		helpMenu.add (aboutItem);	//Adds items to menu
		ImageIcon about = new ImageIcon("Pictures/info.png");
		aboutItem.setIcon (about); //adds Icons to menuItems
		
		menuBar.add (fileMenu); //adds menus to menu bar
		menuBar.add (editMenu);
		menuBar.add (helpMenu);
		
		
	}
	
	/**
	 * 
	 * Class handles action events for menu bar and menus
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 * <hr>
	 * @author Anthony Vandergriff
	 */
	private class menuListener implements ActionListener{

		/**
		 * handles action events for menu bar and menus       
		 *
		 * <hr>
		 * Date created: Aug 10, 2021 
		 *
		 * <hr>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed (ActionEvent e)
		{
			if(e.getSource ( ) == createCollectionItem) {
				
				createMP3Collection();
				
			}else if(e.getSource ( ) == openCollectionItem) {
				
				openCollection();
			
			}else if(e.getSource ( ) == saveCollectionItem) {
				
				saveFile();
				
			}else if(e.getSource ( ) == exitAppItem) {
				
				 sayGoodbye();
				
			}else if(e.getSource ( ) == addMP3Item) {
				
				createMP3();	
				
			}else if(e.getSource ( ) == editMP3Item) {
				
				editMP3();		
				
			}else if(e.getSource ( ) == removeMP3Item) {
				
				dropMP3();		
				
			}else if(e.getSource ( ) == aboutItem) {
				
				AboutBox window = new AboutBox(null);
			}
			
		}//end actionPerformed
		
	}//end menuListener
	
	/**
	 * 
	 * used to scale the photos to the height in pixels         
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 *
	 * <hr>
	 * @param fileName
	 * @param desiredHeight
	 * @return
	 */
	public ImageIcon getPhotoIcon(String fileName, int desiredHeight) {
		
		ImageIcon icon = new ImageIcon ("Pictures\\" + fileName);

		Image pic = icon.getImage ( );
		double ratio = (double) pic.getWidth (null) / pic.getHeight (null);
		
		BufferedImage bl = new BufferedImage ((int) (desiredHeight * ratio), desiredHeight,
						BufferedImage.TYPE_INT_ARGB);
		Graphics gl = bl.getGraphics ( );
		gl.drawImage (pic, 0, 0, (int) (desiredHeight * ratio), desiredHeight, null);
		return new ImageIcon(bl);
		
	}
	
	
	/**
	 * 
	 * Class handles action events for the list
	 *
	 * <hr>
	 * Date created: Aug 9, 2021
	 * <hr>
	 * @author Anthony Vandergriff
	 */
	private class listListener implements ListSelectionListener{

		/**
		 * handles action events for the list        
		 *
		 * <hr>
		 * Date created: Aug 9, 2021 
		 *
		 * <hr>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void valueChanged (ListSelectionEvent e)
		{

			collectionNameField.setText (mP3Collection.getCollectionName ( ));
			firstNameField.setText (mP3Collection.getFirstName ( ));
			lastNameField.setText (mP3Collection.getLastName ( ));
			dateCreatedField.setText (mP3Collection.getCreationDate ( ));
			titleField.setText (mp3List.getSelectedValue ( ));
			artistField.setText (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getArtist ( ));
			releaseDateField.setText (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getDate ( ));
			sizeField.setText (String.valueOf (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getSize ( )));
			costField.setText (String.valueOf (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getCost ( )));
			playbackField.setText (String.valueOf (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getLength ( )));
			genreComboBox.setSelectedItem (mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getSongGenre ( ));
			
			ImageIcon = getPhotoIcon(mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getPhoto ( ), 250);
			String photoPath = mP3Collection.getCollection ( ).get (mp3List.getSelectedIndex ( )).getPhoto ( );
			File albumphoto = new File ("Pictures//" + photoPath);
			
			if(albumphoto.exists ( )) {
				albumphotoLabel.setIcon (ImageIcon);
				albumphotoLabel.setText (null);
			}else {
				albumphotoLabel.setIcon (null);
				albumphotoLabel.setText ("No picture available");
			}
			
			
			
			
		}
		
	}
	
	
	
	
	/**
	 * 
	 * Input data necessary to instantiate an MP3 collection and then instantiate
	 * the MP3 collection    
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	private static void createMP3Collection()
	{
		if (mP3Collection!= null && mP3Collection.isSaveNeeded ( ))
			saveFile ( );
		
		String collectionName = collectionNameField.getText( );
		String firstName = firstNameField.getText ( );
		String lastName = lastNameField.getText ( );
		String date = dateCreatedField.getText();

		mP3Collection = new MP3Collection(collectionName, firstName, lastName, date);
	}

	/**
	 * Input data necessary to instantiate an MP3 object and then instantiate
	 * the MP3 file
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	@SuppressWarnings ("resource")
	private static void createMP3 ( )
	{
		
		if (mP3Collection == null)
			return;
		
		
		
		
		String title = titleField.getText();
		String artist = artistField.getText();
		String date = releaseDateField.getText();
		double length = Double.parseDouble (sizeField.getText ( ));		
		Genre genre = null;
		double cost = Double.parseDouble (costField.getText ( ));
		double size = Double.parseDouble (sizeField.getText ( ));
		String photo = null;
		mp3 = new MP3 (title, artist, length, cost, size, photo, date, genre);
		
		mP3Collection.addMP3 (mp3);
		return;
	}
	
	/**
	 * 
	 * Input data necessary to drop an MP3 object from 
	 * the collection
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public static void dropMP3()
	{
		if (mP3Collection == null)
			return;
		
		
		mP3Collection.dropMP3 (mp3List.getSelectedValue ( ));
	}
	
	/**
	 * 
	 * Input data necessary to search the collection
	 * for an MP3 object by title then prompt user
	 * to input updated MP3 attribute values        
	 *
	 * <hr>
	 * Date created: Jun 26, 2021
	 *
	 * <hr>
	 */
	public static void editMP3()
	{
		if (mP3Collection == null)
			return;
		
		String title = titleField.getText();
		String artist = artistField.getText();
		String date = releaseDateField.getText();
		double length = Double.parseDouble (sizeField.getText ( ));		
		Genre genre = null;
		double cost = Double.parseDouble (costField.getText ( ));
		double size = Double.parseDouble (sizeField.getText ( ));
		String photo = null;
		
		
		mp3 = new MP3 (title, artist, length, cost, size, photo, date, genre);
		mP3Collection.editMP3(mp3, mp3List.getSelectedIndex ( ));
		
			
		
			
	}
	
	
	
	

	/**
	 * Display a goodbye message
	 *
	 * <hr>
	 * Date created: June 10, 2021
	 *
	 * <hr>
	 */
	private static void sayGoodbye ( )
	{
		if (mP3Collection!= null && mP3Collection.isSaveNeeded ( ))
			saveFile ( );
		
		JOptionPane.showMessageDialog (null, "Goodbye, " + userName + "." +
						" Thank you for using this demonstration of the MP3 class.\n",
			"Thank you and Goodbye", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit (0);
	}
	
	/**
	 * 
	 * Open an MP3 Tracker file and populate the tracker      
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 */
	private static void openCollection()
	{
		
		
		
		if (mP3Collection != null && mP3Collection.isSaveNeeded ( ))
		{
			saveFile ( );
		}
		mP3Collection = new MP3Collection ( );
		JFileChooser dlg = new JFileChooser ("MP3TrackerData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the Collection Data File You Wish to Open");
		int button = dlg.showOpenDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Opened",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			fileName = dlg.getSelectedFile ( ).getPath ( );
			mP3Collection.fillFromFile (fileName);
							
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null,
				"There was an error processing the file - operation terminated. \n" +
								e.getMessage ( ),
				"Error Reading from File", JOptionPane.ERROR_MESSAGE);
		}
		
		
		titleArray = new String[mP3Collection.getCollectionSize ( )];

		

		for(int i = 0; i < mP3Collection.getCollectionSize ( ); i++) {
			titleArray[i] = mP3Collection.getMP3 (i).getTitle ( );
			}
		mp3List.setListData (titleArray);
		mp3List.setVisibleRowCount (7);
			
		
	}
	
	/**
	 * 
	 * Save all MP3 Tracker data to the specified text file       
	 *
	 * <hr>
	 * Date created: Jun 10, 2021
	 *
	 * <hr>
	 */
	private static void saveFile ( )
	{
		if (mP3Collection == null)
		{
			JOptionPane.showMessageDialog (null, "There is no collection to save", "Save Failed",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		JFileChooser dlg = new JFileChooser ("MP3TrackerData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the MP3 Collection Data File You Wish to Save");
		int button = dlg.showSaveDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			mP3Collection.saveFile (dlg.getSelectedFile ( ).getPath ( ));
			JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog (null, "File not found - " + e.getMessage ( ),
				"File Not Found", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null, "File not saved - " + e.getMessage ( ),
				"Error During File Save", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
	}
	

}//end MP3TrackerGUI
