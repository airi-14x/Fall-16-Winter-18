//------------------------------------------------------
//
// Assignment #3
//Part: II
// Written By: 
// Earl Steven Aromin (#40004997)
// Airi Chow (#40003396)
//
//------------------------------------------------------


package Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.EOFException;
import java.io.PrintWriter;
import java.lang.ClassNotFoundException;

import Book.Book;

public class BookInventory2
{
	final public static String SORTED = "src/Book/Sorted_Book_Info.txt";
	final public static Scanner keyIn = new Scanner(System.in);
	private static Book[] bkArr;
	private static long big = 0;

	private static int lCount;

	private static int bbsCounter; // Counter for Binary Search //
	private static boolean addLooper = true;

	private static int sequential_it; // Counter for Sequential Search //

	private static boolean searchBinaryBook = true;
	private static boolean searchSequential = true;
	private static int user_value = 0;
	
	private static int placeholderStart;
	private static int placeholderEnd;
	private static int user_ISBN;
	
	public static void main(String[] args)
	{
		try
		{
			displayFileContents(new FileReader(SORTED)); // Initial File is Displayed //

			lCount = lineCount(SORTED);
			bkArr = new Book[lCount]; // Create Book Array with inital # of items //
			insertBook(new FileInputStream(SORTED)); // Add to Book array //
			big = bkArr[bkArr.length - 1].getISBN(); // Biggest ISBN in file //

			while (addLooper)
			{
				addRecords(new FileOutputStream(SORTED, true)); // Add new ISBNs to Output File //
			}

			lCount = lineCount(SORTED);
			bkArr = new Book[lCount];
			insertBook(new FileInputStream(SORTED)); // Reinsert old + new information to Book Array //
			
			// Binary Searching ===> ENTER '-1' to terminate //
			while (searchBinaryBook)
			{
				System.out.println("Do you wish to continue ISBN search with Binary Search? Enter any number to continue... (Enter -1 to terminate)");
				user_value = keyIn.nextInt();
				if (user_value == -1)
				{
					searchBinaryBook = false;
				}
				
				else
				{ 
					bbsCounter = 0;
					System.out.println("Provide the Start Index: ");
					placeholderStart = keyIn.nextInt();
					System.out.println("Provide the End Index: ");
					placeholderEnd = keyIn.nextInt();
					System.out.println("Provide ISBN to search");
					user_ISBN = keyIn.nextInt();
					
					binaryBookSearch(bkArr, placeholderStart, placeholderEnd, user_ISBN);
					System.out.println();
				}
			}
			
			// Sequential Searching ===> ENTER '-1' to terminate //
			while (searchSequential)
			{
				System.out.println("Do you wish to continue ISBN search with Sequential Search? Enter any number to continue... (Enter -1 to terminate)");
				user_value = keyIn.nextInt();
				if (user_value == -1)
				{
					searchSequential = false;
				}
				
				else
				{ 
					System.out.println("Provide the Start Index: ");
					placeholderStart = keyIn.nextInt();
					System.out.println("Provide the End Index: ");
					placeholderEnd = keyIn.nextInt();
					System.out.println("Provide ISBN to search");
					user_ISBN = keyIn.nextInt();
					
					System.out.println(sequentialBookSearch(bkArr, placeholderStart, placeholderEnd, user_ISBN));
					System.out.println();
				}
				
			}
			
			//binaryBookSearch(bkArr, 0, 15, 961111111);

			// ** User's input == Array index ** //
			
			//sequentialBookSearch(bkArr, 0, 17, 231231);
			//sequentialBookSearch(bkArr, -1, 17, 231231);
			//System.out.println(sequentialBookSearch(bkArr, 0, 12, 232421231));
			//System.out.println(sequentialBookSearch(bkArr, 3, 12, 798887166));

			//System.out.println(sequentialBookSearch(bkArr, 0, 14, 957877747));
			//displayFileContents(new FileReader(SORTED));
			
			writeArray("src/Book/Test.dat");
			readBinaryRecords("src/Book/Test.dat");
		}

		catch(EOFException e)
		{
			System.out.println("End of File has been reached");
			
		}catch(ClassNotFoundException e)
		{
			System.out.println("Error. Class Not Found.");
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found... Terminating");
			System.exit(0);
		}

		catch (IOException ioe)
		{
			System.out.println("Error has been found whilst reading this file " + SORTED);
		}

	}

