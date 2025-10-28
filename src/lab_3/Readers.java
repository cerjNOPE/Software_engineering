package lab_3;

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

    //Для вывода в строку данных о читателях
    @Override
    public String toString() {
        return String.format("Читатель: " + name + " Номер читательского билета: " + ticketNumber);
    }
}
