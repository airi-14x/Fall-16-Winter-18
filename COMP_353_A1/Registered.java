
/*
 * [ COMP-353 A1 ]
 * Date: 2018/01/28 @ 20h47
 * Name: Airi Chow (#40003396)
 * 
 */

public class Registered {

	private int SID;
	private int CID;
	private int grade;
	
	public Registered()
	{
		
	}
	
	public Registered(int SID, int CID, int grade)
	{
		this.SID = SID;
		this.CID = CID;
		this.grade = grade;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int SID) {
		this.SID = SID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int CID) {
		this.CID = CID;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
