package project4;

/**
 * The member class. This is a boundary stereotype class.
 * Contains all member data and methods to edit/check the member data.
 * @author Caleb
 * 
 */

public class Member extends Record {
	
	public Member(int id, String name, String address, String city, String state, String ZIP) {
		super(id, name, address, city, state, ZIP);
	}

	private boolean suspended=false;
	private int balance=0;
	
	/**
	 * Checks if member is suspended
	 */
	public boolean isSuspended()
	{
		return suspended;
	}
	
	/**
	 * edit Suspends member
	 *  
	 */
	public void setSuspended(boolean suspend) {
		suspended=suspend;
	}
	
	/**
	 * Either charges the members account an amount or deposits an amount
	 * @param amount The number to change the balance
	 */
	public void changeBalance(int amount)
	{
		balance += amount;
	}
	
	/**
	 * Returns the member's current balance
	 */
	public int getBalance()
	{
		return balance;
	}
	
	/**
	 * Returns a string containing all information about the member
	 */
	public String toString()
	{
		 return "Member name: " + name + "\n"
				+"Member number: " + id + "\n"
				+"Member street address: " + address + "\n"
				+"Member city: " + city + "\n"
				+"Member state: " + state + "\n"
				+"Member ZIP code: " + ZIP;
	}
}
