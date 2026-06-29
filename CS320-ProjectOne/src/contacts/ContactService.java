package contacts;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
    private Map<String, Contact> contactMap;

    //Constructor
    public ContactService() {
        this.contactMap = new HashMap<>();
    }

    //GETTER
    public Contact getContact(String contactId) {
        return contactMap.get(contactId);
    }

    public void addContact(Contact contact) {
        //Validate contact is not Null
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        //Check if contactID already exists
        if(contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists with this ID");
        }
        contactMap.put(contact.getContactId(), contact); //Add the contact into the hash map
    }


    public void removeContact(String contactId) {
        if(!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found, cannot delete.");
        }

        contactMap.remove(contactId);
    }

    public void updateContactFields(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contactMap.get(contactId);
        if(contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

}
