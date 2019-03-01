package util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

public class DateUtils {
    public static String formatDate(LocalDate date) {
        return DateTimeFormat.forPattern("dd-MM-yyyy").print(date);
    }
}

