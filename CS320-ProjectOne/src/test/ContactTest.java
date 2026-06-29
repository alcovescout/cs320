package test;

import contacts.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactClass() {
        Contact myContact = new Contact("AB3456789", "Duke", "Baldwin", "1112223345", "123 SNHU EDU");
        assertTrue(myContact.getContactId().equals("AB3456789"));
        assertTrue(myContact.getFirstName().equals("Duke"));
        assertTrue(myContact.getLastName().equals("Baldwin"));
        assertTrue(myContact.getPhone().equals("1112223345"));
        assertTrue(myContact.getAddress().equals("123 SNHU EDU"));
    }

    @Test
    void testContactTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            new Contact("AB3456789123123", "Duke123123123131", "Baldwin123123123", "345", "12312312312312313131231312313 SNHU EDU");
        });
    }

    @Test
    void testContactNull() {
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            new Contact(null, null, null, null, null);
        });
    }

}
