package scc.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scc.project.SCCCheckIn;

class CheckInTest {
	SCCCheckIn checkIn;
	@BeforeEach
	void setUp() throws Exception {
		checkIn = new SCCCheckIn();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckInTime() {
		checkIn.setCheckInTime("6pm");
		assertEquals("6pm", checkIn.getCheckInTime());
	}
	
	@Test
	void testCheckInDate() {
		checkIn.setCheckInDate("3rd August");
		assertEquals("3rd August", checkIn.getCheckInDate());
	}

}
