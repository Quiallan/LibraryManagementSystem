package com.library.management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends MediaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key with auto-increment
    private Long id;

    // Attributes specific to Book
    private String author;
    private String isbn;
    private boolean firstEdition; // true if firstEdition, false if not

    // Empty constructor for JPA
    public Book() {
    	super();
    }

    // Constructor for Book
    public Book(String title, String author, String isbn, String genre, String bookCondition, double price, int year,
                boolean firstEdition, boolean availability, int quantity) {
        super(title, genre, year, bookCondition, price, availability, quantity); // Call MediaItem constructor
        this.author = author;
        this.isbn = isbn;
        this.firstEdition = firstEdition;
        this.setAvailability(quantity > 0); // Set availability based on the quantity
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters for Book-specific attributes
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isFirstEdition() {
        return firstEdition;
    }

    public void setFirstEdition(boolean firstEdition) {
        this.firstEdition = firstEdition;
    }

    @Override // Override the setQuantity method to automatically update availability
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
        setAvailability(quantity > 0); // Set availability based on quantity
    }

    // Method to display all book details
    @Override // Override displayDetails method to include Book-specific details
    public void displayDetails() {
        System.out.println("----- Book Details -----");
        System.out.println("ID: " + id); // Display the database ID
        System.out.println("Title: " + getTitle()); // Inherited from MediaItem
        System.out.println("Genre: " + getGenre()); // Inherited from MediaItem
        System.out.println("Year: " + getYear());   // Inherited from MediaItem
        System.out.println("Book Condition: " + getBookCondition()); // Inherited from MediaItem
        System.out.println("Price: $" + String.format("%.2f", getPrice())); // Inherited from MediaItem
        System.out.println("Available: " + (isAvailability() ? "Yes" : "No")); // Inherited from MediaItem
        System.out.println("Quantity in Stock: " + getQuantity()); // Inherited from MediaItem
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("First Edition: " + (firstEdition ? "Yes" : "No"));
        System.out.println("------------------------");
    }

    // Method to check out a book
    public boolean checkOutBook() {
        if (getQuantity() > 0) {
            setQuantity(getQuantity() - 1); // Reduce quantity
            if (getQuantity() == 0) {
                setAvailability(false); // Update availability. No copies left, set availability to false
            }
            System.out.println("Book checked out successfully. Remaining quantity: " + getQuantity());
            return true;
        } else {
            System.out.println("Sorry, this book is currently out of stock.");
            return false;
        }
    }

    // Method to return a book
    public void returnBook() {
        setQuantity(getQuantity() + 1); // Increase quantity
        setAvailability(true); // Update availability. It makes sure availability is true since we now have stock
        System.out.println("Book returned successfully. Current quantity: " + getQuantity());
    }
}
