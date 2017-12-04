package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;



public abstract class Database {
	
	protected ArrayList<Record> records;
	
	public Database() {
		records = new ArrayList<Record>();
	}
	
	public abstract void add();//adds record, with prompts
	
	/**
	 * This method searches through our records in an attempt to return the record that matches a specific ID number.
	 * 
	 * @param id The ID to be searched for.
	 * @return the record that matches the ID passed in or null if record not found.
	 */
	public Record search(int id) {
		
		Iterator<Record> records = this.records.iterator();
		
		while(records.hasNext())
		{
			Record record = records.next();
			if(record.matches(id)) {
				return record;
			}		
		}
			return null ;
	}
	public void add(Record record) {
		records.add(record);
	}
	/**
	 * This method behaves the same as the search method, but will delete the record if found
	 * 
	 * @param id The ID to be searched for.
	 * @return the record that matches the ID passed in or null if record not found.
	 */
	public boolean delete(int id) {
		Iterator <Record> records = this.records.iterator();
		Record record = null;
		while(records.hasNext()) 
		{
			record = records.next();
			if(record.matches(id)) {
				System.out.println("Deleting "+ record.getName()+ " of ID "+record.getId());
				records.remove();
				return true;
			}
		}
		System.out.println("Failed to find record with ID of "+ id);
		return false;
	}
	public boolean contains(int id) {
		
		Iterator <Record> records = this.records.iterator();
		Record record = null;
		
		while(records.hasNext()) 
		{
			record = records.next();
			if(record.matches(id)) {
				return true;
			}
		}
		return false;
	}
	public String getName(int id) {
		Iterator <Record> records = this.records.iterator();
		while(records.hasNext()) 
		{
			Record record = records.next();
			if(record.matches(id)) {
				return record.getName();
			}
		}
		System.out.println("Failed to find record with ID of "+ id);
		return "";
	}
	
	public String getRecords(int id) {
		Iterator<Record> records = this.records.iterator();
		while(records.hasNext())
		{
			Record record = records.next();
			if(record.matches(id)) {
				return record.toString();
			}		
		}
			return "Failed to find record with ID of "+ id ;	
	}
	
	public abstract boolean edit(int idToChange);//edit records
	
	public Iterator<Record> giveMeAnIterator(){
		Iterator <Record> records = this.records.iterator();
		return records;
	}
	
	
	public void addClaim(ProvidersDatabase providers, MembersDatabase members, ServiceDatabase services) {
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY hh:mm:ss");// set up the date and time format
	Scanner user_input = new Scanner(System.in);
	
	System.out.println("Enter Provider ID: ");
	int provID = user_input.nextInt();
	while (!providers.contains(provID)) {
		System.out.println("The ID you have entered does not exist for a provider.  Please enter a new Provider ID or enter -1 to exit: ");
		provID = user_input.nextInt();
		if(provID == -1)
			break;
	}
	String providerName = providers.getName(provID);
	System.out.println("Enter Member ID: ");
	int memberId = user_input.nextInt();
	while (!members.contains(memberId)) {
		System.out.println("The ID you have entered does not exist for a member.  Please enter a new member ID or enter -1 to exit: ");
		memberId = user_input.nextInt();
		if(memberId == -1)
			break;
	}
	String memberName = members.getName(memberId);
	System.out.println("Enter Service Code: ");
	int servCode = user_input.nextInt();
	user_input.nextLine();
	while (!services.contains(servCode)) {
		System.out.println("The Service Code you have entered does not match any Service Code in the Directory.  Please enter a new Service Code or enter -1 to exit: ");
		servCode = user_input.nextInt();
		if(servCode == -1){
			break;
		}
	}
	int fee = services.getPrice(servCode);
	String serviceName = services.getName(servCode);
	
	System.out.println("Enter any comments: ");
	String comments = user_input.nextLine();
	System.out.println("Enter date service was provided (MM/DD/YYYY).");
	String manualDate = user_input.nextLine();
	Claim newClaim =new Claim(provID, providerName, memberId, memberName, dateFormat.format(date), servCode, serviceName,  fee, comments, manualDate);
	providers.search(provID).addClaim(newClaim);
	members.search(memberId).addClaim(newClaim);
	}
}
