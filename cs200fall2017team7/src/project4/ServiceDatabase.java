package project4;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * When constructed, this reads services from a Provider Directory and puts them in an ArrayList.
 * @author Caleb
 */
public class ServiceDatabase {
	protected ArrayList<Service> services;
	
	/**
	 * Constructor, this reads from ProviderDirectory.txt and creates an array of Service objects.
	 * @throws IOException
	 */
	public ServiceDatabase() throws IOException {
		BufferedReader bufferedReader = null;
		Service readInService;
		int theServiceCode;
		int thePrice;
		String theServiceName = null;
		String line = null;
		Scanner s;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("ProviderDirectory.txt"));
			services = new ArrayList<Service>();
			while((line = bufferedReader.readLine()) != null)
			{
				theServiceName = "";
				s = new Scanner(line);
				theServiceCode = s.nextInt();
				thePrice = s.nextInt();
				while(s.hasNext())
				{
					theServiceName += s.next();
					theServiceName += " ";
				}
				readInService = new Service(theServiceCode, thePrice, theServiceName);
				services.add(readInService);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		bufferedReader.close();
	}
	/**
	 * This searches the arraylist for a specific service code then returns the corresponding name
	 * @param code The Service Code the method uses to search the array
	 * @return The name of the service
	 */
	public String getName(int code) {
		String name = "Service Not Found";
		for(int i = 0; i < services.size(); i++)
		{
			if(services.get(i).getServiceCode() == code)
			{
				name = services.get(i).getServiceName();
				break;
			}
		} 
		return name;
	}
	/**
	 * This searches the arraylist for a specific service code then returns the corresponding price
	 * @param code The Service Code the method uses to search the array
	 * @return The price of the service
	 */
	public int getPrice(int code) {
		int price = 0;
		for(int i = 0; i < services.size(); i++)
		{
			if(services.get(i).getServiceCode() == code)
			{
				price = services.get(i).getPrice();
				break;
			}
		} 
		return price;
	}
}
