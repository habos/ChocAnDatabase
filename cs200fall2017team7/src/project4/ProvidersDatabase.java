package project4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ProvidersDatabase extends Database {

	public ProvidersDatabase() {
		records = new ArrayList<Record>();
	}
	
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter provider's ID: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Please enter provider's name: ");
		String name = scan.nextLine();
		System.out.println("Please enter provider's address: ");
		String address = scan.nextLine();
		System.out.println("Please enter provider's city: ");
		String city = scan.nextLine();
		System.out.println("Please enter provider's state: ");
		String state = scan.nextLine();
		System.out.println("Please enter provider's ZIP: ");
		String ZIP = scan.nextLine();
		Provider newProvider = new Provider(id, name, address, city, state, ZIP);
		records.add(newProvider);
		scan.close();
	}

	@Override
	public void add(Record recordToAdd) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean edit(int idToChange) {
		// TODO Auto-generated method stub
		return false;
	}

}
