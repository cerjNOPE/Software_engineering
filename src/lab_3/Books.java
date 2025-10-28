package lab_3;

import java.util.Objects;

public class Books {
    private String title;
    private String genre;
    private int year;
    private String author;
    private String publisher;

    //Конструктор
    public Books(String title, String author, String publisher, String genre, int year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    //Необходимо для выдачи книг
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return year == books.year &&
                Objects.equals(title, books.title) &&
                Objects.equals(author, books.author) &&
                Objects.equals(publisher, books.publisher) &&
                Objects.equals(genre, books.genre);
    }

    //Необходимо для выдачи книг
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, genre, year);
    }

    //Для вывода в строку данных о книгах
    @Override
    public String toString() {
        return String.format(title + " (" + year + ") - " + author + ", " + publisher + " Жанр: " + genre);
    }

}