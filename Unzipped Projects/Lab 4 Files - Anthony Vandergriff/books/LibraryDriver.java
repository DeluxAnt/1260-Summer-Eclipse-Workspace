/**
 * ---------------------------------------------------------------------------
 * File name: LibraryDriver.java Project name: Files-Books
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: July 19, 2021
 * ---------------------------------------------------------------------------
 */

package books;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Demo the Book and Library classes<br>
 * 
 * <hr>
 * Date created: March 21, 2018<br>
 * <hr>
 * 
 * @author Anthony Vandergriff
 */
public class LibraryDriver
{
	private static Library	lib			= new Library ( );
	private static String	fileName	= "";	// Save filename for later use
	private static boolean saveNeeded;
	private static Scanner kb = new Scanner(System.in);

	/**
	 * Main method - fill library from input file; add books; save library<br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 * 
	 * @param args
	 *            - not used here
	 * @throws Exception 
	 */
	public static void main (String [ ] args) throws Exception
	{
		UIManager.put ("OptionPane.messageFont", new FontUIResource (new Font ("Arial", Font.PLAIN,
						12)));
		JOptionPane.showMessageDialog (null, "Welcome to the Library Manager.", "Library Manager",
			JOptionPane.INFORMATION_MESSAGE);
		inputFile ();
		
		displayLibrary ( );
		addBooks ( );

		JOptionPane.showMessageDialog (null, "Thank you for using the Library Manager.",
			"Goodbye Now", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Save the file back to its original position <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 */
	private static void saveFile ()throws FileNotFoundException {

		JFileChooser chooser = new JFileChooser("TextFiles"); //prompts user to pick a file
		int result = chooser.showSaveDialog(null);
		
		if (result != JFileChooser.APPROVE_OPTION) {
			System.out.println("No file Selected - TERMINATED");
			System.exit(0);
		}
		fileName = chooser.getSelectedFile().getPath();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
			
			for(int i = 0; i < lib.getNumBooks ( ); i++) {
				Book book = lib.getBook (i);
				writer.println (book.getTitle ( ) + "," + book.getAuthor ( ) + "," + book.getPrice ( ));
				saveNeeded = false;
			}
		} catch (Exception e) {
			System.out.println("File not saved: " + e.getMessage()); //prints error message if file not found

		} finally {
			if(writer != null)
				writer.close ();
		}

	}
	

	/**
	 * Allow the user to try to add any number of books to the library; this
	 * will result in an exception if one tries to add a book beyond the library
	 * size <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 * returns - number of books added
	 * @throws FileNotFoundException 
	 */
	private static void addBooks ( ) throws FileNotFoundException
	{
		int booksAdded = 0;
		String s;
		// code for adding books to library goes here - including any exception handling
		
		int result = JOptionPane.showConfirmDialog (null, "Would you like to add one or more books?");
		
		
		if(result < 1) {
			System.out.println("Enter the Ammount of Books you would like to add");
			
			booksAdded = Integer.parseInt (s = kb.nextLine ( ));
			
			for(int i = 0; i < booksAdded; i++ ) {
				System.out.println ("Enter the Title of your book:" );
				String title = kb.nextLine ( );
				
				System.out.println ("Enter the Author of your book:" );
				String author = kb.nextLine ( );
				
				System.out.println ("Enter the Price of your book:" );
				Double price = kb.nextDouble ( );
				
				kb.nextLine ( );
				
				Book book = new Book(title, author, price);
				try
				{
					lib.addBook (book);
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}

		if (booksAdded > 0)
		{
			JOptionPane.showMessageDialog (null, booksAdded + " books added", "Books Added",
				JOptionPane.INFORMATION_MESSAGE);

			displayLibrary ( );
			saveFile ();
		}
	}

	/**
	 * Get the filename from the user and try to open it (JFileChooser); read contents and
	 * build library; handle any exceptions that occur. Save the filename and path for
	 * later use by the saveFile method<br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 * @throws Exception 
	 */
	private static void inputFile () throws Exception{
		
			boolean firstLine = true;
			File fileIn = new File("D:\\1260 Summer WS\\Eclipse Workspace\\Classwork - Files\\TextFiles\\BookFile.txt");
			Scanner file = null;
//			JFileChooser chooser = new JFileChooser("TextFiles"); //prompts user to pick a file
//			int result = chooser.showOpenDialog (null);
//			
//			if (result != JFileChooser.APPROVE_OPTION) {
//				System.out.println("No file selected - TERMINATED");
//				System.exit(0);
//			}
			//fileName = chooser.getSelectedFile ( ).getPath();
			try
			{
				file = new Scanner(fileIn);
			}
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while (file.hasNextLine ( )) {
				String line = file.nextLine ( );
				
				String[] split = line.split ("\\,");
				try
				{
					Book b = new Book(split[0], split[1], Double.parseDouble (split[2]));
					lib.addBook (b);
				}
				catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		
		
	}

	/**
	 * Display all books in the library <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 */
	private static void displayLibrary ( )
	{
		JOptionPane.showMessageDialog (null, "There are " + lib.getNumBooks ( ) + " books in the library.",
			"Library Size", JOptionPane.INFORMATION_MESSAGE);
		System.out.println ("\n\n\nLibrary Contents\n----------------\n");
		System.out.println (lib);
		System.out.println ("\n\n");
	}
}
