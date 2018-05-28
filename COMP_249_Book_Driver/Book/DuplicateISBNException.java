//------------------------------------------------------
//
// Assignment #3
// Part: I
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------

package Book;

public class DuplicateISBNException extends Exception{

	public DuplicateISBNException() {
		super("Attempt of duplicate entry to a previous record.");
	}

	public DuplicateISBNException(String message) {
		super(message);
	}
	
	public String getErrorMessage()
	{
		return super.getMessage();
	}
	
}
