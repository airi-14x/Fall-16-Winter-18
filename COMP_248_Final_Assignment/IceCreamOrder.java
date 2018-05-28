/* -------------------------------------------------------------------------------------
 * Assignment: 4
 * Written by: Airi Chow (40003396)
 * For COMP 248 Section R - FALL 2016
 * Date: 2016/11/20
 * Purpose: Display Ice cream Choices / Vessel / # of Orders / Unit Price. Calculate the cost. 
 * --------------------------------------------------------------------------------------
 */

import java.util.Scanner;

public class IceCreamOrder {
	
	// ATTRIBUTES //
	private final String[] flavour = {"Avocado", "Banana", "Chocolate" ,"Coffee", "Hazelnut", "Lemon", "Mango" , "Mocha", "Vanilla"};
	private final String[] vessel = {"Cone", "Cup","Sundae"};
	private final String[] amount = {"Single Scoop", "Double Scoops", "Triple Scoops"};
	private final String[] orders = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	
	private final String[] unit_cup_price = {"2.99", "3.99", "4.99"};
	private final String[] unit_cone_price = {"3.49", "4.49", "5.49"};
	private final String[] unit_sundae_price = {"4.25", "5.25", "6.25"};
	
	private String prompt = "?-> Enter an option number: ";
	private double unit_price = 0.00;
	private int quantity = 0;
	
	private int vessel_num; // POSITION OF DESIRED VESSEL //
	private int amount_num;
	
	private String tester;
	private int user_input;
	private String user_flavour = "";
	private String user_vessel = "";
	private String user_amount = "";
	private String user_order = "";
	
	// CONSTRUCTORS //
	public IceCreamOrder(String flavour, String vessel, String amount, double unitPrice, int quantity) //NEED TO FIX.
	{
		// FLAVOUR TESTING + FINDING POSITION OF FLAVOUR //
		for (int i = 0; i < 9; i++)
		{
			tester = this.flavour[i];
			if (flavour.equals(tester))
			{
				user_flavour = this.flavour[i];
			}
		}
		
		// VESSEL TESTING + FINDING POSITION OF VESSEL //
		for (int i = 0; i < 3; i++)
		{
			tester = this.vessel[i];
			if (vessel.equals(tester))
			{
				user_vessel = this.vessel[i];
				System.out.println("Vessel " + user_vessel);
			}
		}
		
		// AMOUNT TESTING + FINDING POSITION OF AMOUNT //
		for (int i = 0; i < 3; i++)
		{
			tester = this.amount[i];
			if (amount.equals(tester))
			{
				user_amount = this.amount[i];
				System.out.println("amount " + user_amount);
			}
		}
		
		// PRICE TESTING //
		// CUP //
		for (int i = 0; i < 3; i++)
		{
			String unit_Price = String.valueOf(unitPrice); // STRING VALUE OF THAT.
			
			tester = unit_cup_price[i];  // STRING VALUE TO BE TESTED
			if (unit_Price.equals(tester))
			{
				unit_price = Double.parseDouble(unit_Price);
			}
		}
		
		// CONE //
		for (int i = 0; i < 3; i++)
		{
			String unit_Price = String.valueOf(unitPrice); // STRING VALUE OF THAT.
			
			tester = unit_cone_price[i]; // STRING VALUE //
			if (unit_Price.equals(tester))
			{
				unit_price = Double.parseDouble(unit_Price);
			}
		}
		
		// SUNDAE //
		for (int i = 0; i < 3; i++)
		{
			String unit_Price = String.valueOf(unitPrice); // STRING VALUE OF THAT.
			
			tester = unit_sundae_price[i]; // STRING VALUE //
			if (unit_Price.equals(tester))
			{
				unit_price = Double.parseDouble(unit_Price);
			}
		}
		
		// QUANTITY //
		this.quantity = quantity;
		
	}
	
	
	public IceCreamOrder(String flavour, String vessel, String amount, double unitPrice)
	{
		this.quantity = 1;
		IceCreamOrder order = new IceCreamOrder(flavour, vessel, amount, unitPrice, 1);
		System.out.print(order.toString());
	}
	
