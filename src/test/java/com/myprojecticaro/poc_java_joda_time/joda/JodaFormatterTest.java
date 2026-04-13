package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JodaFormatterTest {

    private static final DateTimeFormatter FORMATTER_DATETIME =
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter FORMATTER_DATE =
            DateTimeFormat.forPattern("yyyy-MM-dd");


    @Test
    void shouldFormatDateTimeNowCorrectly() {
        DateTime before = new DateTime();

        String result = JodaFormatter.formatDateTimeNow();

        DateTime parsed = FORMATTER_DATETIME.parseDateTime(result);

        DateTime expected = before;

        assertTrue(isClose(expected, parsed));
    }

    @Test
    void shouldFormatDateNowCorrectly() {
        DateTime before = new DateTime();

        String result = JodaFormatter.formatDateNow();

        DateTime parsed = FORMATTER_DATE.parseDateTime(result);

        DateTime expected = before.withTimeAtStartOfDay();

        assertEquals(expected.toLocalDate(), parsed.toLocalDate());
    }

    @Test
    void shouldMatchDateTimePattern() {
        String result = JodaFormatter.formatDateTimeNow();

        assertTrue(result.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
    }

    @Test
    void shouldMatchDatePattern() {
        String result = JodaFormatter.formatDateNow();

        assertTrue(result.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    void shouldNotReturnNullOrEmpty() {
        assertNotNull(JodaFormatter.formatDateTimeNow());
        assertFalse(JodaFormatter.formatDateTimeNow().isEmpty());

        assertNotNull(JodaFormatter.formatDateNow());
        assertFalse(JodaFormatter.formatDateNow().isEmpty());
    }

    private boolean isClose(DateTime expected, DateTime actual) {
        long diff = Math.abs(expected.getMillis() - actual.getMillis());
        return diff < 1000; // milisegundos
    }
}