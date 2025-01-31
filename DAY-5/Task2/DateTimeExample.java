import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample 
{
    public static void main(String[] args) 
    {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        LocalDate dayAfter7Days = today.plusDays(7);
        System.out.println("Day after 7 days: " + dayAfter7Days.getDayOfWeek());

        LocalDate dateAfter1Month = today.plusMonths(1);
        System.out.println("Date after 1 month: " + dateAfter1Month.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
