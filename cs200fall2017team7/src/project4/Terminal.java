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
public class Terminal {

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
		
		System.out.print("Which terminal would you like to simulate? P/M/O/A: ");
		System.out.println("Enter 'P' if you're a provider.");
		System.out.println("Enter 'M' if you're a manager");
		System.out.println("Enter 'O' if you're a operator");
		System.out.println("Enter 'A' if you're part of Acme Accounting Services");
		System.out.println("Enter 'E' to exit.");
		Scanner scan = new Scanner(System.in);
		char c = scan.nextLine().trim().charAt(0);
		
		switch(c){
		case('P'):
			providerTerminal(members, providers, serviceDatabase);
			exit(members, providers);
			break;
		case('M'):
			break;
		case('O'):
			break;
		case('A'):
			break;
		case('E'):
			break;
		}
		
		//Provider Terminal
		/*if(c == 'P' || c == 'p')
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
				//invalidID("provider", members, providers);
				
			}
		}*/
		
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
	
	public static void exit(MembersDatabase members, ProvidersDatabase providers){
		toXML("Members", members);
		toXML("Providers", providers);
	}
	
	public static int invalidID(String chooseDatabase, MembersDatabase members, ProvidersDatabase providers){
		Scanner user_input = new Scanner(System.in);
		int id = -1738;
		if(chooseDatabase.equals("member")){
			while (!members.contains(id)) {
				System.out.println("The ID you have entered does not exist for a member.  Please enter a new Member ID or enter -1 to exit: ");
				id = user_input.nextInt();
				if(id == -1){
					return id;
				}
			}
		}else if(chooseDatabase.equals("provider")){
			while (!providers.contains(id)) {
				System.out.println("The ID you have entered does not exist for a provider.  Please enter a new Provider ID or enter -1 to exit: ");
				id = user_input.nextInt();
				if(id == -1){
					return id;
				}
			}
		}
		else{
			System.out.println("Read the comments stupid you coded something wrong");
		}
		return id;
	}
	
	public static void providerTerminal(MembersDatabase members, ProvidersDatabase providers, ServiceDatabase services){
		Scanner scan = new Scanner(System.in);
		System.out.print("You have chosen provider terminal. Please enter your provider number: ");
		int providerNumber = scan.nextInt();
		if(!providers.contains(providerNumber)){
			providerNumber = invalidID("provider", members, providers);
			if(providerNumber == -1)
				return;
		}
		boolean continueProviderTerminal = true;
		while(continueProviderTerminal){
			System.out.println("Welcome to the Provider Terminal! Please choose one of the following options.");
			System.out.println("Enter '1' to request provider directory.");
			System.out.println("Enter '2' to validate a member.");
			System.out.println("Enter '3' to bill a member.");
			System.out.println("Enter '4' to exit.");
			int choice = scan.nextInt();
			switch(choice){
				case(1):
					services.toString();
					break;
				case(2):
					System.out.println("Please enter a member id to validate that member: ");
					int memberID = scan.nextInt();
					members.validate(memberID);
					break;
				case(3):
					System.out.println("Please enter a member id for the member you would like to bill.");
					int memberId = scan.nextInt();
					if(members.validate(memberId))
						members.addClaim(providers, members, services, providerNumber, memberId);
					break;
				case(4):
					continueProviderTerminal = false;
					break;
				default:
					System.out.println("You have not chosen one of the options. Please try again.");
					break;
			}
		}
	}
	
	public static void operatorTerminal(MembersDatabase members, ProvidersDatabase providers){
		Scanner scan = new Scanner(System.in);
		boolean continueOperatorTerminal = true;
		while(continueOperatorTerminal){
			System.out.println("Welcome to the operators terminal! Please choose one of the following options:");
			System.out.println("Enter '1' to manage the members database.");
			System.out.println("Enter '2' to manage the providers database.");
			System.out.println("Enter '3' to exit.");
			int choice = scan.nextInt();
			switch(choice){
				case(1):
					boolean continueMemberManagement = true;
					while(continueMemberManagement){
						System.out.println("Welcome to member management.  Please choose one of the following options:");
						System.out.println("Enter '1' to add member.");
						System.out.println("Enter '2' to delete member.");
						System.out.println("Enter '3' to edit member.");
						System.out.println("Enter '4' to exit.");
						int memberChoice = scan.nextInt();
						switch(memberChoice){
							case(1):
								members.add();
								break;
							case(2):
								System.out.println("Enter the Member ID for the member you would like to delete:");
								int memberID = scan.nextInt();
								members.delete(memberID);
								break;
							case(3):
								System.out.println("Enter the Member ID for the member you would like to edit:");
								int memberId = scan.nextInt();
								members.edit(memberId);
								break;
							case(4):
								continueMemberManagement = false;
								break;
							default:
								System.out.println("You have not chosen one of the options. Please try again.");
								break;
						}//end switch
					}//end while
					break;
				case(2):
					boolean continueProviderManagement = true;
					while(continueProviderManagement){
						System.out.println("Welcome to provider management.  Please choose one of the following options:");
						System.out.println("Enter '1' to add provider.");
						System.out.println("Enter '2' to delete provider.");
						System.out.println("Enter '3' to edit provider.");
						System.out.println("Enter '4' to exit.");
						int providerChoice = scan.nextInt();
						switch(providerChoice){
							case(1):
								providers.add();
								break;
							case(2):
								System.out.println("Enter the Member ID for the member you would like to delete:");
								int providerID = scan.nextInt();
								providers.delete(providerID);
								break;
							case(3):
								System.out.println("Enter the Member ID for the member you would like to edit:");
								int providerId = scan.nextInt();
								members.edit(providerId);
								break;
							case(4):
								continueProviderManagement = false;
								break;
							default:
								System.out.println("You have not chosen one of the options. Please try again.");
								break;
						}//end switch
					}//end while
					break;
				case(3):
					continueOperatorTerminal = false;
					break;
				default:
					System.out.println("You have not chosen one of the options. Please try again.");
					break;
			}
		}
	}//end operators terminal
}

