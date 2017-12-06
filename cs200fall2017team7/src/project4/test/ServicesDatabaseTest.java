package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.ServiceDatabase;

public class ServicesDatabaseTest {

	ServiceDatabase services;
	
	@Before
	public void setUp() throws Exception {
		services = new ServiceDatabase();
	}

	@Test
	public void testGetNameTrue() {
		assertEquals("Chocolate Bath",services.getName(100000));
	}
	@Test
	public void testGetNameFalse() {
		assertNotEquals("Liposuction",services.getName(100000));
	}

	@Test
	public void testGetPriceTrue() {
		assertEquals(150, services.getPrice(100000));
	}
	@Test
	public void testGetPriceFalse() {
		assertNotEquals(150, services.getPrice(0));
	}

	@Test
	public void testContainsTrue() {
assertTrue(services.contains(100000));	}
	@Test
	public void testContainsFalse() {
assertFalse(services.contains(0));	}



}
