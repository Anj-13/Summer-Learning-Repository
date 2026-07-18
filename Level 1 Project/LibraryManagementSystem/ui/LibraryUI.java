package ui;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.BorrowRecord;
import service.LibraryService;
import storage.FileStorage;

public class LibraryUI {
    private Scanner scanner;
    private FileStorage fileStorage;
    private LibraryService libraryService;

    public void start() {
        scanner = new Scanner(System.in);
        fileStorage = new FileStorage();
        libraryService = new LibraryService();

        List<Book> books = fileStorage.loadBooks();
        libraryService.setBooks(books);
        if (!books.isEmpty()) {
            int maxBookId = 0;
            for (Book b : books) {
                if (b.getId() > maxBookId) {
                    maxBookId = b.getId();
                }
            }
            libraryService.setNextBookId(maxBookId + 1);
        }

        List<BorrowRecord> records = fileStorage.loadRecords();
        libraryService.setRecords(records);
        if (!records.isEmpty()) {
            int maxRecordId = 0;
            for (BorrowRecord r : records) {
                if (r.getId() > maxRecordId) {
                    maxRecordId = r.getId();
                }
            }
            libraryService.setNextRecordId(maxRecordId + 1);
        }

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleAddBook();
                case 2 -> handleViewBooks();
                case 3 -> handleSearchBook();
                case 4 -> handleBorrowBook();
                case 5 -> handleReturnBook();
                case 6 -> handleDeleteBook();
                case 7 -> exitApplication();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("==== Library System ====");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Search Book");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Exit");
    }

    private void handleAddBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        libraryService.addBook(title, author);
        System.out.println("Book added successfully!");
    }

    private void handleViewBooks() {
        List<Book> books = libraryService.viewBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : books) {
                System.out.println(b);
                System.out.println("--------------------");
            }
        }
    }

    private void handleSearchBook() {
        System.out.print("Enter search title: ");
        String title = scanner.nextLine();
        List<Book> results = libraryService.searchBooks(title);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : results) {
                System.out.println(b);
                System.out.println("--------------------");
            }
        }
    }

    private void handleBorrowBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter borrower name: ");
        String borrowerName = scanner.nextLine();
        boolean success = libraryService.borrowBook(bookId, borrowerName);
        if (success) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Error: Book not found or already borrowed.");
        }
    }

    private void handleReturnBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        boolean success = libraryService.returnBook(bookId);
        if (success) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Error: Book not found or not currently borrowed.");
        }
    }

    private void handleDeleteBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        boolean success = libraryService.deleteBook(bookId);
        if (success) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Error: Book not found.");
        }
    }

    private void exitApplication() {
        fileStorage.saveBooks(libraryService.getBooks());
        fileStorage.saveRecords(libraryService.getRecords());
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
