import java.util.*;
import java.io.*;

public class Main 
{
	static HashMap<String, PersonObject> database;
	
	public static void main(String[] args) 
	{
		database = new HashMap<String, PersonObject>();
		
		database.put("155233816", new PersonObject("James", "Adder", 31, "Male", 50));
		database.put("188261987", new PersonObject("Rachel", "Baker", 43, "Female", 100));
		database.put("235789692", new PersonObject("Jen", "Roberts", 31, "Non-binary", 7));
		database.put("683200147", new PersonObject("Frank", "Wright", 31, "Male", 8));
		database.put("911236875", new PersonObject("Aaron", "Wroughts", 31, "Male", 24));
	
		
		String repeat = "yes";
		
		Scanner input = new Scanner(System.in);
		while(repeat.toLowerCase().equals("yes"))
		{
			int created = 0;
			
			while (created == 0)
			{
				
				System.out.println("Hello! This is the City Homeless Assistance System (CHAS).\nPlease input "
						+ "your 9 digit social security ID without dashes:");
				String social = input.next();
			
				PersonObject user = database.get(social);
			
				if(user == null)
				{
					System.out.println("It looks like you are not in our system. Type 0 to try again or 1 to add yourself\n"
							+ "to the system:");
				
					int res = input.nextInt();
				
					if(res == 0)
					{
					
					}
				
					else if(res == 1)
					{
						addNewUser();
					}
				}
			
				else
				{
					created = 1;
					user = database.get(social);
					System.out.println("\nYour Account:\nName: " + user.getFirst() + " " + user.getLast() + "\nAge: " + user.getAge()
							+ "\nGender: " + user.getGender() + "\nAvailable Points: " + user.getCredits());
					
					System.out.println("Please type the number associated with one of the options below: ");
					System.out.println("0 - Exit\n1 - Schedule Appointment at Local Clinic\n2 - Cash in Trash\n"
							+ "3 - Purchase Items\n4 - Emergency (If you are in danger. Will send assistance immediately if pressed)");
					
					int res = input.nextInt();
					
					if(res == 0)
					{
						//repeat = "no";
						System.out.println("Thank you very much for using this CHAS. Have a great day and stay safe.\n\n" );
					}
					
					else if(res == 1)
					{
						scheduleAppointment();
					}
					
					else if(res == 2)
					{
						cashItems(social, user);
					}
					
					else if(res == 3)
					{
						vendingMachine(social, user);
					}
					
					else if(res == 4)
					{
						emergency();
					}
				}
			}
		}
		
		System.out.println("Thank you very much for using this CHAS. Have a great day and stay safe." );		
	}
	
