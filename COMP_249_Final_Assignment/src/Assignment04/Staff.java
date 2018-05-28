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
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Staff extends Employee{
	
	private double salary = 0.0;
	private String performance_code;
	
	public final static String  StaffFile = "src/Staff.txt";
	
	public final static double A_BONUS = 1 + 0.08;
	public final static double B_BONUS = 1 + 0.06;
	public final static double C_BONUS = 1 + 0.03;
	public final static double D_BONUS = 1 + 0.01;
	public final static double E_BONUS = 1;
	
	public Staff()
	{
		super();
		salary = 0.0;
		performance_code = null; 
	}
	
	
	public static void increase_staff_salary()
	{
		Scanner input = null;
		PrintWriter pw = null;
		EmployeeList l1 = new EmployeeList();
		char code;
		
		try
		{
			input = new Scanner(new FileInputStream(StaffFile));
			EmployeeList.Node temp_node = l1.head; // NULL ---> No Employee have been added.
			
			while(input.hasNextLine())
			{
				Staff temp = new Staff();
				temp.setID(input.nextLong());
				temp.setFirstName(input.next());
				temp.setFamilyName(input.next());
				temp.setCityOfResidence(input.next());
				temp.setHireYear(input.nextInt());
				temp.setSalary(input.nextDouble());
				temp.setPerformanceCode(input.next());
				input.nextLine();
				if (l1.head == null)
				{
					l1.addNode(temp);
					temp_node = l1.head;
					System.out.println(temp_node.e);
				}
				
				else
				{
					temp_node.next = l1.new Node(temp, null);
					temp_node = temp_node.next;
					
					System.out.println(temp_node.e);
				}
			}
			
			temp_node = l1.head;
			pw = new PrintWriter(new FileOutputStream(StaffFile));
			
			while (temp_node != null)
			{
				Staff staff_temp = (Staff) temp_node.e;
				double placeholder = 0.0;
				System.out.println(staff_temp.salary);
				code = staff_temp.performance_code.charAt(0);// Cast into character from String
				//System.out.println(code);
				
				switch(code)
				{
					case 'A': 
					{
						placeholder = A_BONUS * staff_temp.salary * 100.0;
						placeholder = Math.round(placeholder);
						staff_temp.salary = placeholder / 100;
						
						//System.out.println(code);
						//System.out.println(staff_temp.salary);
						staff_temp.performance_code = "E";
						pw.println(staff_temp);
						
						temp_node = temp_node.next;
						break;
					}
					case 'B':
					{
						placeholder = B_BONUS * staff_temp.salary * 100.0;
						placeholder = Math.round(placeholder);
						staff_temp.salary = placeholder / 100;
	
						//System.out.println(code);
						//System.out.println(staff_temp.salary);
						staff_temp.performance_code = "E";
						pw.println(staff_temp);
						temp_node = temp_node.next;
						break;
					}
					case 'C':
					{
						placeholder = C_BONUS * staff_temp.salary * 100.0;
						placeholder = Math.round(placeholder);
						staff_temp.salary = placeholder / 100;
					
						//System.out.println(code);
						//System.out.println(staff_temp.salary);
						staff_temp.performance_code = "E";
						pw.println(staff_temp);
						temp_node = temp_node.next;
						break;
					}
					case 'D':
					{
						placeholder = D_BONUS * staff_temp.salary * 100.0;
						placeholder = Math.round(placeholder);
						staff_temp.salary = placeholder / 100;
				
						//System.out.println(code);
						//System.out.println(staff_temp.salary);
						staff_temp.performance_code = "E";
						pw.println(staff_temp);
						temp_node = temp_node.next;
						break;
					}
					case 'E':
					{
						//System.out.println(code);
						//System.out.println(staff_temp.salary);
						pw.println(staff_temp);
						temp_node = temp_node.next;
						break;
					}
					
				}
				
				
				
			}
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error with the file");
		}
		
		
		input.close();
		pw.close();
		
	}
	
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setPerformanceCode(String performance_code)
	{
		this.performance_code = performance_code;
	}
	
	public String getPerformanceCode()
	{
		return performance_code;
	}
	
	public String toString()
	{
		return (employee_id + "\t" + first_name + "\t" + family_name + "\t\t" + city_of_residence + "\t\t" + hire_year + "\t" + salary 
				+ "\t" + performance_code); 
	}

}
