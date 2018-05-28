//------------------------------------------------------
//
// Assignment #4
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------

package Assignment04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Controller
{

	private static ArrayList<PTFaculty> partTimeList = new ArrayList<PTFaculty>();
	private static ArrayList<FTFaculty> fullTimeList = new ArrayList<FTFaculty>();
	private static ArrayList<TA> TAList = new ArrayList<TA>();
	private static ArrayList<Staff> StaffList = new ArrayList<Staff>();
	private final double CURRENT_FIXED_RATE = 18.25;

	private static ArrayList<Long> idList = new ArrayList<Long>();

	private final static Scanner keyIn = new Scanner(System.in); // Keyboard
																	// Scanner

	public static void loadID()
	{
		Scanner loader = null;

		try
		{
			loader = new Scanner(new FileInputStream(TA.TAFile));
			while (loader.hasNextLine())
			{

				idList.add((Long) loader.nextLong());

				loader.next();
				loader.next();
				loader.next();
				loader.nextInt();
				loader.next();
				loader.nextInt();
				loader.nextInt();
				loader.nextLine();
			}
			loader.close();
			loader = new Scanner(new FileInputStream(FTFaculty.FILE_DIR));

			while (loader.hasNextLong())
			{
				idList.add((Long) loader.nextLong());
				loader.next();
				loader.next();
				loader.next();
				loader.nextInt();
				loader.nextDouble();

			}

			loader.close();
			loader = new Scanner(new FileInputStream(PTFaculty.FILE_DIR));

			while (loader.hasNextLine())
			{
				idList.add((Long) loader.nextLong());
				loader.next();
				loader.next();
				loader.next();
				loader.nextInt();
				loader.nextDouble();
				loader.nextInt();

				loader.nextInt();
				
				loader.nextLine();

			}

			loader.close();
			loader = new Scanner(new FileInputStream(Staff.StaffFile));
			while (loader.hasNextLine())
			{
				idList.add(loader.nextLong());
				loader.next();
				loader.next();
				loader.next();
				loader.nextInt();
				loader.nextDouble();
				loader.next();
				loader.nextLine();
			}

			loader.close();
		}

		catch (FileNotFoundException e)
		{
			System.out.println("NO");
		}

	}

	public static void addTARecords()
	{
		Scanner TA_input = null;
		PrintWriter pw = null;
		// Opening File //
		try
		{
			TA_input = new Scanner(new FileInputStream(TA.TAFile));
			
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}

		// Reading File Line by Line //
		while (TA_input.hasNextLine())
		{
			TA temp_TA = new TA(); // Create a TA object to use the setters.
			temp_TA.setID(TA_input.nextLong());
			temp_TA.setFirstName(TA_input.next());
			temp_TA.setFamilyName(TA_input.next());
			temp_TA.setCityOfResidence(TA_input.next());
			temp_TA.setHireYear(TA_input.nextInt());
			temp_TA.setTypeofTA(TA_input.next());
			temp_TA.setNumOfClass(TA_input.nextInt());
			temp_TA.setTotalHours(TA_input.nextInt());
			TA_input.nextLine();

			if (temp_TA.getTypeofTA().equals("UGrad") || temp_TA.getTypeofTA().equals("Grad"))
			{
				TAList.add(temp_TA); // Add object to list
				idList.add((Long)temp_TA.getID());
			}
		
			//System.out.println(TAList);
		}
			
		// Let the User add new TA's info //
		int user_value = 0;
	
		while (user_value != -1)
		{
			try
			{

				TA new_TA = new TA();
				do
				{
					System.out.println("Enter ID Code:");
					new_TA.setID(keyIn.nextLong());
				} while (idList.contains((Long)new_TA.getID())); // ?? why the second
														// condition?

				System.out.println("Enter First Name: ");
				new_TA.setFirstName(keyIn.next());

				System.out.println("Enter Family Name: ");
				new_TA.setFamilyName(keyIn.next());

				System.out.println("Enter City of Residence: ");
				new_TA.setCityOfResidence(keyIn.next());

				System.out.print("Enter Hire Year: ");
				new_TA.setHireYear(keyIn.nextInt());

				System.out.println("Enter Type of TA: ");
				new_TA.setTypeofTA(keyIn.next());

				System.out.println("Enter Number of Class Teaching this semester: ");
				new_TA.setNumOfClass(keyIn.nextInt());

				System.out.println("Enter Total Number of Hours: ");
				new_TA.setTotalHours(keyIn.nextInt());

				if (new_TA.getTypeofTA().equals("UGrad") || new_TA.getTypeofTA().equals("Grad"))
				{
					TAList.add(new_TA);
				}
				
				System.out.println("Do you want to add another record? Enter '-1' to terminate or any other input to continue");
				user_value = keyIn.nextInt();
			}
			

			catch (InputMismatchException e)
			{
				keyIn.nextLine();
				System.out.println("Yeah, no. Input the correct info. Try again....");
			}
			
			// Printing //
			try 
			{
				pw = new PrintWriter(new FileOutputStream(TA.TAFile));
				
				for(TA temp: TAList)
				{
					System.out.println(temp);
					pw.println(temp);
				}
				
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Error with creation of file");
			}
			
		}
		
		pw.close();
	}

	public static void addFTRecords()
	{
		Scanner ftIn = null;
		// ====================================================================
		// For putting into ArrayList
		// ====================================================================
		try
		{
			ftIn = new Scanner(new FileInputStream(FTFaculty.FILE_DIR));
		} catch (FileNotFoundException e)
		{
			System.out.println("lol try again");
		}

		while (ftIn.hasNextLine())
		{
			FTFaculty temp = new FTFaculty();
			temp.setID(ftIn.nextLong());
			temp.setFirstName(ftIn.next());
			temp.setFamilyName(ftIn.next());
			temp.setCityOfResidence(ftIn.next());
			temp.setHireYear(ftIn.nextInt());
			temp.setSalary(ftIn.nextDouble());
			ftIn.nextLine();
			fullTimeList.add(temp);
		}

		// ===================================================
		// Adding new stuff
		// ===================================================
		int trigger = 0;
		while (trigger != -1)
		{
			try
			{
				FTFaculty temp = new FTFaculty();
				do
				{
					System.out.print("Please enter ID: ");
					temp.setID(keyIn.nextLong());
				} while ((idList.contains((Long) temp.getID())));

				System.out.print("Please enter First Name: ");
				temp.setFirstName(keyIn.next());

				System.out.print("Please enter Family Name: ");
				temp.setFamilyName(keyIn.next());

				System.out.print("Please enter City of Residence: ");
				temp.setCityOfResidence(keyIn.next());

				System.out.print("Please enter Hire Year: ");
				temp.setHireYear(keyIn.nextInt());

				System.out.print("Please enter Salary: ");
				temp.setSalary(keyIn.nextDouble());

				fullTimeList.add(temp);

				idList.add((Long) temp.getID());
				System.out.print("Add new record? Enter -1 for no, anything else for yes.");
				trigger = keyIn.nextInt();

			} catch (InputMismatchException ime)
			{
				keyIn.nextLine();
				System.out.println("Do it rrighht");
			}

		}
		// ===================================================
		// Writing it into the file
		// ===================================================
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new FileOutputStream(FTFaculty.FILE_DIR));

			for (FTFaculty i : fullTimeList)
			{
				if(fullTimeList.lastIndexOf(i) == fullTimeList.size()-1)
				{	pw.print(i);
				}else
				{
					pw.println(i);
				}
			}
		} catch (FileNotFoundException e)
		{

			System.out.println("FILE NOT FOUND NIGGA");
		}

		pw.close();

		ftIn.close();
	}

	public static void addPTRecords()
	{
		Scanner ptIn = null;
		// ====================================================================
		// For putting into ArrayList
		// ====================================================================
		try
		{
			ptIn = new Scanner(new FileInputStream(PTFaculty.FILE_DIR));
		} catch (FileNotFoundException e)
		{
			System.out.println("lol try again");
		}

		while (ptIn.hasNextLine())
		{
			PTFaculty temp = new PTFaculty();
			temp.setID(ptIn.nextLong());
			temp.setFirstName(ptIn.next());
			temp.setFamilyName(ptIn.next());
			temp.setCityOfResidence(ptIn.next());
			temp.setHireYear(ptIn.nextInt());

			temp.setHourlyRate(ptIn.nextDouble());
			temp.setNumOfHours(ptIn.nextInt());
			temp.setNumOfStudents(ptIn.nextInt());
			ptIn.nextLine();

			partTimeList.add(temp);
			idList.add((Long) temp.getID());
			System.out.println(temp);
		}

		// ===================================================
		// Adding new stuff
		// ===================================================
		int trigger = 0;
		while (trigger != -1)
		{
			try
			{
				PTFaculty temp = new PTFaculty();
				do
				{
					System.out.print("Please enter ID: ");
					temp.setID(keyIn.nextLong());
				} while ((idList.contains((Long) temp.getID())));

				System.out.print("Please enter First Name: ");
				temp.setFirstName(keyIn.next());

				System.out.print("Please enter Family Name: ");
				temp.setFamilyName(keyIn.next());

				System.out.print("Please enter City of Residence: ");
				temp.setCityOfResidence(keyIn.next());

				System.out.print("Please enter Hire Year: ");
				temp.setHireYear(keyIn.nextInt());

				System.out.print("Please enter Hourly Rate: ");
				temp.setHourlyRate(keyIn.nextDouble());

				System.out.println("Please enter Number of Hours: ");
				temp.setNumOfHours(keyIn.nextInt());

				System.out.println("Please enter Number of Students: ");
				temp.setNumOfStudents(keyIn.nextInt());

				partTimeList.add(temp);
				idList.add((Long) temp.getID());
				System.out.print("Add new record? Enter -1 for no, anything else for yes.");
				trigger = keyIn.nextInt();

			} catch (InputMismatchException ime)
			{
				keyIn.nextLine();
				System.out.println("Do it rrighht");
			}

		}
		// ===================================================
		// Writing it into the file
		// ===================================================
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new FileOutputStream(PTFaculty.FILE_DIR));

			for (PTFaculty i : partTimeList)
			{
				if (i.equals(partTimeList.get(partTimeList.size()-1)))
				{
					pw.print(i);
				} else
				{
					pw.println(i);
				}
			}
		} catch (FileNotFoundException e)
		{

			System.out.println("FILE NOT FOUND NIGGA");
		}
		ptIn.close();
		pw.close();
	}

	public static void openStaffRecords()
	{
		Scanner staffInput = null;
		try
		{
			staffInput = new Scanner(new FileInputStream(Staff.StaffFile));
		}

		catch (FileNotFoundException e)
		{
			System.out.println("Error Opening the File");
		}

		while (staffInput.hasNextLine())
		{
			int user_input = 0;

			while (user_input != -1)
			{
				Staff temp = new Staff();
				temp.setID(staffInput.nextLong());
				temp.setFirstName(staffInput.next());
				temp.setFamilyName(staffInput.next());
				temp.setCityOfResidence(staffInput.next());
				temp.setHireYear(staffInput.nextInt());
				temp.setSalary(staffInput.nextDouble());
				temp.setPerformanceCode(staffInput.next());
			
				staffInput.nextLine();
				StaffList.add(temp);

			}
		}

		staffInput.close();
	}
}
