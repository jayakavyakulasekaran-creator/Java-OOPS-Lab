import java.util.ArrayList;
import java.util.List;

// 1. ABSTRACT BASE CLASS (Must be defined first)
abstract class LibraryItem {
    private String id;
    private String title;
    private boolean isAvailable;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public abstract void displayDetails();
}

// 2. SUBCLASSES
class Book extends LibraryItem {
    private String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Book] ID: " + getId() + " | Title: " + getTitle() + 
                           " | Author: " + author + " | Available: " + isAvailable());
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Magazine] ID: " + getId() + " | Title: " + getTitle() + 
                           " | Issue: #" + issueNumber + " | Available: " + isAvailable());
    }
}

// 3. THE LIBRARY CLASS (Now it can safely find "LibraryItem")
class Library {
    private List<LibraryItem> inventory = new ArrayList<>();

    public void addItem(LibraryItem item) {
        inventory.add(item);
        System.out.println("Added to inventory: " + item.getTitle());
    }

    public void displayInventory() {
        System.out.println("\n--- Library Inventory ---");
        for (LibraryItem item : inventory) {
            item.displayDetails();
        }
    }

    public void borrowItem(String id) {
        for (LibraryItem item : inventory) {
            if (item.getId().equals(id)) {
                if (item.isAvailable()) {
                    item.setAvailable(false);
                    System.out.println("Successfully borrowed: " + item.getTitle());
                    return;
                } else {
                    System.out.println("Sorry, " + item.getTitle() + " is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }
}

// 4. MAIN EXECUTION CLASS
public class Main {
    public static void main(String[] args) {
        Library centralLibrary = new Library();

        LibraryItem item1 = new Book("B01", "Effective Java", "Joshua Bloch");
        LibraryItem item2 = new Magazine("M01", "National Geographic", 402);

        centralLibrary.addItem(item1);
        centralLibrary.addItem(item2);

        centralLibrary.displayInventory();

        System.out.println("\n--- Processing Transactions ---");
        centralLibrary.borrowItem("B01");
        centralLibrary.borrowItem("B01"); 

        centralLibrary.displayInventory();
    }
}
