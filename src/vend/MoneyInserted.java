package vend;

/**
 * MoneyInserted Class
 * 
 * This is the class that determines the results of interactions 
 * between the user and the vending when money has been inserted
 * into the machine. It implements the VMState interface.
 * 
 * @author Louis Warner
 */
public class MoneyInserted implements VMState{
	//The Vending Machine
	VendingMachine vm;
	
	/**
	 * Constructor for MoneyInserted
	 * @param VendingMachine newVendor
	 */
	public MoneyInserted(VendingMachine newVendor){
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
	 * by the amount given.
	 * @param double cash
	 */
	public void insertCash(double cash) {
		vm.setInsertedCash(vm.getInsertedCash() + cash);
		System.out.println();
		System.out.println("Inserting cash...");
		System.out.printf("Amount inserted: $%.2f\n", vm.getInsertedCash());
		System.out.println();
		vm.setMachineCash(vm.getMachineCash()+ cash);
	}

	/**
	 * Returns all inserted cash to the user and subtracts that amount from the total cash and inserted
	 * cash in the machine.
	 */
	public void returnCash() {
		System.out.println();
		System.out.printf("Amount returned: $%.2f\n", vm.getInsertedCash());
		vm.setMachineCash(vm.getMachineCash()- vm.getInsertedCash());
		vm.setInsertedCash(0);
		System.out.println();
		System.out.printf("Amount inserted: $%.2f\n", vm.getInsertedCash());
		vm.setVMState(vm.getNoMoneyInsertedState());
	}

	/**
	 * Attempts to purchase the item with the corresponding item code. If the code is invalid, the item
	 * is out of stock, or the user has not inserted enough cash to perform the purchase the machine will
	 * give an error message. Otherwise the machine will vend the requested product and return the appropriate
	 * amount of change to the user.
	 * @param String itemCode
	 */
	public void purchaseItem(String itemCode) {
		System.out.println();
		int index = -1;
		for(int i = 0; i < vm.getItems().length; i++){
			Item currentItem = vm.getItems()[i];
			if(itemCode.equals(currentItem.getCode())){
				index = i;
				break;
			}
		}
		if(index == -1){
			System.out.println("Invalid item code. Please try again.");
		} else {
			if(vm.getItems()[index].getPrice() > vm.getInsertedCash()){
				System.out.println("Not enough cash inserted to purchase this item.");
				System.out.printf("Item Price: %4.2f   Inserted Amount: %4.2f\n", vm.getItems()[index].getPrice(), vm.getInsertedCash());
			} else if (vm.getItems()[index].getQuantity() == 0){
				System.out.println("Item currently out of stock.");
			} else {
				System.out.println("Vending...");
				System.out.println("Enjoy your " + vm.getItems()[index].getName() + "!");
				System.out.printf("Amount returned: $%.2f\n", vm.getInsertedCash() - vm.getItems()[index].getPrice());
				vm.setMachineCash(vm.getMachineCash() - (vm.getInsertedCash() - vm.getItems()[index].getPrice()));
				vm.getItems()[index].setQuantity(vm.getItems()[index].getQuantity() - 1);
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
				}
			}
		}	
	}

	/**
	 * Informs the user that restocking can only be performed in stock mode.
	 */
	public void restockMachine() {
		System.out.println();
		System.out.println("This action can only be performed in stock mode.");
	}
	
	/**
	 * Informs the user that you cannot attempt to change to stock mode while there is money inserted into the machine.
	 */
	public void changeMode() {
		System.out.println();
		System.out.println("Cannot enter stock mode while purchase is in progress.");
		System.out.println("Complete your purchase or return change if you wish to enter stock mode.");
	}
	
	/**
	 * Informs the user that the password can only be changed in stock mode.
	 */
	public void changePassword() {
		System.out.println();
		System.out.println("This action can only be performed in stock mode.");
	}
}