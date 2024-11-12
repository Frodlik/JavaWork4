import org.example.Task26.Article;
import org.example.Task26.ElectronicStore;
import org.example.Task6.Book;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Task26_Test {

    private HashMap<Integer, Article> productCatalog = new HashMap<>() {
        { put(1001, new Article("Smartphone", 299.99f));
            put(1002, new Article("Laptop", 799.99f));
            put(1003, new Article("Headphones", 49.99f));
            put(1004, new Article("Smartwatch", 199.99f));
            put(1005, new Article("Camera", 499.99f));
        }
    };

    @Test
    public void testViewProducts() {
        ElectronicStore.viewProducts(productCatalog);
    }

    @Test
    public void testAddProduct() {
        String input = "1006\nTablet\n299,99\n";
        Scanner scanner = new Scanner(input);
        ElectronicStore.addProduct(productCatalog, scanner);
        assertEquals(6, productCatalog.size());
        assertTrue(productCatalog.containsKey(1006));
        assertEquals("Tablet", productCatalog.get(1006).getName());
        assertEquals(299.99f, productCatalog.get(1006).getPrice());
        scanner.close();
    }
}
