package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.ServiceDatabase;

public class ServicesDatabase {

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
		assert("Chocolate Bath",services.getName(100000));
	}

	@Test
	public void testGetPrice() {
		assertEquals(150, services.getPrice(100000));
	}

	@Test
	public void testContainsTrue() {
assertTrue(services.contains(100000));	}
	@Test
	public void testContainsFalse() {
assertTrue(services.contains(0));	}



}
