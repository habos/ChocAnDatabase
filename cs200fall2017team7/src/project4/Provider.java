package project4;

/**
 * The provider class. This is an entity stereotype class.
 * @author Colin 
 */

public class Provider extends Record {
	
	public Provider(int numberID, String name, String address, String city, String state, String ZIP){
		this.numberID = numberID;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.ZIP = ZIP;
	}
	
	public String toString(){
		String providerString = "";
		providerString += "Provider name: " + name + "\n";
		providerString += "Provider number: " + numberID + "\n";
		providerString += "Provider street address: " + address + "\n";
		providerString += "Provider city: " + city + "\n";
		providerString += "Provider ZIP: " + ZIP + "\n";
		return providerString;
	}
}
