package project4.test;

import static org.junit.Assert.*;

import java.io.File;

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
		members.add(new Member( 111111, "Logan", "Dumbass Lane", "Tuscaloosa", "Alabama", "35757"));
		members.add(new Member( 111110, "Nagol", "enaL ssabmuD", "asoolacsuT", "amabalA", "75753"));
		providers.add(new Provider(1313131, "Irene", "Super man ln", "Tuscaloosa", "ER", "54676"));
		Claim theClaim = new Claim(1313131, "Irene", 111111, "Logan", "Date", 123456, "Stomach Pumping", 100, "This sucks", "Second date");
		members.search(111110).addClaim(theClaim);
		providers.search(1313131).addClaim(theClaim);
	}

	@Test
	public void testMainAccountingProcedure() {
		File f = new File("Data/SummaryReports/SummaryReport20171206");
		File g = new File("Data/ProviderReports/Irene20171206");
		Email.mainAccountingProcedure(members, providers);
		assertTrue(f.exists());
		assertTrue(g.exists());
	}
	
	public void testIndividualRecord(){
		
	}

}
