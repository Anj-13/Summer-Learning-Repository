package model;

public class BorrowRecord {
    private int id;
    private int bookId;
    private String borrowerName;
    private String borrowDate;
    private String returnDate;

    public BorrowRecord(int id, int bookId, String borrowerName, String borrowDate, String returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "ID: " + id
        + "\nBook ID: " + bookId
        + "\nBorrower: " + borrowerName
        + "\nBorrow Date: " + borrowDate
        + "\nReturn Date: " + returnDate;
    }
}
