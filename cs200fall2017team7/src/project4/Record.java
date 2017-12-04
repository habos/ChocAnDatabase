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
	

	public int getId() {
		return id;
	}
	
	public void setNumberID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZIP() {
		return ZIP;
	}

	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	/**
	 * 
	 * @param id to be compared
	 * @return boolean if matching id's
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
	
	public int getClaimFee() {
		int feeTotal = 0;
		for (int i = 0; i < claims.size(); i++){
			if(claims.get(i).isCurrent)
				feeTotal+=claims.get(i).getFee();
		}
		return feeTotal;
	}

	public int getConsultants() {
		return claims.size();
	}
	
	public boolean hasClaims(){
		for(int i = 0; i < claims.size(); i++){
			if(claims.get(i).isCurrent)
				return true;
			}
		return false;
	}
	
	public void setIsCurrentFalse(){
		for(int i = 0; i < claims.size(); i++){
			claims.get(i).isCurrent = false;
		}
	}
}
