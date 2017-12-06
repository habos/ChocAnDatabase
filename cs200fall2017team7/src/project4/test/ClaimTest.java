package project4.test;
import project4.Claim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test for Claim.java
 * @author Caleb
 */
public class ClaimTest {

	Claim theClaim;
	@Before
	public void setUp() throws Exception {
		theClaim = new Claim(100000, "Joe", 200000, "Steve", "Date", 123456, "Stomach Pumping", 100, "This sucks", "Second date");
	}

	//Test for success
	@Test
	public void testMatchProviderSuccess() {
		int flag = 0;
		if(theClaim.matchProvider(100000))
		{
			flag = 1;
		}
		assertEquals(1, flag, 0);
	}
	//Test for failure
	@Test(expected = AssertionError.class)
	public void testMatchProviderFailure() {
		int flag = 0;
		if(theClaim.matchProvider(500))
		{
			flag = 1;
		}
		assertEquals(1, flag, 0);
	}

	//Test for success
	@Test
	public void testMatchMemberSuccess() {
		int flag = 0;
		if(theClaim.matchMember(200000))
		{
			flag = 1;
		}
		assertEquals(1, flag, 0);
	}
	//Test for success
	@Test(expected = AssertionError.class)
	public void testMatchMemberFailure() {
		int flag = 0;
		if(theClaim.matchMember(500))
		{
			flag = 1;
		}
		assertEquals(1, flag, 0);
	}

	//Test for success
	@Test
	public void testGetFeeSuccess() {
		assertEquals(100, theClaim.getFee(), 0);
	}
	//Test for success
	@Test(expected = AssertionError.class)
	public void testGetFeeFailure() {
		assertEquals(50, theClaim.getFee(), 0);
	}

}
