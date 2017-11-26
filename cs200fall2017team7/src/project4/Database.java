package project4;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Database {
	
	protected ArrayList<Record> records;
	public Database() {
		records = new ArrayList<Record>();
	}
	public abstract void add();//adds record, with prompts
	
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
	//public boolean contains(int idToFind);//checks if id is there
	public abstract boolean edit(int idToChange);//edit records
	
	
	
	
}
