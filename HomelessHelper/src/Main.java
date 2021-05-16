import java.util.*;
import java.io.*;

/**This Main clas will simulate the the functions of a walk-up assistance kiosk 
 * in the city of LA. User's can access an account, make their own account (first time
 * user's only), make an clinic appointment, turn in recyclable materials for
 * points, spend points on healthcare products and food, and dial emergency services. 
 * @author Gabriel Arye and Josh Wang
 *
 */
public class Main 
{
	/**database: This HashMap object is static (so it can be accessed by all). It has a 
	 * String key that will hold an unique identification/social security number
	 * of a user. This will then reference a PersonObject which will
	 * hold a user's information so it can be retrieved. It will
	 * also ensure that each value is unique. 
	 * 
	 */
	static HashMap<String, PersonObject> database;
	
	/**main method: this will run the simulation of the kiosk functions.
	 * First, the database static object above is initialized as a new HashMap
	 * that will have String keys that reference PersonObject values.
	 * 
	 * Then, the database will be populated by several existing users, each with their own unique
	 * identifier and information. 
	 * 
	 * String repeat is set to yes. It will ensure that the program will keep running. 
	 * Scanner input is initialized to take user input from the keyboard. 
	 * 
	 * Then, a while loop will iterate while repeat equals yes (basically infinitely as 
	 * the kiosk will stay on). Inside the while loop, int created is initialized as 0.
	 * It will remain 0 if a user wants to retry putting in their information or 
	 * keeps failing inputting the proper identifier. It will become 1 if the identifier is correct.
	 * 
	 * 
	 * @param args
	 */
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
			
			/*
			 * This while loop will iterate while created is equal to 0. This will remain the case
			 * as long as the user gets their input wrong so they can keep retrying. 
			 * A print statement will greet the user and ask them for their social security ID as
			 * an identifier. input will put the user's response into String social.
			 * 
			 * If social is greater than or less than 9 characters, then a print statement will 
			 * say the number is invalid and the user would try again (because created equals 0). 
			 * In any other case, an els statement is reached
			 */
			while (created == 0)
			{
				
				System.out.println("Hello! This is the City Homeless Assistance System (CHAS).\nPlease input "
						+ "your 9 digit social security ID without dashes:");
				String social = input.next();
				
				if(social.length() < 9 || social.length() > 9)
				{
					System.out.println("Invalid number. Please try again\n");
				}
				
				
				/*This else statement is reached if a user inputs a 9 digit number. PersonObject user is set to the result of
				 * database.getSocial to get the PersonObject associated with that number. If user is null
				 * and the number doesn't exist, the system will say that the user can try inputting the number again in case of a 
				 * mistake by clicking 0, or add themselve to the system if they know they are not present by clicking 1.
				 * int res will then take in the user's response. If res equal 0, then everything that follows
				 * is skipped to it can go back to the main screen and he user can try again (because completed equals 0 still).
				 * 
				 * If the user's input is 1 and they want to make an account, then the method addNewUser is called to the user 
				 * can make their account. If the user input their own, correct id, another else statement is met. 
				 *
				 */
				else
				{
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
				
					/*
					 * This else statement is met if the user inputs their id correctly and the system finds them in the HashMap 
					 * database. created is set to 1 so that the program restarts from line 66 when the user exits.
					 * Then, boolean loop is set to true. This will allow the user to go back to view all their available options
					 * upon completing any one task. 
					 * 
					 * A while loop will iterate while loop equals true. user is then set to database.get(social). This happens again
					 * to update the credits on the user's account if the user has turned in recyclable materials or bought items from the kiosk.
					 * A print statement will then print out the user's information using getter methods.
					 * 
					 * Then, the user will be prompted to select one of 5 number options: 0 to exit from their account, 1 to 
					 * schedule a doctor's appointment, 2 to cash in recyclable materials for points, 3 to buy from the kiosk's
					 * vending machine, and 4 to call for help in case of an emergency. input then takes in the user's response.
					 * 
					 * If the user selects 0, then loop is set to false to break out of the loop at line 133 and go 
					 * to back to line 52 on the next iteration. A message wishes the user a good day. If they select
					 * 1, the method scheduleAppointment is called to schedule an appointment. If they select 2,
					 * the method cashItems is called with social and user as parameters to they can be updated in the HashMap.
					 * If 3 is selected, then the method vedingMachine is called with social and user as parameters. Finally, if 4 is
					 * selected the method emergency is called to send assistance. This concludes the main method. 
					 */
					else
					{
						created = 1;
						boolean loop = true;
						
						while(loop == true)
						{
							user = database.get(social);
							System.out.println("\nYour Account:\nName: " + user.getFirst() + " " + user.getLast() + "\nAge: " + user.getAge()
									+ "\nGender: " + user.getGender() + "\nAvailable Points: " + user.getCredits());
							
							System.out.println("Please type the number associated with one of the options below: ");
							System.out.println("0 - Exit\n1 - Schedule Appointment at Local Clinic\n2 - Cash in Trash\n"
									+ "3 - Purchase Items\n4 - Emergency (If you are in danger. Will send assistance immediately if pressed)");
							
							int res = input.nextInt();
							
							if(res == 0)
							{
								loop = false;
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
			}
		}	
		//System.out.println("Thank you very much for using this CHAS. Have a great day and stay safe." );		
	}
	
	/**void scheduleAppointment(): this method will let the user schedule a visit at the local health clinic.
	 * Scanner input will take input from the keyboard. A print statement will prompt the user with the name
	 * of the local health clinic and when it is open. Then, they will be asked to type out notes on symptoms or issues
	 * for the doctor, or press 0 to cancel the appointment. The user can then input their notes which will be sent to the doctor 
	 * (not pictured). An instruction will be given on how to get to the clinic. After this method completes, 
	 * the code will go back to line 138. 
	 * 
	 */
	public static void scheduleAppointment()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen to make an appointment at the local clinic: Ralph's Free Clinic."
				+ "\nThe clinic will be open all day today. Please type out notes on health concerns so doctors"
				+ " can help you. Otherwise, type 0: ");
		
		String res = input.nextLine();
		
		if(!res.trim().equals("0"))
		{
			System.out.println("Your Appointment notes: " + res);
			System.out.println("The clinic is on the right and down the street. Please go there after \nyou log out of your account.");	
		}
		//input.close();
	}
	
