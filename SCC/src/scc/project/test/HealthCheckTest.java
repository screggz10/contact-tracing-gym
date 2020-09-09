package scc.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scc.project.HealthCheck;

class HealthCheckTest {
	HealthCheck check;
	@BeforeEach
	void setUp() throws Exception {
		check = new HealthCheck();
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testFever() {
		check.setFever("Yes");
		assertEquals("Yes", check.getFever());
	}
	
	@Test
	void testCough() {
		check.setCough("Yes");
		assertEquals("Yes", check.getCough());
	}

	@Test
	void testBreathless() {
		check.setBreathless("Yes");
		assertEquals("Yes", check.getBreathless());
	}
	
	@Test
	void testSoreThroat() {
		check.setSoreThroat("Yes");
		assertEquals("Yes", check.getSoreThroat());
	}
	
	@Test
	void testChestPain() {
		check.setChestPain("Yes");
		assertEquals("Yes", check.getChestPain());
	}
	
	@Test
	void testConfirmedCase() {
		check.setConfirmedCase("Yes");
		assertEquals("Yes", check.getConfirmedCase());
	}
	
	@Test
	void testTravel() {
		check.setTravel("Yes");
		assertEquals("Yes", check.getTravel());
	}
	
	@Test
	void testTime() {
		check.setTime("10am");
		assertEquals("10am", check.getTime());
	}
	
	@Test
	void testDate() {
		check.setDate("10/8/2020");
		assertEquals("10/8/2020", check.getDate());
	}
}
