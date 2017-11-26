/**
 * This is an entity class that contains information about a particular service
 * @author Caleb
 */

package project4;

public class Service {
	private int serviceCode;
	private int price;
	private String serviceName;
	
	public Service(int newServiceCode, int newPrice, String newServiceName) {
		serviceCode = newServiceCode;
		price = newPrice;
		serviceName = newServiceName;
	}
	
	public int getServiceCode() {
		return serviceCode;
	}
	public int getPrice() {
		return price;
	}
	public String getServiceName() {
		return serviceName;
	}
}