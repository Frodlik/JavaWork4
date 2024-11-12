package org.example.Task26;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Створити застосунок для додавання товару і перегляду списку товарів електронного магазину.
// Початкові записи в списку товарів (5 записів) створюються в програмному коді і є об'єктом класу HashMap.
// Ключем запису є артикул товару (типу Integer), а значенням - об'єкт Article, що містить найменування товару
// (типу String) і ціну товару (типу float).

public class ElectronicStore {
    public static void main(String[] args) {

        HashMap<Integer, Article> productCatalog = new HashMap<>();
        productCatalog.put(1001, new Article("Smartphone", 299.99f));
        productCatalog.put(1002, new Article("Laptop", 799.99f));
        productCatalog.put(1003, new Article("Headphones", 49.99f));
        productCatalog.put(1004, new Article("Smartwatch", 199.99f));
        productCatalog.put(1005, new Article("Camera", 499.99f));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nElectronic Store Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts(productCatalog);
                    break;
                case 2:
                    addProduct(productCatalog, scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void viewProducts(HashMap<Integer, Article> catalog) {
        if (catalog.isEmpty()) {
            System.out.println("The product catalog is empty.");
        } else {
            for (Map.Entry<Integer, Article> entry : catalog.entrySet()) {
                System.out.println("SKU: " + entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    public static void addProduct(HashMap<Integer, Article> catalog, Scanner scanner) {
        System.out.print("Enter SKU (Integer): ");
        int sku = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price (float): ");
        float price = scanner.nextFloat();

        catalog.put(sku, new Article(name, price));
        System.out.println("Product added successfully!");
    }
}
