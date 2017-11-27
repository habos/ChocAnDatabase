package project4;

import java.util.Iterator;

/**
 * The member class. This is an entity stereotype class.
 * Contains all member data and methods to edit/check the member data.
 * @author Caleb
 * 
 */

public class Member extends Record {
	
	private boolean suspended=false;
	private int balance=0;
	
	public Member(int id, String name, String address, String city, String state, String ZIP) {
		super(id, name, address, city, state, ZIP);
	}

	public Member(int id, String name, String address, String city, String state, String ZIP, int balance, boolean suspended){
		super(id, name, address, city, state, ZIP);
		this.balance = balance;
		this.suspended = suspended;
	}
	

	
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
				+"Member ZIP code: " + ZIP+"\n"
				+getClaims();
	}
	

	@Override
	public String getClaims() {	
			Iterator<Claim> claims = this.claims.iterator();
			String matchingClaims = "";
			
			while(claims.hasNext())
			{
				Claim claim = claims.next();
					matchingClaims += claim.toStringMember();		
			}
				return matchingClaims;	
		}
}