	public static void scheduleAppointment()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen to make an appointment at the local clinic: Ralph's Free Clinic."
				+ "\nThe clinic will be open all day today. Please type out notes on health concerns so doctors"
				+ "can help you. Otherwise, type 0: ");
		
		String res = input.nextLine();
		
		if(!res.trim().equals("0"))
		{
			System.out.println("Your Appointment notes: " + res);
			System.out.println("The clinic is on the right and down the street. Please go there after you log out of your account.");	
		}
		input.close();
	}
	
	public static void cashItems(String social, PersonObject user)
	{
		System.out.println("Here are items we will credit you points for cleaning up:"
				+ "\nMetals cans: 5 points each each"
				+ "\nPlastic bottles: 4 points each"
				+ "\nGlass bottles: 7.5 points each"
				+ "\nSharp metal objects: 100 points each"
				+ "\nPlastic bags: 2.5 points each");
	
		System.out.println("Type 0 if you don't turn in anything. Type 1 if you do turn in something for points: ");
		Scanner input = new Scanner(System.in);
		int cash = input.nextInt();
		
		System.out.println("Please type out the number of each item you have");
		
		if(cash == 1)
		{
			System.out.println("Metal cans: ");
			int cans = input.nextInt();
			System.out.println("Plastic bottles: ");
			int plas = input.nextInt();
			System.out.println("Glass bottles: ");
			int glass = input.nextInt();
			System.out.println("Sharp metal objects: ");
			int sharp = input.nextInt();
			System.out.println("Plastic bags: ");
			int bags = input.nextInt();
			
			double creds = ((cans * 5) + (plas * 4) + (glass * 7.5) + (sharp * 100) + (bags * 2.5));
			double newBal = creds + user.getCredits();
		
			System.out.println("Value of findings: $" + creds + "Your new balance is: $" + newBal);
			user.changeCreds(newBal);
			database.replace(social, user);	
		}
		input.close();
	}
	
	public static void vendingMachine(String social, PersonObject user)
	{
		boolean iterate = true;
		while(iterate == true)
		{
			System.out.println("Available Credits: " + user.getCredits());
			System.out.println("Here are items we have available you for you to buy with your credits: "
					+ "\nToothbrush: 3 points each"
					+ "\nToothpaste: 2 points each"
					+ "\nMenstrual products (pads): 1 point each"
					+ "\nSanitary wipes: 2 points each"
					+ "\nDry shampoo: 3 points each"
					+ "\nBandaids: 1.5 points each"
					+ "\nOintment: 1.5 points each"
					+ "\nWater: 2 points each" 
					+ "\nProtein bar: 2 points each");
			
			System.out.println("Type 0 if you do not want to buy anything. Type 1 if you do want to buy something");
			Scanner input = new Scanner(System.in);
			int buy = input.nextInt();
			
			if(buy == 0)
			{
				iterate = false;
			}
			
			else if(buy == 1)
			{
				System.out.println("Please type out the amount of each item you want to buy: ");
				
				System.out.println("Toothbrush: ");
				int brush = input.nextInt();
				System.out.println("Toothpaste: ");
				int paste = input.nextInt();
				System.out.println("Menstrual Products: ");
				int men = input.nextInt();
				System.out.println("Sanitary wipes: ");
				int san = input.nextInt();
				System.out.println("Dry shampoo: ");
				int dry = input.nextInt();
				System.out.println("Bandaids: ");
				int band = input.nextInt();
				System.out.println("Ointment: ");
				int oint = input.nextInt();
				System.out.println("Water: ");
				int wat = input.nextInt();
				System.out.println("Protein bar: ");
				int bar = input.nextInt();
				
				double price = ((brush * 3) + (paste * 2) + (men * 1) + (san * 2) + (dry * 3) + (band * 1.5) + (oint * 1.5) + (wat * 2) + (bar * 2));
				double newBal = user.getCredits() - price;
			
				System.out.println("Total purchase price: " + price + " points.");
				
				if(newBal < 0)
				{
					System.out.println("You do not have the necessary points to buy these items. Please choose"
							+ "fewer things,\n or recycle more items to get more credit points");
				}
				
				else
				{
					System.out.println("If you purchase these itmesyour new point balance will be " + newBal + "points.\n"
							+ "Are you sure you want to buy these items? The points will be taken out of your account\n"
							+ "to pay for them. Type 0 to not buy them, or type 1 to buy them: ");
					
					int toBe = input.nextInt();
					
					if(toBe == 0)
					{
						iterate = true;
					}
					
					else if(toBe == 1)
					{
						user.changeCreds(newBal);
						database.replace(social, user);
						iterate = false;
					}	
				}
			}
			input.close();
		}
	}
	
	public static void emergency()
	{
		System.out.println("Emergency services are on stand by. Can you please type out the emerggency so we can better assist you?"
				+ "\nType 0 if this was a false alarm:");
		
		Scanner keyInput = new Scanner(System.in);
		String issue = keyInput.nextLine();
		keyInput.close();
		Scanner zeroFinder = new Scanner(issue);
		String num = zeroFinder.next();
		zeroFinder.close();
		
		if(!num.equals("0"))
		{
			//System would notify relevant services here
			System.out.println("The relevant services are on the way. Please remain calm");
		}
		
	}
	
	public static void addNewUser()
	{
		Scanner keyInput = new Scanner(System.in);
		System.out.println("Please type out your 9 digit social security ID without dashes or spaces: ");
		String id = keyInput.next();
		
		if(database.get(id) instanceof PersonObject)
		{
			System.out.println("Whoops! Looks like you input an exisiting id. Please wait while we reroute you");
		}
		
		else if(database.get(id) == null)
		{
			System.out.println("Please type your first name");
			String first = keyInput.next().trim();
			
			System.out.println("Please type your last name");
			String last = keyInput.next().trim();
			
			System.out.println("Please type your first name");
			int age = keyInput.nextInt();
			
			System.out.println("Please type your gender");
			String gender = keyInput.next().trim();
			
			database.put(id, new PersonObject(first, last, age, gender, 5.0));
			System.out.println("You have successfully been added to our system and you have $5 dollars"
					+ "as starting funds from the city. Please wait while we take you to the main page.");
		}
		keyInput.close();
	}
}
