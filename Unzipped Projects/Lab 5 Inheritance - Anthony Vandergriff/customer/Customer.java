/**
 * ---------------------------------------------------------------------------
 * File name: Customer.java Project name: Customer
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu 
 * Course-Section: CSCI1260 
 * Creation Date: March 14, 2011 
 * Date of Last Modification: March 14, 2011
 * ---------------------------------------------------------------------------
 */

package customer;

import java.text.NumberFormat;

/**
 * Abstract Customer class<br>
 * 
 * <hr>
 * Date created: March 14, 2011<br>
 * Date last modified: March 14, 2011<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class Customer extends Person
{
	protected double	totalPurchase;


	/**
	 * Default Constructor <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 */
	public Customer ( )
	{
		super ( );
		totalPurchase = 0.0;
	}


	/**
	 * Constructor description here <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 * 
	 * @param name
	 * @param city
	 * @param state
	 * @param id
	 */
	public Customer (String name, String city, String state, String id,
						double total)
	{
		super (name, city, state, id);
		this.totalPurchase = total;
	}


	/**
	 * @return totalPurchase
	 */
	public double getTotalPurchase ( )
	{
		return this.totalPurchase;
	}


	/**
	 * Determine the amount of the discount for this type of customer <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 */
	public double discount ( )
	{
		return -10;
	}


	/**
	 * Right justify str in n columns by adding leading spaces if needed <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public String right (String str, int n)
	{
		String strS = str;
		if (str.length ( ) < n)
		{
			for (int i = 0; i < n - str.length ( ); i++ )
				strS = " " + strS;
		}
		return strS;
	}


	/**
	 * Enter method description here <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance ( );
		return this.getClass ( ).getSimpleName ( ) + "\t" + name + "\t" + city
						+ ", " + state + "\t"
						+ right (fmt.format (totalPurchase), 11) + "\t"
						+ right (fmt.format (discount ( )), 10) + "\t"
						+ right (fmt.format (totalPurchase - discount ( )), 13);
	}

}
