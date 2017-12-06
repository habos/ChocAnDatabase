package project4;

import java.util.ArrayList;

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
	
	/**
	 * Constructor
	 * @param id The integer ID of the person
	 * @param name The name of the person
	 * @param address The address of the person
	 * @param city The city of the person
	 * @param state The state of the person
	 * @param ZIP The zip code of the person
	 */
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
	
	/**
	 * Gets the id of the person.
	 * @return The id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of a person.
	 * @param id The new id
	 */
	public void setNumberID(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the person.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the person.
	 * @param name New name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address of the person.
	 * @return The address of the person
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the person.
	 * @param address New address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city of the person.
	 * @return The city of the person
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city of the person
	 * @param city New city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state of the person
	 * @return The state of the person
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state of the person
	 * @param state New state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip code of the person
	 * @return The zip code of the person
	 */
	public String getZIP() {
		return ZIP;
	}

	/**
	 * Sets the zip code of the person
	 * @param zIP New zip code
	 */
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	/**
	 * Checks to see if the id in the parameter matches the id in the object
	 * @param id to be compared
	 * @return boolean if matching id's
	 */
	public boolean matches(int id) {
		if(id==this.id)
			return true;
		return false;
	}
	
	public abstract String getClaims();
	
	/**
	 * Adds claim
	 * @param claim claim to add
	 */
	public void addClaim(Claim claim) {
		claims.add(claim);
	}
	
	/**
	 * Gets claim fee
	 * @return claim fee
	 */
	public int getClaimFee() {
		int feeTotal = 0;
		for (int i = 0; i < claims.size(); i++){
			if(claims.get(i).isCurrent)
				feeTotal+=claims.get(i).getFee();
		}
		return feeTotal;
	}

	/**
	 * Gets total number of claims, used in summary report
	 * @return Total number of claims
	 */
	public int getTotalNumberOfClaims() {
		int claimTotal=0;
		for(int i = 0; i < claims.size();i++) {
			if(claims.get(i).isCurrent)
				claimTotal++;
		}
		return claimTotal;
	}
	
	/**
	 * Checks to see if provider or member has made a claim
	 * @return True if a claim has been made, false if a claim hasn't been made.
	 */
	public boolean hasClaims(){
		for(int i = 0; i < claims.size(); i++){
			if(claims.get(i).isCurrent)
				return true;
			}
		return false;
	}
	
	/**
	 * Sets a claim is not current (It was not made in the current week)
	 */
	public void setIsCurrentFalse(){
		for(int i = 0; i < claims.size(); i++){
			claims.get(i).isCurrent = false;
		}
	}
}
