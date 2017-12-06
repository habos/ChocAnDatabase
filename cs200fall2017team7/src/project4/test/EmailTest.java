package project4.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import project4.*;

public class EmailTest {

	MembersDatabase members;
	ProvidersDatabase providers;
	@Before
	public void setUp() throws Exception {
		members = new MembersDatabase();
		providers = new ProvidersDatabase();
		members.add(new Member( 111111, "Logan", "Main Street", "Tuscaloosa", "Alabama", "35757"));
		members.add(new Member( 111110, "Nagol", "Main Street", "asoolacsuT", "amabalA", "75753"));
		providers.add(new Provider(1313131, "Irene", "Super man ln", "Tuscaloosa", "ER", "54676"));
		Claim theClaim = new Claim(1313131, "Irene", 111111, "Logan", "Date", 123456, "Stomach Pumping", 100, "This sucks", "Second date");
		members.search(111110).addClaim(theClaim);
		providers.search(1313131).addClaim(theClaim);
	}

	@Test
	public void testMainAccountingProcedure() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		File f = new File("Data/SummaryReports/SummaryReport"+ dateFormat.format(date));
		File g = new File("Data/ProviderReports/Irene"+dateFormat.format(date));
		Email.mainAccountingProcedure(members, providers);
		assertTrue(f.exists());
		assertTrue(g.exists());
	}
	@Test
	public void testIndividualRecord(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		File file = new File("Data/MemberReports/Logan"+dateFormat.format(date));
		ByteArrayInputStream in = new ByteArrayInputStream("1\n111111\n".getBytes());
		System.setIn(in);
		Email.requestEmail(members, providers);
		assertTrue(file.exists());
		file = new File("Data/ProviderReports/Irene"+dateFormat.format(date));
		in = new ByteArrayInputStream("2\n1313131\n".getBytes());
		System.setIn(in);
		Email.requestEmail(members,providers);
		assertTrue(file.exists());
		file = new File("Data/EFTReports/Irene");
		assertTrue(file.exists());
		
	}

}
