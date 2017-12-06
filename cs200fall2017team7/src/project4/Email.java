package project4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Creates 'emails' from reports (saves it to a text file)
 * @author Chris
 */
public class Email {	
	
	/**
	 * This creates all the needed reports for the main accounting procedure
	 * @param membersDatabase Member database
	 * @param providersDatabase Provider database
	 */
	public void mainAccountingProcedure(MembersDatabase membersDatabase, ProvidersDatabase providersDatabase){
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date date = new Date();
		Iterator<Record> member = membersDatabase.giveMeAnIterator();
		Iterator<Record> providers = providersDatabase.giveMeAnIterator();
		while(member.hasNext()){
			Record record = member.next();
			if(record.hasClaims()){
				MemberReport report = new MemberReport(record.getId(), membersDatabase);
				Emailer("MemberReports", record.getName()+" "+dateFormat.format(date), report.toString());
			}
			record.setIsCurrentFalse();
		}
		while(providers.hasNext()){
			Record record = providers.next();
			if(record.hasClaims()){
				ProviderReport report = new ProviderReport(record.getId(), providersDatabase);
				Emailer("ProviderReports", record.getName()+" "+dateFormat.format(date), report.toString());
				EFT eft = new EFT(record.getName(), record.getId(), record.getClaimFee());
				Emailer("EFTReports", record.getName(), eft.toString());
			}
			record.setIsCurrentFalse();
		}
		SummaryReport summary = new SummaryReport(providersDatabase);
		Emailer("SummaryReports", "SummaryReport " + dateFormat.format(date), summary.toString());
		
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
			Emailer("MemberReports", members.getName(memberID)+dateFormat.format(date), report.toString());
		} else if (option == 2) {
			System.out.println("Please enter the ID of the Provider you would like to generate the report for: ");
			int providerID = scan.nextInt();
			ProviderReport report = new ProviderReport(providerID, providers);
			Emailer("ProviderReports", providers.getName(providerID)+dateFormat.format(date), report.toString());
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
	public void Emailer(String path, String recipient, String text) {
		File f = new File("Data/"+path+"/"+recipient);
		try
		{
			BufferedWriter email = new BufferedWriter( new FileWriter(f));
		    email.write(text);
		    email.close();
		}
		catch ( IOException e)
		{
			System.out.println("Exception in Emailing"); 	
		}
	}
}