	/**void cashItems(): this method will allow user's to cash in recyclable items in exchange for 
	 * points with which they can purchase goods from the kiosk. 
	 * A print statement will then say what items are accepeted and the amount of points the user can get for turning in each.
	 * A print statement will then prompt the user to type 0 if they don't want to turn in anything, or type 1 if they do.
	 * If they type in 1, then the user will be asked how many of each item they have, and will have to input how many they have. 
	 * This is done on an honors system. Ideally, there would be a barcode scanner or camera that would identify the object.
	 * 
	 * Then, the reward for turning in the cans is calculated by multiplying the amount each user put in with
	 * its respective point value. A print statement tells the user the points earned (from creds) and the new number of points
	 * they have user.changeCreds is then called to update the point balance with the value in newBal. Then, database.replace will
	 * replace the value linked to social with the update user object so credits will be accurate.
	 * @param social, social identifier of the user
	 * @param user, PersonObject with the user's specific data that needs to be updated in the HashMap
	 */
	public static void cashItems(String social, PersonObject user)
	{
		System.out.println("\nHere are items we will credit you points for cleaning up:"
				+ "\nMetals cans: 5 points each each"
				+ "\nPlastic bottles: 4 points each"
				+ "\nGlass bottles: 7.5 points each"
				+ "\nSharp metal objects: 100 points each"
				+ "\nPlastic bags: 2.5 points each");
	
		System.out.println("Type 0 if you don't turn in anything. Type 1 if you do turn in something for points: ");
		Scanner input = new Scanner(System.in);
		int cash = input.nextInt();
		
		if(cash == 1)
		{
			System.out.println("Please type out the number of each item you have");
			
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
		
			System.out.println("\nValue of findings: " + creds + " points. Your new point balance is: " + newBal + "\nPlease"
					+ "put all items in the trashcan on the right of the kiosk.");
			user.changeCreds(newBal);
			database.replace(social, user);	
		}
		//input.close();
	}
	
