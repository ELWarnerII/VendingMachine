package vend;

/**
 * Item Class
 * 
 * The item is a type of product available for purchase in the
 * VendingMachine object. It has a name, and item code, a price,
 * and a quantity of this object available in the machine. 
 * 
 * @author Louis Warner
 */
public class Item {
	// Variables in each item
	private String name;
	private String itemCode;
	private double price;
	private int quantity;
	
	/**
	 * Constructor method for Item.
	 * 
	 * @param name
	 * @param itemCode
	 * @param price
	 * @param quantity
	 */
	public Item(String name, String itemCode, double price, int quantity){
		this.name = name;
		this.itemCode = itemCode;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	// Setter Methods	
	/**
	 * Setter for the item name.
	 */
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * Setter for the item code
	 */
	public void setCode(String newCode){
		itemCode = newCode;
	}
	
	/**
	 * Setter for the item price.
	 */
	public void setPrice(double newPrice){
		price = newPrice;
	}
	
	/**
	 * Setter for the item quantity.
	 */
	public void setQuantity(int newQuantity){
		quantity = newQuantity;
	}
	
	
	// Getter Methods	
	/**
	 * Getter for the item name.
	 * @return String name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Getter for the item code
	 * @return String itemCode
	 */
	public String getCode(){
		return itemCode;
	}
	
	/**
	 * Getter for the item price
	 * @return double price
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * Getter for the item quantity
	 * @return int quantity
	 */
	public int getQuantity(){
		return quantity;
	}
}