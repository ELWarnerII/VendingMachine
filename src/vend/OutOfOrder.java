package vend;

import java.util.Scanner;

/**
 * OutOfOrder Class
 * 
 * This is the class that determines the results of interactions 
 * between the user and the vending when the machine is out of products.
 * It implements the VMState interface.
 * 
 * @author Louis Warner
 */
public class OutOfOrder implements VMState{
	//The Vending Machine
	VendingMachine vm;
	
	/**
	 * Constructor for OutOfOrder
	 * @param VendingMachine newVendor
	 */
	public OutOfOrder(VendingMachine newVendor){
		vm = newVendor;
	}
	
	/**
	 * Lists the available items for purchase
	 */
	public void listItems() {
		System.out.println();
		for(int i = 0; i < vm.getItems().length; i++){
			Item currentItem = vm.getItems()[i];
			System.out.printf("Code: %3s   Item: %-21s   ", currentItem.getCode(), currentItem.getName());
			System.out.printf("Price: $%4.2f   Quantity: %2d\n", currentItem.getPrice(), currentItem.getQuantity());
		}
	}

	/**
	 * Attempts to insert cash into the machine. Returns cash immediately
	 * to the user and reports that the machine is our of order.
	 * @param double cash
	 */
	public void insertCash(double cash) {
		System.out.println();
		System.out.println("This machine is currently out of order.");
		System.out.printf("Amount returned: $%.2f\n", cash);
	}

	/**
	 * If a user attempts to return cash while machine is out of order,
	 * it simply returns a message that the machine is out of order.
	 */
	public void returnCash() {
		System.out.println();
		System.out.println("This machine is currently out of order.");
	}

	/**
	 * Attempts to purchase an item from the machine. Reports that
	 * the machine is out of order.
	 * @param String itemCode
	 */
	public void purchaseItem(String itemCode) {
		System.out.println();
		System.out.println("This machine is currently out of order.");
	}
	
	/**
	 * Informs the user that restocking can only be performed in stock mode.
	 */
	public void restockMachine() {
		System.out.println();
		System.out.println("This action can only be performed in stock mode.");
	}
	
	/**
	 * User attempts to change to stock mode by entering the password. An incorrect password
	 * leaves the machine in its current status. A correct password will switch the mode.
	 */
	public void changeMode() {
		System.out.println();
		System.out.println("Please enter password: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String password = input.nextLine();
		if(password.equals(vm.getPassword())){	
			vm.setVMState(vm.getStockModeState());
			System.out.print("Machine is now in stock mode.");
		} else {
			System.out.println("That password is incorrect.");
		}
	}

	/**
	 * Informs the user that the password can only be changed in stock mode.
	 */
	public void changePassword() {
		System.out.println();
		System.out.println("This action can only be performed in stock mode.");
	}
}