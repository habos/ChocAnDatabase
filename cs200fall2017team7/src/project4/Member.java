//Start to member, not complete

package project4;

public class Member {
	
	private boolean suspended;
	private int numberID;
	private int balance;
	private String name;
	private String address;
	private String city;
	private String state;
	private String ZIP;
	
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
	
	public boolean isSuspended()
	{
		if(suspended == true)
			return true;
		return false;
	}
	public void suspendMember()
	{
		suspended = true;
	}
	public void reinstateMember()
	{
		suspended = false;
	}
	public void changeBalance(int amount)
	{
		balance -= amount;
	}
	public int getBalance()
	{
		return balance;
	}
	public int getID()
	{
		return numberID;
	}
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
