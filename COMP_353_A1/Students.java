
/*
 * [ COMP-353 A1 ]
 * Date: 2018/01/28 @ 20h47
 * Name: Airi Chow (#40003396) 
 */
public class Students {
	
	private int SID;
	private String SName;
	private String Program;
	private String Address;
	private boolean selected = false; // Has this ID been selected? //
	
	public Students()
	{
		
	}
	
	public Students(int SID, String SName, String Program, String Address)
	{
		this.SID = SID;
		this.SName = SName;
		this.Program = Program;
		this.Address = Address;
	}
	
	public void setSID(int SID)
	{
		this.SID = SID;
	}
	
	public void setSName(String SName)
	{
		this.SName = SName;
	}
	
	public void setProgram(String Program)
	{
		this.Program = Program;
	}
	
	public void setAddress(String Address)
	{
		this.Address = Address;
	}

	public int getSID() {
		return SID;
	}

	public String getSName() {
		return SName;
	}

	public String getProgram() {
		return Program;
	}

	public String getAddress() {
		return Address;
	}
	
	public boolean getSelected()
	{
		return selected;
	}
	public void setSelected()
	{
		selected = true;
	}

}
