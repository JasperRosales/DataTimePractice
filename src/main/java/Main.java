import java.time.ZoneId;

public class Main {
    public static void main(String[] args){
        DateFormatter date = new DateFormatter();
        BirthdayManager bday = new BirthdayManager();

        bday.setBday("Jasper", "04/26/2005");
        bday.getAllBirthdays();

        date.getAlldates();
    }
}
