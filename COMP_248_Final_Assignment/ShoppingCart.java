/* -------------------------------------------------------------------------------------
 * Assignment: 4
 * Written by: Airi Chow (40003396)
 * For COMP 248 Section R - FALL 2016
 * Date: 2016/11/20
 * Purpose: Store IceCream Order in Array. Check if it is Empty/Full. Check the quantity
 * 			of items in the cart.  Class is capable to adding/removing orders. Display cart. 
 * --------------------------------------------------------------------------------------
 */
public class ShoppingCart {

	private final int MAX_CAPACITY = 5; // MAX: 5 Orders.
	private IceCreamOrder[] cart_array = new IceCreamOrder[MAX_CAPACITY];
	private IceCreamOrder[] copy_array = new IceCreamOrder[MAX_CAPACITY];
	private IceCreamOrder[] new_array = new IceCreamOrder[MAX_CAPACITY]; // Re-created array if something is removed.
	
	private int counter = 0;
	private int empty_counter = 0; 
	private int full_counter = 0;
	
	// * CONSTRUCTOR * //
	public ShoppingCart()
	{
		copy_array = (IceCreamOrder[]) cart_array.clone(); // NEW ARRAY WITH SAME DATA //
	}
	
	public void add(IceCreamOrder order)
	{	
		if (counter < 5)
		{
			copy_array[counter] = order;
			size();
			//System.out.println("Order " + counter + "  " + copy_array[counter].toString());
			counter++;
		}
		
		if (isFull())
		{
			System.out.println("Error: Full");	
		}
	}
	
	public void remove(int position)
	{
		if (isEmpty())
		{
			System.out.println("Empty");
		}
		
		else if (position > 5)
		{
			System.out.println("Invalid Position Number*");
		}
		
		
		else if (position < 5 || copy_array[position - 1] != null) // Position is valid if it exists (not Null) and less than 5
		{
			copy_array[position - 1] = null;
			counter--;
			
			new_array(position - 1);
		}
	}
	
	public boolean isEmpty()
	{
		for (int i = 0 ; i < copy_array.length; i++)
		{
			if (copy_array[i] == null)
				empty_counter++;
		}
		
		if (empty_counter == 5) // EVERYTHING IS EMPTY //
		{
			empty_counter = 0;
			return true;
		}
		
		else
		{
			empty_counter = 0;
			return false;
		}
	}
	
	public boolean isFull()
	{
		for (int i = 0; i < copy_array.length; i++)
		{
			if (copy_array[i] != null)
			{
				full_counter++;
			}
		}
		
		if (full_counter == 5)
		{
			full_counter = 0;
			return true;
		}
		
		else
		{
			full_counter = 0;
			return false; 
		}
	}
	
	public IceCreamOrder get(int position)
	{
		
		if (position >= 5)
		{
			//System.out.println("Invalid Position Number");
			return null;
		}
		
		return copy_array[position];
	}
	
	public int size()
	{
		return counter; // # of orders in cart.
	}
	
	// USING NEW ARRAY AS A CONTAINER WHERE THE NULL ARE AT THE END OF THE ARRAY //
	// THEN COPY DATA BACK INTO COPY_ARRAY //
	private void new_array(int position)
	{
		for (int i = 0; i < copy_array.length; i++)
		{
			if (i < position)
			{
				new_array[i] = copy_array[i];
			}
			
			if (i > position)
			{
				new_array[i-1] = copy_array[i];
			}
		}
		
		for (int copy = 0; copy < copy_array.length; copy++)
		{
			copy_array[copy] = new_array[copy];
		}
	}
	
	public String toString()
	{
		int counter_string = 1;
		int exit_counter = 1;
		for(int i = 0; i < copy_array.length; i++)
		{
			if (copy_array[i] != null)
			{
				System.out.println("(" + counter_string + ") " + copy_array[i] + "\n");
				exit_counter++;
			}
			counter_string++;
		}
		
		System.out.println("(" + exit_counter + ") " + "Exit this menu");
		return "";
	}
}
