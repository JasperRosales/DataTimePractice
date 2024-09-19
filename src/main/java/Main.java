

public class Main {
    public static void main(String[] args){
        DateFormatter date = new DateFormatter();

        date.setBirthday("04/26/2005");
        date.setBirthday("22-04-2006");

        date.getAllBirthdays();
    }
}
