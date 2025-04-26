//George Saxby
//CS-320
//23MAR25
import java.util.HashMap;
import java.util.Map;

// Service class to manage Contact objects
public class ContactService {
    // Using in-memory storage (HashMap) as required
    private Map<String, Contact> contacts;

    // Constructor initializes empty contact list
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Adds a new contact to the service
    // Enforces uniqueness of contact ID as required
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Deletes a contact by contact ID
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    // Updates the first name of a contact by ID
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setFirstName(newFirstName); // Validation handled in Contact class
        }
    }

    // Updates the last name of a contact by ID
    public void updateLastName(String contactID, String newLastName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setLastName(newLastName);
        }
    }

    // Updates the phone number of a contact by ID
    public void updatePhone(String contactID, String newPhone) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setPhone(newPhone);
        }
    }

    // Updates the address of a contact by ID
    public void updateAddress(String contactID, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setAddress(newAddress);
        }
    }

    // Retrieves a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