	/**void vendingMachine(): this will simulate the kiosk's vending machine capability so the user can 
	 * user the credit points to purchase healthcare items, like wipes, dry shampoo, and bottled water. 
	 * boolen iterate is set to true. This will allow a while loop to repeat in case the user buys too much or 
	 * they want to change their purchases. A print statement will then printout the user's available
	 * credits from recycling and the available items along with the number of points each one costs. 
	 * 
	 * Then, a print statement will statement will tell the user to type 0 if they don't want to buy anything, or type 1 if they do.
	 * The user's input is then put into int buy. If buy equals 0 and the user doesn't want to buy, iterate is set to false
	 * and so the while loop and method both end. If buy equals 1, then the user wants to buy items with their 
	 * points. The user twill then be prompted to say how much of each item they want to buy. See inside 
	 * the method for more comments.
	 * @param social, social identifier of the user
	 * @param user, PersonObject with the user's specific data that needs to be updated in the HashMap
	 */
	public static void vendingMachine(String social, PersonObject user)
	{
		boolean iterate = true;
		while(iterate == true)
		{
			System.out.println("\nAvailable Points: " + user.getCredits());
			System.out.println("Here are items we have available you for you to buy with your credits: "
					+ "\nToothbrush: 3 points each"
					+ "\nToothpaste: 2 points each"
					+ "\nFeminine Care Products: 1 point each"
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
				
				/*
				 * The total number of points the user will need to pay is then calculated by adding of the sum of 
				 * multiplying the number of products purchased by eahc of their purchase price. This is then stored in double price.
				 * Then, double newBal is calculated by subtracting price from user.getCredits() to find the user's remaining balance if
				 * they decide to get the items. 
				 * 
				 * A print statement will then mention the price of the user's purchases. If newBal is negative and the
				 * user doesn't have enough points to cover their purchases, then a print statement tells the user
				 * they don't have enough points, and they will be taken back to the loop at line 281 to rearrange their purchases.
				 * 
				 *  If the user has enough funds, an else statement is met and the user will be told of their new point balance
				 *  after they make the purchase. They are then asked to input 0 for no or 1 to make the purchase. 
				 *  If the user inputs 0 for no, then iterate remains as true so they can be taken back to line 281. 
				 *  If the user types in 1, then user.changeCredits will update the user's points the the value of newBal, 
				 *  database.replace(social, user) is called to update the user's person object, and iterate is set to false
				 *  to break out of the while loop and exit this method. A print statement will then tell the user that the items 
				 *  have been dispensed and are at the bottom compartment of the kiosk. 
				 *  
				 */
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
					System.out.println("If you purchase these items our new point balance will be " + newBal + " points.\n"
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
						System.out.println("Your items have been despensed. Check the compartment of the kiosk.");
					}	
				}
			}
			//input.close();
		}
	}
	
	/**void emergency(): This method will contact emergency services if they are needed. A print statement will say that
	 * emergency services have been contacted (911 dispatch) and for the user to remain calm and type out more information
	 * if possible. Otherwise, they can type 0 if it is a false alarm or they misclicked. 
	 * 
	 * If the user inputs 0, then the call is cancelled. If not, the information they give will be sent 
	 * to the lcoal dispatcher who will send help as soon as possible. 
	 * 
	 */
	public static void emergency()
	{
		System.out.println("\nEmergency services are coming to help. Can you please type out the emergency so we can better assist you?"
				+ "\nType 0 if this was a false alarm:");
		
		Scanner keyInput = new Scanner(System.in);
		String issue = keyInput.nextLine();
		//keyInput.close();
		Scanner zeroFinder = new Scanner(issue);
		String num = zeroFinder.next();
		//zeroFinder.close();
		
		if(!num.equals("0"))
		{
			//System would notify relevant services here
			System.out.println("The relevant services are on the way. Please remain calm");
		}
	}
	
	/**void addNewUser(): this method will add a new user account to the kiosk cloud system. 
	 * A print statement will ask the user to put in their 9 digit security id, which Scanner keyInput
	 * will assign to String id. An if statement will check to see if the HashMap database contains
	 * the id and if it does, the user will be taken back to the appropriate screen. 
	 * 
	 * If the id is unique and the user is new, then the user will be asked for their first name which will be stored in String 
	 * first. then they will be asked for their last name which will be stored in String last. 
	 * 
	 * Then the user will be asked for their name and gender, which are stored in int age and String gender. 
	 * 
	 * Finally, database.put will add a new mapping with String id as a key that links to the value of a new Person object, with
	 * first, last, age, gender and 50 as parameters. The 50 points given are to help users get fast access to items in the kiosk,
	 * and is subsidized by the city and state. After this method, the user is taken back to the main page. 
	 * 
	 */
	public static void addNewUser()
	{
		Scanner keyInput = new Scanner(System.in);
		System.out.println("Please type out your 9 digit social security ID without dashes or spaces: ");
		String id = keyInput.next();
		
		if(database.get(id) instanceof PersonObject)
		{
			System.out.println("Whoops! Looks like you input an exisiting id. Please wait while we reroute you.\n");
		}
		
		else if(database.get(id) == null)
		{
			System.out.println("Please type your first name");
			String first = keyInput.next().trim();
			
			System.out.println("Please type your last name");
			String last = keyInput.next().trim();
			
			System.out.println("Please type your age");
			int age = keyInput.nextInt();
			
			System.out.println("Please type your gender");
			String gender = keyInput.next();
			
			database.put(id, new PersonObject(first, last, age, gender, 50));
			System.out.println("You have successfully been added to our system and you have 50 points"
					+ " as starting funds from the city.\nPlease wait while we take you to the main page.");
		}
		//keyInput.close();
	}
}
