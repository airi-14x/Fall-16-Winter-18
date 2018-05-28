
public class Testing {

	public static void main(String[] args) {
		
		String[] drink_options = {"Water", "Soda pop", "Beer"};
		Menu drinkMenu = new Menu(drink_options);
		
		System.out.println(drinkMenu);
		
		drinkMenu.setTopPrompt(null);
		drinkMenu.setBottomPrompt(null);
		System.out.println(drinkMenu);
		
		String[] option_list = {"Water", "Soda pop", "Beer"};
		Menu full_menu = new Menu(option_list);
		
		full_menu.setTopMessage("Quench your thirst with our fine drinks!");
		full_menu.setBottomMessage("Time to obey your thirst!");
		//System.out.println(full_menu);
		full_menu.setTopPrompt("Choose your thirst crusher:");
		full_menu.setBottomPrompt("Enter a drink number: ");
		
		int choice = full_menu.getOptionNumber();
		System.out.println("You entered " + choice);
		
		
		Menu m = new Menu();
		int number1 = m.getOptionNumber();
		System.out.println("You entered " + number1);
		System.out.println("-----------------------");
		
		m.setBottomPrompt("Enter an integer for bottom prompt: ");
		int number2 = m.getOptionNumber();
		System.out.println("You entered " + number2);
		System.out.println("-----------------------");
		
		m.setBottomPrompt(null);
		m.setBottomMessage("Enter an integer for bottom message: ");
		
		int number3 = m.getOptionNumber();
		System.out.println("You entered " + number3);
		System.out.println("------------------------");
		
		m.setTopMessage("*****************************");
		m.setTopPrompt("An integer is even if it is twice another integer");
		m.setBottomMessage("**************************");
		m.setBottomPrompt("Enter an even integer: ");
		int number4 = m.getOptionNumber();
		System.out.println("Your entered " + number4);
	}

}
