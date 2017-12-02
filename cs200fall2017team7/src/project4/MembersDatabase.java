package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MembersDatabase extends Database{

	@Override
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter member's ID: ");
		int id = scan.nextInt();
		while(contains(id)){
			System.out.println("The ID you have entered already exists for another member.  Please enter a new member ID: ");
			id = scan.nextInt();
		}
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
		records.add(new Member(id, name, address, city, state, ZIP));
		scan.close();
	}


	
	/**
	 * This allows the operator to edit information about a member.
	 * @param idToChange This indicates which member to edit
	 */
	@Override
	public boolean edit(int idToChange) {
		// Implementation attempt by Caleb
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).id == idToChange)
			{
				
				System.out.println("What would you like to change? I/N/A/C/S/Z: ");
				Scanner scan = new Scanner(System.in);
				char c = scan.next().trim().charAt(0);
				if(c == 'I')
				{	
					System.out.println("Enter new Member ID: ");
					records.get(i).setNumberID(scan.nextInt());
				}
				else if(c == 'N')
				{
					System.out.println("Enter new name: ");
					records.get(i).setName(scan.nextLine());
				}
				else if(c == 'A')
				{
					System.out.println("Enter new address: ");
					records.get(i).setAddress(scan.nextLine());
				}
				else if(c == 'C')
				{
					System.out.println("Enter new city: ");
					records.get(i).setCity(scan.nextLine());
				}
				else if(c == 'S')
				{
					System.out.println("Enter new state: ");
					records.get(i).setState(scan.nextLine());
				}
				else if(c == 'Z')
				{
					System.out.println("Enter new ZIP code: ");
					records.get(i).setZIP(scan.nextLine());
				}
				else
				{
					System.out.println("Invalid Choice.");
					scan.close();
					return false;
				}
				System.out.println("Information Updated.");
				scan.close();
				return true;
			}
		}
		System.out.println("Member not found\n"); //For some reason, printing needs to be included in brackets in a method
		
		return false;
	}

}
