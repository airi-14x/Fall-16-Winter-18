/* -------------------------------------------------------------------------------------
 * Assignment: 4
 * Written by: Airi Chow (40003396)
 * For COMP 248 Section R - FALL 2016
 * Date: 2016/11/20
 * Purpose: IceCreamStore Menu. Display options. Number of items in cart. List of items.
 * 			Add/Remove items... 
 * --------------------------------------------------------------------------------------
 */
import java.util.Scanner;
public class IceCreamStore 
{
	private String[] options = {"Place an order", "Delete an order", "Price the cart", "List the cart", "Proceed to checkout", "Exit this menu"};
	private IceCreamOrder[] cart_items_price = new IceCreamOrder[5]; // ARRAY TO STORE ORDERS' PRICES //
	private String[] cart_items_list = new String[5]; // ARRAY TO STORE ORDERS VIA STRING //
	
	private String[] container = new String[5]; // CONTAINER TO REWRITE THE ARRAYS //
	private IceCreamOrder[] container_order = new IceCreamOrder[5];
	private IceCreamOrder order;
	
	private int counter = 0; // # ELEMENTS IN THE CART //
	private int storage_counter = 0; // INDEX OF STORAGE ARRAY(LIST / PRICE)
	private boolean does_not_exit = true; 
	
	private static ShoppingCart cart = new ShoppingCart();
	private int user_input; 
	private int user_position; // WHICH VALUE DOES THE USER WANT TO REMOVE? //
	
	private double total_price = 0.00;
	private int value = 0;
	
	public void placeOrder()
	{
		this.order = new IceCreamOrder();
		cart.add(order);
		
		cart_items_list [storage_counter] = order.toString();
		cart_items_price[storage_counter] = order; // TO BE USED FOR: TOTAL VALUE PRICE //
		
		System.out.println(" Price " + cart_items_list[0]);
		System.out.println(" Price " + cart_items_list[1]);
		System.out.println(" Price " + cart_items_list[2]);
		System.out.println(" Price " + cart_items_list[3]);
		System.out.println(" Price " + cart_items_list[4]);
		
		storage_counter++;
	}
	
	public void deleteOrder()
	{
		String[] array = new String[cart.size() + 1]; // '1' ADDED FOR 'EXIT'
		Scanner input = new Scanner(System.in);
		
		String exit_string = "Exit this menu";
		
		// LOOPING THE CHOICES INTO AN ARRAY //
		for (int i = 0; i < array.length; i++)
		{
			if (cart.get(i) != null) // ADD NON NULLS
				array[i] = cart.get(i).toString();
			
			value = i + 1;
			if (value < array.length && array[i+1] == null) // EXIT IS ADD TO THE END OF THE ARRAY
			{
				array[i+1] = " " + exit_string;
			}
			
		}
		
		Menu delete_menu = new Menu(array);
		delete_menu.setTopMessage("You have selected to remove an order from your cart");
		delete_menu.setTopPrompt("What would you like to do?");
		delete_menu.setBottomPrompt("Enter an option number:");
	
		System.out.print(delete_menu.toString());
		
		user_position = input.nextInt();

		if (user_position == cart.size() + 1 || user_position > 5)
		{
			System.out.println("Exiting");
		}
		
		else
		{
			cart.remove(user_position);
			
			// RELOOP AND RECONSTRUCT THE ARRAY WITH THE NULL AT THE LAST POSITION OF THE ARRAY //
			for (int i = 0; i < array.length; i++)
			{
				if (cart.get(i) != null)
					array[i] = cart.get(i).toString();
				
				value = i + 1;
				
				if (value < array.length && array[i+1] == null)
				{
					array[i+1] = exit_string;
				}
				
			}

			// REMOVE DESIRED USER'S ORDER FROM LIST AND PRICE ARRAY // 
			cart_items_list[user_position-1] = null;
			cart_items_price[user_position-1] = null;
			
			
			//storage_counter--;
			// RECONSTRUCTING/UPDATING ARRAYS IF THERE IS MORE THAN ONE ELEMENT IN ARRAY //
			if (user_position - 1 > 0 || storage_counter > 1 )
			{
				new_array(user_position - 1);
				new_array_icecream(user_position - 1);
			}
			
			storage_counter--;
			System.out.println(" ");
			System.out.println("The order you selected was deleted");
			counter--;
		}
	
	}
	
