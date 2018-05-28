/* -------------------------------------------------------------------------------------
 * Assignment: 4
 * Written by: Airi Chow (40003396)
 * For COMP 248 Section R - FALL 2016
 * Date: 2016/11/20
 * Purpose: Create Menu class with at least six attributes. Opening Message, Closing 
 * 			Message, Top Prompt, Options, Bottom Prompt and String "?->"
 * --------------------------------------------------------------------------------------
 */

import java.util.Scanner;
public class Menu {
	
	// ----- ATTRIBUTES ----- //
	private String opening_message;
	private String closing_message;
	private String top_prompt;
	private String closing_prompt;
	private final String min_s = "?-> "; 
	private String[] options;
	
	private int choice_num;
	
	// CONSTRUCTOR //
	// ---- NON-DEFAULT ------- //
	public Menu(String[] options) 
	{
		setTopMessage(null);
		setBottomMessage(null);
		
		// OPTION LIST MENU //
		if (isEmpty(options) == false)
		{
			this.options = new String[options.length]; // Another Array with Same Size
			for(int i = 0; i < options.length; i++)
			{
				this.options[i] = options[i];
			}
		}
		
		else 
			this.options = null; // Empty or Null
	
		setTopPrompt("Choose an option: ");
		setBottomPrompt("Enter an option number: ");
	}
	
	// -------- DEFAULT ------ //
	public Menu()
	{
		setTopMessage(null);
		setBottomMessage(null);
		setTopPrompt(null);
		setBottomPrompt(null);
		this.options = null;
	}
	
	// FACILITATOR //
	public boolean isEmpty(String[] options)
	{
		// Null //
		if (length(options) == 0)
			return true;
		// Empty, Pointing at Array but no Elements //
		else if (options.length == 0)
			return true;
		// Elements Exist, so Not Empty //
		else
			return false;
		
	}
	
	public int length(String[] options)
	{	
		// Is the string null? aka Pointing at Nothing? //
		if (options == null)
			return 0;
		else
			return options.length; 
	}
	
	//---- INPUT ------ //
	public int getOptionNumber()
	{
		Scanner input = new Scanner(System.in);
		
		// DISPLAY MENU AT LEAST ONCE //
		if (getTopMessage() != null)
			System.out.println(getTopMessage());
		
		if (getTopPrompt() != null)
			System.out.println(getTopPrompt());
	
		// NON-NULL OPINIONS //
		if (this.options != null)
		{
			for (int i = 0; i < this.options.length; i++)
				System.out.println("    (" + (i+1) + ") " + this.options[i]);
		}
		
		if (getBottomMessage() != null)
			System.out.println(getBottomMessage());
		
		System.out.print(min_s);
		
		if (getBottomPrompt() != null)
			System.out.println(getBottomPrompt());
		
		// USER INPUT //
		choice_num = input.nextInt();
		
		if (this.options == null)
			return choice_num;
		
		else if (this.options.length == 0)
			return choice_num;
		
		else if (this.options != null || choice_num >= 1 && choice_num <= this.options.length - 1)
			return choice_num;
		else
		{
			while (!(choice_num >= 1 && choice_num <= this.options.length - 1))
			{
				if (getTopMessage() != null)
					System.out.println(getTopMessage());
				
				if (getTopPrompt() != null)
					System.out.println(getTopPrompt());
			
				if (this.options != null)
				{
					for (int i = 0; i < this.options.length; i++)
					{	
						System.out.println("    (" + (i+1) + ") " + this.options[i]);
					}
				}
				
				if (getBottomMessage() != null)
					System.out.println(getBottomMessage());
				
				System.out.print(min_s);
				
				if (getBottomPrompt() != null)
					System.out.println(getBottomPrompt());
				
				choice_num = input.nextInt();
			}
		}
		return choice_num; 
	}
	
	
	// SETTERS + GETTERS //
	// -------- OPENING MESSAGE -------- //
	// SETTER //
	public void setTopMessage(String s)
	{
		opening_message = s;
	}

	// GETTER //
	public String getTopMessage()
	{
		return opening_message;
	}
	
	// ------- CLOSING MESSAGE -------- //
	// SETTER //
	public void setBottomMessage(String s)
	{
		 closing_message = s;
	}
	
	// GETTER //
	public String getBottomMessage()
	{
		return closing_message;
	}
	
	// -------- TOP PROMPT ----------- //
	// SETTER //
	public void setTopPrompt(String s)
	{
		top_prompt = s;
	}
	
	// GETTER //
	public String getTopPrompt()
	{
		return top_prompt;
	}
	
	// ------- CLOSING PROMPT ------- //
	// SETTER //
	public void setBottomPrompt(String s)
	{
		closing_prompt = s;
	}
	
	// GETTER //
	public String getBottomPrompt()
	{
		return closing_prompt;
	}
	
	// ----- STRING FORMATTER -------- //
	public String toString()
	{
		if (getTopMessage() != null)
			System.out.println(getTopMessage());
		
		if (getTopPrompt() != null)
			System.out.println(getTopPrompt());
	
		if (this.options != null)
		{
			for (int i = 0; i < this.options.length; i++)
			{
				System.out.println("    (" + (i+1) + ") " + this.options[i]);
			}
		}
		
		if (getBottomMessage() != null)
			System.out.println(getBottomMessage());
		
		System.out.print(min_s);
		
		if (getBottomPrompt() != null)
			System.out.println(getBottomPrompt());
		
		return "";
	}
	
}
