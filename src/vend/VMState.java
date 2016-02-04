package vend;

/**
 * VMState Interface
 * 
 * This is the interface for the vending machine. It holds declarations
 * for all methods for interaction between the user and the machine.
 * The current state of the vending machine determines the definition
 * of each method.
 * 
 * @author Louis Warner
 */
public interface VMState {
	//Context-Based Method Definitions
	public void listItems();
	public void insertCash(double cash);
	public void returnCash();
	public void purchaseItem(String itemCode);
	public void restockMachine();
	public void changeMode();
	public void changePassword();
}