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
	private int numberID;*/ 
	
	private boolean suspended;
	private int balance;
	private String address;
	private String city;
	private String state;
	private String ZIP;
	
	/**
	 *  Default Constructor
	 */
	public Member() {
		suspended = false;
		numberID = 0;
		balance = 0;
		name = null;
		address = null;
		city = null;
		state = null;
		ZIP = null;
	}
	
	/**
	 * Constructor
	 */
	public Member(int ID, int initialBalance, String memberName, String memberAddress, 
	String memberCity, String memberState, String memberZIP)
	{
		suspended = false;
		numberID = ID;
		balance = initialBalance;
		name = memberName;
		address = memberAddress;
		city = memberCity;
		state = memberState;
		ZIP = memberZIP;
	}
	
	/**
	 * Checks if member is suspended
	 */
	public boolean isSuspended()
	{
		if(suspended == true)
			return true;
		return false;
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
	 * @param amount Positive amount means a charge (subtracts), negative amount means a deposit (adds)
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
	 * Returns the member's ID
	 */
	public int getID()
	{
		return numberID;
	}
	
	/**
	 * Returns a string containing all information about the member
	 */
	public String toString()
	{
		String FullMemberString = "";
		FullMemberString += "Member name: " + name + "\n";
		FullMemberString += "Member number: " + numberID + "\n";
		FullMemberString += "Member street address: " + address + "\n";
		FullMemberString += "Member city: " + city + "\n";
		FullMemberString += "Member state: " + state + "\n";
		FullMemberString += "Member ZIP code: " + ZIP + "\n";
		
		return FullMemberString;
	}
}
