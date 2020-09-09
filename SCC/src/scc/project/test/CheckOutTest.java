package scc.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scc.project.SCCCheckOut;

class CheckOutTest {
	SCCCheckOut checkOut;
	@BeforeEach
	void setUp() throws Exception {
		checkOut = new SCCCheckOut();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckInTime() {
		checkOut.setCheckOutTime("6pm");
		assertEquals("6pm", checkOut.getCheckOutTime());
	}
	
	@Test
	void testCheckInDate() {
		checkOut.setCheckOutDate("3rd August");
		assertEquals("3rd August", checkOut.getCheckOutDate());
	}

}
