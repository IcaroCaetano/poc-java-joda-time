package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class JodaBusinessDate {

    private final DateTime date;

    public JodaBusinessDate(DateTime date) {

        this.date = date.withTimeAtStartOfDay();
    }

    public boolean isWeekend() {
        int day = date.getDayOfWeek();
        return day == DateTimeConstants.SATURDAY ||
               day == DateTimeConstants.SUNDAY;
    }

    public boolean isBusinessDay() {

        return !isWeekend();
    }

    public JodaBusinessDate nextBusinessDay() {
        DateTime next = date.plusDays(1);

        while (isWeekend(next)) {
            next = next.plusDays(1);
        }

        return new JodaBusinessDate(next);
    }

    private boolean isWeekend(DateTime d) {
        int day = d.getDayOfWeek();
        return day == DateTimeConstants.SATURDAY ||
               day == DateTimeConstants.SUNDAY;
    }

    public DateTime getDate() {
        return date;
    }
}