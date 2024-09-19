import java.time.ZoneId;

public class Main {
    public static void main(String[] args){
        DateFormatter date = new DateFormatter();
        BirthdayManager bday = new BirthdayManager();

       date.setInput("24/12/2005").printOutput();

        date.getAlldates();
    }
}
