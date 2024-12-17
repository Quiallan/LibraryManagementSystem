package com.library.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Comparator;
import java.util.List;

@Service
public class Library {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MovieRepository movieRepository;

    // Method to add a media item to the library
    public void addMediaItem(MediaItem mediaItem) {
        if (mediaItem instanceof Book) {
            bookRepository.save((Book) mediaItem);
            System.out.println("Book added successfully: " + mediaItem.getTitle());
        } else if (mediaItem instanceof Movie) {
            movieRepository.save((Movie) mediaItem);
            System.out.println("Movie added successfully: " + mediaItem.getTitle());
        }
    }

    // Method to count media items by type
    public void countMediaByType() {
        long booksCount = bookRepository.count();
        long moviesCount = movieRepository.count();

        System.out.println("Books: " + booksCount);
        System.out.println("Movies: " + moviesCount);
    }

    // Method to search for media items by multiple criteria
    public void advancedSearch(String title, String genre, int year) {
        List<Book> books = bookRepository.findAll();
        boolean found = false;

        for (Book book : books) {
            if ((title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                (genre == null || book.getGenre().equalsIgnoreCase(genre)) &&
                (year == -1 || book.getYear() == year)) {
                book.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media items found matching criteria.");
        }
    }

    // Method to search for media items by a keyword
    public void searchByKeyword(String keyword) {
        List<Book> books = bookRepository.findAll();
        List<Movie> movies = movieRepository.findAll();

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                book.displayDetails();
                found = true;
            }
        }
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                movie.getDirector().toLowerCase().contains(keyword.toLowerCase())) {
                movie.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media items found matching the keyword.");
        }
    }

    // Method to remove a book by ISBN
    public void removeBook(String isbn) {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                bookRepository.delete(book);
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
    }

    // Method to sort books by title
    public void sortBooksByTitle() {
        List<Book> books = bookRepository.findAll();
        books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(Book::displayDetails);

        System.out.println("Books sorted by title.");
    }

    // Method to sort media items by price
    public void sortMediaItemsByPrice() {
        List<Book> books = bookRepository.findAll();
        List<Movie> movies = movieRepository.findAll();

        books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .forEach(Book::displayDetails);

        movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getPrice))
                .forEach(Movie::displayDetails);

        System.out.println("Media items sorted by price.");
    }

    // Method to sort media items by availability
    public void sortByAvailability() {
        List<Book> books = bookRepository.findAll();
        books.stream()
                .sorted((b1, b2) -> Boolean.compare(b2.isAvailability(), b1.isAvailability()))
                .forEach(Book::displayDetails);

        System.out.println("Books sorted by availability (Available items first).");
    }

    // Method to add a Book to the library
    public void addBook(Book book) {
        bookRepository.save(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    // Method to display all books in the library
    public void displayAllBooks() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            books.forEach(Book::displayDetails);
        }
    }

    // Method to save media items to a file
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            List<Book> books = bookRepository.findAll();
            oos.writeObject(books);
            System.out.println("Library data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }

    // Method to load media items from a file
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Book> books = (List<Book>) ois.readObject();
            bookRepository.saveAll(books);
            System.out.println("Library data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library data: " + e.getMessage());
        }
    }
}
