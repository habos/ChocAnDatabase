package project4;

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
	public boolean delete(int id) {
		Iterator <Record> records = this.records.iterator();
		Record record = null;
		while(records.hasNext()) {
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
		while(records.hasNext()) {
			record = records.next();
			if(record.matches(id)) {
				return true;
			}
		}
		System.out.println("Failed to find record with ID of "+ id);
		return false;
	}
	public String getName(int id) {
		Iterator <Record> records = this.records.iterator();
		Record record = null;
		while(records.hasNext()) {
			record = records.next();
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
	
	
	
	
	public void addClaim(ProvidersDatabase providers, MembersDatabase members) {
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("MM–DD–YYYY hh:mm:ss");// set up the date and time format
	Scanner user_input = new Scanner(System.in);
	
	System.out.println("Enter Provider ID: ");
	int provID = user_input.nextInt();
	String providerName = providers.getName(provID);
	System.out.println("Enter Member ID: ");
	int memberId = user_input.nextInt();
	String memberName = members.getName(memberId);
	System.out.println("Enter Service Code: ");
	int servCode = user_input.nextInt();
	user_input.nextLine();
	
	//FIXME: add provider directory
	int fee=1;
	String serviceName = "**Placeholder Service Name**";
	//
	
	System.out.println("Enter any comments: ");
	String comments = user_input.nextLine();
	System.out.println("Enter date service was provided (MM–DD–YYYY).");
	String manualDate = user_input.nextLine();
	Claim newClaim =new Claim(provID, providerName, memberId, memberName, dateFormat.format(date), servCode, serviceName,  fee, comments, manualDate);
	providers.search(provID).addClaim(newClaim);
	members.search(memberId).addClaim(newClaim);
	user_input.close();
	}
	

	
}
