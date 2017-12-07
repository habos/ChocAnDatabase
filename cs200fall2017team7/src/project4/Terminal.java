package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

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
		
		
		if(fromXML("Members") != null)
			members = (MembersDatabase) fromXML("Members");
		if(fromXML("Providers") != null)
			providers = (ProvidersDatabase) fromXML("Providers");
		
		
		boolean programRunning = true;
		while(programRunning){
			System.out.println("Which terminal would you like to simulate?");
			System.out.println("Enter '1' if you're a provider.");
			System.out.println("Enter '2' if you're a manager.");
			System.out.println("Enter '3' if you're a operator.");
			System.out.println("Enter '4' if you're part of Acme Accounting Services.");
			System.out.println("Enter '5' to exit.");
			Scanner scan = new Scanner(System.in);
			char c = scan.nextLine().trim().charAt(0);
		
			switch(c){
			case('1'):
				providerTerminal(members, providers, serviceDatabase);
				break;
			case('2'):
				managerTerminal(members, providers);
				break;
			case('3'):
				operatorTerminal(members, providers);
				break;
			case('4'):
				acmeTerminal(members, providers);
				break;
			case('5'):
				programRunning = false;
				exit(members, providers);
				break;
			default:
				System.out.println("You have not chosen one of the options. Please try agian.");
				break;
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
		//Initialize xstream and get rid of useless error
		XStream xstream = new XStream(new StaxDriver());
		XStream.setupDefaultSecurity(xstream);
		AnyTypePermission per = new AnyTypePermission();
		xstream.addPermission(per);
		//Return the database from the xml
		return (Database) xstream.fromXML(text);
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
					System.out.println(services.toString());
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
								while(memberId<0) {
									System.out.println("Error: please enter a valid member ID: (enter -1 to exit)");
									memberId = scan.nextInt();
									if(memberId ==-1)break;
								}
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
	
	public static void acmeTerminal(MembersDatabase members, ProvidersDatabase providers){
		Scanner scan = new Scanner(System.in);
		boolean continueACMETerminal = true;
		while(continueACMETerminal){
			System.out.println("Welcome to the ACME terminal! Please choose one of the following options: ");
			System.out.println("Enter '1' to change member balance.");
			System.out.print("Enter '2' to exit.");
			int choice = scan.nextInt();
			switch(choice){
				case(1):
					System.out.println("Please enter the Member ID of the member whose balance you would like to change.");
					int memberNumber = scan.nextInt();
					if(!members.contains(memberNumber)){
						memberNumber = invalidID("member", members, providers);
						if(memberNumber == -1){
							System.out.println("Returning to terminal.");
							break;
						}
					}
					System.out.println("Enter the amount you would like to change balance.  Negative values charge the member and positive add money to the members account.");
					System.out.println("If a members balance is less than zero, that member will be suspended.");
					int changeInBalance = scan.nextInt();
					((Member) members.search(memberNumber)).changeBalance(changeInBalance);
					System.out.println(members.search(memberNumber).getName() + "'s balance is now " + ((Member) members.search(memberNumber)).getBalance()); 
					if(((Member) members.search(memberNumber)).getBalance() < 0){
						((Member) members.search(memberNumber)).setSuspended(true);
						System.out.println(members.search(memberNumber).getName() + " is now suspended.");
					}
					if(((Member) members.search(memberNumber)).getBalance() >= 0){
						((Member) members.search(memberNumber)).setSuspended(false);
						System.out.println(members.search(memberNumber).getName() + " is now unsuspended.");
					}
					break;
				case(2):
					continueACMETerminal = false;
					break;
				default:
					System.out.println("You have not chosen one of the options. Please try agian.");
					break;
			}//end switch
		}//end while
	}//end ACME terminal
	
	public static void managerTerminal(MembersDatabase members, ProvidersDatabase providers){
		Scanner scan = new Scanner(System.in);
		boolean continueManagerTerminal = true;
		while(continueManagerTerminal){
			System.out.println("Welcome to the Manager terminal! Please choose one of the following options.");
			System.out.println("Enter '1' to request a report.");
			System.out.println("Enter '2' to simulate 'Main Accounting Procedure'.");
			System.out.println("Enter '3' to exit.");
			int choice = scan.nextInt();
			switch(choice){
				case(1):
					Email.requestEmail(members, providers);
					break;
				case(2):
					Email.mainAccountingProcedure(members, providers);
					break;
				case(3):
					continueManagerTerminal = false;
					break;
				default:
					System.out.println("You have not chosen one of the options. Please try agian.");
					break;
			}
		}
	}
}

