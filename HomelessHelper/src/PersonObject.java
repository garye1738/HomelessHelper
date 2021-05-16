import java.util.*;
import java.io.*;


/**This class will hold information for an individual user of the system
 * @author Gabriel Arye and Josh Wang
 *
 */
public class PersonObject 
{
	/**firstName: will hold a user's first name
	 * 
	 */
	private String firstName;
	
	/**lastName: will hold a user's last name
	 * 
	 */
	private String lastName;
	
	/**age: will hold a user's age
	 * 
	 */
	private int age;
	
	/**gender: will hold a user's gender
	 * 
	 */
	private String gender;
	
	/**credits: will hold the number of points the user can spend (gained from recycling
	 * 
	 */
	private double credits;
	
	/**PersonObject: this is a constructor for a PersonObject. It will construct a PersonObject with the relevant data 
	 * in parameters.
	 * @param firstName user's first name
	 * @param lastName user's last name
	 * @param age user's age
	 * @param gender user's gender
	 * @param credits user's initial number of credits (50)
	 */
	public PersonObject(String firstName, String lastName, int age, String gender, double credits) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.credits = credits; 
	}
	
	/**getFirst(): this getter method will return the user's first name
	 * @return firstName, the user's first name
	 */
	public String getFirst()
	{
		return firstName;
	}
	
	/**getLast(): this getter method will return the user's last name
	 * @return lastName, the user's last name
	 */
	public String getLast()
	{
		return lastName;
	}
	
	/**getAge(): this getter method will return a user's age
	 * @return age, a user's age
	 */
	public int getAge()
	{
		return age;
	}
	
	/**getGender(): this getter method will return  user's gender
	 * @return gender, a user's gender
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**getCredits(): this getter method will return a user's number of points
	 * with which they can buy items
	 * @return credits, user's "money" points
	 */
	public double getCredits()
	{
		return credits;
	}
	
	/**changeCreds(): this method will change the uer's total number of credits (based on adding or
	 * removing funds)
	 * @param newBalance, a user's new account balance
	 */
	public void changeCreds(double newBalance)
	{
		credits = newBalance;
	}
}
