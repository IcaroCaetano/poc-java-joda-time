package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class JodaConverterTest {

    @Test
    void shouldConvertJodaToJavaTime() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        LocalDateTime result = JodaConverter.toJavaTime(joda);

        assertNotNull(result);
    }

    @Test
    void shouldKeepSameInstant_afterConversion() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        long jodaMillis = joda.getMillis();

        long javaMillis = javaTime
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(jodaMillis, javaMillis);
    }

    @Test
    void shouldConvertCorrectly_whenUsingUTC() {
        DateTime joda = new DateTime(2026, 4, 8, 13, 0,
                DateTimeZone.UTC);

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        LocalDateTime expected = LocalDateTime.ofInstant(
                joda.toInstant().toDate().toInstant(),
                ZoneId.systemDefault()
        );

        assertEquals(expected, javaTime);
    }

    @Test
    void shouldUseSystemDefaultTimezone() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.UTC);

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        ZoneId systemZone = ZoneId.systemDefault();

        LocalDateTime expected = LocalDateTime.ofInstant(
                joda.toInstant().toDate().toInstant(),
                systemZone
        );

        assertEquals(expected, javaTime);
    }

    @Test
    void shouldThrowException_whenNullInput() {
        assertThrows(NullPointerException.class, () ->
                JodaConverter.toJavaTime(null)
        );
    }
}