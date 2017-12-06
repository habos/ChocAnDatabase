package project4;

/**
 * This is an entity class that contains information about a particular service
 * @author Caleb
 */

public class Service {
	private int serviceCode;
	private int price;
	private String serviceName;
	
	/**
	 * Constructor for the service
	 * @param newServiceCode The Service Code
	 * @param newPrice The Price
	 * @param newServiceName The Name
	 */
	public Service(int newServiceCode, int newPrice, String newServiceName) {
		serviceCode = newServiceCode;
		price = newPrice;
		serviceName = newServiceName;
	}
	
	/**
	 * Gets service code for the service
	 * @return The service code
	 */
	public int getServiceCode() {
		return serviceCode;
	}

	/**
	 * Gets the price for the service
	 * @return The price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Gets the name of the service
	 * @return The name
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Checks if the id matches a serviceCode
	 * @param id : the given serviceCode
	 * @return boolean : whether it matches
	 */
	public boolean matches(int id) {
		if(id == this.serviceCode)
			return true;
		return false;
	}
}