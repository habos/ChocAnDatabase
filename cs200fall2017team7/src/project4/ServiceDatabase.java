package project4;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ServiceDatabase {
	protected ArrayList<Service> services;
	
	public ServiceDatabase() throws IOException {
		BufferedReader bufferedReader = null;
		Service readInService;
		int serviceCode;
		int price;
		String serviceName = null;
		String line = null;
		Scanner s;
		
		try {
			bufferedReader = new BufferedReader(new FileReader("ProviderDirectory.txt"));
			services = new ArrayList<Service>();
			while((line = bufferedReader.readLine()) != null)
			{
				s = new Scanner(line);
				serviceCode = s.nextInt();
				price = s.nextInt();
				while(s.hasNext())
				{
					serviceName += s.next();
				}
				readInService = new Service(serviceCode, price, serviceName);
				services.add(readInService);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		bufferedReader.close();
	}
}
