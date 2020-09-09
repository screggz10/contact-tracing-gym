package scc.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scc.project.SCCLogin;

class LoginTest {
	SCCLogin login;
	@BeforeEach
	void setUp() throws Exception {
		login = new SCCLogin();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUsername() {
		login.setUsername("new user");
		assertEquals("new user", login.getUsername());
	}
	
	@Test
	void testPassword() {
		login.setPassword("1234");
		assertEquals("1234", login.getPassword());
	}
	
	@Test
	void testAccessID() {
		login.setAccessID(1);
		assertEquals(1, login.getAccessID());
	}

}
