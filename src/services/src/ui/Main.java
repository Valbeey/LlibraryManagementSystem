package ui;

import models.Book;
import models.Borrower;
import services.LibraryService;
import java.util.Scanner;

public class Main {
    private static LibraryService libraryService = new LibraryService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Borrower");
            System.out.println("6. List Borrowers");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String option = scanner.nextLine();
            switch (option) {
                case "1" -> addBook();
                case "2" -> libraryService.listBooks();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> addBorrower();
                case "6" -> libraryService.listBorrowers();
                case "0" -> {
                    running = false;
                    System.out.println("Thank you for using the Library Management System!");
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        Book book = new Book(id, title, author, genre);
        libraryService.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void borrowBook() {
        System.out.print("Enter Book ID to Borrow: ");
        String id = scanner.nextLine();
        libraryService.borrowBook(id);
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        String id = scanner.nextLine();
        libraryService.returnBook(id);
    }

    private static void addBorrower() {
        System.out.print("Enter Borrower ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Details: ");
        String contact = scanner.nextLine();
        Borrower borrower = new Borrower(id, name, contact);
        libraryService.addBorrower(borrower);
        System.out.println("Borrower added successfully!");
    }
}
