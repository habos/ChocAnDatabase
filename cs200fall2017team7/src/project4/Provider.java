package project4;

/**
 * The provider class. This is an entity stereotype class.
 * @author Colin 
 */

public class Provider extends Record {
	
	
	public Provider(int id, String name, String address, String city, String state, String ZIP) {
		super(id, name, address, city, state, ZIP);
	}

	public String toString(){
		String providerString = "";
		providerString += "Provider name: " + name + "\n";
		providerString += "Provider number: " + id + "\n";
		providerString += "Provider street address: " + address + "\n";
		providerString += "Provider city: " + city + "\n";
		providerString += "Provider ZIP: " + ZIP + "\n";
		return providerString;
	}
}
