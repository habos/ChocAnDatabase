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
	
		ServiceDatabase serviceDatabase = new ServiceDatabase();
		for(int i = 0; i < serviceDatabase.services.size(); i++)
		{
			System.out.print(serviceDatabase.services.get(i).getServiceCode());
			System.out.print(" " + serviceDatabase.services.get(i).getPrice());
			System.out.println(" " + serviceDatabase.services.get(i).getServiceName());
		}
		
		
		MembersDatabase members = new MembersDatabase();
		members = (MembersDatabase) fromXML("swagmoney");
		members.toString();
		//members.add(new Member(1, "Joe", "123 Main St", "Tuscaloosa", "AL", "30541"));
		//members.add(new Member(2, "Harry", "1131 Jackson Ave", "Tuscaloosa", "AL", "30541"));
		System.out.println(members.getRecords(2));
		//members.delete(1);
		System.out.println(members.getRecords(1));
		//ProvidersDatabase providers = new ProvidersDatabase();
		//providers.add(new Provider(100, "Dr Smith Cholocate", "321 Other main Street", "Asoolacsut", "lA", "14503"));
		//System.out.println(providers.getRecords(100));
		//toXML("swagmoney", members);
		
		
	}

	
	public static void toXML(String fileName, Database database){
		//Initialize xstream and get rid of useless error
		File f = new File(fileName + ".txt");
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
	
	public static Database fromXML(String fileName) throws IOException{
		//Initialize bufferReader and read in the line from the file
		File f = new File(fileName + ".txt");
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
	
}
	

