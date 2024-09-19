import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;


public class DateFormatter{
    private LocalDateTime output;
    private String input;
    private List<LocalDate> BirthdayList = new ArrayList<>();

    DateFormatter(){}

    public DateFormatter setInput(String Input) {
        this.input = Input;


        try{
            DateTimeFormatter formatString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.output = LocalDateTime.parse(input, formatString);

        }catch (Exception e){
            System.out.println("Invalid Format:" + e.getMessage());
        }
        return this;
    }

    public void getDateNow(){
        System.out.println(LocalDate.now());
    }

    public void getTimeNow(){
        System.out.println(LocalTime.now());
    }

    public void setBirthday(String bday){
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy/dd/MM"),

                new DateTimeFormatterBuilder()
                        .append(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        .parseDefaulting(ChronoField.YEAR,2000)
                        .toFormatter(),
                new DateTimeFormatterBuilder()
                        .append(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                        .parseDefaulting(ChronoField.YEAR, 2000)
                        .toFormatter()

        };

        boolean parsed = false;

        for(DateTimeFormatter format : formatters){
            try{
                LocalDate temp = LocalDate.parse(bday, format);
                BirthdayList.add(temp);
                parsed = true;
                break;
            }catch(DateTimeParseException ignored){

            }
        }

        if(!parsed){
            System.out.println("Invalid Format: " + bday);
        }
    }

    public void getAllBirthdays(){
        DateTimeFormatter bdayFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        for(LocalDate i : BirthdayList){
            System.out.println(i.format(bdayFormat));
        }
    }

    public DateFormatter printOutput() {
        System.out.println(output);
        return this;
    }
}