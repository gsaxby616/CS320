//George Saxby
//CS-320
//23MAR25
// Define the Contact class to represent contact details
public class Contact {
    // The contactID is required, must be unique, non-null, max 10 characters, and NOT updatable
    private final String contactID;

    // Other required fields with specific constraints
    private String firstName; // Required, non-null, max 10 characters
    private String lastName;  // Required, non-null, max 10 characters
    private String phone;     // Required, non-null, exactly 10 digits
    private String address;   // Required, non-null, max 30 characters

    // Constructor to initialize all fields with validation checks
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Enforce all constraints per project requirements
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less.");
        }

        // Assign values after validation
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for immutable contact ID
    public String getContactID() {
        return contactID;
    }

    // Getters and Setters with validation

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less.");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less.");
        }
        this.address = address;
    }
}
