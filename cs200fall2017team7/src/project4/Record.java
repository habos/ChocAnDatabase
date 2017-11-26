package project4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The abstract superclass for member and provider
 * @author Caleb
 */

public abstract class Record {
	
	protected int id;
	protected String name;
	protected String address;
	protected String city;
	protected String state;
	protected String ZIP;
	protected ArrayList<Claim> claims;
	
	
	public Record(int id, String name, String address, String city, String state, String ZIP)
			{
				this.id = id;
				this.name = name;
				this.address = address;
				this.city = city;
				this.state = state;
				this.ZIP = ZIP;
				claims= new ArrayList<Claim>();
			}
	public void addClaim(ProvidersDatabase providers, MembersDatabase members) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM–DD–YYYY hh:mm:ss");// set up the date and time format
		Scanner user_input = new Scanner(System.in);
		System.out.println("Enter Provider ID: ");
		int provID = user_input.nextInt();
		String providerName = providers.getName(provID);
		System.out.println("Enter Member ID: ");
		int memberId = user_input.nextInt();
		String memberName = members.getName(memberId);
		System.out.println("Enter Service Code: ");
		int servCode = user_input.nextInt();
		user_input.nextLine();
		
		//FIXME: add provider directory
		int fee=1;
		String serviceName = "**Placeholder Service Name**";
		//
		
		System.out.println("Enter any comments: ");
		String comments = user_input.nextLine();
		System.out.println("Enter date service was provided (MM–DD–YYYY).");
		String manualDate = user_input.nextLine();
		claims.add(new Claim(provID, providerName, memberId, memberName, dateFormat.format(date), servCode, serviceName,  fee, comments, manualDate));
		user_input.close();
	}
	/**
	 * @return the numberID
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param numberID the numberID to set
	 */
	public void setNumberID(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zIP
	 */
	public String getZIP() {
		return ZIP;
	}
	/**
	 * @param zIP the zIP to set
	 */
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	/**
	 * 
	 * @param id to be compared
	 * @return if matching id's
	 */
	public boolean matches(int id) {
		if(id==this.id)
			return true;
		return false;
	}
	public String getClaims() {	
		Iterator<Claim> claims = this.claims.iterator();
		String matchingClaims = "";
		
		while(claims.hasNext())
		{
			Claim claim = claims.next();
				matchingClaims += claim.toString();		
		}
			return matchingClaims;	
	}
}

