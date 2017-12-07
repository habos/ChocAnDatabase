package project4.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;


import project4.ProvidersDatabase;
import project4.MembersDatabase;
import project4.ServiceDatabase;
import project4.Provider;
import project4.Member;


/**
 * Testing AddClaim and other database methods
 * @author Caleb
 *
 */
public class AddClaimTest {

	ProvidersDatabase providersDatabase;
	MembersDatabase membersDatabase;
	ServiceDatabase serviceDatabase;
	@Before
	public void setUp() throws Exception {
		providersDatabase = new ProvidersDatabase();
		membersDatabase = new MembersDatabase();
		serviceDatabase = new ServiceDatabase();
		providersDatabase.add(new Provider(10, "Joe", "101 Whatever", "Huntsville", "AL", "35405"));
		providersDatabase.add(new Provider(30, "Joe", "101 Whatever", "Huntsville", "AL", "35405"));
		membersDatabase.add(new Member(20, "Steve", "102 Whatever", "New Market", "GA", "35444"));
	}

	//Test for success
	@Test
	public void testSearchSuccess() {
		assertEquals(10, providersDatabase.search(10).getId());
	}
	//Test for failure
	@Test
	public void testSearchFailure() {
		assertNotEquals(20, providersDatabase.search(10).getId());
	}

	//Test for success
	@Test
	public void testContainsSuccess() {
		int flag = 0;
		if(membersDatabase.contains(20))
		{
			flag = 1;
		}
		assertEquals(flag, 1);
	}
	//Test for failure
	@Test
	 public void testContainsFailure() {
		int flag = 0;
		if(membersDatabase.contains(80))
		{
			flag = 1;
		}
		assertNotEquals(flag, 1);
	}
	//Test for success
	@Test
	public void testAddClaimSuccess() {
		int flag = 0;
		ByteArrayInputStream in = new ByteArrayInputStream("100000\n1\nasdf\n11/11/1111".getBytes());
		System.setIn(in);
		providersDatabase.addClaim(providersDatabase, membersDatabase, serviceDatabase, 10, 20);
		if(providersDatabase.search(10).hasClaims())
		{
			flag = 1;
		}
		assertEquals(flag, 1);
	}
	//Test for failure
	@Test
	public void testAddClaimFailure() {
		int flag = 0;
		ByteArrayInputStream in = new ByteArrayInputStream("100000\n1\nasfd\n11/11/1111\n1".getBytes());
		System.setIn(in);
		providersDatabase.addClaim(providersDatabase, membersDatabase, serviceDatabase, 10, 20);
		if(providersDatabase.search(30).hasClaims())
		{
			flag = 1;
		}		
		assertNotEquals(flag, 1);
	}
	

}
