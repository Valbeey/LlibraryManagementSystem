package services;

import models.Book;
import models.Borrower;
import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;

    public LibraryService() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isAvailable()) {
                book.borrowBook();
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isAvailable()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or already available!");
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public void listBorrowers() {
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }
}
