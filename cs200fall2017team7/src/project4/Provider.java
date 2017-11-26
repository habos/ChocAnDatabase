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
	return "Provider name: " + name + "\n"
		 + "Provider number: " + id + "\n"
		 + "Provider street address: " + address + "\n"
		 + "Provider city: " + city + "\n"
		 + "Provider ZIP: " + ZIP;
	}
//FIXME: put in needed report format
	@Override
	public String getClaims() {
		// TODO Auto-generated method stub
		return null;
	}
}
