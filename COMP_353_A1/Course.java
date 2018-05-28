
/*
 * [ COMP-353 A1 ]
 * Date: 2018/01/28 @ 20h47
 * Name: Airi Chow (#40003396)
 *  
 */

public class Course {
	
	private int CID;
	private String CName;
	private double NoOfCredits;
	
	public Course()
	{	
	}
	
	public Course(int CID, String CName, double NoOfCredits)
	{
		this.CID = CID;
		this.CName = CName;
		this.NoOfCredits = NoOfCredits;	
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public double getNoOfCredits() {
		return NoOfCredits;
	}

	public void setNoOfCredits(double noOfCredits) {
		NoOfCredits = noOfCredits;
	}
	
	
}
