package vend;

import java.util.Scanner;

/**
 * NoMoneyInserted Class
 * 
 * This is the class that determines the results of interactions 
 * between the user and the vending when no money has been inserted
 * into the machine. It implements the VMState interface.
 * 
 * @author Louis Warner
 */
public class NoMoneyInserted implements VMState{
	//The Vending Machine
	VendingMachine vm;
	
	/**
	 * Constructor for NoMoneyInserted
	 * @param VendingMachine newVendor
	 */
	public NoMoneyInserted(VendingMachine newVendor){
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
	 * Attempts to insert cash into the machine. Increases the total cash and inserted cash variables
	 * by the amount given and changes the state to MoneyInserted.
	 * @param double cash
	 */
	public void insertCash(double cash) {
		vm.setInsertedCash(cash);
		System.out.println();
		System.out.println("Inserting cash...");
		System.out.printf("Amount inserted: $%.2f\n", vm.getInsertedCash());
		vm.setMachineCash(vm.getMachineCash()+ cash);
		vm.setVMState(vm.getMoneyInsertedState());
	}

	/**
	 * Informs the user that no cash has yet been inserted into the machine.
	 */
	public void returnCash() {
		System.out.println();
		System.out.println("You have not inserted any cash.");
	}

	/**
	 * Informs the user that no cash has yet been inserted into the machine.
	 * @param itemCode
	 */
	public void purchaseItem(String itemCode) {
		System.out.println();
		System.out.println("You have not inserted any cash.");
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
		System.out.print("Please enter password: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String password = input.nextLine();
		if(password.equals(vm.getPassword())){
			System.out.println("Machine is now in stock mode.");
			vm.setVMState(vm.getStockModeState());
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