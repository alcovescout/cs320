package test;

import appointment.Appointment;
import appointment.AppointmentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

	private String testId = "1";
	private String newId = "2";
	
	private Date testDate = new Date(System.currentTimeMillis() + 36000);
	private Date newDate = new Date(System.currentTimeMillis() + 3600000);
	
	private String testDescription = "This is my test Description";
	private String newDescription = "This is my new Description";
	//private Date oldDate = new Date(testDate.getTime() - (24 * 60 * 60 * 1000));
	
    private AppointmentService testAppointmentService;
    private Appointment testAppointment;
    private Appointment newAppointment;
    
    @BeforeEach
    //Set up commonly used classes.
    void setup(){
        testAppointmentService = new AppointmentService();
        testAppointment = new Appointment(testId, testDate, testDescription);
        newAppointment = new Appointment(newId, newDate, newDescription);
        //Test if Appointment adds
        testAppointmentService.addAppointment(testAppointment);
        
        
    }
    @Test
	void testAddAppointment() {
    	//Add new Appointment
    	assertDoesNotThrow(() -> testAppointmentService.addAppointment(newAppointment)); 
    	//Add existing appointment
    	   Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
               testAppointmentService.addAppointment(testAppointment);
    	   });
    	   
    	   //Add null appointment
    	   Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
               testAppointmentService.addAppointment(null);
    	   });
    }
    @Test
    void testGetAppointment() {
    	//Add the appointment
    	
        //Test if appointment exists   	
       assertDoesNotThrow(() -> testAppointmentService.getAppointment(testId));
       
    }

    @Test
    void testRemoveAppointment() {
    	//Remove existing appointment
    	assertDoesNotThrow(() -> testAppointmentService.removeAppointment(testId));
    	
    	//Test if Appointment does not exist.
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testAppointmentService.removeAppointment(newId);
        });
    }


  

}