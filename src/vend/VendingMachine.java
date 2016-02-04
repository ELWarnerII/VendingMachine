package vend;

/**
 * Vending Machine Class
 * 
 * This vending machine uses a state design pattern that covers four
 * unique states for the machine: NoMoneyInserted, MoneyInserted, StockMode,
 * and OutOfOrder. It keeps a running count of cash in the machine, items
 * in stock, and the amount of cash inserted. User interactions with the machine
 * are state dependent and include inserting cash, returning cash, purchasing items,
 * stocking the machine, and more.
 * 
 * @author Louis Warner
 */
public class VendingMachine {
	// Constants for starting state of the machine
	public static final double STARTINSERT = 0;	
	public static final double STARTMACHINE = 100;
	public static final String INITPASS = "ABC123";
	
	// Set of possible states for the vending machine
	private VMState noMoneyInserted;
	private VMState moneyInserted;
	private VMState stockMode;
	private VMState outOfOrder;
	
	// Variables that determine the state of the machine and its actions
	private VMState currentState;
	private double insertedCash;
	private double machineCash;
	private Item[] items;
	private String password;
	
	/**
	 * Constructor for Vending Machine
	 */
	public VendingMachine(){
		// Initialize possible states for the vending machine
		noMoneyInserted = new NoMoneyInserted(this);
		moneyInserted = new MoneyInserted(this);
		stockMode = new StockMode(this);
		outOfOrder = new OutOfOrder(this);
		
		// Sets the machine to the starting point values
		insertedCash = STARTINSERT;
		machineCash = STARTMACHINE;
		password = INITPASS;
		items = new Item[25];
		for(int i = 0; i < items.length; i++){
			items[i] = new Item("00", "Name", 0.00, 0);
		}
		currentState = stockMode;
		currentState.restockMachine();
		currentState = noMoneyInserted;
	}
	
	// Setter Methods
	/**
	 * Setter for the current state.
	 */
	public void setVMState(VMState newState){
		currentState = newState;
	}
	
	/**
	 * Setter for the amount of inserted cash.
	 */
	public void setInsertedCash(double newAmount){
		insertedCash = newAmount;
	}
	
	/**
	 * Setter for the amount of machine cash.
	 */
	public void setMachineCash(double newAmount){
		machineCash = newAmount;
	}
	
	/**
	 * Setter for the item array.
	 */
	public void setItems(Item[] newItems){
		items = newItems;
	}
	
	/**
	 * Setter for the current state.
	 */
	public void setPassword(String newPass){
		password = newPass;
	}
	
	// Getter Methods
	/**
	 * Getter for the amount of inserted cash.
	 * @return double insertedCash
	 */
	public double getInsertedCash(){
		return insertedCash;
	}
	
	/**
	 * Getter for the amount of machine cash.
	 * @return double machineCash
	 */
	public double getMachineCash(){
		return machineCash;
	}
	
	/**
	 * Getter for the item array.
	 * @return Item[] items
	 */
	public Item[] getItems(){
		return items;
	}
	
	/** 
	 * Getter for the current password.
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * Getter for the no inserted cash state.
	 * @return VMState noMoneyInserted
	 */
	public VMState getNoMoneyInsertedState(){
		return noMoneyInserted;
	}
	
	/**
	 * Getter for the inserted cash state.
	 * @return VMState moneyInserted
	 */
	public VMState getMoneyInsertedState(){
		return moneyInserted;
	}
	
	/**
	 * Getter for the stock mode state.
	 * @return VMState stockMode
	 */
	public VMState getStockModeState(){
		return stockMode;
	}
	
	/**
	 * Getter for the out of order state.
	 * @return VMState outOfOrder
	 */
	public VMState getOutOfOrderState(){
		return outOfOrder;
	}
	
	
	// Context-Based Methods
	/**
	 * Performs the current state function for listItems()
	 */
	public void listItems(){
		currentState.listItems();
	}
	
	/**
	 * Performs the current state function for insertCash()
	 * @param double cash
	 */
	public void insertCash(double cash){
		currentState.insertCash(cash);
	}
	
	/**
	 * Performs the current state function for returnCash()
	 */
	public void returnCash(){
		currentState.returnCash();
	}
	
	/**
	 * Performs the current state function for purchaseItem()
	 * @param String itemCode
	 */
	public void purchaseItem(String itemCode){
		currentState.purchaseItem(itemCode);
	}
	
	/**
	 * Performs the current state function for restockMachine()
	 */
	public void restockMachine(){
		currentState.restockMachine();
	}
	
	/**
	 * Performs the current state function for changeMode()
	 */
	public void changeMode(){
		currentState.changeMode();
	}
	
	/**
	 * Performs the current state function for changePassword()
	 */
	public void changePassword(){
		currentState.changePassword();
	}
}