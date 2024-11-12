import org.example.Task20.*;

import org.junit.Test;


import java.util.LinkedList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task20_Test {
    private LinkedList<QueuePerson> queue = new LinkedList<>() {
        { add(new QueuePerson("Ivanov", "Ivan", "Ivanovich",
                new AddressValue("Kyiv", "Shevchenko", "10", 5), 1));
            add(new QueuePerson("Petrov", "Petr", "Petrovich",
                    new AddressValue("Lviv", "Halytska", "15", 0), 2));
            add(new QueuePerson("Sidorov", "Sidor", "Sidorovich",
                    new AddressValue("Odessa", "Deribasivska", "3", 12), 1));
            add(new QueuePerson("Kovalenko", "Olena", "Oleksandrivna",
                    new AddressValue("Kharkiv", "Gagarina", "50", 8), 3));
            add(new QueuePerson("Shevchenko", "Taras", "Hryhorovych",
                    new AddressValue("Poltava", "Stryletskyi", "20", 0), 2));
        }
    };

    @Test
    public void testViewQueue() {
        Queue.viewQueue(queue);
    }

    @Test
    public void testAddPersonToQueue() {
        String input = "\nDoe\nJohn\nSmith\nDnipro\nBroadway\n100\n0\n2\n";
        Scanner scanner = new Scanner(input);
        Queue.addPersonToQueue(queue, scanner);
        assertEquals(6, queue.size());
        scanner.close();
    }

    @Test
    public void testServeNextPerson() {
        QueuePerson firstPerson = queue.getFirst();
        Queue.serveNextPerson(queue);
        assertEquals(4, queue.size());
        assertNotEquals(firstPerson, queue.getFirst());
    }
}
