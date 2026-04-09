package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaFormatter {

    private static final DateTimeFormatter FORMATTER_DATETIME =
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter FORMATTER_DATE =
            DateTimeFormat.forPattern("yyyy-MM-dd");

    public static String formatDateTimeNow() {

        return FORMATTER_DATETIME.print(new DateTime());
    }

    public static String formatDateNow() {

        return FORMATTER_DATE.print(new DateTime());
    }
}