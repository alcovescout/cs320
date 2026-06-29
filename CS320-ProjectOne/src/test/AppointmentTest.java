package test;

import appointment.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
	
	private String testId = "1";
	private Date testDate = new Date(System.currentTimeMillis() + 36000);
	private String testDescription = "This is my test Description";
	private Date oldDate = new Date(testDate.getTime() - (24 * 60 * 60 * 1000));
	private String invalidDescription = "This description is going to be over 50 characters making it bad.";
	
	private Appointment testAppointment;
	
	@BeforeEach
	void setup() {
		testAppointment = new Appointment(testId, testDate, testDescription);
	}

	@Test
	void testAppointmentClass() {
		assertEquals(testId, testAppointment.getAppointmentId());
		
		assertEquals(testDate, testAppointment.getAppointmentDate());
		
		assertEquals(testDescription, testAppointment.getAppointmentDescription());
		
	}

	//******************************************//
	//            Test the ID                   //
	//******************************************//
	@Test
	// Tests if error is thrown when ID is too long.
	void testAppointmentIdTooLong() {
		  Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
	            new Appointment("123456789012", testDate, testDescription);
	        });
	}
	@Test
	// Tests if error is thrown when ID is null.
	void testAppointmentIdNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, testDate, testDescription);
		});
	}

	//******************************************//
	//            Test the Date                 //
	//******************************************//
	@Test
	//Test if error is thrown when Date is older.
	void testAppointmentDate(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testId, oldDate, testDescription);
		});
	}
	@Test
	//Test if error is thrown when date is null.
	void testAppointmentDateNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(testId, null, testDescription);
		});
	}
	@Test
	//Test setter for date
	void testSetDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			testAppointment.setAppointmentDate(oldDate);
		});
	}

	//******************************************//
	//            Test the Description          //
	//******************************************//
	@Test
	//Test if error is thrown with description is too long.
	void testAppointmentBadDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testId, oldDate, invalidDescription);
		});
	}
	@Test
	//Tests if error is thrown when description is null.
	void testAppointmentDescriptionNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(testId, testDate, null);
		});
	}
	@Test
	void testSetDescritpion() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			testAppointment.setAppointmentDescription(invalidDescription);
		});
	}



}