	/**
	 * Creating Binary File... Loop through file and writes the Objects in the Binary File
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	private static void writeArray(String name) throws FileNotFoundException, IOException
	{	
		ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(name));
		
		for(int i = 0; i < bkArr.length; i++)
		{
			writer.writeObject(bkArr[i]);
		}
		writer.close();
		
	}
	
	/**
	 * Takes the FileName's String. Loop through the file, in order to read the Binary file.
	 * 
	 * @param name : String, FileName
	 * @throws EOFException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	private static void readBinaryRecords(String name) throws EOFException,ClassNotFoundException,FileNotFoundException, IOException
	{
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream (name));
		while(true)
		{
			Book temp = (Book)reader.readObject();
			System.out.println(temp);
		}
	}
	
	/**
	 * Add input's content to the Book array.
	 * @param input : FileInputStream
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void insertBook(FileInputStream input) throws FileNotFoundException, IOException
	{
		Scanner test = new Scanner(input);
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
	 * Add new Records to Output's File. The inputed ISBN must be larger than the one existing on the file.
	 * - Enter '-1' to terminate the loop.
	 * - Add the info to file if ISBN given is bigger than current ISBN in file.
	 * @param fos : FileOutputStream
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	private static void addRecords(FileOutputStream fos) throws IOException, FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(fos);
		long isbn = 0;

		while (isbn < big && isbn!= -1)
		{
			System.out.println(big);
			System.out.println("Please insert ISBN of new entry (input -1 to stop): ");
			isbn = keyIn.nextLong();
			if (isbn == -1)
			{
				System.out.println("Thank you for using me.");

				addLooper = false;
			}
			if (isbn > big)
			{
				big = isbn;
				System.out.println(big);
				

				System.out.println("Please enter name of reading apparatus: ");
				String bkNm = keyIn.next();

				System.out.println("Please enter year of publication: ");
				int year = keyIn.nextInt();

				System.out.println("Please enter name of author: ");
				String auth = keyIn.next();

				System.out.println("Please enter price: ");
				double price = keyIn.nextDouble();

				System.out.println("Please enter number of pages: ");
				int page = keyIn.nextInt();
				pw.println(isbn + " " + bkNm + " " + year + " " + auth + " " + price + " " + page);


			}
		}
		keyIn.nextLine();

		pw.close();
		fos.close();
	}

	/**
	 * Displays File's content using BufferReader.
	 * - Displays until 'null' String is encountered.
	 * @param fin : FileReader
	 * @throws IOException
	 */
	private static void displayFileContents(FileReader fin) throws IOException
	{
		BufferedReader br = new BufferedReader(fin);
		String holder = br.readLine();

		while (holder != null)
		{
			System.out.println(holder);
			holder = br.readLine();

		}

		br.close();
		fin.close();
	}

	/**
	 * Loops through the file to check # of lines in the file...
	 * @param s
	 * @return line_counter: int ===> # of lines
	 * @throws FileNotFoundException
	 * @throws IOException
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

	/**
	 * Searches through the Book's array within the given start and end boundary. 
	 * Recursively loop through the Book's array in order to find ISBN...
	 * - Checks Validity of Interval
	 * - Checks ISBN at midpoint value of given start/end.
	 * - Adjusts midpoint to start - 1 or end - 1 according to the value of ISBN. (Whether it is smaller/greater than mid)
	 * - Loop until ISBN is found or start > end...
	 * 
	 * @param bkr
	 * @param start
	 * @param end
	 * @param isbn
	 */
	
	private static void binaryBookSearch(Book[] bkr, int start, int end, int isbn)
	{
		int currentLength = end - start;
		int mid = (currentLength / 2 + start);

		bbsCounter++;

		System.out.println("Iteration #" + bbsCounter + ":  Searching between index " + start + " and " + end + "...");
		if(start < 0 || end >= bkr.length)
		{
			System.out.println("Invalid interval");
		}
		else if (mid < start || mid > end )
		{
			System.out.println("Not in interval");

		} else if (isbn == bkr[mid].getISBN())
		{
			System.out.println("Iz at index " + (mid));
		} else

		if (isbn < bkr[mid].getISBN())
		{
			binaryBookSearch(bkr, start, (mid - 1), isbn);
		} else if (isbn > bkr[mid].getISBN())
		{
			binaryBookSearch(bkr, (mid + 1), end, isbn);
		}

	}

	/**
	 * Searches through the Book's array within the start/end boundary.
	 * 
	 * @param bkr : Book
	 * @param start : int
	 * @param end : int
	 * @param isbn : int
	 * @return '-1' if there is no matching ISBN || Returns Number of Sequential Loops done to find ISBN 
	 */
	
	private static int sequentialBookSearch(Book[] bkr, int start, int end, int isbn)
	{
		if(start < 0 || end >= bkr.length)
		{
			System.out.print("Invalid interval: ");
			return -1;
		}
		
		if (start >= 0 || start < bkr.length)
		{
			sequential_it = 0;

			if (end < bkr.length)
			{
				for (int i = start; i <= end; i++)
				{
					if (bkr[i].getISBN() == isbn)
					{
						System.out.print("Number of Sequential Iterations done: ");
						return sequential_it;
					}

					sequential_it++;
				}
			}

		}

		System.out.println("No matched ISBN found: ");
		return -1; // Zero iterations, ISBN not found....
	}

}
