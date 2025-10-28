package lab_3;


import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Map<Books, Integer> book = new HashMap<>();
    private Map<String, Readers> reader = new HashMap<>();
    private Map<Readers, List<Books>> accountingOfBook = new HashMap<>();

    //Поиск по параметру книги внутри библиотеки
    public List<Map.Entry<Books, Integer>> search(String keyword) {
        return book.entrySet().stream()
                .filter(entry ->
                        entry.getKey().getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                entry.getKey().getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                                entry.getKey().getGenre().toLowerCase().contains(keyword.toLowerCase()) ||
                                entry.getKey().getPublisher().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    //Поиск книг по Году издательства
    public List<Map.Entry<Books, Integer>> searchYear(int year) {
        return book.entrySet().stream()
                .filter(entry -> entry.getKey().getYear() == year)
                .collect(Collectors.toList());
    }

    //Сортировка книг по критерию переданному вместе с функцией (если не совпадает с критериями по умолчанию Сортирует по названию)
    public List<Map.Entry<Books, Integer>> sortBy(String criterion) {
        Comparator<Books> comparator = switch (criterion.toLowerCase()) {
            case "название" -> Comparator.comparing(Books::getTitle);
            case "автор" -> Comparator.comparing(Books::getAuthor);
            case "год" -> Comparator.comparingInt(Books::getYear);
            case "жанр" -> Comparator.comparing(Books::getGenre);
            default -> Comparator.comparing(Books::getTitle);
        };
        return book.entrySet().stream().sorted(Map.Entry.comparingByKey(comparator)).collect(Collectors.toList());
    }

    //Функция для отображения всех книг с их количеством в библиотеке
    public void showAllBooks() {
        System.out.println("\nКаталог библиотеки:");
        for (Map.Entry<Books, Integer> entry : book.entrySet()) {
            System.out.println(entry.getKey() + " — в наличии: " + entry.getValue());
        }
    }

    //Функция добавления книги или сразу несколько одинаковых книг в библиотеку
    public void addBook(Books Book, int quantity) {
        book.put(Book, book.getOrDefault(Book, 0) + quantity);
    }

    //Функция добавления читателя
    public void addReader(Readers Reader) {
        reader.put(Reader.getTicketNumber(), Reader);
    }

    //Функция выдачи книги читателю
    public void bookIssuance(String TicketNumber, Books Book) {
        Readers readers = reader.get(TicketNumber);

        if (reader == null) {
            System.out.println("\nЧитателя с таким номером читательского билета не существует!!!");
            return;
        }

        int amountBooks = book.getOrDefault(Book, 0);
        if (amountBooks <= 0) {
            System.out.println("\nКниги не существует или отсутствует в наличии!!!");
        } else {
            book.put(Book, amountBooks - 1);
            accountingOfBook.computeIfAbsent(readers, k -> new ArrayList<>()).add(Book);
            System.out.println("\nКнига \"" + Book.getTitle() + "\" выдана " + readers.getName());
        }
    }

    //Вывод книг какие взял читатель по номеру его читательского билета
    public void showBorrowedBooks(String ticketNumber) {
        Readers readers = reader.get(ticketNumber);
        if (readers == null) {
            System.out.println("\nЧитатель с билетом №" + ticketNumber + " не найден!");
            return;
        }
        List<Books> taken = accountingOfBook.get(readers);
        if (taken == null || taken.isEmpty()) {
            System.out.println("\n" + readers.getName() + " пока не взял ни одной книги.");
        } else {
            System.out.println("\nКниги, взятые читателем " + readers.getName() + ":");
            for (Books book : taken) {
                System.out.println(" - " + book);
            }
        }
    }

}
