package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;

public class JodaDateOperations {

    public static DateTime addYears(int years) {
        return new DateTime().plusYears(years);
    }

    public static DateTime addMonths(int months){
        return new DateTime().plusMonths(months);
    }

    public static DateTime addDays(int days) {

        return new DateTime().plusDays(days);
    }

    public static DateTime addHours(int hours) {
        return new DateTime().plusHours(hours);
    }

    public static DateTime addMinutes(int minutes) {

        return new DateTime().plusMinutes(minutes);
    }

    public static DateTime addSeconds(int seconds) {
        return new DateTime().plusSeconds(seconds);
    }

    public static DateTime minusDays(int days) {

        return new DateTime().minusDays(days);
    }

    public static DateTime minusHours(int hours) {

        return new DateTime().minusHours(hours);
    }

    public static DateTime minusMinutes(int minutes) {

        return new DateTime().minusMinutes(minutes);
    }

    public static DateTime minusSeconds(int seconds) {

        return new DateTime().minusSeconds(seconds);
    }

    public static DateTime addDateTime(int years, int months, int days,
                                       int hours, int minutes, int seconds) {
        return new DateTime()
                .plusYears(years)
                .plusMonths(months)
                .plusDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds);
    }
}