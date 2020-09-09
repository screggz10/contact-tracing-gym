package scc.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scc.project.SCCUser;

class UserTest {
	SCCUser user;
	@BeforeEach
	void setUp() throws Exception {
		user = new SCCUser();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUserID() {
		user.setUserID(1);
		assertEquals(1, user.getUserID());
	}
	
	@Test
	void testUserName() {
		user.setUserName("Stephen");
		assertEquals("Stephen", user.getUserName());
	}
	
	@Test
	void testUserGender() {
		user.setGender("Male");
		assertEquals("Male", user.getGender());
	}
	
	@Test
	void testEmailAddress() {
		user.setEmailAddress("steve@gmail.com");
		assertEquals("steve@gmail.com", user.getEmailAddress());
	}
	
	@Test
	void testPhoneNumber() {
		user.setPhoneNumber("0851019108");
		assertEquals("0851019108", user.getPhoneNumber());
	}
	
	@Test
	void testAddress() {
		user.setAddress("Kilcormac");
		assertEquals("Kilcormac", user.getAddress());
	}
	
	@Test
	void testCity() {
		user.setCity("Offaly");
		assertEquals("Offaly", user.getCity());
	}

}
