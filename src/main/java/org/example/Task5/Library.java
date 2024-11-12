package org.example.Task5;

import java.util.*;

//Створити застосунок для перегляду списку книг і видалення книг в бібліотечному каталозі.
// Початкові записи в списку (5 записів) є об'єктами класу HashMap, де ключем є індекс ISBN книги (типу Integer),
// а значенням - об'єкт Book, що містить найменування книги, прізвище та ім'я учасника,
// видавництво (всі поля типу String), рік видання (типу int) і ціну книги (типу double).
// Передбачити можливість сортування книг по 2-3 полях.

public class Library {
    public static void main(String[] args) {

        HashMap<Integer, Book> bookCatalog = new HashMap<>();
        bookCatalog.put(1, new Book("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925, 10.99));
        bookCatalog.put(2, new Book("1984", "George Orwell", "Secker & Warburg", 1949, 8.99));
        bookCatalog.put(3, new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, 7.99));
        bookCatalog.put(4, new Book("Pride and Prejudice", "Jane Austen", "T. Egerton", 1813, 5.99));
        bookCatalog.put(5, new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, 6.99));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Delete Book");
            System.out.println("3. Sort Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBooks(bookCatalog);
                    break;
                case 2:
                    deleteBook(bookCatalog, scanner);
                    break;
                case 3:
                    sortBooks(bookCatalog);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the library catalog. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void viewBooks(HashMap<Integer, Book> catalog) {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (Map.Entry<Integer, Book> entry : catalog.entrySet()) {
                System.out.println("ISBN: " + entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    public static void deleteBook(HashMap<Integer, Book> catalog, Scanner scanner) {
        System.out.print("Enter the ISBN of the book to delete: ");
        int isbn = scanner.nextInt();
        if (catalog.containsKey(isbn)) {
            catalog.remove(isbn);
            System.out.println("Book with ISBN " + isbn + " has been deleted.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public static void sortBooks(HashMap<Integer, Book> catalog) {
        List<Book> bookList = new ArrayList<>(catalog.values());

        System.out.println("\nSort by:");
        System.out.println("1. Title");
        System.out.println("2. Year");
        System.out.println("3. Price");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                bookList.sort(Comparator.comparing(Book::getTitle));
                break;
            case 2:
                bookList.sort(Comparator.comparingInt(Book::getYear));
                break;
            case 3:
                bookList.sort(Comparator.comparingDouble(Book::getPrice));
                break;
            default:
                System.out.println("Invalid choice. Books not sorted.");
                return;
        }

        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
