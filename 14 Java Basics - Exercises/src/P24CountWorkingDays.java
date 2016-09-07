import java.text.*;
import java.util.*;

public class P24CountWorkingDays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = formatter.parse(scan.nextLine());
            dateEnd = formatter.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Holiday> holidays = getHolidays();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        int workingDaysCount = 0;
        while (!calendar.getTime().after(dateEnd)) {
            if (isBusinessDay(calendar.getTime(), holidays))
                workingDaysCount++;
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(workingDaysCount);
    }

    private static boolean isBusinessDay(Date date, List<Holiday> holidays) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        int dayOfWeek = calender.get(Calendar.DAY_OF_WEEK);
        if (holidays.contains(new Holiday(date)))
            return false;    // TODO
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)
            return false;
        return true;
    }

    private static List<Holiday> getHolidays() {
        List<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday(Calendar.JANUARY, 1));
        holidays.add(new Holiday(Calendar.MARCH, 3));
        holidays.add(new Holiday(Calendar.MAY, 1));
        holidays.add(new Holiday(Calendar.MAY, 6));
        holidays.add(new Holiday(Calendar.MAY, 24));
        holidays.add(new Holiday(Calendar.SEPTEMBER, 6));
        holidays.add(new Holiday(Calendar.SEPTEMBER, 22));
        holidays.add(new Holiday(Calendar.NOVEMBER, 1));
        holidays.add(new Holiday(Calendar.DECEMBER, 24));
        holidays.add(new Holiday(Calendar.DECEMBER, 25));
        holidays.add(new Holiday(Calendar.DECEMBER, 26));
        return holidays;
    }

    static class Holiday {
        private int month;
        private int day;

        private Holiday(int month, int day) {
            this.month = month;
            this.day = day;
        }

        private Holiday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.month = calendar.get(Calendar.MONTH);
            this.day = calendar.get(Calendar.DAY_OF_MONTH);
        }
    }
}