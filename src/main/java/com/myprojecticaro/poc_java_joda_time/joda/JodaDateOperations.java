package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;

public class JodaDateOperations {

    public static DateTime addDays(int days) {

        return new DateTime().plusDays(days);
    }

    public static DateTime minusHours(int hours) {

        return new DateTime().minusHours(hours);
    }

    public static DateTime addMinutes(int minutes) {

        return new DateTime().plusMinutes(minutes);
    }
}