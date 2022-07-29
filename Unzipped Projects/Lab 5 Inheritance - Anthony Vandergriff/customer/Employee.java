/**
 * ---------------------------------------------------------------------------
 * File name: Employee.java
 * Project name: Classwork - Inheritance
 * ---------------------------------------------------------------------------
 * Creator's name and email: Anthony Vandergriff, VANDERGRIFF@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 28, 2021
 * ---------------------------------------------------------------------------
 */

package customer;


/**
 * Inherits from customer class and calculates discount for employees and total from
 * overloading discount method
 *
 * <hr>
 * Date created: Jul 28, 2021
 * <hr>
 * @author Anthony Vandergriff
 */
public class Employee extends Customer
{
	private final double MAXDISCOUNT = 0.2;
	private final double MINDISCOUNT = 0.15;
	private final double MAXDOLLARAMT = 100;

	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Jul 28, 2021 
	 *
	 * 
	 */
	public Employee ( )
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
	public Employee (String name, String city, String state, String id, double total)
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
		double onehundred;
		double amount;
		double amount2;
		double finalAmount;
		if(totalPurchase <= MAXDOLLARAMT) {
			amount = MAXDISCOUNT * totalPurchase;
			return amount;
		}else {
			onehundred = totalPurchase - MAXDOLLARAMT;
			amount = MAXDISCOUNT * 100;
			amount2 = (MINDISCOUNT * onehundred);
			finalAmount = amount + amount2;
			return finalAmount;
		}
		
	}

}
