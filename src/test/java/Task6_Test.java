import org.example.Task6.Book;
import org.example.Task6.Library;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import static junit.framework.TestCase.*;

public class Task6_Test {

    private HashMap<Integer, Book> bookCatalog = new HashMap<>() {
        { put(1001, new Book("Book One", "Author One", "Publisher One", 2020, 25.50));
            put(1002, new Book("Book Two", "Author Two", "Publisher Two", 2018, 30.00));
            put(1003, new Book("Book Three", "Author Three", "Publisher Three", 2021, 45.75));
            put(1004, new Book("Book Four", "Author Four", "Publisher Four", 2019, 20.99));
            put(1005, new Book("Book Five", "Author Five", "Publisher Five", 2022, 50.00));
        }
    };

    @Test
    public void testViewBooks() {
        assertFalse(bookCatalog.isEmpty());
        Library.viewBooks(bookCatalog);
    }

    @Test
    public void testAddBookWithNewISBN() {
        int initialSize = bookCatalog.size();
        String input = "2001\nNew Book\nNew Author\nNew Publisher\n2023\n60,50\n";
        Scanner scanner = new Scanner(input);

        Library.addBook(bookCatalog, scanner);

        assertEquals(initialSize + 1, bookCatalog.size());
        assertTrue(bookCatalog.containsKey(2001));
        Book newBook = bookCatalog.get(2001);
        assertNotNull(newBook);
        assertEquals("New Book", newBook.getTitle());
        assertEquals("New Author", newBook.getAuthor());
    }

    @Test
    public void testAddBookWithExistingISBN() {
        int initialSize = bookCatalog.size();
        String input = "1001\nDuplicate Book\nAuthor\nPublisher\n2023\n30,50\n"; // ISBN 1001 already exists
        Scanner scanner = new Scanner(input);

        Library.addBook(bookCatalog, scanner);

        assertEquals(initialSize, bookCatalog.size());
    }

    @Test
    public void testViewUniqueAuthors() {
        TreeSet<String> expectedAuthors = new TreeSet<>();
        expectedAuthors.add("Author One");
        expectedAuthors.add("Author Two");
        expectedAuthors.add("Author Three");
        expectedAuthors.add("Author Four");
        expectedAuthors.add("Author Five");

        TreeSet<String> actualAuthors = new TreeSet<>();
        for (Book book : bookCatalog.values()) {
            actualAuthors.add(book.getAuthor());
        }

        assertEquals(expectedAuthors, actualAuthors);
        Library.viewUniqueAuthors(bookCatalog);
    }
}
