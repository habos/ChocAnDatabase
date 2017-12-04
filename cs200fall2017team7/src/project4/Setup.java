package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import org.xmlpull.v1.*;

/**
 * Start of the program (currently for testing)
 * @author Chris
 *
 */
public class Setup {

	public static void main(String[] args) throws IOException{
		
		//Initialization of databases
		ServiceDatabase serviceDatabase = new ServiceDatabase();
		MembersDatabase members = new MembersDatabase();
		ProvidersDatabase providers = new ProvidersDatabase();
		
		//refreshFiles(false);
		if(fromXML("members") != null)
			members = (MembersDatabase) fromXML("members");
		if(fromXML("proiders") != null)
			providers = (ProvidersDatabase) fromXML("providers");
		
		toXML("members", members);
		toXML("providers", providers);
		
		System.out.print("Which terminal would you like to simulate? P/M/O/A: ");
		Scanner scan = new Scanner(System.in);
		char c = scan.nextLine().trim().charAt(0);
		
		//Provider Terminal
		if(c == 'P')
		{
			System.out.print("\nYou have chosen provider terminal. Please enter your provider number: ");
			int providerNumber = scan.nextInt();
			if(providers.contains(providerNumber))
			{
				System.out.println("Welcome, " + providers.getName(providerNumber) + ".");
				System.out.print("Please enter a member number: ");
				int memberNumber = scan.nextInt();
				if(members.contains(memberNumber))
				{
					if(!((Member) members.search(memberNumber)).isSuspended())
					{
						System.out.println("Validated");
						System.out.println("Would you like to make a claim? y/n: ");
						c = scan.nextLine().trim().charAt(0);
						if(c == 'y')
						{
							//TODO
						}
						else if(c =='n')
						{
							System.out.println("Logging out...");
						}
						else
						{
							//TODO
						}
					}
					else
					{
						System.out.println("This member is suspended");
					}
				}
				else
				{
					System.out.println("Invalid Number");
				}
			}
			else
			{
				System.out.println("The provider number you entered was not found.");
				
			}
		}
		
	}

	/**
	 * This method puts the data contained in our database into an XML file to accomplish persistence. 
	 * @param fileName filename to write to
	 * @param database database to pull data from
	 * @return void
	 */	
	public static void toXML(String fileName, Database database){
		//Initialize xstream and get rid of useless error
		File f = new File("Data/SavedData/" + fileName + ".txt");
		XStream xstream = new XStream(new StaxDriver());
		XStream.setupDefaultSecurity(xstream);
		AnyTypePermission per = new AnyTypePermission();
		xstream.addPermission(per);
		//Convert database to xml file
		String xml = xstream.toXML(database);
		//Write to file
		try
		{
			BufferedWriter email = new BufferedWriter( new FileWriter(f));
		    email.write(xml);
		    email.close();
		}
		catch ( IOException e)
		{
			System.out.println("Exception in Emailing"); 	
		}
	}
	/**
	 * This method takes the data from our XML file in order to re-construct our database upon each session to accomplish persistence.
	 * @param fileName the name of the file to pull data from
	 * @throws IOException
	 * @return Database 
	 */
	public static Database fromXML(String fileName) throws IOException{
		//Initialize bufferReader and read in the line from the file
		File f = new File("Data/SavedData/" + fileName + ".txt");
		if(!f.exists())
			return null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
		String text = bufferedReader.readLine();
		bufferedReader.close();
		f.delete();
		//Initialize xstream and get rid of useless error
		XStream xstream = new XStream(new StaxDriver());
		XStream.setupDefaultSecurity(xstream);
		AnyTypePermission per = new AnyTypePermission();
		xstream.addPermission(per);
		//Return the database from the xml
		return (Database) xstream.fromXML(text);
	}
	public static void refreshFiles(boolean doDelete) throws IOException {
		File mem = new File("members.txt");
		File pro = new File("providers.txt");
		if(doDelete) {
		if(mem.exists()) 
			mem.delete();
		if(pro.exists())
			pro.delete();
		}
		if(!mem.exists())
		mem.createNewFile();
		if(!pro.exists())
		pro.createNewFile();
	}	
	
}
	

