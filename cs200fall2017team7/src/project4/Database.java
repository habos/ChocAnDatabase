package project4;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {
	ArrayList<Record> records = new ArrayList<Record>();
	Scanner scan = new Scanner(System.in);
	public abstract void add();//adds record, with prompts
	public abstract void add(Record recordToAdd);//add record, without prompts (for to add from file)
	public abstract boolean delete(int idToDelete);//returns if deletion is successful
	public abstract boolean contains(int idToFind);//checks if id is there
	public abstract boolean edit(int idToChange);//edit records
	
	
	
	
}
