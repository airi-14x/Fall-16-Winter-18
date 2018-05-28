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
import java.text.DecimalFormat;
import java.util.Scanner;

public class TA extends Employee{
	
	private String type_of_TA;
	private int num_of_class;
	private int total_hours;
	private double rate;
	private final static double UD_TA_RATE = 18.25;
	private final static double GD_TA_RATE = 1.2 * UD_TA_RATE;
	
	private final static double CURRENT_FIXED_RATE = 0.0;
	
	public final static String TAFile = "src/TAs.txt";
	
	public TA()
	{
		super();
		type_of_TA = null;
		num_of_class = 0;
		total_hours = 0;
		rate = 0.0;
	}

	public String getTypeofTA() {
		return type_of_TA;
	}

	public void setTypeofTA(String type_of_TA) {
		this.type_of_TA = type_of_TA;
	}

	public int getNumOfClass() {
		return num_of_class;
	}

	public void setNumOfClass(int num_of_class) {
		this.num_of_class = num_of_class;
	}

	public int getTotalHours() {
		return total_hours;
	}

	public void setTotalHours(int total_hours) {
		this.total_hours = total_hours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public static double getCurrentFixedRate() {
		return CURRENT_FIXED_RATE;
	}
	
	public static double findTermSalary()
	{
		Scanner input = null;
		EmployeeList l1 = new EmployeeList(); // Create new list //
		double sum = 0.0;
		try
		{
			input = new Scanner(new FileInputStream(TA.TAFile));
			
			// Add the Nodes //
			while(input.hasNextLine())
			{
				TA temp_TA = new TA(); // Create a TA object to use the setters.
				temp_TA.setID(input.nextLong());
				temp_TA.setFirstName(input.next());
				temp_TA.setFamilyName(input.next());
				temp_TA.setCityOfResidence(input.next());
				temp_TA.setHireYear(input.nextInt());
				temp_TA.setTypeofTA(input.next());
				temp_TA.setNumOfClass(input.nextInt());
				temp_TA.setTotalHours(input.nextInt());
				input.nextLine();
				
				if (temp_TA.getTypeofTA().equals("UGrad") || temp_TA.getTypeofTA().equals("Grad"))
				{
					l1.addNode(temp_TA);
				}
				
			}
			
			EmployeeList.Node temp = l1.head;
			
			while (temp != null)
			{
				TA ta_temp = (TA) temp.e;
				if (ta_temp.type_of_TA.equals("UGrad"))
				{
					sum += UD_TA_RATE * ta_temp.total_hours * ta_temp.num_of_class;
				}
				
				else if (ta_temp.type_of_TA.equals("Grad"))
				{
					sum += GD_TA_RATE * ta_temp.total_hours * ta_temp.num_of_class;
				}
				temp = temp.next;
			}
			
		}
		
		
		catch (FileNotFoundException e)
		{
			System.out.println("File cannot be opened");
		}
		
		input.close();
		
		// Rounding //
		sum = sum * 100;
		sum = Math.round(sum);
		//System.out.println(sum / 100);
		return (sum / 100);
	}
	
	
	public String toString()
	{
		return (employee_id + "\t" + first_name + "\t" + family_name + "\t\t" + city_of_residence + "\t\t" + hire_year + "\t" + type_of_TA 
			   + "\t" + num_of_class + "\t" + total_hours);
	}
}
 