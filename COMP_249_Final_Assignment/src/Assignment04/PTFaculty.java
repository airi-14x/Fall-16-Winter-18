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

import java.util.Scanner;

public class PTFaculty extends Employee
{

	private double hourlyRate;
	private int numOfHours, numOfStudents;
	public static final String FILE_DIR = "src/Part-Time-Faculty.txt";

	public PTFaculty(long employee_id, String first_name, String family_name, String city_of_residence, int hire_year,
			double hRate, int numHour, int numStud)
	{
		super(employee_id, first_name, family_name, city_of_residence, hire_year);
		hourlyRate = hRate;
		numOfHours = numHour;
		numOfStudents = numStud;
	}

	public PTFaculty()
	{
		hourlyRate = 0.0;
		numOfHours = 0;
		numOfStudents = 0;
	}

	public double getHourlyRate()
	{
		return hourlyRate;
	}

	public int getNumOfHours()
	{
		return numOfHours;
	}

	public int getNumOfStudents()
	{
		return numOfStudents;
	}

	public void setHourlyRate(double rate)
	{
		hourlyRate = rate;
	}

	public void setNumOfHours(int hours)
	{
		numOfHours = hours;
	}

	public void setNumOfStudents(int students)
	{
		numOfStudents = students;
	}

	public String toString()
	{
		return (super.toString() + "\t" + hourlyRate + "\t" + numOfHours + "\t" + numOfStudents);
	}

	public static double findTermSalary()
	{
		EmployeeList el = new EmployeeList();
		Scanner ptIn = null;
		double sum = 0.0;
		try
		{
			ptIn = new Scanner(new FileInputStream(FILE_DIR));
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
				el.addNode(temp);

			}
		} catch (FileNotFoundException e)
		{
			System.out.println("File not derr");
		}

		EmployeeList.Node temp = el.head;

		while (temp != null)
		{
			PTFaculty pttemp = (PTFaculty) temp.e;
			if (pttemp.numOfStudents > 60)
			{
				sum += (pttemp.getNumOfHours() * pttemp.getHourlyRate()) + 1000;
			} else if (pttemp.numOfStudents > 40 && pttemp.numOfStudents < 60)
			{

				sum += (pttemp.getNumOfHours() * pttemp.getHourlyRate()) + 500;
			} else
			{
				sum += (pttemp.getNumOfHours() * pttemp.getHourlyRate());

			}

			temp = temp.next;
		}

		ptIn.close();
		
		sum *= 100;
		sum = Math.round(sum);
		return sum;
	}

}
