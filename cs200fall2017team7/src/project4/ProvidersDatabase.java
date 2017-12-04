package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProvidersDatabase extends Database {

	/**
	 * The add() method prompts the user to enter information for a new Provider
	 * and adds it to the ProviderDatabase
	 */
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter provider's ID: ");
		int id = scan.nextInt();
		while (contains(id)) {
			System.out.println("The ID you have entered already exists for another provider.  Please enter a new provider ID: ");
			id = scan.nextInt();
		}
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
		//scan.close();
	}


	@Override
	/**
	 * The edit(int) method allows the user to edit Provider information.
	 * @param idToChange : The ID of the provider that will be edited
	 * @return boolean : Whether or not the edit operation was successful
	 */
	public boolean edit(int idToChange) {
		// Implementation attempted by Caleb, perfected by Harry
		// Go through members
		for (int i = 0; i < records.size(); i++) {
			// Find a matching ID
			if (records.get(i).id == idToChange) {
				// Find which item the user would like to change
				System.out.println("What would you like to change? I/N/A/C/S/Z: ");
				Scanner scan = new Scanner(System.in);
				char c = scan.nextLine().trim().charAt(0);
				// Ask user to change the selected item
				if (c == 'I') {
					System.out.println("Enter new Provider ID: ");
					int id = scan.nextInt();
					while (contains(id)) {
						System.out.println("The ID you have entered already exists for another provider.  Please enter a new Provider ID or enter -1 to exit: ");
						id = scan.nextInt();
						if(id == -1)
							break;
					}
					records.get(i).setNumberID(id);
				} else if (c == 'N') {
					System.out.println("Enter new name: ");
					records.get(i).setName(scan.nextLine());
				} else if (c == 'A') {
					System.out.println("Enter new address: ");
					records.get(i).setAddress(scan.nextLine());
				} else if (c == 'C') {
					System.out.println("Enter new city: ");
					records.get(i).setCity(scan.nextLine());
				} else if (c == 'S') {
					System.out.println("Enter new state: ");
					records.get(i).setState(scan.nextLine());
				} else if (c == 'Z') {
					System.out.println("Enter new ZIP code: ");
					records.get(i).setZIP(scan.nextLine());
				} else {
					// User's choice was out of bounds
					System.out.println("Invalid Choice.");
					scan.close();
					return false;
				}
				// Success in edit
				System.out.println("Information Updated.");
				scan.close();
				return true;
			}
		}
		// The selected member ID did not find a match
		System.out.println("Provider not found. Failed to update.");
		return false;
	}

	/**
	 * 
	 * @return the total fee amount of all the claims in record
	 */

	public int getTotalFee() {
		int feeTotal = 0;

		for (int i = 0; i < records.size(); i++) {
			feeTotal += records.get(i).getClaimFee();
		}

		return feeTotal;
	}

	/**
	 * 
	 * @param the
	 *            location in records to get the claims
	 * @return the fee for a claim in records
	 */
	public int getIndivFee(int recordLocation) {

		return records.get(recordLocation).getClaimFee();

	}

	/**
	 * 
	 * @return the total number of consultations in records
	 */
	public int getTotalConsultant() {
		int numConsultants = 0;

		for (int i = 0; i < records.size(); i++) {
			numConsultants += records.get(i).getConsultants();
		}
		return numConsultants;
	}

	/**
	 * 
	 * @param takes
	 *            in the records location
	 * @return the number of claims for a record
	 */

	public int getConsultant(int recordLocation) {

		return records.get(recordLocation).getConsultants();

	}

	/**
	 * 
	 * @return the record size
	 */

	public int getSize() {
		return records.size();
	}

	/**
	 * 
	 * @param takes
	 *            in the record location
	 * @return returns the name of the provider
	 */
	public String getNameByIndex(int index) {
		return records.get(index).getName();
	}

}
