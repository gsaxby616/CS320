//George Saxby
//CS-320
//23MAR25
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("123"));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("123");
        assertNull(contactService.getContact("123"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateFirstName("123", "Jane");
        assertEquals("Jane", contactService.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateLastName("123", "Smith");
        assertEquals("Smith", contactService.getContact("123").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updatePhone("123", "0987654321");
        assertEquals("0987654321", contactService.getContact("123").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateAddress("123", "456 Elm St");
        assertEquals("456 Elm St", contactService.getContact("123").getAddress());
    }

    // NEGATIVE TESTS

    @Test
    public void testAddDuplicateContactID() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("123", "Jane", "Smith", "0987654321", "456 Oak St");

        contactService.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    public void testUpdateInvalidPhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", "123");
        });
    }

    @Test
    public void testUpdateNullFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("123", null);
        });
    }

    @Test
    public void testUpdateNullLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("123", null);
        });
    }

    @Test
    public void testUpdateInvalidAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", "1234567890123456789012345678901"); // 31 chars
        });
    }
}
