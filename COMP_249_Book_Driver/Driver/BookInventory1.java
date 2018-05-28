//------------------------------------------------------
//
// Assignment #3
// Part: I
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------

package Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

import Book.Book;
import Book.DuplicateISBNException;

public class BookInventory1
{

	static Book[] bkArr;

	static Scanner test;
	static boolean isDuplicate = false;

	final static String BOOK_INIT = "src/Book/Initial_Book_Info.txt";

	public static void main(String[] args)
	{
		FileInputStream init = null;
		try
		{
			init = new FileInputStream("src/Book/Initial_Book_Info.txt");
		} 
		
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found... Terminating");
			System.exit(0);
		}

		Scanner keyboard = new Scanner(System.in);

		// Check Validity of Output File //
		System.out.println("Please enter the name of output file, which will have correct information: ");
		String user_input = keyboard.next();
		File f1 = new File(user_input);

		// Continues to Loop if the file exists //
		while (f1.exists())
		{
			System.out.println("Error: There is an existing  file called: " + user_input + ".");
			System.out.println("That file already has a size of " + f1.length() + " bytes.");
			System.out.println("Please enter another file name to create:");

			user_input = keyboard.next();
			f1 = new File(user_input); // Re-prompt user for file name //
		}
		
		System.out.println();
		System.out.println("Attempting to open file: Initial_Book_Info.txt.");
		System.out.println();
		
		System.out.println("Detecting number of records in file: Initial_Book_Info.txt");
		System.out.println("");
		
		try
		{
			// CHECK NUMBER OF LINES //
			int lineCount = lineCount(BOOK_INIT);
			System.out.println("This file has " + lineCount(BOOK_INIT) + " Records");
			if (lineCount == 0 || lineCount == 1)
			{
				System.out.println("Nothing needs to be fixed. Closing File and Terminating...");
				try
				{
					init.close();
				} 
				catch (IOException e)
				{
					System.out.println("Error has been found whilst reading this file " + init);
				}
				System.exit(0);
			}

			// CALL FIXINVENTORY IF LINE IS NEITHER 0 OR 1 //
			bkArr = new Book[lineCount]; // Set 
			
			fixInventory(init, new FileOutputStream(user_input));
			System.out.println();
			System.out.println("Here are the contents of the file Initial_Book_Info.txt AFTER copying operation:");
			System.out.println("================================================================================");
			init = new FileInputStream("src/Book/Initial_Book_Info.txt"); // Open file again because after fixInventory, it's at EOF //
			displayFileContents(init);
			
			System.out.println();
			System.out.println("Here are the contents of the file " + f1 + ":");
			System.out.println("=================================================");
			FileInputStream input = new FileInputStream(f1); // Open user's file instead //
			
			displayFileContents(input);
			init.close();
			input.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("File Not Found... Terminating");
			System.exit(0);

		} catch (IOException io)
		{
			System.out.println("Error has been found whilst reading the file.");
			System.exit(0);
		} 
		
