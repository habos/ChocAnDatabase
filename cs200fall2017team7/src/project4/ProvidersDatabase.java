package project4;

import java.util.Scanner;


public class ProvidersDatabase extends Database {

	
	public void add() {
		Scanner scan= new Scanner(System.in);
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
		records.add(new Provider(id, name, address, city, state, ZIP));
		scan.close();
	}

	@Override
	public boolean edit(int idToChange) {
		// TODO Auto-generated method stub
		return false;
	}

}
