package com.library.management; // Ensure the package matches your project structure

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication // This annotation enables Spring Boot's auto-configuration and component scanning
public class LibraryManagementApplication {

    @Autowired
    private static Library library; // Use Spring to manage the Library instance

    public static void main(String[] args) {
        // Launch the Spring Boot application and get the application context
        ApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);

        // Obtain the Library bean from the application context
        library = context.getBean(Library.class);

        // Initialize Scanner for user interaction
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Remove a Book");
            System.out.println("5. Sort Books by Title");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Handle user menu choices and execute the corresponding action based on the selected option
            switch (choice) {
                case 1:
                    // Add a book
                    System.out.println("Enter book details:");

                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Book Condition: ");
                    String bookCondition = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Is it a first edition? (true/false): ");
                    boolean firstEdition = scanner.nextBoolean();
                    System.out.print("Quantity in stock: ");
                    int quantity = scanner.nextInt();

                    Book book = new Book(title, author, isbn, genre, bookCondition, price, year, firstEdition, true, quantity);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // View all books
                    library.displayAllBooks();
                    break;

                case 3:
                    // Search for a book
                    System.out.print("Enter a keyword to search (title/author): ");
                    String keyword = scanner.nextLine();
                    library.searchByKeyword(keyword);
                    break;

                case 4:
                    // Remove a book
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBook(removeIsbn);
                    break;

                case 5:
                    // Sort books by title
                    library.sortBooksByTitle();
                    System.out.println("Books sorted by title.");
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
