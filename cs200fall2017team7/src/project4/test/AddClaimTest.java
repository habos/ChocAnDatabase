package project4.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import project4.Database;
import project4.ProvidersDatabase;
import project4.MembersDatabase;
import project4.ServiceDatabase;
import project4.Provider;
import project4.Member;
import project4.Record;

/**
 * Testing AddClaim and other database methods
 * @author Caleb
 *
 */
class AddClaimTest {

	ProvidersDatabase providersDatabase;
	MembersDatabase membersDatabase;
	ServiceDatabase serviceDatabase;
	@Before
	void setUp() throws Exception {
		providersDatabase = new ProvidersDatabase();
		membersDatabase = new MembersDatabase();
		serviceDatabase = new ServiceDatabase();
		providersDatabase.add(new Provider(10, "Joe", "101 Whatever", "Huntsville", "AL", "35405"));
		providersDatabase.add(new Provider(30, "Joe", "101 Whatever", "Huntsville", "AL", "35405"));
		membersDatabase.add(new Member(20, "Steve", "102 Whatever", "New Market", "GA", "35444"));
	}

	//Test for success
	@Test
	void testSearchSuccess() {
		assertEquals(10, providersDatabase.search(10).getId());
	}
	//Test for failure
	@Test
	void testSearchFailure() {
		assertNotEquals(20, providersDatabase.search(10).getId());
	}

	//Test for success
	@Test
	void testContainsSuccess() {
		int flag = 0;
		if(membersDatabase.contains(20))
		{
			flag = 1;
		}
		assertEquals(flag, 1);
	}
	//Test for failure
	@Test
	void testContainsFailure() {
		int flag = 0;
		if(membersDatabase.contains(80))
		{
			flag = 1;
		}
		assertNotEquals(flag, 1);
	}
	//Test for success
	@Test
	void testAddClaimSuccess() {
		int flag = 0;
		providersDatabase.addClaim(providersDatabase, membersDatabase, serviceDatabase, 10, 20);
		if(providersDatabase.search(10).hasClaims())
		{
			flag = 1;
		}
		assertEquals(flag, 1);
	}
	//Test for failure
	@Test
	void testAddClaimFailure() {
		int flag = 0;
		providersDatabase.addClaim(providersDatabase, membersDatabase, serviceDatabase, 10, 20);
		if(providersDatabase.search(30).hasClaims())
		{
			flag = 1;
		}		
		assertNotEquals(flag, 1);
	}
	

}