		keyboard.close(); 
	}

	/**
	 * Takes FileInputStream's input and copies information into bkArr[]...
	 * 
	 * @param input  : Input Stream
	 * @param output : String
	 */
	
	private static void insertBook(FileInputStream input) throws FileNotFoundException, IOException
	{
		test = new Scanner(input);
		for (int k = 0; k < bkArr.length; k++)
		{
			bkArr[k] = new Book();
			bkArr[k].setISBN(test.nextLong());
			bkArr[k].setTitle(test.next());
			bkArr[k].setIssueYear(test.nextInt());
			bkArr[k].setAuthorName(test.next());

			bkArr[k].setPrice(test.nextDouble());
			bkArr[k].setNum_of_pages(test.nextInt());
			test.nextLine();
		}
		test.close();

	}

	/**
	 * PRECONDITION: Input file has at least two lines..
	 *  - Calls isDuplicate to check if there are duplicates. 
	 *  - Asks the user for new ISBN if there is a duplicate.
	 * 
	 * @param input  : Input Stream
	 * @param output : String
	 */
	private static void fixInventory(FileInputStream input, FileOutputStream output) throws IOException, FileNotFoundException 
	{
		insertBook(input);
		input = new FileInputStream("src/Book/Initial_Book_Info.txt"); // Open again.
		
		PrintWriter pw = null;
		pw = new PrintWriter(output);
		
		Scanner teste = new Scanner(System.in);
		System.out.println();
		containsDuplicate(bkArr);
		
		while(isDuplicate)
		{
			long temp = 0;
			int original_index = 0; // Used in order to avoid using try/catch when displaying error message (isDuplicate(bkArr,temp) + 1) <--- Requires try/catch //
			
			// Using '-1' as index will cause an error //
			if (containsDuplicate(bkArr) != -1)
			{
				System.out.print("Duplicate ISBN " + bkArr[containsDuplicate(bkArr)].getISBN() +
						" detected in record # " + (containsDuplicate(bkArr) + 1) + ". Please enter correct ISBN: ");
				temp = teste.nextLong();
			}
				
			try
			{
				original_index = isDuplicate(bkArr, temp);
			
				if (original_index > 0) // Neither Default Value or Valid ISBN //
				{
					throw new DuplicateISBNException();
				}
			}
			catch(DuplicateISBNException disbne)
			{
				disbne.getMessage();
				System.out.println();
				System.out.println("Initial appearance of ISBN " + temp  + " was found at record #: " + (original_index + 1) + "." );
				System.out.println("Error.... Duplicate Entry of ISBN. The entered ISBN exists for another record.");
			}
			
			// Valid ISBN //
			if (original_index == -1)
			{
				if (containsDuplicate(bkArr) != -1)
				{
					bkArr[containsDuplicate(bkArr)].setISBN(temp);
				}
			}
			
		}
		
		for (int i = 0; i < bkArr.length; i++)
		{
			pw.print(bkArr[i].getISBN());
			pw.print(" ");
			pw.print(bkArr[i].getTitle());
			pw.print(" ");
			pw.print(bkArr[i].getIssueYear());
			pw.print(" ");
			
			pw.print(bkArr[i].getAuthorName());
			pw.print(" ");
			pw.print(bkArr[i].getPrice());
			pw.print(" ");
			pw.print(bkArr[i].getNum_of_pages());
			pw.println();	 
		}
		
		// Close FileInputStream, Scanner, PrintWriter, FileOutputStream //
		input.close();
		pw.close();
		teste.close();
		output.close();
	}
		
	/**
	 * Checks the Book array if the ISBN already exists.
	 * 
	 * @param bkArr : Book
	 * @return index j if the ISBN number exists. 
	 * @return -1 if the ISBN number doesn't exist.
	 *
	 */

	private static int containsDuplicate(Book[] bkArr) 
	{
		for(int i = 0; i < bkArr.length - 1; i++)
		{
			for (int j = i + 1; j < bkArr.length; j++)
			{
				if (bkArr[i].getISBN() == bkArr[j].getISBN())
				{
					isDuplicate = true;
					
					return j; // First occurance of duplicate... "Duplicate ISBN *INSERT Duplicate ISBN* ... # index j"
				}
			}
		}
		
		isDuplicate = false;
		return -1;
	}
	
	/**
	 * Checks the Book array if the user's new ISBN already exists.
	 * 
	 * @param bkArr : Book
	 * @param j : long
	 * @return index i if the ISBN number exists.
	 * @return -1 if the ISBN number doesn't exist.
	 */
	private static int isDuplicate(Book[] bkArr, long j) throws DuplicateISBNException
	{
		for(int i = 0; i < bkArr.length; i++)
		{
			if (bkArr[i].getISBN() == j)
			{
				isDuplicate = true;
				return i; // Index of Original ISBN that is duplicated... "Initial appearance of ... #: index i"
			}
		}
		
		return -1;
		
	}

	/**
	 * Accepts FileInputStream input in order to be sent to standard output (screen).
	 * 
	 * @param input : FileInputStream
	 * .
	 */
	private static void displayFileContents(FileInputStream input) throws FileNotFoundException, IOException
	{
		Scanner sc = new Scanner(input);

		while (sc.hasNextLine())
		{
			System.out.println(sc.nextLong() + " " + sc.next() + " " + sc.nextInt() + " " + sc.next() + " "
					+ sc.nextDouble() + " " + sc.nextInt());
			sc.nextLine();
		}
		
		sc.close();

	}

	/**
	 * Returns an int line_counter which represents the # of lines from input file.
	 * 
	 * @param String s ---> File's name
	 * @return int lineCount
	 * 
	 */
	private static int lineCount(String s) throws FileNotFoundException, IOException
	{
		FileInputStream i = new FileInputStream(s);
		Scanner input;
		input = new Scanner(i);
		int line_counter = 0;

		// Returns false, when it is End Of File //
		while (input.hasNextLine())
		{
			input.nextLine();
			line_counter++;
		}

		i.close();
		input.close();
		return line_counter;

	}

}
