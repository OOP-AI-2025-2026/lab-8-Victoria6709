package ua.opnu;
import java.util.*;
import java.lang.reflect.Method;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        List<BookData> books = new ArrayList<>();

        books.add(new BookData("Java Basics", "Alice", 10, 45.0));
        books.add(new BookData("Advanced Java", "Bob", 5, 25.0));
        books.add(new BookData("Spring Framework", "Carol", 8, 36.0));
        books.add(new BookData("Java Basics", "Dave", 0, 0.0));
        books.add(new BookData("Algorithms", "Eve", 10, 45.0));

        Collections.sort(books);

        System.out.println("Відсортовані книги за рейтингом (вищий — перший):");
        for (BookData book : books) {
            System.out.println(book);
        }

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] evenNumbers = Filter.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(evenNumbers));

        String[] words = {"Apple", "Banana", "Avocado", "Cherry"};
        String[] aWords = Filter.filter(words, s -> s.startsWith("A"));
        System.out.println("Слова на 'A': " + Arrays.toString(aWords));

        String[] words1 = {"apple", "banana", "cherry"};
        boolean hasBanana = Utils.contains(words1, "banana");
        boolean hasOrange = Utils.contains(words1, "orange");

        System.out.println("Містить 'banana': " + hasBanana);
        System.out.println("Містить 'orange': " + hasOrange);

        Integer[] numbers1 = {1, 2, 3, 4};
        boolean hasThree = Utils.contains(numbers1, 3);
        System.out.println("Містить 3: " + hasThree); // true

        GenericTwoTuple<Product, Integer> orderItem = new GenericTwoTuple<>(
                new Product("USB Flash Drive", 19.99),
                3
        );
        System.out.println("Замовлення: " + orderItem);

        GenericThreeTuple<Product, Integer, String> fullOrder = new GenericThreeTuple<>(
                new Product("Wireless Mouse", 29.99),
                2,
                "Очікує на відправку"
        );
        System.out.println("Повне замовлення: " + fullOrder);
    }
}

