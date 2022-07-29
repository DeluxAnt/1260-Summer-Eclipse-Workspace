/**
 * ---------------------------------------------------------------------------
 * File name: Person.java Project name: Classwork 8 - Inheritance 
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu 
 * Course-Section: CSCI1260
 * Creation Date: March 14, 2011 
 * Date of Last Modification: March 14, 2011
 * ---------------------------------------------------------------------------
 */

package customer;

/**
 * Enter type purpose here<br>
 * 
 * <hr>
 * Date created: March 14, 2011<br>
 * Date last modified: March 14, 2011<br>
 * <hr>
 * 
 * @author Don Bailes
 */

public class Person
{
	protected String	name;
	protected String	city;
	protected String	state;
	protected String	id;


	/**
	 * Default constructor <br>
	 * 
	 * <hr>
	 * Date created: March 14, 2011 <br>
	 * Date last modified: March 14, 2011 <br>
	 * 
	 * <hr>
	 */
	public Person ( )
	{
		this.name = "";
		this.city = "Johnson City";
		this.state = "TN";
		this.id = "00000";
	}


	/**
	 * Parameterized constructor <br>
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
	 */
	public Person (String name, String city, String state, String id)
	{
		this.name = name;
		this.city = city;
		this.state = state;
		this.id = id;
	}


	/**
	 * @return name
	 */
	public String getName ( )
	{
		return this.name;
	}


	/**
	 * @param name
	 *            the name to set
	 */
	public void setName (String name)
	{
		this.name = name;
	}


	/**
	 * @return city
	 */
	public String getCity ( )
	{
		return this.city;
	}


	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity (String city)
	{
		this.city = city;
	}


	/**
	 * @return state
	 */
	public String getState ( )
	{
		return this.state;
	}


	/**
	 * @param state
	 *            the state to set
	 */
	public void setState (String state)
	{
		this.state = state;
	}


	/**
	 * @return id
	 */
	public String getId ( )
	{
		return this.id;
	}


	/**
	 * @param id
	 *            the id to set
	 */
	public void setId (String id)
	{
		this.id = id;
	}

}
