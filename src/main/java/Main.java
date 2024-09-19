

public class Main {
    public static void main(String[] args){
        DateFormatter date = new DateFormatter();

        date.setBirthday("04/26/05");
        date.setBirthday("04-22-06");

        date.getAllBirthdays();
    }
}
