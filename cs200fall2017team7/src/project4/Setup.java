package project4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import org.xmlpull.v1.*;

/**
 * Start of the program (currently for testing)
 * @author Chris
 *
 */
public class Setup {

	public static void main(String[] args) throws IOException{
	
		
		MembersDatabase members = new MembersDatabase();
		members = (MembersDatabase) fromXML("swagmoney");
		members.add(new Member(1, "Joe", "123 Main St", "Tuscaloosa", "AL", "30541"));
		members.add(new Member(2, "Harry", "1131 Jackson Ave", "Tuscaloosa", "AL", "30541"));
		System.out.println(members.getRecords(1));
		members.delete(1);
		System.out.println(members.getRecords(1));
		ProvidersDatabase providers = new ProvidersDatabase();
		providers.add(new Provider(100, "Dr Smith Cholocate", "321 Other main Street", "Asoolacsut", "lA", "14503"));
		System.out.println(providers.getRecords(100));
		toXML("swagmoney", members);
		
		
	}

	
	public static void toXML(String fileName, Database database){
		XStream xstream = new XStream(new StaxDriver());
		String xml = xstream.toXML(database);
		try
		{
			BufferedWriter email = new BufferedWriter( new FileWriter(fileName + ".txt"));
		    email.write(xml);
		    email.close();
		}
		catch ( IOException e)
		{
			System.out.println("Exception in Emailing"); 	
		}
		System.out.println(xml);
	}
	
	public static Database fromXML(String fileName) throws IOException{
		String text = new String(Files.readAllBytes(Paths.get(fileName + ".txt")), StandardCharsets.UTF_8);
		XStream xstream = new XStream();
		return (Database)xstream.fromXML(text);
	}
	
}
	

