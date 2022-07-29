/**
 * ---------------------------------------------------------------------------
 * File name: Corporate.java
 * Project name: Classwork - Inheritance
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 28, 2021
 * ---------------------------------------------------------------------------
 */

package customer;


/**
 * Inherits from customer class and calculates discount for corporate customers and total from
 * overloading discount method
 *
 * <hr>
 * Date created: Jul 28, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Corporate extends Customer
{
	private final double MINDISCOUNT = 0.18;
	private final double MAXDISCOUNT = 0.21;
	private final double MINDOLLARAMT = 1000;

	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jul 28, 2021 
	 *
	 * 
	 */
	public Corporate ( )
	{
		super();
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
	public Corporate (String name, String city, String state, String id, double total)
	{
		super (name, city, state, id, total);
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
		if(totalPurchase <= MINDOLLARAMT) {
			return MINDISCOUNT * totalPurchase;
		}else {
			return MAXDISCOUNT * totalPurchase;
		}
		
	}

}
