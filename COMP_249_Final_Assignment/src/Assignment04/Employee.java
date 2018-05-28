//------------------------------------------------------
//
// Assignment #4
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------


package Assignment04;


public class Employee implements Ordered {

	protected long employee_id;
	protected String first_name;
	protected String family_name;
	protected String city_of_residence;
	protected int hire_year;
	
	
	public Employee()
	{
		employee_id = 0;
		first_name = null;
		family_name = null;
		city_of_residence = null;
		hire_year = 0;
	}
	
	public Employee(long employee_id, String first_name, String family_name, String city_of_residence, int hire_year)
	{
		setID(employee_id);
		setFirstName(first_name);
		setFamilyName(family_name);
		setCityOfResidence(city_of_residence);
		setHireYear(hire_year);
	}
	
	public void setID(long id)
	{
		employee_id = id;
	}
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public void setFamilyName(String family_name)
	{
		this.family_name = family_name;
	}
	
	public void setCityOfResidence(String city_of_residence)
	{
		this.city_of_residence = city_of_residence;
	}
	
	public void setHireYear(int hire_year)
	{
		this.hire_year = hire_year;
	}
	
	public long getID()
	{
		return employee_id;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public String getFamilyName()
	{
		return family_name;
	}
	
	public String getCityOfResidence()
	{
		return city_of_residence;
	}
	
	public int getHireYear()
	{
		return hire_year;
	}
	
	@Override
	public boolean precedes(Object o1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean follows(Object o1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString()
	{
		return (employee_id + "\t" + first_name + "\t" + family_name
				+ "\t" + city_of_residence + "\t" + hire_year);
	}
	
	public static double findTermSalary()
	{
		return (PTFaculty.findTermSalary() + TA.findTermSalary());
	}
	
	public boolean equals(Object o1)
	{
		return false;
	}
	

}
