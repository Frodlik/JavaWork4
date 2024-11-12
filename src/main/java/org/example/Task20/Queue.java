package org.example.Task20;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//Створити застосунок для вибірки черговика з черги.
// Початкові записи в списку (5 записів) створюються в програмному коді і є об'єктом класу LinkedList.
// Запис списку є об'єктом QueuePerson, що містить поля прізвища,
// імені та по батькові черговика (всі поля типу String), поле типу AddressValue для адреси черговика і пріоритету
// черговика (типу int). У свою чергу, поле типу AddressValue містить три поля типу String:
// найменування міста, найменування вулиці та номер будинку, а також поле типу int - номер квартири
// (якщо номер квартири дорівнює 0, будинок, в якому проживає суб'єкт, не має квартир).
// Записи в черзі упорядковано відповідно до пріоритету, і черговик додається останнім в черзі свого пріоритету.

public class Queue {
    public static void main(String[] args) {

        LinkedList<QueuePerson> queue = new LinkedList<>();
        queue.add(new QueuePerson("Ivanov", "Ivan", "Ivanovich",
                new AddressValue("Kyiv", "Shevchenko", "10", 5), 1));
        queue.add(new QueuePerson("Petrov", "Petr", "Petrovich",
                new AddressValue("Lviv", "Halytska", "15", 0), 1));
        queue.add(new QueuePerson("Sidorov", "Sidor", "Sidorovich",
                new AddressValue("Odessa", "Deribasivska", "3", 12), 2));
        queue.add(new QueuePerson("Kovalenko", "Olena", "Oleksandrivna",
                new AddressValue("Kharkiv", "Gagarina", "50", 8), 3));
        queue.add(new QueuePerson("Shevchenko", "Taras", "Hryhorovych",
                new AddressValue("Poltava", "Stryletskyi", "20", 0), 2));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. View Queue");
            System.out.println("2. Add Person to Queue");
            System.out.println("3. Serve Next Person");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewQueue(queue);
                    break;
                case 2:
                    addPersonToQueue(queue, scanner);
                    break;
                case 3:
                    serveNextPerson(queue);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the queue management system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void viewQueue(LinkedList<QueuePerson> queue) {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            Collections.sort(queue, Comparator.comparingInt(QueuePerson::getPriority));
            for (QueuePerson person : queue) {
                System.out.println(person);
            }
        }
    }

    public static void addPersonToQueue(LinkedList<QueuePerson> queue, Scanner scanner) {
        scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter Street: ");
        String street = scanner.nextLine();

        System.out.print("Enter House Number: ");
        String houseNumber = scanner.nextLine();

        System.out.print("Enter Apartment Number (0 if none): ");
        int apartmentNumber = scanner.nextInt();

        System.out.print("Enter Priority (int): ");
        int priority = scanner.nextInt();

        AddressValue address = new AddressValue(city, street, houseNumber, apartmentNumber);
        QueuePerson newPerson = new QueuePerson(lastName, firstName, middleName, address, priority);

        // Додаємо черговика у правильне місце у черзі відповідно до пріоритету
        int insertIndex = 0;
        while (insertIndex < queue.size() && queue.get(insertIndex).getPriority() <= priority) {
            insertIndex++;
        }
        queue.add(insertIndex, newPerson);
        System.out.println("Person added successfully!");
    }

    public static void serveNextPerson(LinkedList<QueuePerson> queue) {
        if (queue.isEmpty()) {
            System.out.println("No one is in the queue.");
        } else {
            QueuePerson nextPerson = queue.removeFirst();
            System.out.println("Serving: " + nextPerson);
        }
    }
}
