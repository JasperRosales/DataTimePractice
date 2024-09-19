import java.time.LocalDate;

public class Birthday {
    private String name;
    private LocalDate date;

    public Birthday(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}