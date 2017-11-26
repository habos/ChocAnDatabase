package project4;

/**
 * The member class. This is a boundary stereotype class.
 * Contains all member data and methods to edit/check the member data.
 * @author Caleb
 * 
 */

public class Member extends Record {
	
	//These are in Record.java
	/*private String name;
	private integer numberID;*/ 
	
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
	 * Suspends member
	 */
	public void suspendMember()
	{
		suspended = true;
	}
	
	/**
	 * Reinstates suspended member
	 */
	public void reinstateMember()
	{
		suspended = false;
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
		String fullMemberString = "";
		fullMemberString += "Member name: " + name + "\n";
		fullMemberString += "Member number: " + id + "\n";
		fullMemberString += "Member street address: " + address + "\n";
		fullMemberString += "Member city: " + city + "\n";
		fullMemberString += "Member state: " + state + "\n";
		fullMemberString += "Member ZIP code: " + ZIP + "\n";
		
		return fullMemberString;
	}
}
