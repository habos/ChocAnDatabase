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
		records.add(new Member(id, name, address, city, state, ZIP));
		scan.close();
	}

	
	@Override
	public boolean edit(int idToChange) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void writeOut(){
		try
		{
			BufferedWriter save = new BufferedWriter( new FileWriter("MembersPersistence.txt"));
		    for(Record m : records){
		    	save.write(m.write());
		    }
		    save.close();
		}
		catch ( IOException e)
		{
			System.out.println("Exception in Emailing"); 	
		}
	}



	@Override
	public void readIn() {
		try (BufferedReader br = new BufferedReader(new FileReader("MembersPersistence.txt"))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
