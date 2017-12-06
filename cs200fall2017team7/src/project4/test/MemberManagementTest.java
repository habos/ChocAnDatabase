package project4.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import project4.Member;
import project4.MembersDatabase;
import project4.Record;

/**
 * 
 * @author logan
 *
 */

public class MemberManagementTest {

	MembersDatabase members;
	
	@Before
	public void setUp() throws Exception {
		members = new MembersDatabase();
		members.add(new Member( 111111, "Logan", "Dumbass Lane", "Tuscaloosa", "Alabama", "35757"));
	}

	//test for success
	@Test
	public void testAddTrue() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("123456\nLogan\nBrooklyn\nTuscaloosa\nAlabama\n35757".getBytes());
	//	PrintStream x = null;
		//TODO set output Stream to not show the console
		System.setIn(in);
//		System.setOut((PrintStream) x);
		
		members.add();
		System.setIn(System.in);
	//	System.setOut(System.out);
		assertTrue(members.contains(123456));
	}

	@Test
	public void testAddFalse() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("111111\n-1\n".getBytes());
		System.setIn(in);
		assertFalse(members.add());
		
		System.setIn(System.in);
		
	}
	
	@Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
