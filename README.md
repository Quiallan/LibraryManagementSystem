### **Project Description: Library Management System**

This project is a **Library Management System** built using **Java 17**, **Spring Boot 3.2.2**, **Spring Data JPA**, and **MySQL** (or H2 for in-memory testing). It demonstrates a fully functional, object-oriented library system with features such as book and movie management, sorting, searching, and persistent data storage.

The system is designed to manage a collection of media items, including **Books** and **Movies**, while showcasing core Java and Spring Boot principles such as:

- **Object-Oriented Programming (OOP)**: Polymorphism through abstract classes.
- **Database Persistence**: Integration with MySQL for data storage and retrieval.
- **Data Management**: Adding, sorting, removing, and searching for items.
- **Interactive Menu System**: A simple console-based interface for user interaction.
- **Spring Boot Integration**: Use of JPA for ORM and dependency injection for modular components.

---

### **Features**

1. **Media Management**:
   - Add new **Books** and **Movies**.
   - View all media items.
   - Remove a book by ISBN.
   - Search for books and movies by **title**, **author**, **director**, or **keywords**.

2. **Data Persistence**:
   - Uses **MySQL** for persistent data storage.
   - Auto-generates tables for **Books** and **Movies** using Hibernate ORM.
   - Optional support for an **H2 database** for in-memory testing.

3. **Sorting**:
   - Sort books by **title**.
   - Sort media items by **price** or **availability**.

4. **User-Friendly Console Interface**:
   - A simple, menu-driven console interface for intuitive navigation.
   - Input validation ensures smooth handling of user entries.

5. **Object-Oriented Design**:
   - Abstract class `MediaItem` serves as the base for `Book` and `Movie` classes.
   - Demonstrates inheritance, polymorphism, method overriding, and clean code practices.

6. **Testing and Data Management**:
   - Supports in-memory H2 database for testing purposes.
   - MySQL integration ensures persistent data storage across sessions.

---

### **Technologies Used**

- **Java 17**: Core programming language.
- **Spring Boot 3.2.2**: Framework for application development.
- **Spring Data JPA**: ORM framework for database interaction.
- **MySQL**: Relational database for persistent storage.
- **H2 Database**: For in-memory database testing.
- **Maven**: Build tool and dependency management.
- **Hibernate**: ORM framework for managing entities.

---

### **Project Structure**

```
src/
│
├── main/
│   ├── java/com/library/management/
│   │   ├── LibraryManagementApplication.java  # Main application runner
│   │   ├── Library.java                       # Service class managing the library operations
│   │   ├── Book.java                          # Book entity class
│   │   ├── Movie.java                         # Movie entity class
│   │   ├── MediaItem.java                     # Abstract class for all media
│   │   ├── BookRepository.java                # Repository interface for Books
│   │   ├── MovieRepository.java               # Repository interface for Movies
│   │
│   └── resources/
│       ├── application.yml                    # Database configurations
│
└── pom.xml                                    # Project dependencies
```

---

### **How It Works**

1. **Add Items**:
   - Input book or movie details such as title, author/director, price, genre, and quantity.

2. **View All Items**:
   - Display all books and movies currently stored in the database.

3. **Search**:
   - Search for books or movies by title, author, director, or other keywords.

4. **Sort**:
   - Sort books alphabetically by title or media items based on price or availability.

5. **Remove Items**:
   - Remove a book from the library by providing its ISBN.

6. **Data Persistence**:
   - Data is stored persistently in MySQL and automatically updated or created using Hibernate ORM.

---

This project demonstrates clean coding practices, object-oriented principles, and practical integration of Spring Boot with relational databases, providing a simple yet powerful library management solution. 🚀
