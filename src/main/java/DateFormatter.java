import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class DateFormatter{
    private LocalDate output;
    private String input;
    private List<LocalDate> listOfDates = new ArrayList<>();
    private ZonedDateTime ztime;

    DateFormatter(){}

    //Date Formats
    DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("yyyy/dd/MM"),
    };

    //Parse a String into a Local Date Format
    public DateFormatter setInput(String Input) {
        this.input = Input;


        try{
            DateTimeFormatter formatString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.output = LocalDate.parse(input, formatString);

        }catch (Exception e){
            System.out.println("Invalid Format:" + e.getMessage());
        }
        return this;
    }

    //Get all the list of Dates stored in the array
    public void getAlldates(){
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        for(LocalDate i : listOfDates){
            System.out.println(i.format(dateformat));
        }
    }
    //set a date on the list using certain formats
    public LocalDate addDate(String date){
        LocalDate result = null;
        boolean parsed = false;

        for(DateTimeFormatter format : formatters){
            try{
                result = LocalDate.parse(date, format);
                listOfDates.add(result);
                parsed = true;
                break;
            }catch(DateTimeParseException ignored){

            }
        }

        if(!parsed){
            System.out.println("Invalid Format: " + date);
        }

        return result;
    }

    //Allows to chain an input to print the set date
    public DateFormatter printOutput() {
        if(output != null){
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            System.out.println(output.format(dateFormat));
        }
        return this;
    }

}


