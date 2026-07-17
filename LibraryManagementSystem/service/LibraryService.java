package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BorrowRecord;

public class LibraryService {
    private List<Book> books;
    private List<BorrowRecord> borrowRecords;
    private int nextBookId;
    private int nextRecordId;

    public LibraryService() {
        this.books = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
        this.nextBookId = 1;
        this.nextRecordId = 1;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<BorrowRecord> getRecords() {
        return borrowRecords;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setRecords(List<BorrowRecord> records) {
        this.borrowRecords = records;
    }

    public void setNextBookId(int nextBookId) {
        this.nextBookId = nextBookId;
    }

    public void setNextRecordId(int nextRecordId) {
        this.nextRecordId = nextRecordId;
    }

    public boolean addBook(String title, String author) {
        int id = generateBookId();
        Book newBook = new Book(id, title, author, true);

        return books.add(newBook);
    }

    public List<Book> viewBooks() {
        return books;
    }

    public List<Book> searchBooks(String title) {
        List<Book> found = new ArrayList<>();

        for (Book a : books) {
            if (a.getTitle().toLowerCase().contains(title.toLowerCase())) {
                found.add(a);
            }
        }

        return found;
    }

    public boolean borrowBook(int bookId, String borrowerName) {
        Book borrowbook = searchBookById(bookId);

        if (borrowbook == null) return false;
        if (!borrowbook.isAvailable()) return false;

        int borrowedId = generateRecordId();
        String currentDate = LocalDate.now().toString();

        BorrowRecord borrow = new BorrowRecord(borrowedId, bookId, borrowerName, currentDate, null);
        borrowRecords.add(borrow);
        borrowbook.setAvailable(false);

        return true;
    }

    public boolean returnBook(int bookId) {
        Book returnbook = searchBookById(bookId);

        if (returnbook == null) return false;
        if (returnbook.isAvailable()) return false;

        for(BorrowRecord a: borrowRecords) {
            if(a.getBookId() == bookId && a.getReturnDate() == null) {
                String currentDate = LocalDate.now().toString();
                a.setReturnDate(currentDate);
                returnbook.setAvailable(true);
                return true;
            }
        }

        return false;
    }

    public boolean deleteBook(int bookId) {
        Book deleteBook = searchBookById(bookId);

        if (deleteBook != null) {
            books.remove(deleteBook);
            return true;
        }

        return false;
    }

    private Book searchBookById(int id) {
        for (Book a : books) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    private int generateBookId() {
        int currentBookId = nextBookId;
        nextBookId++;
        return currentBookId;
    }

    private int generateRecordId() {
        int currentRecordId = nextRecordId;
        nextRecordId++;
        return currentRecordId;
    }

}
