/**
 * ---------------------------------------------------------------------------
 * File name: Preferred.java
 * Project name: Classwork - Inheritance
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 28, 2021
 * ---------------------------------------------------------------------------
 */

package customer;


/**
 * Inherits from customer class and calculates discount for preferred customers and total from
 * overloading discount method
 *
 * <hr>
 * Date created: Jul 28, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Preferred extends Customer
{
	private final double DISCOUNT = 0.1;

	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jul 28, 2021 
	 *
	 * 
	 */
	public Preferred ( )
	{
		super( );
	}

	/**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Jul 28, 2021 
	 *
	 * 
	 * @param name
	 * @param city
	 * @param state
	 * @param id
	 * @param total
	 */
	public Preferred (String name, String city, String state, String id, double total)
	{
		super (name, city, state, id, total);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Determine the amount of the discount for this type of customer <br>
	 * 
	 * <hr>
	 * Date created: Jul 28, 2021  <br>
	 * 
	 * <hr>
	 * 
	 * @return
	 */
	public double discount ( )
	{
		return DISCOUNT * totalPurchase;
	}

}
