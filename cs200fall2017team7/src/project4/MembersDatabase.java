package project4;

import java.util.Scanner;

public class MembersDatabase extends Database {

	@Override
	/**
	 * The add() method prompts the user to enter information for a new Member
	 * and adds it to the MemberDatabase
	 */
	public void add() {
		// Create a new scanner
		Scanner scan = new Scanner(System.in);
		// Start asking the user for information
		System.out.println("Please enter member's ID: ");
		int id = scan.nextInt();
		// Make sure that there are no duplicate IDs
		while (contains(id)){
			System.out.println("The ID you have entered already exists for another member.  Please enter a new member ID or -1 to exit: ");
			id = scan.nextInt();
			if(id == -1)
				return;
		}
		scan.nextLine();
		System.out.println("Please enter member's name: ");
		String name = scan.nextLine();
		System.out.println("Please enter member's address: ");
		String address = scan.nextLine();
		System.out.println("Please enter member's city: ");
		String city = scan.nextLine();
		System.out.println("Please enter member's state: ");
		String state = scan.nextLine();
		System.out.println("Please enter member's ZIP: ");
		String ZIP = scan.nextLine();
		// Create and add the Member to MembersDatabase
		records.add(new Member(id, name, address, city, state, ZIP));
	}

	/**
	 * The edit(int) method allows the operator to edit information about a
	 * Member based on the Member's ID.
	 * 
	 * @param idToChange
	 *            : This indicates which member to edit
	 * @return boolean whether or not the function was successful
	 */
	@Override
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
					System.out.println("Enter new Member ID: ");
					int id = scan.nextInt();
					while (contains(id)) {
						System.out.println("The ID you have entered already exists for another member.  Please enter a new member ID: ");
						id = scan.nextInt();
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
					return false;
				}
				// Success in edit
				System.out.println("Information Updated.");
				return true;
			}
		}
		// The selected member ID did not find a match
		System.out.println("Member not found. Failed to update.");
		return false;
	}
	
	public boolean validate(int id){
		Scanner scan = new Scanner(System.in);
		boolean invalidMember = true;
		while(invalidMember){
			if(!this.contains(id)){
				while (!this.contains(id)) {
					System.out.println("The ID you have entered does not exist for a member.  Please enter a new Member ID or enter -1 to exit: ");
					id = scan.nextInt();
					if(id == -1)
						return false;
				}
			}
			if(((Member) this.search(id)).isSuspended()){
					System.out.println("The Member you want to validate is suspended. Please enter a new Member ID or enter -1 to exit: ");
					id = scan.nextInt();
					if(id == -1)
						return false;
					break;
			}
			invalidMember = false;
		}
		System.out.println("Validated!");
		return true;
	}

}
