package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Creates 'emails' from reports (saves it to a text file)
 * 
 * @author Chris
 *
 */
public class Email {	
	
	
	public void mainAccountingProcedure(MembersDatabase members, ProvidersDatabase providers){
			
		for(Provider p : providers){
			
		}
	}
	
	
	/**
	 * The manager would use this method to "request" an "email" consisting of members of and providers.
	 * @param members List of members in our database
	 * @param providers List of providers in our database
	 * 
	 */
	public void requestEmail(MembersDatabase members, ProvidersDatabase providers){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd ");// set up the date and time format
		Date date = new Date();
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number for the type of report you want:");
		System.out.println("1: Member Report\n2: Provider Report");
		int option = scan.nextInt();
		if (option == 1) {
			System.out.println("Please enter the ID of the Member you would like to generate the report for: ");
			int memberID = scan.nextInt();
			while (!members.contains(memberID)) {
				System.out.println("The ID you have entered does not exist for a member.  Please enter a new member ID: ");
				memberID = scan.nextInt();
			}
			MemberReport report = new MemberReport(memberID, members);
			Emailer(members.getName(memberID)+dateFormat.format(date), report.toString());
		} else if (option == 2) {
			System.out.println("Please enter the ID of the Provider you would like to generate the report for: ");
			int providerID = scan.nextInt();
			ProviderReport report = new ProviderReport(providerID, providers);
			Emailer(providers.getName(providerID)+dateFormat.format(date), report.toString());
		} else {
			System.out.println("ERROR: Incorrect option");
		}
	}
	
	/**
	 * This method saves the generated email as a .txt file.
	 * 
	 * @param recipient The recipient of the email
	 * @param text Text to be written to a file
	 * 
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
