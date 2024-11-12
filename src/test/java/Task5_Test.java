import org.example.Task5.Book;
import org.example.Task5.Library;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Task5_Test {
    private HashMap<Integer, Book> bookCatalog = new HashMap<Integer, Book>() {
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
    public void testDeleteBookValidISBN() {
        assertTrue(bookCatalog.containsKey(1003));
        Library.deleteBook(bookCatalog, new java.util.Scanner("1003\n"));
        assertFalse(bookCatalog.containsKey(1003));
    }

    @Test
    public void testDeleteBookInvalidISBN() {
        int initialSize = bookCatalog.size();
        Library.deleteBook(bookCatalog, new java.util.Scanner("9999\n")); // ISBN 9999 does not exist
        assertEquals(initialSize, bookCatalog.size());
    }
}