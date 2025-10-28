package lab_3;

public class LAB_3_main {
    public static void main(String[] args) {
        Library library = new Library();
        //Добавление книг
        library.addBook(new Books("1984", "Джордж Оруэлл", "АСТ", "Антиутопия", 1949), 5);
        library.addBook(new Books("Преступление и наказание", "Ф. Достоевский", "Эксмо", "Роман", 1866), 2);
        library.addBook(new Books("Война и мир", "Л. Толстой", "АСТ", "Эпос", 1869), 1);
        library.addBook(new Books("Алхимик", "Пауло Коэльо", "АСТ", "Философский роман", 1988), 5);
        library.addBook(new Books("Пикник на обочине", "Аркадий и Борис Стругацкие", "АСТ", "Фантастика", 1972), 3);

        //Добавление читателей
        library.addReader(new Readers("Сергей", "0001"));
        library.addReader(new Readers("Кирилл", "0002"));
        library.addReader(new Readers("Иван", "0003"));

        //Выдача книг
        library.bookIssuance("0001", new Books("Преступление и наказание", "Ф. Достоевский", "Эксмо", "Роман", 1866));
        library.bookIssuance("0002", new Books("Преступление и наказание", "Ф. Достоевский", "Эксмо", "Роман", 1866));
        library.bookIssuance("0001", new Books("Преступление и наказание", "Ф. Достоевский", "Эксмо", "Роман", 1866));

        //проверка выданных книг
        library.showBorrowedBooks("0001");
        //проверка выданных книг
        library.showBorrowedBooks("0003");

        //Вывод всего каталога библиотеки
        library.showAllBooks();

        //Поиск по ключевым словам
        System.out.println("\nПоиск по ключевому слову 'Роман':");
        library.search("Роман").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nПоиск по ключевому слову 'Эпос':");
        library.search("Эпос").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nПоиск по ключевому слову 'Оруэлл':");
        library.search("Оруэлл").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nПоиск по году издательства '1866':");
        library.searchYear(1866).forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));

        //Сортировка по разным параметрам
        System.out.println("\nСортировка по автору:");
        library.sortBy("автор").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nСортировка по году:");
        library.sortBy("год").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nСортировка по жанру:");
        library.sortBy("жанр").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
        System.out.println("\nСортировка по названию:");
        library.sortBy("название").forEach(Entry -> System.out.println(Entry.getKey() + " - в наличии: " + Entry.getValue()));
    }
}