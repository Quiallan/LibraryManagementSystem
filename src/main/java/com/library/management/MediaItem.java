package com.library.management;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MediaItem { // Abstract class to serve as a base for all media types
    // Common attributes for all media types
    private String title;
    private String genre;
    private int year;
    private String bookCondition;
    private double price;
    private boolean availability; // true if available, false if checked out
    private int quantity;
    
    // Empty constructor for JPA
    public MediaItem() {
    }

    // Parameterized Constructors for all media items
    public MediaItem(String title, String genre, int year, String bookCondition, double price, boolean availability, int quantity) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.bookCondition = bookCondition;
        this.price = price;
        this.availability = availability;
        this.quantity = quantity;
    }

    // Getters and Setters for all media items
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getBookCondition() {
        return bookCondition;
    }
    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract method for displaying details
    public abstract void displayDetails();
}
