package project4.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import project4.Provider;
import project4.ProvidersDatabase;

/**
 * @author colinmacwilliam
 */

public class ProviderManagementTest {

	ProvidersDatabase providers;
	
	@Before
	public void setUp() throws Exception {
		providers = new ProvidersDatabase();
		providers.add(new Provider( 1234, "Colin Macwilliam", "190 University Blvd", "Tuscaloosa", "AL", "36695"));
	}

	//test for success
	@Test
	public void testAddSuccess() {
		ByteArrayInputStream newInput = new ByteArrayInputStream("9876\nJohn\n190 University Blvd\nTuscaloosa\nAlabama\n36695".getBytes());
		System.setIn(newInput);
		providers.add();
		System.setIn(System.in);
		
		assertTrue(providers.contains(9876));
	}
	
	//test for failure
	@Test
	public void testAddFailure() {
		ByteArrayInputStream newInput = new ByteArrayInputStream("9876\nJohn\n190 University Blvd\nTuscaloosa\nAlabama\n36695".getBytes());
		System.setIn(newInput);
		providers.add();
		
		ByteArrayInputStream nextInput = new ByteArrayInputStream("9876\n-1".getBytes());
		System.setIn(nextInput);
		assertFalse(providers.add());
		
		System.setIn(System.in);
	}


	//test for success
	//@Test
	//public void testEditSuccess() {	
	//	ByteArrayInputStream newInput = new ByteArrayInputStream("");
	//	System.setIn(newInput);
		
	//	providers.edit();
		
	//}
	
	//test for failure
	//@Test
	//public void testEditFailure() {
	//}
	
	//test for success
	@Test
	public void testDeleteSuccess() {
		providers.delete(1234);
		assertFalse(providers.contains(1234));		
	}

	//test for failure
	//@Test
	//public void testDeleteFailure() {
	//}

}
