package vend;

import java.util.Scanner;

/**
 * VMTest Class
 * 
 * This class is used for testing out the VendingMachine. It gives the user a list
 * of possible actions the user can take, and allows the user to interact with the
 * machine by entering the appropriate commands.
 * 
 * @author Louis Warner
 */
public class VMTest {
	public static void main(String[] args){
		// Welcome Message
		System.out.println("Welcome to the Vending Machine!");
		
		// Create new vending machine object
		VendingMachine vm = new VendingMachine();
		
		// Create scanner and string for user input
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String nextCommand = "";
		
		// The main program loop
		while(true){
			System.out.println();
			listInstructions();
			nextCommand = input.nextLine();
			
			// Switch determines the appropriate command to be attempted
	        switch (nextCommand) {
            case "1" :  vm.listItems();
                     	break;
            case "2":  	System.out.print("Insert Amount: ");
            			Scanner cashScan = new Scanner(System.in);
            			double cash = cashScan.nextDouble();
            			vm.insertCash(cash);
                     	break;
            case "3":  	System.out.print("Returning cash...");
            			vm.returnCash();;
                     	break;
            case "4":   System.out.print("Enter Item Code: ");
           				Scanner itemScan = new Scanner(System.in);
						String itemCode = itemScan.nextLine();
            			vm.purchaseItem(itemCode);
                     	break;
            case "5":   vm.restockMachine();;
                     	break;
            case "6":   vm.changePassword();
                     	break;
            case "7":   vm.changeMode();
                     	break;
            case "8":   System.out.println("Goodbye!");
            			System.exit(0);;
                     	break; 
            default: 	System.out.println("Invalid command. Please try again.");;
            			break;
	        }
		}
	}
	
	/**
	 * Lists the possible user interactions with the vending machine and their
	 * corresponding command entries.
	 */
	public static void listInstructions(){
		System.out.println("Please enter one of the following: ");
		System.out.println("1 - List Vendable Items");
		System.out.println("2 - Insert Cash");
		System.out.println("3 - Return Cash");
		System.out.println("4 - Purchase Item");
		System.out.println("5 - Restock Machine");
		System.out.println("6 - Change Password");
		System.out.println("7 - Switch Between Stock/User Mode");
		System.out.println("8 - Exit Program");
		System.out.println();
	}
}