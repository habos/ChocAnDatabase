package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Creates 'emails' from reports (saves it too a text file)
 * 
 * @author Chris
 *
 */
public class Email {

	/**
	 * For Requesting 'emails'
	 * @return email as a string
	 */
	public String requestEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number for the typle of report you want:\n");
		System.out.println("1: Member Report\n2: Provider Report");
		int option = scan.nextInt();
		scan.close();
		if (option == 1) {
			return "**PlaceHolder for Member Report**";
		} else if (option == 2) {

			return "**PlaceHolder for Provider Report**";
		} else {
			System.out.println("ERROR: Incorrect option");
			return null;
		}

	}
	/**
	 * Saves 'email' to file
	 */
	public void Emailer(String recipient, String text) {
		
		try
		{
			BufferedWriter email = new BufferedWriter( new FileWriter(recipient+".txt"));
		    email.write(text);
		    email.close();
		}
		catch ( IOException e)
		{
			System.out.println("Exception in Emailing"); 	
		}
		}
}
