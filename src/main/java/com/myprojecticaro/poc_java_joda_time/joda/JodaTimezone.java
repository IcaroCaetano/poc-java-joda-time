package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaTimezone {

    private static final String TIMEZONE_JAPAN = "Asia/Tokyo";

    public static DateTime getBrazilTime() {

        return new DateTime(DateTimeZone.forID("America/Sao_Paulo"));
    }

    public static DateTime convertToJapan(DateTime dateTime) {
        return dateTime.withZone(DateTimeZone.forID(TIMEZONE_JAPAN));
    }

    public static DateTime convert(DateTime dateTime, String timezone) {
        return dateTime.withZone(DateTimeZone.forID(timezone));
    }
}