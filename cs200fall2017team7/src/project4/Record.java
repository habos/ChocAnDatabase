package project4;

/**
 * The abstract superclass for member and provider
 * @author Caleb
 */

public abstract class Record {
	
	protected int numberID;
	protected String name;
	protected String address;
	protected String city;
	protected String state;
	protected String ZIP;
	/**
	 * @return the numberID
	 */
	public int getNumberID() {
		return numberID;
	}
	/**
	 * @param numberID the numberID to set
	 */
	public void setNumberID(int numberID) {
		this.numberID = numberID;
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
}
