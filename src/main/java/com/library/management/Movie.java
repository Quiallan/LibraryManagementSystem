package com.library.management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie extends MediaItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;

    // Attributes specific to Movie
    private String director;
    private int duration; // Duration in minutes
    
    //Empty constructor for JPA
    public Movie() {
    	super();
    }

    // Constructor for Movie Attributes
    public Movie(String title, String genre, int year, String bookCondition, double price, boolean availability,
                 int quantity, String director, int duration) {
        super(title, genre, year, bookCondition, price, availability, quantity); // Call MediaItem constructor
        this.director = director; // Initialize Movie-specific attributes
        this.duration = duration;
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // Getters and setters for Movie-specific attributes
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
   
    @Override // Override displayDetails method to include Movie-specific details
    public void displayDetails() {
        System.out.println("----- Movie Details -----");
        System.out.println("ID: " + id); // Display the primary key
        System.out.println("Title: " + getTitle()); // Inherited from MediaItem
        System.out.println("Genre: " + getGenre()); // Inherited from MediaItem
        System.out.println("Year: " + getYear());   // Inherited from MediaItem
        System.out.println("Book Condition: " + getBookCondition()); // Inherited from MediaItem
        System.out.println("Price: $" + String.format("%.2f", getPrice())); // Inherited from MediaItem
        System.out.println("Available: " + (isAvailability() ? "Yes" : "No")); // Inherited from MediaItem
        System.out.println("Quantity in Stock: " + getQuantity()); // Inherited from MediaItem
        System.out.println("Director: " + director);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("-------------------------");
    }
}
