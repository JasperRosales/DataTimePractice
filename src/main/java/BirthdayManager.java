import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BirthdayManager extends DateFormatter {
    private String name;
    private List<Birthday> birthdayList = new ArrayList<>();

    public BirthdayManager(){}


    public Boolean checkbday(LocalDate date) {
        return birthdayList.stream().anyMatch(b -> b.getDate().equals(date));
    }

    public void setBday(String name, String bday) {
        LocalDate bdate = addDate(bday);
        if (bdate != null && !checkbday(bdate)) {
            birthdayList.add(new Birthday(name, bdate));
        } else {
            System.out.println("Invalid or duplicate birthday for " + name + ": " + bday);
        }
    }

    public void getAllBirthdays() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        for (Birthday birthday : birthdayList) {
            System.out.println(birthday.getName() + ": " + birthday.getDate().format(dateFormat));
        }
    }
}
