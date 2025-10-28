package lab_3;

import java.util.Objects;

public class Readers {
    private String name;
    private String ticketNumber;

    //Конструктор
    public Readers(String name, String ticket_Number) {
        this.name = name;
        this.ticketNumber = ticket_Number;
    }

    public String getName() {
        return name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Readers reader)) return false;
        return Objects.equals(ticketNumber, reader.ticketNumber) &&
                Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ticketNumber);
    }

    //Для вывода в строку данных о читателях
    @Override
    public String toString() {
        return String.format("Читатель: " + name + " Номер читательского билета: " + ticketNumber);
    }
}