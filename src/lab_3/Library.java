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

    //Поиск книг по критерию переданному вместе с функцией (если не совпадает с критериями по умолчанию ищет по названию)
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

    //Функция выдачи книги читателю (Выдает false при ошибке и true при успехе выдачи книги)
    public boolean bookIssuance(String TicketNumber, Books Book) {
        Readers readers = reader.get(TicketNumber);

        if (reader == null) {
            System.out.println("Читателя с таким номером читательского билета не существует!!!");
            return false;
        }

        int amountBooks = book.getOrDefault(Book, 0);
        if (amountBooks <= 0) {
            System.out.println("Книги не существует или отсутствует в наличии!!!");
            return false;
        } else {
            book.put(Book, amountBooks - 1);
            accountingOfBook.computeIfAbsent(readers, k -> new ArrayList<>()).add(Book);
            System.out.println("Книга \"" + Book.getTitle() + "\" выдана " + readers.getName());
            return true;
        }

    }
}