	public void printTotalPrice()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Total price of all your orders in the cart: $" + String.format("%.2f", computeTotalPrice()));
		System.out.println("-------------------------------------------------");
	}
	
	public double computeTotalPrice()
	{
		total_price = 0;
		for (int i = 0; i < 5; i++)
		{
			// DON'T ADD NULL ITEMS //
			if (cart_items_price[i] != null)
				total_price += cart_items_price[i].price();
		}
			
		return total_price;
	}
	
	public void reviewOrders()
	{
		System.out.println("Your current selections of our scrumptious ice creams");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < 5; i++)
		{
			// DON'T DISPLAY NULL ITEMS //
			if(cart_items_list[i] != null)
				System.out.println(cart_items_list[i]);
		}
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	
	public void checkout()
	{
		reviewOrders();
		printTotalPrice();
	}
	
	// RECONSTRUCT ARRAY WITH THE REMOVED ITEM (NULL) PLACED AT THE END //
	private void new_array(int position)
	{
		for (int i = 0; i < cart_items_list.length; i++)
		{
			if (i < position)
			{
				container[i] = cart_items_list[i];
			}
			
			if (i >= position && (i + 1 < cart_items_list.length))
			{
				container[i] = cart_items_list[i + 1];
			}
			
			if (i >= position &&  (i + 1 == cart_items_list.length))
			{
				if (cart_items_list[i] != null)
					container[i] = null;
			}
		}
		
		for (int copy = 0; copy < cart_items_list.length; copy++)
		{
			cart_items_list[copy] = container[copy];
		}
	}
	
	
	// RECONSTRUCT ARRAY WITH THE REMOVED ITEM (NULL) PLACED AT THE END //
	private void new_array_icecream(int position)
	{
		for (int i = 0; i < cart_items_price.length; i++)
		{
			if (i < position)
			{
				container_order[i] = cart_items_price[i];
			}
			
			if (i >= position && (i + 1 < cart_items_price.length))
			{
				container_order[i] = cart_items_price[i+1];
			}
			
			else if (i >= position &&  (i + 1 == cart_items_price.length)) // USER'S NUMBER IS THE LAST ONE
			{
				if (cart_items_price[i] != null)
					container_order[i] = null;
			}
		}
		
		for (int copy = 0; copy < cart_items_price.length; copy++)
		{
			cart_items_price[copy] = container_order[copy];
		}
	}
	
	public void run()
	{
		Menu new_menu = new Menu(options);
		
		Scanner input = new Scanner(System.in);
		
		while (does_not_exit)
		{
			// EMPTY CART //
			if (cart.isEmpty() || counter == 0)
			{
				new_menu.setTopMessage("Your Shopping Cart is empty.");
				new_menu.setTopPrompt("You have only two options: 1 or 6");
				new_menu.setBottomMessage("Please enter 1 or 6");
				new_menu.setBottomPrompt("Enter an option number:");
				System.out.print(new_menu.toString());
				
				user_input = input.nextInt();
				while (user_input != 1 && user_input != 6)
				{
					user_input= new_menu.getOptionNumber();
				}
				
				if (user_input == 1)
				{
					System.out.println();
					placeOrder();
					counter++;
					
				}
				
				else if (user_input == 6)
				{
					System.out.println("Cheers!");
					System.exit(0);
				}
				
			}
			
			// N-number of items in cart //
			else if (counter > 0 && counter < 5)
			{
				if (counter == 1)
					new_menu.setTopMessage("Your Shopping Cart contains 1 ice cream order");
				else if (counter == 2)
					new_menu.setTopMessage("Your Shopping Cart contains 2 ice cream order");
				else if (counter == 3)
					new_menu.setTopMessage("Your Shopping Cart contains 3 ice cream order");
				else 
					new_menu.setTopMessage("Your Shopping Cart contains 4 ice cream order");
				
				new_menu.setBottomMessage(null);
				new_menu.setTopPrompt("What would you like to do?");
				
				System.out.print(new_menu.toString());
				
				user_input = input.nextInt();
				if (user_input == 1)
				{
					System.out.println();
					placeOrder();
					counter++;
				}
				
				if (user_input == 2)
				{
					deleteOrder();
				}
				
				if (user_input == 3)
				{
					printTotalPrice();
				}
				
				if (user_input == 4)
				{
					reviewOrders();
				}
				
				if (user_input == 5)
				{
					checkout();
					for(int i = 0; i < 5; i++)
					{
						cart_items_price[i] = null;
						cart_items_list[i] = null;
					}
					
					counter = 0;
				}
				
				if (user_input == 6)
				{
					System.out.print("EXIT~");
					System.exit(0);
				}
					
			}
			
			// FULL CART //
			else if (cart.isFull() || counter == 5)
			{
				new_menu.setTopMessage("Your Shopping Cart is full with 5 ice cream orders.");
				new_menu.setTopPrompt("Cannot place orders! What would you like to do?");
				new_menu.setBottomMessage("Please select option 2, 3, 4, 5, or 6");
				
				System.out.print(new_menu.toString());
				user_input = input.nextInt();
				while (user_input != 2 && user_input != 3 && user_input != 4 && user_input != 5 && user_input != 6)
				{
					user_input= new_menu.getOptionNumber();
				}
				
				if (user_input == 2)
				{
					deleteOrder();
				}
				
				if (user_input == 3)
				{
					printTotalPrice();
				}
				
				if (user_input == 4)
				{
					reviewOrders();
				}
				
				if (user_input == 5)
				{
					checkout();
					
					// RESET ARRAYS //
					for(int i = 0; i < 5; i++)
					{
						cart_items_price[i] = null;
						cart_items_list[i] = null;
					}
					
					counter = 0;
				}
				
				if (user_input == 6)
				{
					System.out.print("Cheers~");
					System.exit(0);
				}
				
			}
		}
		
	}
}
