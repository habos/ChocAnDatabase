package project4;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Database {
	
	protected ArrayList<Record> records;
	
	public abstract void add();//adds record, with prompts
	
	public abstract void add(Record recordToAdd);//add record, without prompts (for to add from file)
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
	public String getRecords(int id) {
		Iterator<Record> records = this.records.iterator();
		
		while(records.hasNext())
		{
			Record record = records.next();
			if(record.matches(id)) {
				return record.toString();
			}		
		}
			return null;	
	}
	//public boolean contains(int idToFind);//checks if id is there
	public abstract boolean edit(int idToChange);//edit records
	
	
	
	
}
