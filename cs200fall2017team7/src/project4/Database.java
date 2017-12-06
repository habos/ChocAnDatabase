package project4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


/**
 * The superclass for MembersDatabase and ProvidersDatabase.
 * @author Chris
 */
public abstract boolean class Database {
	
	protected ArrayList<Record> records;
	
	/**
	 * Constructor
	 */
	public Database() {
		records = new ArrayList<Record>();
	}
	
	public abstract boolean add();//adds record, with prompts
	
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
	/**
	 * Adds record to database.
	 * @param record
	 */
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
	/**
	 * Checks if the database contains a record that matches an id
	 * @param id The id to compare against database entries
	 * @return True if the database contains the id, false if it does not.
	 */
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
	/**
	 * Finds the entry that matches an id, and returns the name
	 * @param id The id to match
	 * @return The string that is the name of the person that has the id sent in as a paramater
	 */
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
	
	/**
	 * Returns a record in the form of a string to be used in reports
	 * @param id The id to search for in the database
	 * @return The record in the form of a properly formatted string
	 */
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
	
	/**
	 * It returns an iterator for the records arraylist
	 * @return The iterator for the records arraylist
	 */
	public Iterator<Record> giveMeAnIterator(){
		Iterator <Record> records = this.records.iterator();
		return records;
	}
	
	/**
	 * Adds a claim.
	 * @param providers Providers database
	 * @param members Members database
	 * @param services Service database
	 */
	public void addClaim(ProvidersDatabase providers, MembersDatabase members, ServiceDatabase services, int provID, int memberId) {
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss");
	Date date = new Date();
	Scanner user_input = new Scanner(System.in);

	String providerName = providers.getName(provID);
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
