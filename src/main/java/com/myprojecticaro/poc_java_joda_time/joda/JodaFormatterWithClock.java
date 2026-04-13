package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.Clock;
import java.time.Instant;

public class JodaFormatterWithClock {

    private final Clock clock;

    private static final DateTimeFormatter FORMATTER_DATETIME =
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter FORMATTER_DATE =
            DateTimeFormat.forPattern("yyyy-MM-dd");

    public JodaFormatterWithClock(Clock clock) {

        this.clock = clock;
    }

    private DateTime now() {
        Instant instant = clock.instant();
        return new DateTime(instant.toEpochMilli());
    }

    public String formatDateTimeNow() {

        return FORMATTER_DATETIME.print(now());
    }

    public String formatDateNow() {
        return FORMATTER_DATE.print(now());
    }
}