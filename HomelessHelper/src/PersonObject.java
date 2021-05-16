import java.util.*;
import java.io.*;


public class PersonObject 
{

	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private double credits;
	
	public PersonObject(String firstName, String lastName, int age, String gender, double credits) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.credits = credits; 
	}
	
	public String getFirst()
	{
		return firstName;
	}
	
	public String getLast()
	{
		return lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public double getCredits()
	{
		return credits;
	}
	
	public void changeCreds(double newBalance)
	{
		credits = newBalance;
	}

}
