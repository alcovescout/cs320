//Duke Baldwin
package test;

import contacts.Contact;
import contacts.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class ContactServiceTest {
    private ContactService testService;

    //Set up before each test
    @BeforeEach
    void setUp(){
        testService = new ContactService();
    }
    @Test
    void testAddContact() {

        Contact contact = new Contact("1", "Duke", "Baldwin", "1112223345", "123 SNHU EDU");

        //Test if it throws exception
        assertDoesNotThrow(() -> testService.addContact(contact));
        
        //Attempt to add it again
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
        	testService.addContact(contact);
        });

    }
    // Test if adding null throws an error
    @Test
    void testAddContactNull() {

        //Test if it throws exception
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testService.addContact(null);
        });

    }
    @Test
    void testRetrieveContact() {
        Contact contact = new Contact("1", "Duke", "Baldwin", "1112223345", "123 SNHU EDU");

        //Add the new Contact to the HashMap
        testService.addContact(contact);

        // Validating the Contact was indeed added using the unique ID
        Contact retrievedContact = testService.getContact("1");

        // Test if it is empty
        assertNotNull(retrievedContact, "The contact should exist in the service.");

        // Test if First name Matches
        assertEquals("Duke", retrievedContact.getFirstName(), "The first name should match.");

        // Test if Last name Matches
        assertEquals("Baldwin", retrievedContact.getLastName(), "The last name should match.");

        // Test if Phone Number matches
        assertEquals("1112223345", retrievedContact.getPhone(), "The phone number should match.");

        // Test if Address matches
        assertEquals("123 SNHU EDU", retrievedContact.getAddress(), "The address should match.");

    }

    @Test
    void testRemoveContact() {

        Contact contact = new Contact("1", "Duke", "Baldwin", "1112223345", "123 SNHU EDU");

        //Add the new Contact to the HashMap
        testService.addContact(contact);

        assertDoesNotThrow(() -> testService.removeContact("1"));

        assertEquals(null, testService.getContact("1"));
    }
    @Test
    void testRemoveContactNull() {

    
        //Test if it throws exception
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testService.removeContact("5");
        });

    }

    @Test
    void testUpdateContact() {
        //Create a new Contact
        Contact contact = new Contact("1", "Duke", "Baldwin", "1112223345", "123 SNHU EDU");

        // Add the contact
        testService.addContact(contact);

        //Update the contact fields using the Unique ID
        assertDoesNotThrow(() -> testService.updateContactFields("1", "Mike", "Smith", "9991112222", "854 MY SNHU EDU"));

        //Retrieve the new entry
        Contact retrievedContact = testService.getContact("1");
        // Test if it is empty
        assertNotNull(retrievedContact, "The contact should exist in the service.");
        // Test if First name Matches
        assertEquals("Mike", retrievedContact.getFirstName(), "The first name should match.");
        // Test if Last name Matches
        assertEquals("Smith", retrievedContact.getLastName(), "The last name should match.");
        // Test if Phone Number matches
        assertEquals("9991112222", retrievedContact.getPhone(), "The phone number should match.");
        // Test if Address matches
        assertEquals("854 MY SNHU EDU", retrievedContact.getAddress(), "The address should match.");

    }
    @Test
    void testUpdateContactNull() {

    
        //Test if it throws exception
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testService.updateContactFields(null, null, null, null, null);
        });

    }


}
