package storage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BorrowRecord;

public class FileStorage {
    private static final String BOOKS_FILE = "books.txt";
    private static final String RECORDS_FILE = "records.txt";
    private static final String delimiter = ",";

    public boolean saveBooks(List<Book> books) {
        Path temp = Paths.get(BOOKS_FILE + "_temp.txt");
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(temp.toFile()));

            for (Book a : books) {
                String line = bookToString(a);
                fw.write(line);
                fw.newLine();
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving Books Record");
            return false;
        }

        try {
            Files.move(temp, Paths.get(BOOKS_FILE), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error moving books file: " + e.getMessage());
            return false;
        }
    }

    public List<Book> loadBooks() {
        List<Book> load = new ArrayList<>();
        File file = new File(BOOKS_FILE);

        if (!file.exists()) {
            return load;
        }

        try {
            BufferedReader r = new BufferedReader(new FileReader(file));

            String line;

            while ((line = r.readLine()) != null) {
                Book loadbook = stringToBook(line);

                if (loadbook == null)
                    break;

                load.add(loadbook);
            }

            r.close();
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return load;
    }

    public boolean saveRecords(List<BorrowRecord> records) {
        Path temp = Paths.get(RECORDS_FILE + "_temp.txt");
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(temp.toFile()));

            for (BorrowRecord a : records) {
                String line = recordToString(a);

                fw.write(line);
                fw.newLine();
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving Borrow Record");
            return false;
        }

        try {
            Files.move(temp, Paths.get(RECORDS_FILE), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error moving records file: " + e.getMessage());
            return false;
        }
    }

    public List<BorrowRecord> loadRecords() {
        List<BorrowRecord> load = new ArrayList<>();
        File file = new File(RECORDS_FILE);

        if (!file.exists()) {
            return load;
        }

        try {
            BufferedReader r = new BufferedReader(new FileReader(file));

            String line;

            while ((line = r.readLine()) != null) {
                BorrowRecord loadrecord = stringToRecord(line);

                if (loadrecord == null)
                    break;

                load.add(loadrecord);
            }

            r.close();
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return load;
    }

    private String bookToString(Book book) {
        return (book.getId() + delimiter
                + book.getTitle() + delimiter
                + book.getAuthor() + delimiter
                + book.isAvailable());
    }

    private String recordToString(BorrowRecord record) {
        return (record.getId() + delimiter
                + record.getBookId() + delimiter
                + record.getBorrowerName() + delimiter
                + record.getBorrowDate() + delimiter
                + record.getReturnDate());
    }

    private Book stringToBook(String line) {
        String[] parts = line.split(delimiter);

        if (parts.length == 4) {
            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String author = parts[2];
            Boolean available = Boolean.parseBoolean(parts[3]);

            Book book = new Book(id, title, author, available);

            return book;
        }

        return null;
    }

    private BorrowRecord stringToRecord(String line) {
        String[] parts = line.split(delimiter);

        if (parts.length == 5) {
            int id = Integer.parseInt(parts[0]);
            int bookid = Integer.parseInt(parts[1]);
            String borrowName = parts[2];
            String borrowDate = parts[3];
            String ReturnDate = parts[4];

            BorrowRecord record = new BorrowRecord(id, bookid, borrowName, borrowDate, ReturnDate);

            return record;
        }

        return null;
    }
}
