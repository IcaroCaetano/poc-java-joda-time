package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class JodaConverter {

    public static LocalDateTime toJavaTime(DateTime jodaDateTime) {

        return LocalDateTime.ofInstant(
                // milliseconds from the epoch of 1970-01-01T00:00:00Z.
                Instant.ofEpochMilli(jodaDateTime.getMillis()),
                ZoneId.systemDefault()
        );
    }
}