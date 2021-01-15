package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getDate(String stringDateFormat, int offset) {
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, offset);
        Date date = cal.getTime();
        return dateFormat.format(date);
    }
}
