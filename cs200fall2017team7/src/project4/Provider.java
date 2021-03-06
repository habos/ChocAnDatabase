package project4;

import java.util.Iterator;

/**
 * The provider class. This is an entity stereotype class.
 * @author Colin 
 */

public class Provider extends Record {
	

	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param ZIP
	 */
	public Provider(int id, String name, String address, String city, String state, String ZIP) {
		super(id, name, address, city, state, ZIP);
	}

	/**
	 * Returns a formatted string containing provider information
	 */
	public String toString(){
	return "Provider name: " + name + "\n"
		 + "Provider number: " + id + "\n"
		 + "Provider street address: " + address + "\n"
		 + "Provider city: " + city + "\n"
		 + "Provider ZIP: " + ZIP+"\n"
		 +getClaims();
	}

	/**
	 * This method gets the list of claims files by a provider.
	 * 
	 * @return list of claims that match
	 */
	@Override
	public String getClaims() {	
		Iterator<Claim> claims = this.claims.iterator();
		String matchingClaims = "";
		
		while(claims.hasNext())
		{
			Claim claim = claims.next();
			if(claim.isCurrent)
				matchingClaims += claim.toStringProvider();		
		}
			return matchingClaims;	
	}
	

}