	public IceCreamOrder()
	{
		System.out.println("Placing an order is as easy as ABC, and D.");
		
		// ----- STEP A ------ //
		System.out.println("Step A: Select your favourite flavour");
		for (int i = 0; i < flavour.length; i++)
		{
			System.out.println("     ("+ (i+1) + ") " + flavour[i]);
		}
		
		System.out.print(prompt);
		Scanner input = new Scanner(System.in);
		
		user_input = input.nextInt();
		setFlavour();
		
		System.out.println();
		
		// ----- STEP B ----- //
		System.out.println("Step B: Select a vessel for your ice cream: ");
		for (int i = 0; i < vessel.length; i++)
		{
			System.out.println("     ("+ (i+1) + ") " + vessel[i]);
		}
		System.out.print(prompt);
		user_input = input.nextInt();
		vessel_num = user_input;
		setVessel();
		
		System.out.println();
		
		// ------ STEP C ----- //
		System.out.println("Step C: How much ice cream?");
		for (int i = 0; i < amount.length; i++)
		{
			System.out.println("     ("+ (i+1) + ") " + amount[i]);
		}
		System.out.print(prompt);
		user_input = input.nextInt();
		amount_num = user_input;
		setAmount();
		
		System.out.println();
		
		// ------ STEP D ----- //
		System.out.println("Step D: how many orders of your current selection?");
		for (int i = 0; i < orders.length; i++)
		{
			System.out.println("     ("+ (i+1) + ") " + orders[i]);
		}
		
		System.out.print(prompt);
		user_input = input.nextInt();
		quantity = user_input;
		setOrder();
		
		System.out.println();
		// ------ UNIT PRICE ----- //
		//System.out.println('\t' + amount[0] + '\t' + amount[1] + '\t' + amount[2]);
		//System.out.println(vessel[0] + '\t' + "    " + unit_cup_price[0] + '\t' + "     " + unit_cup_price[1] + '\t' + "    " + unit_cup_price[2]);
		//System.out.println(vessel[1] + '\t' + "    "+ unit_cone_price[0] + '\t' +  "     " + unit_cone_price[1] + '\t' + "    " + unit_cone_price[2]);
		//System.out.println(vessel[2] + '\t' + "    " + unit_sundae_price[0] + '\t' + "     " + unit_sundae_price[1] + '\t' + "    " + unit_sundae_price[2]);
		setUnitPrice();
	}
	// SETTER + GETTER //
	// -------- FLAVOURS ------------ //
	public void setFlavour()
	{
		switch(user_input)
		{
			case 1: user_flavour = flavour[0];
					break;
			case 2: user_flavour = flavour[1];
					break;
			case 3: user_flavour = flavour[2];
					break;
			case 4: user_flavour = flavour[3];
					break;
			case 5: user_flavour = flavour[4];
					break;
			case 6: user_flavour = flavour[5];
					break;
			case 7: user_flavour = flavour[6];
					break;
			case 8: user_flavour = flavour[7];
					break;
			case 9: user_flavour = flavour[8];
					break;
		}
	}
	
	public String getFlavour()
	{
		return user_flavour;
	}
	
	// ------- VESSELS ---------- //
	public void setVessel()
	{
		switch(vessel_num)
		{
			case 1: user_vessel = vessel[0]; 
					break;
			case 2: user_vessel = vessel[1];
					break;
			case 3: user_vessel = vessel[2];
					break;
		}
	}
	
	public String getVessel()
	{
		return user_vessel;
	}
	
	// ------- AMOUNT ------------ //
	public void setAmount()
	{
		switch(amount_num)
		{
			case 1: user_amount = amount[0];
					break;
			case 2: user_amount = amount[1];
					break;
			case 3: user_amount = amount[2];
					break;
		}
	}
	
	public String getAmount()
	{
		return user_amount;
	}
	
	// ------- ORDERS ---------- //
	public void setOrder()
	{
		switch(user_input)
		{
			case 1: user_order = orders[0];
					break;
			case 2: user_order = orders[1];
					break;
			case 3: user_order = orders[2];
					break;
			case 4: user_order = orders[3];
					break;
			case 5: user_order = orders[4];
					break;
			case 6: user_order = orders[5];
					break;
			case 7: user_order = orders[6];
					break;
			case 8: user_order = orders[7];
					break;
			case 9: user_order = orders[8];
					break;
		}
	}
	
	public String getOrder()
	{
		return user_order;
	}
	
	// ------ UNIT PRICE ------ // 
	public void setUnitPrice()
	{
		if (vessel_num == 1)
		{
			switch(amount_num)
			{
				case 1: unit_price = Double.parseDouble(unit_cup_price[0]);
						break;
				case 2: unit_price = Double.parseDouble(unit_cup_price[1]);
						break;
				case 3: unit_price = Double.parseDouble(unit_cup_price[2]);
						break;
			}
		}
		
		if (vessel_num == 2)
		{
			switch(amount_num)
			{
				case 1: unit_price = Double.parseDouble(unit_cone_price[0]);
						break;
				case 2: unit_price = Double.parseDouble(unit_cone_price[1]);
						break;
				case 3: unit_price = Double.parseDouble(unit_cone_price[2]);
						break;
			}
		}
		
		if (vessel_num == 3)
		{
			switch(amount_num)
			{
				case 1: unit_price = Double.parseDouble(unit_sundae_price[0]); 
						break;
				case 2: unit_price = Double.parseDouble(unit_sundae_price[1]);
						break;
				case 3: unit_price = Double.parseDouble(unit_sundae_price[2]);
						break;
			}
		}
	}
	
	public double getUnitPrice()
	{
		return unit_price;
	}
	
	public double price()
	{
		return (double)(Math.round((100.00 * (quantity * unit_price)))) / 100.00;
	}
	
	public String toString()
	{
		return (quantity + " orders of " + user_amount + " of " + user_flavour + " ice cream in a " + user_vessel 
				+ " for $" + String.format("%.2f",price()) + " = " + quantity + " x " + unit_price);
	}
	
}
