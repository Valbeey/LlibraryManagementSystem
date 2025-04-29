package models;

public class Borrower {
    private String id;
    private String name;
    private String contactDetails;

    public Borrower(String id, String name, String contactDetails) {
        this.id = id;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactDetails() { return contactDetails; }

    public String toFileString() {
        return id + "," + name + "," + contactDetails;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + contactDetails + ")";
    }
}
