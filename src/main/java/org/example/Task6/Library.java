package org.example.Task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

//Створити застосунок для додавання книг і перегляду списку книг в бібліотечному каталозі.
// Початкові записи в списку книг (5 записів) створюється в програмному коді і є об'єктом класу HashMap.
// Ключем запису є індекс ISBN книги (типу Integer), а значенням - об'єкт Book, що містить найменування книги,
// прізвище та ім'я учасника, видавництво (всі поля типу String), рік видання (типу int) і ціну книги (типу double).
// Передбачити можливість отримання списку авторів книг, де автори не повторюються, для чого використати TreeSet.

public class Library {
    public static void main(String[] args) {

        HashMap<Integer, Book> bookCatalog = new HashMap<>();
        bookCatalog.put(1001, new Book("Book One", "Author One", "Publisher One", 2020, 25.50));
        bookCatalog.put(1002, new Book("Book Two", "Author Two", "Publisher Two", 2018, 30.00));
        bookCatalog.put(1003, new Book("Book Three", "Author One", "Publisher Three", 2021, 45.75));
        bookCatalog.put(1004, new Book("Book Four", "Author Three", "Publisher Four", 2019, 20.99));
        bookCatalog.put(1005, new Book("Book Five", "Author Two", "Publisher Five", 2022, 50.00));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. View Unique Authors");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBooks(bookCatalog);
                    break;
                case 2:
                    addBook(bookCatalog, scanner);
                    break;
                case 3:
                    viewUniqueAuthors(bookCatalog);
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

    public static void addBook(HashMap<Integer, Book> catalog, Scanner scanner) {
        System.out.print("Enter ISBN (Integer): ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        if (catalog.containsKey(isbn)) {
            System.out.println("Error: A book with this ISBN already exists.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Enter Year (int): ");
        int year = scanner.nextInt();

        System.out.print("Enter Price (double): ");
        double price = scanner.nextDouble();

        catalog.put(isbn, new Book(title, author, publisher, year, price));
        System.out.println("Book added successfully!");
    }

    public static void viewUniqueAuthors(HashMap<Integer, Book> catalog) {
        TreeSet<String> uniqueAuthors = new TreeSet<>();
        for (Book book : catalog.values()) {
            uniqueAuthors.add(book.getAuthor());
        }

        System.out.println("\nUnique Authors:");
        for (String author : uniqueAuthors) {
            System.out.println(author);
        }
    }
}
