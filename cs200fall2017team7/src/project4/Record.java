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
	public abstract String getClaims();
	public void addClaim(Claim claim) {
		claims.add(claim);
	}
}

