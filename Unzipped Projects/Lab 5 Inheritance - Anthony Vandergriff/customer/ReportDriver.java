/**
 * ---------------------------------------------------------------------------
 * File name: ReportDriver.java Project name: Classwork 8 - Inheritance 
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu 
 * Course-Section: CSCI1260
 * Creation Date: March 14, 2011
 * Date of Last Modification: March 14, 2011
 * ---------------------------------------------------------------------------
 */

package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Demo the customer classes in action<br>
 * 
 * <hr>
 * Date created: March 14, 2011<br>
 * Date last modified: March 14, 2011<br>
 * <hr>
 * 
 * @author Erin L Cook
 */

public class ReportDriver
{
	private static Customer [ ]	customer	= new Customer [25];
	private static int			numCustomers;


	/**
	 * Enter method description here <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 * 
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		inputDataFile ( );
		displayReport ( );
	}


	private static void displayReport ( )
	{
		System.out.println ("Type\t\tName\t\tAddress\t\t   "
						+ "Purchase\t  Discount\tDiscounted Total");
		System.out.println ("----\t\t----\t\t-------\t\t   "
						+ "--------\t  --------\t----------------");
		for (int n = 0; n < numCustomers; n++ )
			System.out.println (customer [n]);

	}


	private static void inputDataFile ( )
	{
		try
		{
			File in = new File ("CustomerData/cust.txt");
			Scanner file = new Scanner (in);
			int n = 0;
			while (file.hasNext ( ))
			{
				String rec = file.nextLine ( );
				String [ ] fields = rec.split (":");
				if (fields.length != 6)
					throw new Exception ("Invalid input data");
				switch (Integer.parseInt (fields [0]))
				{
					case 1:
						customer [n] = new Standard (fields [1], fields [2],
										fields [3], fields [4],
										Double.parseDouble (fields [5]));
						break;
					case 2:
						customer [n] = new Preferred (fields [1], fields [2],
										fields [3], fields [4],
										Double.parseDouble (fields [5]));
						break;
					case 3:
						customer [n] = new Corporate (fields [1], fields [2],
										fields [3], fields [4],
										Double.parseDouble (fields [5]));
						break;
					case 4:
						customer [n] = new Employee (fields [1], fields [2],
										fields [3], fields [4],
										Double.parseDouble (fields [5]));
						break;
				}
				n++ ;
			}
			numCustomers = n;
			file.close ( );
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace ( );
		}
		catch (Exception e)
		{
			e.printStackTrace ( );
		}
	}

}
