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
import java.util.Scanner;

public class FTFaculty extends Employee
{

	private double salary;
	public static final String FILE_DIR = "src/Full-Time-Faculty.txt";

	public static void findHighest_and_Lowest_FT_Salary()
	{
		Scanner ftIn = null;
		EmployeeList ftl = new EmployeeList();
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
			ftl.addNode(temp);
		}
		double highest,lowest;
		
		EmployeeList.Node temp1 = ftl.head;
		FTFaculty temp = (FTFaculty)temp1.e;
		
		highest = temp.getSalary();
		lowest = temp.getSalary();
		// Go through once to find highest and lowest
		while(temp1 != null)
		{
			temp = (FTFaculty) temp1.e;
			if(highest < temp.getSalary())
			{
				highest = temp.getSalary();
			}
			if(lowest > temp.getSalary())
			{
				lowest = temp.getSalary();
			}
			temp1 = temp1.next;
		}

		ArrayList <FTFaculty> highList = new ArrayList<FTFaculty>();
		ArrayList <FTFaculty> lowList = new ArrayList<FTFaculty>();
	
		//populating the higList and lowList
		
		temp1 = ftl.head;
		while(temp1 != null)
		{
			temp = (FTFaculty) temp1.e;
			if(highest == temp.getSalary())
			{
				highList.add(temp);
			}
			if(lowest == temp.getSalary())
			{
				lowList.add(temp);
			}
			temp1 = temp1.next;
		}
		
		System.out.println("HERE BE THE PEOPLE WITH HIGHEST SALARIES");
		for(FTFaculty t : highList)
		{
			System.out.println(t);
		}
		
		System.out.println("LET THIS BE THE PEOPLE OF LOWEST CLASS, PLEBS WITH NO MONEY");
		for(FTFaculty t : lowList)
		{
			System.out.println(t);
		}
	}

	public String toString()
	{
		return (super.toString() + "\t" + salary);
	}

	public FTFaculty(long employee_id, String first_name, String family_name, String city_of_residence, int hire_year,
			double sal)
	{
		super(employee_id, first_name, family_name, city_of_residence, hire_year);
		salary = sal;
	}

	public FTFaculty()
	{
		salary = 0.0;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double d)
	{
		salary = d;
	}

}
