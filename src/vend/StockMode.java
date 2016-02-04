package vend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * StockMode Class
 * 
 * This is the class that determines the results of interactions 
 * between the user and the vending the machine is in stock mode.
 * It implements the VMState interface.
 * 
 * @author Louis Warner
 */
public class StockMode implements VMState{
	//The Vending Machine
	VendingMachine vm;
	
	/**
	 * Constructor for StockMode
	 * @param VendingMachine newVendor
	 */
	public StockMode(VendingMachine newVendor){
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
	 * Informs the user that this action cannot be performed in stock mode.
	 * @param double cash
	 */
	public void insertCash(double cash) {
		System.out.println();
		System.out.println("This action cannot be performed in stock mode.");
	}
	
	/**
	 * If this command is accessed in stock mode, the machine will retain $100.00 in change
	 * and return the rest of the profit.
	 */
	public void returnCash() {
		System.out.println();
		System.out.printf("You take $%.2f from the machine and leave $100.00 in change.\n", vm.getMachineCash() - 100);
		vm.setMachineCash(100);
	}
	
	/**
	 * Informs the user that this action cannot be performed in stock mode.
	 * @param itemCode
	 */
	public void purchaseItem(String itemCode) {
		System.out.println();
		System.out.println("This action cannot be performed in stock mode.");
	}

	/**
	 * Resets the quantity of all items in the machine to the value given in ItemList.txt.
	 * @exception FileNotFoundException e
	 */
	public void restockMachine() {
		Scanner input = null;
		String name = "ItemList.txt";
	    try {
		    input = new Scanner(new File(name));
		} catch (FileNotFoundException e) {
			System.out.println("File: " + name + " not found. Cannot stock the machine.");
			return;
		}
	    int index = 0;
	    while(input.hasNext()){
			vm.getItems()[index].setCode(input.next());
			vm.getItems()[index].setName(input.next());
			vm.getItems()[index].setPrice(input.nextDouble());
			vm.getItems()[index].setQuantity(input.nextInt());
			index++;
		}
	    input.close();
	    System.out.println("All items are now fully stocked.");
	}

	/**
	 * If there are no items in the machine, it will be set to out of order.
	 * Otherwise, the machine will be set to NoMoneyInserted.
	 */
	public void changeMode() {
		boolean emptyMachine = true;
		for(int j = 0; j < vm.getItems().length; j++){
			Item currentItem = vm.getItems()[j];
			if(currentItem.getQuantity() != 0){
				emptyMachine = false;
				break;
			}
		}
		if(emptyMachine){
			vm.setVMState(vm.getOutOfOrderState());
			System.out.println("No remaining products. Machine is now out of order.");
		} else {
			vm.setVMState(vm.getNoMoneyInsertedState());
			System.out.println();
			System.out.println("Machine is now in user mode.");
		}
	}

	/**
	 * Allows the password for entering stock mode to be changed.
	 */
	public void changePassword() {
		System.out.println();
		System.out.print("Please enter current password: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String password = input.nextLine();
		if(password.equals(vm.getPassword())){
			System.out.println();
			System.out.print("Please enter new password: ");
			String newPass = input.nextLine();
			System.out.println();
			System.out.print("Confirm new password: ");
			String checkPass = input.nextLine();
			if(newPass.equals(checkPass)){
				vm.setPassword(newPass);
				System.out.println("Password changed successfully.");
			} else {
				System.out.println("Passwords did not match.");
			}
		} else {
			System.out.println("That password is incorrect.");
		}
	}
}